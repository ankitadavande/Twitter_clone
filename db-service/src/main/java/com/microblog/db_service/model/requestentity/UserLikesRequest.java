package com.microblog.db_service.model.requestentity;

import lombok.Data;

@Data
public class UserLikesRequest {
	
	private Long userId;
	
	private Long tweetId;
	
	private String email;

}
