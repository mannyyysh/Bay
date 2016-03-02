package com.bay.service.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "zipCodeResponse")
@XmlType(name = "", propOrder = {"city", "state","zipcode", "country", "latitude","longitude"})
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ZipCodeResponse extends Error {
	
	@XmlElement(name = "city", required = true)
	private String city;
	
	@XmlElement(name = "state", required = true)
	private String state;
	
	@XmlElement(name = "zipcode", required = true)
	private String zipcode;
	
	@XmlElement(name = "country", required = true)
	private String country;
	
	@XmlElement(name = "latitude", required = true)
	private Double latitude;
	
	@XmlElement(name = "longitude", required = true)
	private Double longitude;

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	

	

}
