package com.microblog.db_service.model.requestentity;

import lombok.Data;

@Data
public class UserPostRequest {
	
	private String email;
	
	private String content;

}
