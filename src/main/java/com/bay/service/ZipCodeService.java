package com.bay.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.bay.service.response.ZipCodeResponse;
import com.bay.service.response.ZipCodeResponses;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Produces({ "application/xml", "application/json" })
@Path("/zip-service/api")
@Api(value = "/zip-service/api", description = "Zip REST for Integration Testing")

public interface ZipCodeService {


	@GET
	@Path("/v1/zipcodes")
	@ApiOperation( value = "List all zipcodes", notes = "List all zipcodes using latitude longitude", response = ZipCodeResponse.class, responseContainer = "List")
	public Response getAllZipCodes(
			@ApiParam( value = "Latitude", required = true ) @QueryParam("lat") Double lat, 
			@ApiParam( value = "Longitude", required = true ) @QueryParam("lon") Double lon, 
			@ApiParam( value = "Radius", required = true ) @QueryParam("radius") Double radius,
			@ApiParam( value = "Zipcode", required = true ) @QueryParam("zipcode") String zipcode);
}