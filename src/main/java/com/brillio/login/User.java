package com.brillio.login;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class User {
	@Id
	private String id;
	
	private String email;
	private String password;
	public User() {
		super();
	}
	
	public User( String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
