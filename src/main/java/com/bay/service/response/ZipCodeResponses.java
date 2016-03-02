package com.bay.service.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "zipCodeResponses")
@XmlType(name = "", propOrder = {"zipCodeResponse"})
public class ZipCodeResponses extends Error {
	
	@XmlElement(name = "zipCodeResponse", required = true)
	private List<ZipCodeResponse> zipCodeResponse;

	/**
	 * @return the zipCodeResponse
	 */
	public List<ZipCodeResponse> getZipCodeResponse() {
		return zipCodeResponse;
	}

	/**
	 * @param zipCodeResponse the zipCodeResponse to set
	 */
	public void setZipCodeResponse(List<ZipCodeResponse> zipCodeResponse) {
		this.zipCodeResponse = zipCodeResponse;
	}

	

	
}
