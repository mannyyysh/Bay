/**
 * 
 */
package com.bay.adapter;

import java.util.List;

import com.bay.domain.Zipcode;
import com.bay.service.response.ZipCodeResponses;

/**
 * @author aagarwal
 *
 */
public interface ZipCodeAdapter {
	
	public ZipCodeResponses convertToZipCodeResponse(List<Zipcode> zipcodes);

}
