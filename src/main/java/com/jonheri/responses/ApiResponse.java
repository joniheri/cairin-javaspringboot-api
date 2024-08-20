package com.jonheri.responses;

import com.jonheri.DTOs.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponse<T> {

	private String status;
	private String message;
	private T data;

	public ApiResponse(String status, String message, T data) {
		this.status = status;
		this.message = status;
		this.data = data;
	}
}
