package com.microblog.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.post.feign.UserDbClient;
import com.microblog.post.reqentity.PostRequest;
import com.microblog.post.resentity.PostResponse;


@Service
public class PostService {
	
	
	@Autowired
	UserDbClient dbClient;
	
	public ResponseEntity dataPostS(PostRequest postReq1)
	{
		if(postReq1!=null)
		{
		PostResponse postRes=dbClient.postRes(postReq1);
		return new ResponseEntity(postRes,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

}
