package com.microblog.db_service.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TWITTER_FOLLOWER")

public class DataFollower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FOLLOW_ID")
	private long followId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FOLLOWER_ID", nullable = false)
	private DataUser follower;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FOLLOWEE_ID", nullable = false)
	private DataUser followee;
	
}
