
package com.example.demo.model;

public class UserRegistrationModel {
	private Long userId;
	private String email;
	private String firstName;
	private String lastName;
	public UserRegistrationModel (Long userId,String email, String firstName, String lastName) {
		this.userId=userId;
		this.email=email;
		this.firstName=firstName;
		this.lastName=lastName;
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	  public String toString() {
	    return "Tutorial [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	  }
	
}
