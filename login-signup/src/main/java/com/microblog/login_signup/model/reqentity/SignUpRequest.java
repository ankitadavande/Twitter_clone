package com.microblog.login_signup.model.reqentity;

import lombok.Data;

@Data
public class SignUpRequest {
	
	private String email;
	private String name;
	private String username;

	private String password;

}
