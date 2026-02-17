package com.microblog.db_service.datamodel;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.AnyDiscriminatorImplicitValues.Strategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "TWITTER_USER",
		uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))

public class DataUser {
	
	@Column(name = "NAME")
	private String name;
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

	public DataUser() {
		super();
	}
	
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
	private List<DataPost> post=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "user") // 'user' is the field in Like.java
	private List<UserLikes> likes;
	
	
	@OneToMany(mappedBy = "follower", cascade=CascadeType.ALL)
	private List<DataFollower> follower;
	
	
	@OneToMany(mappedBy = "followee", cascade=CascadeType.ALL)
	private List<DataFollower> followee;

//	@OneToMany(mappedBy = "tweet", cascade=CascadeType.ALL)
//	private List<UserLikes> likes=new ArrayList<>();

}
