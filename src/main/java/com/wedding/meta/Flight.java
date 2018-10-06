package com.wedding.meta;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="flightdata")
public class Flight {
	
	String ORIGIN_AIRPORT;
	String DESTINATION_AIRPORT;
	String AIRLINE_DELAY;
	public String getAIRLINE_DELAY() {
		return AIRLINE_DELAY;
	}
	public void setAIRLINE_DELAY(String aIRLINE_DELAY) {
		AIRLINE_DELAY = aIRLINE_DELAY;
	}
	public String getORIGIN_AIRPORT() {
		return ORIGIN_AIRPORT;
	}
	public void setORIGIN_AIRPORT(String oRIGIN_AIRPORT) {
		ORIGIN_AIRPORT = oRIGIN_AIRPORT;
	}
	public String getDESTINATION_AIRPORT() {
		return DESTINATION_AIRPORT;
	}
	public void setDESTINATION_AIRPORT(String dESTINATION_AIRPORT) {
		DESTINATION_AIRPORT = dESTINATION_AIRPORT;
	}

}
