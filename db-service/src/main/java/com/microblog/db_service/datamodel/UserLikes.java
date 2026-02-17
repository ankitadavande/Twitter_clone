package com.microblog.db_service.datamodel;

import org.apache.el.parser.AstFalse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name="TWITTER_LIKES")

public class UserLikes {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LIKE_ID")
	private long likeId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable = false)
	private DataUser user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TWEET_ID", nullable = false)
	private DataPost post;
	//private DataPost tweet;
	
	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private DataUser user;

}
