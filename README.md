# Bay
Demo App Server to feth zipcodes based on lat, long and miles
Sample URL
http://localhost:8080/house-0.0.1-SNAPSHOT/zipcodes?lat=37.3382&lon=121.8863&radius=10.0

Have integrated swagger too. Cool to read APIs

Need to run this once we insert data to Mongo
db.zipcodes.createIndex({"loc": "2dsphere"});


Location object in Zipcode has list of coordiantes. Make sure we  insert longitude first, and then latitude.
