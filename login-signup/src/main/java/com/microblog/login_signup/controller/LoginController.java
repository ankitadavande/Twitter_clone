package com.microblog.login_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.login_signup.model.reqentity.LoginRequest;
import com.microblog.login_signup.service.LoginSvc;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	LoginSvc loginsvc;
	
	@PostMapping
	
	public ResponseEntity loginC(@RequestBody LoginRequest loginreq1)
	{
		return loginsvc.loginS(loginreq1);
	}
	

}
