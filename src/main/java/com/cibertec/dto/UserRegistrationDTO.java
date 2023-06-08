package com.cibertec.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserRegistrationDTO {
	private String username;
    private String password;
    private List<Long> roles;
}
