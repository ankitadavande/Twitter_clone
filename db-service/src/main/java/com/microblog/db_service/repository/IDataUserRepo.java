package com.microblog.db_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microblog.db_service.datamodel.DataPost;
import com.microblog.db_service.datamodel.DataUser;

@Repository
public interface IDataUserRepo extends JpaRepository<DataUser, Long>{

	public DataUser findByEmail(String email);
	
	public DataUser findByUsername(String username);
	
	public Optional<DataUser> findById(Long userId);
	
	
	
	
}
