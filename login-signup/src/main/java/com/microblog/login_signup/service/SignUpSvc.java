package com.microblog.login_signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microblog.login_signup.feign.UserDbClient;
import com.microblog.login_signup.model.reqentity.SignUpRequest;
import com.microblog.login_signup.model.resentity.SignUpResponse;

@Service
public class SignUpSvc {

	
//	@Autowired
//	RestTemplate rest;
	
	@Autowired
	UserDbClient dbClient;
	
	public ResponseEntity signUpS(SignUpRequest signureq1)
	{
		if(signureq1!=null)
		{
			//SignUpResponse signupres=rest.postForObject("http://localhost:8080/User-DB-Operations/Insert", signureq1, SignUpResponse.class);
			SignUpResponse signupres = dbClient.signupRes(signureq1);
			return new ResponseEntity(signupres,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}
}
