package com.tires.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Product {
	@Id
	private int itemNumber;
	private int width;
	private int profile;
	private int rimsize;
	private String localisedName;
	@Column(length = 4000)
	private String description;
	private String speedRating;
	private int loadIndex;
	private String image;

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
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

	public int getLoadIndex() {
		return loadIndex;
	}

	public void setLoadIndex(int loadIndex) {
		this.loadIndex = loadIndex;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
