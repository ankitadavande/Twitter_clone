package com.microblog.login_signup.model.resentity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LoginResponse {

	private String msg;
	
	
	private String email;
//	private String name;
//	private String username;

	private String password;

	public LoginResponse(String msg) {
		super();
		this.msg = msg;
	}
}
