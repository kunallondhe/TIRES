package com.tires.web.model;

import javax.validation.constraints.NotBlank;

public class Search {

	@NotBlank(message = "Enter width")
	private String width;
	@NotBlank(message="Enter profile")
	private String profile;
	@NotBlank(message="Enter rimsize")
	private String rimsize;
	
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getRimsize() {
		return rimsize;
	}
	public void setRimsize(String rimsize) {
		this.rimsize = rimsize;
	}
}
