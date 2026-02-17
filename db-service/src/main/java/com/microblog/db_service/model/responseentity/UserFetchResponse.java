package com.microblog.db_service.model.responseentity;

import lombok.Data;

@Data
public class UserFetchResponse {
	
	private String email;
	private String name;
	private String username;

	private String password;

}
