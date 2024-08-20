package com.jonheri.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class UserDTO {

	private String id;
	private String email;
	private String username;
	private String fullname;

	public UserDTO(String id, String email, String username, String fullname) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
	}
}
