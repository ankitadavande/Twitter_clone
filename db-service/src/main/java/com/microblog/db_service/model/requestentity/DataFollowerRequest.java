package com.microblog.db_service.model.requestentity;

import lombok.Data;

@Data
public class DataFollowerRequest {

	private Long follower;

	private Long followee;

}
