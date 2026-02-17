package com.microblog.login_signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableFeignClients(
		basePackages = "com.microblog.login_signup.feign"
		)
@SpringBootApplication
public class LoginSignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSignupApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
}
