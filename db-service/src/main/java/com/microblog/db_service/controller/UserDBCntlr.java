package com.microblog.db_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.db_service.datamodel.DataPost;
import com.microblog.db_service.model.requestentity.DataFollowerRequest;
import com.microblog.db_service.model.requestentity.MyPostRequest;
import com.microblog.db_service.model.requestentity.UserDeleteRequest;
import com.microblog.db_service.model.requestentity.UserFetchRequest;
import com.microblog.db_service.model.requestentity.UserLikesRequest;
import com.microblog.db_service.model.requestentity.UserPostRequest;
import com.microblog.db_service.model.requestentity.UserRequest;
import com.microblog.db_service.model.requestentity.UserUpdatedRequest;
import com.microblog.db_service.service.UserDBSvc;

@RestController
@RequestMapping("/User-DB-Operations")
public class UserDBCntlr {
	
	@Autowired
	UserDBSvc userdbsvc;
	
	@PostMapping("/Insert")
	public ResponseEntity insertUserData(@RequestBody UserRequest req1)
	{
		return userdbsvc.insertUserData(req1);
	}
	@PostMapping("/Update")
	public ResponseEntity updateUserData(@RequestBody UserUpdatedRequest req2)
	{
		return userdbsvc.updateUserData(req2);
	}
	@PostMapping("/Fetch")
	public ResponseEntity fetchUserData(@RequestBody UserFetchRequest req3)
	{
		return userdbsvc.fetchUserData(req3);
	}
	
	@DeleteMapping("/Delete")
	public ResponseEntity deleteUserData(@RequestBody UserDeleteRequest req4 )
	{
		return userdbsvc.deleteUserData(req4);
	}
	
	
	@PostMapping("/posts")
	public ResponseEntity postData(@RequestBody UserPostRequest req5)
	{
		return userdbsvc.postDataS(req5);
	}
	
	
	@PostMapping("/likes")
	public ResponseEntity likesData(@RequestBody UserLikesRequest req6)
	{
		return userdbsvc.likesDataS(req6);
	}
	
	
	@PostMapping("/follow")
	public ResponseEntity followData(@RequestBody DataFollowerRequest req7)
	{
		return userdbsvc.followDataS(req7);
	}

	
	@PostMapping("/myposts")
	public ResponseEntity<List<DataPost>> getmyPosts(@RequestBody MyPostRequest req8)
	{
		return userdbsvc.getMyPostsS(req8);
	}
	
}
