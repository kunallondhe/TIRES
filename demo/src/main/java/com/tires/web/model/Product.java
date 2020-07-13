package com.tires.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.springframework.context.annotation.Configuration;

@Entity
@Configuration
public class Product implements Serializable {
	@Id
	private int itemnumber;
	@Min(value = 0L, message = "{notblank.add.width}")
	private int width;
	private int profile;
	private int rimsize;
	@NotBlank(message = "{notblank.add.localisedName}")
	private String localisedName;
	@Column(length = 4000)
	private String description;
	private String speedRating;
	private String loadIndex;
	@NotBlank(message = "{notblank.add.image}")
	private String image;

	public int getItemNumber() {
		return itemnumber;
	}

	public void setItemNumber(int itemnumber) {
		this.itemnumber = itemnumber;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}

	public int getRimsize() {
		return rimsize;
	}

	public void setRimsize(int rimsize) {
		this.rimsize = rimsize;
	}

	public String getLocalisedName() {
		return localisedName;
	}

	public void setLocalisedName(String localisedName) {
		this.localisedName = localisedName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpeedRating() {
		return speedRating;
	}

	public void setSpeedRating(String speedRating) {
		this.speedRating = speedRating;
	}

	public String getLoadIndex() {
		return loadIndex;
	}

	public void setLoadIndex(String loadIndex) {
		this.loadIndex = loadIndex;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
