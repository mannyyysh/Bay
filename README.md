# Bay
Demo App Server to feth zipcodes based on lat, long and miles
Sample URL
http://localhost:8080/house-0.0.1-SNAPSHOT/zipcodes?lat=37.3382&lon=121.8863&radius=10.0

Have integrated swagger too. Cool to read APIs

Need to run this once we insert data to Mongo
db.zipcodes.createIndex({"loc": "2dsphere"});


Location object in Zipcode has list of coordiantes. Make sure we  insert longitude first, and then latitude.


Need mysql set up too

Run this sql scripts once we create the zipcodes table - zip.sql

DELIMITER //
CREATE FUNCTION calculate_distance(measurement varchar(2), base_lat double precision, base_lon double precision, lat double precision, lon double precision) RETURNS double precision
   BEGIN
      DECLARE earth_radius double precision;
      IF measurement = 'km' THEN
         SET earth_radius = 6371.0;
      ELSEIF measurement = 'mi' THEN
         SET earth_radius = 3959.0;
      END IF;
      RETURN earth_radius * ACOS(SIN(base_lat / 57.2958) * SIN(lat / 57.2958) + COS(base_lat / 57.2958) * COS(lat / 57.2958) * COS((lon / 57.2958) - (base_lon / 57.2958)));
   END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE zip_proximity(zipcode varchar(5), radius double precision, measurement varchar(2))
   BEGIN
   DECLARE base_lat double precision;
   DECLARE base_lon double precision;
   SELECT lat, lon INTO base_lat, base_lon FROM zipcodes WHERE zip = zipcode;
   SELECT zip, lat, lon, city, state, state_abbrev, calculate_distance(measurement, base_lat, base_lon, lat, lon) AS distance FROM zipcodes
      WHERE calculate_distance(measurement, base_lat, base_lon, lat, lon) < radius ORDER BY distance;
   END //
DELIMITER ;



Result will be like
mysql> call zip_proximity('94043', 3, 'mi');
+-------+----------+------------+---------------+------------+--------------+-------------------+
| zip   | lat      | lon        | city          | state      | state_abbrev | distance          |
+-------+----------+------------+---------------+------------+--------------+-------------------+
| 94043 | 37.42337 | -122.07981 | MOUNTAIN VIEW | CALIFORNIA | CA           |                 0 |
| 94039 | 37.41884 | -122.09124 | MOUNTAIN VIEW | CALIFORNIA | CA           | 0.701004115082249 |
| 94035 | 37.41753 | -122.05283 | MOUNTAIN VIEW | CALIFORNIA | CA           |  1.53459076784732 |
| 94042 | 37.39314 | -122.07827 | MOUNTAIN VIEW | CALIFORNIA | CA           |  2.09052870372395 |
| 94041 | 37.38961 | -122.07715 | MOUNTAIN VIEW | CALIFORNIA | CA           |  2.33729808557031 |
| 94306 | 37.41478 | -122.12139 | PALO ALTO     | CALIFORNIA | CA           |  2.35776644108718 |
| 94303 | 37.44424 | -122.11736 | PALO ALTO     | CALIFORNIA | CA           |  2.51480871282271 |
+-------+----------+------------+---------------+------------+--------------+-------------------+
7 rows in set (0.75 sec)
 
Query OK, 0 rows affected (0.75 sec)



Logic is client will have to pass lat, lon,zipcode and radius. Server is ignoring lat, long at the moment.
Based on the zip code, we will be finding nearest zipcodes on radius from mysql.
Then for those zip codes, we dip mongo database to pass zipcode documents.

Note - Mysql procedure will also retuen the distance between zipcodes, but we are not passing it to the client at the moment. 

