package com.microblog.db_service.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.db_service.datamodel.DataFollower;
import com.microblog.db_service.datamodel.DataPost;
import com.microblog.db_service.datamodel.DataUser;
import com.microblog.db_service.datamodel.UserLikes;
import com.microblog.db_service.model.requestentity.DataFollowerRequest;
import com.microblog.db_service.model.requestentity.MyPostRequest;
import com.microblog.db_service.model.requestentity.UserDeleteRequest;
import com.microblog.db_service.model.requestentity.UserFetchRequest;
import com.microblog.db_service.model.requestentity.UserLikesRequest;
import com.microblog.db_service.model.requestentity.UserPostRequest;
import com.microblog.db_service.model.requestentity.UserRequest;
import com.microblog.db_service.model.requestentity.UserUpdatedRequest;
import com.microblog.db_service.model.responseentity.UserFetchResponse;
import com.microblog.db_service.repository.IDataFollower;
import com.microblog.db_service.repository.IDataPostRepo;
import com.microblog.db_service.repository.IDataUserLikes;
import com.microblog.db_service.repository.IDataUserRepo;

@Service
public class UserDBSvc {

	@Autowired
	IDataUserRepo repo;

	@Autowired
	IDataPostRepo repo2;

	@Autowired
	IDataUserLikes likerepo3;

	@Autowired
	IDataFollower followrepo4;

	public ResponseEntity insertUserData(UserRequest req1) {
		if (req1 != null && req1.getEmail() != null) {
			try {
				DataUser user1 = repo.findByEmail(req1.getEmail());
				DataUser user2 = repo.findByUsername(req1.getUsername());

				if (user1 != null) {
					Map<String, String> responseMap = new HashMap<>();
					responseMap.put("msg", "user alreeady exist");
					return new ResponseEntity<>(responseMap, HttpStatus.OK);

				} else if (user2 != null) {
					Map<String, String> responseMap = new HashMap<>();
					responseMap.put("msg", "username not available");
					return new ResponseEntity<>(responseMap, HttpStatus.OK);
				}

				else {

					{
						DataUser datauser1 = new DataUser();
						datauser1.setEmail(req1.getEmail());
						datauser1.setName(req1.getName());
						datauser1.setUsername(req1.getUsername());
						datauser1.setPassword(req1.getPassword());

						repo.save(datauser1);

					}
					Map<String, String> responseMap = new HashMap<>();
					responseMap.put("msg", "user created");
					return new ResponseEntity<>(responseMap, HttpStatus.OK);
				}
			}

			catch (Exception e) {
				// TODO: handle exception
				Map<String, String> responseMap1 = new HashMap<>();
				responseMap1.put("msg", "db down");
				return new ResponseEntity<>(responseMap1, HttpStatus.OK);
			}
		} else {
			Map<String, String> responseMap1 = new HashMap<>();
			responseMap1.put("msg", "something went wrong");
			return new ResponseEntity<>(responseMap1, HttpStatus.OK);
		}

	}

