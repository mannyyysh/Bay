package com.bay.bo;

import com.bay.service.response.ZipCodeResponses;

public interface ZipCodeBO {
	public ZipCodeResponses getAllZipCodes(Double lat, Double lon, Double radius);

}
