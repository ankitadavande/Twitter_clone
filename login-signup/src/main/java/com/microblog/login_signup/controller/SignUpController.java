package com.microblog.login_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.login_signup.model.reqentity.SignUpRequest;
import com.microblog.login_signup.service.SignUpSvc;

@RestController
@RequestMapping("/signUp")
public class SignUpController {

	
	@Autowired
	SignUpSvc signupsvc;
	
	@PostMapping
	public ResponseEntity signUpC(@RequestBody SignUpRequest req1)
	{
		return signupsvc.signUpS(req1);
	}
}
