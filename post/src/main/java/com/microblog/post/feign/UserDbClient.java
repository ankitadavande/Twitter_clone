package com.microblog.post.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microblog.post.configuration.ClientConfiguration;
import com.microblog.post.reqentity.PostRequest;
import com.microblog.post.resentity.PostResponse;

@FeignClient(name="db-service", url="http://localhost:8080",configuration = ClientConfiguration.class)
public interface UserDbClient {

	
	@PostMapping("User-DB-Operations/posts")
	public PostResponse postRes(@RequestBody PostRequest postResobj);
}
