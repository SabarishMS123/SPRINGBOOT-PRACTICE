package com.example.payload.response;

import com.example.payload.dto.UserDto;

import lombok.Data;

@Data
public class AuthResponse {
      private String jwt;
      private String message;
      private UserDto user;
	  public String getJwt() {
		  return jwt;
	  }
	  public void setJwt(String jwt) {
		  this.jwt = jwt;
	  }
	  public String getMessage() {
		  return message;
	  }
	  public void setMessage(String message) {
		  this.message = message;
	  }
	  public UserDto getUser() {
		  return user;
	  }
	  public void setUser(UserDto user) {
		  this.user = user;
	  }
	
}
