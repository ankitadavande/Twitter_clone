package com.microblog.db_service.model.requestentity;

import lombok.Data;

@Data
public class UserDeleteRequest {

	private String email;
	private String name;
	private String username;

	private String password;
}
