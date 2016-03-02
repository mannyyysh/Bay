package com.bay.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bay.adapter.ZipCodeAdapter;
import com.bay.domain.Zipcode;
import com.bay.repository.ZipCodeRepository;
import com.bay.service.response.ZipCodeResponses;

@Component("zipCodeBO")
public class ZipCodeBOImpl implements ZipCodeBO {
	
	@Autowired
	private ZipCodeAdapter zipCodeAdapter;
	
	@Autowired
	private ZipCodeRepository zipCodeRepository;

	public ZipCodeResponses getAllZipCodes(Double lat, Double lon,
			Double radius) {
		List<Zipcode> zList = zipCodeRepository.findAll(lat, lon, radius);
		ZipCodeResponses zipCodeResponses = null;
		if (zList != null && zList.size() > 0) {
			zipCodeResponses = zipCodeAdapter.convertToZipCodeResponse(zList);
		}
		
		return zipCodeResponses;
	}

}
