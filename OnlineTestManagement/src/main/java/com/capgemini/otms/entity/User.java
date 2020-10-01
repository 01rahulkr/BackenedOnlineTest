package com.capgemini.otms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UserTest")
/**
 * 
 * user pojo class
 *
 */
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long userId;
	private String userName;
	private int testId = 0;
	private boolean isAdmin = false;
	private String email;
	private String userPassword;


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public User(String userName, int testId, boolean isAdmin, String email, String userPassword) {

		this.userName = userName;
		this.testId = testId;
		this.isAdmin = isAdmin;
		this.email = email;
		this.userPassword = userPassword;
	}

	public User() {
	}
}
