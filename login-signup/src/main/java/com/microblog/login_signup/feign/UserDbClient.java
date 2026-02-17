package com.microblog.login_signup.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microblog.login_signup.model.reqentity.LoginRequest;
import com.microblog.login_signup.model.reqentity.PostRequest;
import com.microblog.login_signup.model.reqentity.SignUpRequest;
import com.microblog.login_signup.model.resentity.LoginResponse;
import com.microblog.login_signup.model.resentity.PostResponse;
import com.microblog.login_signup.model.resentity.SignUpResponse;

@FeignClient(name="db-service", url="http://localhost:8080")
public interface UserDbClient {
	
	
	@PostMapping("User-DB-Operations/Insert")
	
	public SignUpResponse signupRes(@RequestBody SignUpRequest signupReq);
	
	@PostMapping("User-DB-Operations/Fetch")
	
	public LoginResponse logInRes(@RequestBody LoginRequest logInReq);
	
	
	@PostMapping("User-DB-Operations/posts")
	public PostResponse postRes(@RequestBody PostRequest postResobj);
	

}
