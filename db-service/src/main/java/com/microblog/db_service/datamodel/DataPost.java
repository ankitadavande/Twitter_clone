package com.microblog.db_service.datamodel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TWITTER_POST")

public class DataPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TWEET_ID")
	private Long tweetId;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="CREATED_DATE")
	private LocalDateTime createdDate;
	
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	DataUser user;
	
	@OneToMany(mappedBy = "post", cascade=CascadeType.ALL)
	private List<UserLikes> likes=new ArrayList<>();
	
	
}
