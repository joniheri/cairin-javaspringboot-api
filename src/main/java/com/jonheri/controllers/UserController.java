package com.jonheri.controllers;

import com.jonheri.DTOs.UserDTO;
import com.jonheri.entities.User;
import com.jonheri.responses.ApiResponse;
import com.jonheri.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ApiResponse<List<UserDTO>> getUsers() {
		List<UserDTO> users = userService.findAll();
		return new ApiResponse<>(
						"success",
						"Get all data Success",
						users
		);
	}

	@PostMapping("/add-user")
	public ApiResponse<UserDTO> addData(@RequestBody User user) {
		User insertData = userService.addData(user);
		UserDTO resData = new UserDTO(
						insertData.getId(),
						insertData.getEmail(),
						insertData.getUsername(),
						insertData.getFullname()
		);
		return new ApiResponse<>(
						"success",
						"Add data data Success",
						resData
		);
	}

	@GetMapping("/user/{id}")
	public ApiResponse<UserDTO> getDataById(@PathVariable String id) {
		Optional<UserDTO> user = userService.findById(id);

		if (user.isEmpty()) {
//			logger.warn("User with ID: " + id + " not found");
			return new ApiResponse<>(
							"fail",
							"User with ID: " + id + " not found",
							null
			);
		}

//		logger.info("Get data by ID: " + id + " Success");
		return new ApiResponse<>(
						"success",
						"Get data by ID: " + id + " Success",
						user.get()
		);
	}
}
