package com.tires.web.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Search implements Serializable {
	@NotBlank(message = "{notblank.search.width}")
	private String width;
	@NotBlank(message = "{notblank.search.profile}")
	private String profile;
	@NotBlank(message = "{notblank.search.rimsize}")
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
