package com.tires.web.model;

public class Search {

	private int width;
	private int profile;
	private int rimsize;
	
    public Search(int width, int profile, int rimsize) {
		super();
		this.width = width;
		this.profile = profile;
		this.rimsize = rimsize;
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
}
