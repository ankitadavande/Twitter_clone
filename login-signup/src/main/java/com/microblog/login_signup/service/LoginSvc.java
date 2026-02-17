package com.microblog.login_signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.login_signup.feign.UserDbClient;
import com.microblog.login_signup.model.reqentity.LoginRequest;
import com.microblog.login_signup.model.resentity.LoginResponse;

@Service
public class LoginSvc {

	
//	@Autowired
//	RestTemplate rest;
	
	@Autowired
	UserDbClient dbClient;
	
	public ResponseEntity loginS(LoginRequest loginReq)
	{
		if(loginReq!=null)
		{
			//SignUpResponse signupres=rest.postForObject("http://localhost:8080/User-DB-Operations/Fetch", loginreq, SignUpResponse.class);
			LoginResponse logInres=dbClient.logInRes(loginReq);
			if(logInres.getEmail()==null)
			{
				LoginResponse logInres1=new LoginResponse("User not found");
				return new ResponseEntity(logInres1,HttpStatus.OK);
				
			}
			else {
				if(logInres.getPassword().equals(loginReq.getPassword()))
				{
					LoginResponse logInres1=new LoginResponse("Login Successful");
					return new ResponseEntity(logInres1,HttpStatus.OK);
				}
				else
				{
					LoginResponse logInres1=new LoginResponse("password not matched");
					return new ResponseEntity(logInres1,HttpStatus.OK);
				}
			}
			
		}
		else
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
