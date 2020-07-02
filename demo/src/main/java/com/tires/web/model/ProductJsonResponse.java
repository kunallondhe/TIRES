package com.tires.web.model;

import java.util.Map;

public class ProductJsonResponse {
	private boolean validated;
	private Map<String, String> errorMessages;
	
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
}