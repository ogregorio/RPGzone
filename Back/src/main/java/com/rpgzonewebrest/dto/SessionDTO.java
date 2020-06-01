package com.rpgzonewebrest.dto;

import java.io.Serializable;

import com.rpgzonewebrest.models.data.BrazilianDate;

public class SessionDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BrazilianDate brazilianDate;
	private String street;
	private String zipCode;
	private String country;
	private Long sessionID;
	private static Long sessionCounter = new Long(0);

	public SessionDTO(BrazilianDate brazilianDate, String street, String zipCode, String country) {
		this.setBrazilianDate(brazilianDate);
		this.setCountry(country);
		this.setStreet(street);
		this.setZipCode( putTrace(zipCode) );
		this.setSessionID( generateSessionID() );
	}
	public SessionDTO() { this.setSessionID( generateSessionID() ); }
	
	public static String putTrace(String zipCode) {
		return zipCode.substring(0, 5) + '-' + zipCode.substring(5, 8);
	}
	public static Long generateSessionID() {
		sessionCounter = new Long(sessionCounter.longValue() + 1);
		return sessionCounter;
	}

	public BrazilianDate getBrazilianDate() {
		return brazilianDate;
	}

	public void setBrazilianDate(BrazilianDate brazilianDate) {
		this.brazilianDate = brazilianDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object obj) {
		return ( (SessionDTO) obj ).getSessionID() == this.getSessionID();
	}
	public Long getSessionID() {
		return sessionID;
	}
	public void setSessionID(Long sessionID) {
		this.sessionID = sessionID;
	}
}
