package com.example.userservice.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {

	private Long userId;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	public UserDTO() {
		
	}

	public UserDTO(Long userId, String firstName, String lastName, String emailId) {

		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
