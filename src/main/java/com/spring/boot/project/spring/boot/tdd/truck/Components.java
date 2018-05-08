package com.spring.boot.project.spring.boot.tdd.truck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Components {

	@JsonProperty("mirror")
	private String mirror;
	
	@JsonProperty("tyre")
	private Tyre tyre;

	public String getMirror() {
		return mirror;
	}

	public void setMirror(String mirror) {
		this.mirror = mirror;
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

}
