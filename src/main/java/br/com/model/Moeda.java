package br.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Moeda {
	
	@JsonProperty("EURBRL")
	private Currency EURBRL;
	
	@JsonProperty("USDBRL")
	private Currency USDBRL;

	public Currency getEURBRL() {
		return EURBRL;
	}

	public Currency getUSDBRL() {
		return USDBRL;
	}
	
	
	
}
