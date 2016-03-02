package com.bay.adapter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bay.domain.Zipcode;
import com.bay.service.response.ZipCodeResponse;
import com.bay.service.response.ZipCodeResponses;


@Component("zipCodeAdapter")
public class ZipCodeAdapterImpl implements ZipCodeAdapter{
	private static Logger log = LoggerFactory.getLogger(ZipCodeAdapterImpl.class);
	
	public ZipCodeResponses convertToZipCodeResponse(List<Zipcode> zipcodes) {
		List<ZipCodeResponse> zipCodeResponseList = null;
		ZipCodeResponses zipCodeResponses = null;
		if (zipcodes != null && zipcodes.size() > 0) {
			zipCodeResponseList = new ArrayList<ZipCodeResponse>();
			zipCodeResponses = new ZipCodeResponses();
			for (Zipcode zipcode: zipcodes) {
				ZipCodeResponse zipCodeResponse = convert(zipcode);
				zipCodeResponseList.add(zipCodeResponse);
			}
			zipCodeResponses.setZipCodeResponse(zipCodeResponseList);
		}
		return zipCodeResponses;
	}
	
	
	
	private ZipCodeResponse convert(Zipcode zipcode) {
		ZipCodeResponse zipCodeResponse = new ZipCodeResponse();
		zipCodeResponse.setCity(zipcode.getCity());
		zipCodeResponse.setCountry(zipcode.getCountry());
		zipCodeResponse.setLatitude(zipcode.getLoc().getCoordinates().get(0));
		zipCodeResponse.setLongitude(zipcode.getLoc().getCoordinates().get(1));
		zipCodeResponse.setState(zipcode.getState());
		zipCodeResponse.setZipcode(zipcode.getZipcode());
		return zipCodeResponse;
	}

}
