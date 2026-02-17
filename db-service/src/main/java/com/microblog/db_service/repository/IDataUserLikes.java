package com.microblog.db_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microblog.db_service.datamodel.DataPost;
import com.microblog.db_service.datamodel.DataUser;
import com.microblog.db_service.datamodel.UserLikes;

public interface IDataUserLikes extends JpaRepository<UserLikes, Long>{

	UserLikes findByUserAndPost(DataUser user1, DataPost post1);

}
