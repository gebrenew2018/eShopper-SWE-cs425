package edu.miu.cs.cs425.eshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Account {

	@Id
	@GeneratedValue
	private long userId;
	private  String  username;
	private  String password;
	private String []  roles;
	
	public Account() {
		super();
	}
	
	public Account(String username, String password, String[] roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	
}
