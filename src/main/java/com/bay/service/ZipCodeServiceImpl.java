package com.bay.service;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bay.adapter.ZipCodeAdapter;
import com.bay.bo.ZipCodeBO;
import com.bay.service.response.ZipCodeResponses;

@Service("zipCodeService")
public class ZipCodeServiceImpl implements ZipCodeService {
    private static Logger log = LoggerFactory.getLogger(ZipCodeServiceImpl.class);
    
    @Autowired
    private ZipCodeBO zipCodeBO;
    
    @Autowired
    private ZipCodeAdapter zipCodeAdapter;
    
    
	public Response getAllZipCodes(Double lat, Double lon, Double radius) {
		ZipCodeResponses zipCodeResponses = null;
		log.info("received getAllZipCodes request");
		try {
			zipCodeResponses = zipCodeBO.getAllZipCodes(lat, lon, radius);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return Response.ok(zipCodeResponses).build();
	}
	
}
