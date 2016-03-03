package com.bay.service.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "zipCodeResponses")
@XmlType(name = "", propOrder = {"zipCodeResponse"})
@ApiModel( value = "ZipCodeResponses", description = "ZipCodeResponses resource representation" )
public class ZipCodeResponses extends Error {
	
	@ApiModelProperty( value = "zipCodeResponse", required = true ) 
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
