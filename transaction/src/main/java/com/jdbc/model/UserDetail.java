package com.jdbc.model;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable{

	private static final long serialVersionUID = 1L;

	private int userDetailId;
	
	private String fistName;
	
	private String lastName;
	
	private Date birthDate;
	
	public UserDetail() {
}

	public UserDetail(int userDetailId, String fistName, String lastName, Date birthDate) {
		this.userDetailId = userDetailId;
		this.fistName = fistName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public int getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(int userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", fistName=" + fistName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + "]";
	}

	 
}
