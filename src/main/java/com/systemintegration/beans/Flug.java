package com.systemintegration.beans;

import org.springframework.context.annotation.Scope;

public class Flug {
	private String Flightcode;
	private CodeVO codes;
	
	public Flug(String f, CodeVO c){
		this.Flightcode=f;
		this.codes=c;
	}
	
	public CodeVO getCodes() {
		return codes;
	}
	public void setCodes(CodeVO codes) {
		this.codes = codes;
	}
	
	
	/**
	 * @return the flightcode
	 */
	public String getFlightcode() {
		return Flightcode;
	}
	/**
	 * @param flightcode the flightcode to set
	 */
	public void setFlightcode(String flightcode) {
		Flightcode = flightcode;
	}
	
	
	
}
