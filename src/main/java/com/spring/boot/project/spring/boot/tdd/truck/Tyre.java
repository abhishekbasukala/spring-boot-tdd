package com.spring.boot.project.spring.boot.tdd.truck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tyre {
	
	@JsonProperty("radius")
	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
