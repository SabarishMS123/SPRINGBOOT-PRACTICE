package com.school.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {

    public JwtResponse(String jwt, String string, String username2, List<String> roles2) {
		// TODO Auto-generated constructor stub
	}
	private String token;
    private String type;
    private String username;
    private List<String> roles;
}
