package com.example.coffeeshop.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRegisterResponse {
	private Boolean success = false;

	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
