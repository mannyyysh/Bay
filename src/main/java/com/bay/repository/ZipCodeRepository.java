/**
 * 
 */
package com.bay.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Query.*;
import org.springframework.stereotype.Repository;

import com.bay.domain.Zipcode;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @author aagarwal
 *
 */
@Repository("zipCodeRepository")
public class ZipCodeRepository {
private static final Logger log = LoggerFactory.getLogger(ZipCodeRepository.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
//	public List<Zipcode> findAll(Double lat, Double lon, Double radius) {
//		List<Zipcode> zipList = null;
//		   NearQuery nq = NearQuery.near(lon, lat, Metrics.MILES).maxDistance(new Double(radius));
//		   GeoResults<Zipcode> zipGeoResults = mongoTemplate.geoNear(nq, Zipcode.class);
//		   if (zipGeoResults != null) {
//			   zipList = new ArrayList<Zipcode>();
//		    for (GeoResult<Zipcode> e : zipGeoResults) {
//		    	zipList.add(e.getContent());
//		    }
//		   
//		   }
//        return zipList;
//		   
//	}
	
	public List<Zipcode> findAll(Double lat, Double lon, Double radius) {
		Point point = new Point(lon, lat);
		List<Zipcode> zipList = null;
		   NearQuery nq = NearQuery.near(point).maxDistance(new Distance(radius, Metrics.MILES));
		    GeoResults<Zipcode> zipGeoResults = mongoTemplate.geoNear(nq, Zipcode.class);
		   if (zipGeoResults != null) {
			   zipList = new ArrayList<Zipcode>();
		    for (GeoResult<Zipcode> e : zipGeoResults) {
		    	zipList.add(e.getContent());
		    }
		   
		   }
//		   Double[] latlon = new Double[2];
//		   latlon[0] = lat;
//		   latlon[1] = lon;
//		   DBObject geoQuery = buildGeoQuery(latlon, radius);
//		   DBObject Loc = BasicDBObjectBuilder.start().add("loc", geoQuery).get();
//		   DBCursor cursor = mongoTemplate.getCollection("zipcodes").find(Loc);
//		   zipList = cursor.hasNext() ? new ArrayList<Zipcode>() : null;
//		   while (cursor.hasNext()) {
//		    DBObject zipDBObject = (DBObject)cursor.next();
//		    Zipcode e = mongoTemplate.getConverter().read(Zipcode.class, zipDBObject);
//		    zipList.add(e);
//		   }
		   
		   
        return zipList;
		   
	}
	
	 /**
	  * Builds geo query using latitude, longitude co-ordinates and radius. Given
	  * radius is in miles and needs to be converted into meters.
	  * @param lname
	  * @param latlng
	  * @param radius
	  * @return
	  */
	 private DBObject buildGeoQuery(Double[] latlng, Double radius) {
	  // Mongo uses longitude, latitude combination
	  Double[] coordinates = new Double[] {latlng[1], latlng[0]};
	  DBObject geometryContent = BasicDBObjectBuilder.start().add("type", "Point")
	    .add("coordinates", coordinates).get();
	  DBObject nearContent = BasicDBObjectBuilder.start().add("$geometry", geometryContent)
	    .add("$maxDistance", (Double.valueOf(radius) * 1609.34)).get();
	  DBObject addressLocContent = BasicDBObjectBuilder.start().add("$near", nearContent).get();
	  return addressLocContent;
	 }
	 
	 public List<Zipcode> findZipcodes(List<String> zipCodes) {
			List<Zipcode> zipList = null;
			Query query = new Query();
			query.addCriteria(Criteria.where("zipcode").in(zipCodes));
			zipList = mongoTemplate.find(query, Zipcode.class);

			   
	        return zipList;
			   
		}
	 
	 

}
