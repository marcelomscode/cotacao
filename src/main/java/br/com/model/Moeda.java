package br.com.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Moeda {
	
	@JsonProperty("EURBRL")
	private Currency EURBRL;
	
	@JsonProperty("USDBRL")
	private Currency USDBRL;
	
	public Currency getUSDBRL() {
		return USDBRL;
	}

	public void setUSDBRL(Currency uSDBRL) {
		USDBRL = uSDBRL;
	}

	public Currency getEURBRL() {
		return EURBRL;
	}

	public void setEURBRL(Currency eURBRL) {
		EURBRL = eURBRL;
	}

}
