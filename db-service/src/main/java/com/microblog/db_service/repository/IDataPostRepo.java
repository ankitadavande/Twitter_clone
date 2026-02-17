package com.microblog.db_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microblog.db_service.datamodel.DataPost;
import com.microblog.db_service.datamodel.DataUser;

public interface IDataPostRepo extends JpaRepository<DataPost, Long>{
	
	public Optional<DataPost> findById(Long tweetId);

}
