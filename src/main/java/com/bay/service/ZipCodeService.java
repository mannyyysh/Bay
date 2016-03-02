package com.bay.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Produces({ "application/xml", "application/json" })
public interface ZipCodeService {


	@GET
	@Path("/zipcodes")
	public Response getAllZipCodes(@QueryParam("lat") Double lat, @QueryParam("lon") Double lon, @QueryParam("radius") Double radius);
}