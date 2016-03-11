package com.bay.bo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bay.adapter.ZipCodeAdapter;
import com.bay.db.template.ZipJDBCTemplate;
import com.bay.domain.Zip;
import com.bay.domain.Zipcode;
import com.bay.repository.ZipCodeRepository;
import com.bay.service.response.ZipCodeResponses;

@Component("zipCodeBO")
public class ZipCodeBOImpl implements ZipCodeBO {
	
	@Autowired
	private ZipCodeAdapter zipCodeAdapter;
	
	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	@Autowired
    private ZipJDBCTemplate zipJDBCTemplate;

	public ZipCodeResponses getAllZipCodes(Double lat, Double lon,
			Double radius,String zipcode) {
		List<Zip> zips = zipJDBCTemplate.findZips(zipcode, radius);
		List<String> list = zips.stream().map(t -> t.getZip()).collect(Collectors.toList());
		
		List<Zipcode> zList = zipCodeRepository.findZipcodes(list);
		ZipCodeResponses zipCodeResponses = null;
		if (zList != null && zList.size() > 0) {
			zipCodeResponses = zipCodeAdapter.convertToZipCodeResponse(zList);
		}
		
		return zipCodeResponses;
	}

}