	public ResponseEntity updateUserData(UserUpdatedRequest updatedReq1) {
		try {
			DataUser user1 = repo.findByEmail(updatedReq1.getEmail());
			if (user1 != null) {
				user1.setName(updatedReq1.getName());
				user1.setUsername(updatedReq1.getUsername());
				user1.setPassword(updatedReq1.getPassword());

				repo.save(user1);

				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "user details updated");
				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			} else {
				Map<String, String> responseMap1 = new HashMap<>();
				responseMap1.put("msg", "user not found");
				return new ResponseEntity<>(responseMap1, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap1 = new HashMap<>();
			responseMap1.put("msg", "dbb down");
			return new ResponseEntity<>(responseMap1, HttpStatus.OK);
		}

	}

	public ResponseEntity fetchUserData(UserFetchRequest fetchreq1) {
		try {

			DataUser user1 = repo.findByEmail(fetchreq1.getEmail());
			if (user1 != null) {
				UserFetchResponse fetchres1 = new UserFetchResponse();
				fetchres1.setName(user1.getName());
				fetchres1.setUsername(user1.getUsername());
				fetchres1.setEmail(user1.getEmail());
				fetchres1.setPassword(user1.getPassword());
				return new ResponseEntity<>(fetchres1, HttpStatus.OK);
			}

			else {
				Map<String, String> responseMap1 = new HashMap<>();
				responseMap1.put("msg", "user details not found");
				return new ResponseEntity<>(responseMap1, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap1 = new HashMap<>();
			responseMap1.put("msg", "dbb down");
			return new ResponseEntity<>(responseMap1, HttpStatus.OK);
		}

	}

	public ResponseEntity deleteUserData(UserDeleteRequest deletereq1) {
		try {
			DataUser user1 = repo.findByEmail(deletereq1.getEmail());
			if (user1 != null) {
				repo.delete(user1);
				Map<String, String> responseMap1 = new HashMap<>();
				responseMap1.put("msg", "user deleted");
				return new ResponseEntity<>(responseMap1, HttpStatus.OK);
			} else {
				Map<String, String> responseMap1 = new HashMap<>();
				responseMap1.put("msg", "user not found");
				return new ResponseEntity<>(responseMap1, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap1 = new HashMap<>();
			responseMap1.put("msg", "dbb down");
			return new ResponseEntity<>(responseMap1, HttpStatus.OK);
		}

	}

	public ResponseEntity postDataS(UserPostRequest postReq1) {
		if (postReq1 != null && postReq1.getEmail() != null) {

			DataUser user1 = repo.findByEmail(postReq1.getEmail());

			if (user1 != null) {
				DataPost dataPost = new DataPost();
				dataPost.setContent(postReq1.getContent());
				dataPost.setUser(user1);
				dataPost.setCreatedDate(LocalDateTime.now());
				repo2.save(dataPost);

				Map<String, String> responseMap1 = new HashMap<>();
				responseMap1.put("msg", "Post save");
				return new ResponseEntity<>(responseMap1, HttpStatus.OK);
			} else {
				Map<String, String> responseMap1 = new HashMap<>();
				responseMap1.put("msg", "user not found");
				return new ResponseEntity<>(responseMap1, HttpStatus.OK);
			}
		} else {
			Map<String, String> responseMap1 = new HashMap<>();
			responseMap1.put("msg", "something went wrong");
			return new ResponseEntity<>(responseMap1, HttpStatus.OK);
		}

	}

	public ResponseEntity likesDataS(UserLikesRequest likeReq1) {

		if (likeReq1 != null && likeReq1.getEmail() != null && likeReq1.getTweetId() != null) {
			DataUser user1 = repo.findByEmail(likeReq1.getEmail());
			// Optional<DataUser> user2=repo.findById(likeReq1.getUserId());

			if (user1 != null) {
				DataPost post1 = repo2.findById(likeReq1.getTweetId()).orElse(null);

				UserLikes like1 = likerepo3.findByUserAndPost(user1, post1);

				if (post1 != null && like1 == null) {
					UserLikes userlike = new UserLikes();
					// userlike.setUser(user1);

					userlike.setUser(user1);
					userlike.setPost(post1);

					likerepo3.save(userlike);
					Map<String, String> responseMap1 = new HashMap<>();
					responseMap1.put("msg", "post likedd");
					return new ResponseEntity<>(responseMap1, HttpStatus.OK);

				} else {
					Map<String, String> responseMap1 = new HashMap<>();
					responseMap1.put("msg", "already liked post");
					return new ResponseEntity<>(responseMap1, HttpStatus.OK);
				}
			} else {
				Map<String, String> responseMap1 = new HashMap<>();
				responseMap1.put("msg", "user not found");
				return new ResponseEntity<>(responseMap1, HttpStatus.OK);
			}
		} else {
			Map<String, String> responseMap1 = new HashMap<>();
			responseMap1.put("msg", "something went wrong");
			return new ResponseEntity<>(responseMap1, HttpStatus.OK);
		}

	}

	public ResponseEntity followDataS(DataFollowerRequest followReq1) {
		if (followReq1 != null) {
			Optional<DataUser> user1 = repo.findById(followReq1.getFollower());

			Optional<DataUser> user2 = repo.findById(followReq1.getFollowee());

			DataFollower follow = new DataFollower();

			follow.setFollower(user1.get());
			follow.setFollowee(user2.get());

			followrepo4.save(follow);

			Map<String, String> responseMap1 = new HashMap<>();
			responseMap1.put("msg", "doneee");
			return new ResponseEntity<>(responseMap1, HttpStatus.OK);

		}
		else {
			Map<String, String> responseMap1 = new HashMap<>();
			responseMap1.put("msg", "something went wrong");
			return new ResponseEntity<>(responseMap1, HttpStatus.OK);
		}
	}
	
	
	public ResponseEntity<List<DataPost>>  getMyPostsS(MyPostRequest mypostReq)
	{
		List<DataFollower> following=followrepo4.findByFollowerUserId(mypostReq.getUserId());
		
		return null;
		
	}

}
