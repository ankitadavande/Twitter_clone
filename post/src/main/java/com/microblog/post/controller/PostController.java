package com.microblog.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.post.reqentity.PostRequest;
import com.microblog.post.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
 
	@Autowired
	PostService postsvc;
	
	@PostMapping
	public ResponseEntity datapostC(@RequestBody PostRequest postReq1) {
		return postsvc.dataPostS(postReq1);
	}
	
	
}
