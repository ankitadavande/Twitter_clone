package com.microblog.db_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microblog.db_service.datamodel.DataFollower;

public interface IDataFollower extends JpaRepository<DataFollower, Long>{

	List<DataFollower> findByFollowerUserId(Long userId);

}
