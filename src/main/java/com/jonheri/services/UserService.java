package com.jonheri.services;

import com.jonheri.DTOs.UserDTO;
import com.jonheri.entities.User;
import com.jonheri.repositories.UserRepo;
import com.jonheri.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<UserDTO> findAll() {
		return userRepo.findAll().stream()
						.map(user -> new UserDTO(
										user.getId(),
										user.getEmail(),
										user.getUsername(),
										user.getFullname()
						))
						.collect(Collectors.toList());
	}

	public User addData(User user) {
		if (user.getId() == null) {
			user.setId(UUID.randomUUID().toString());
		}
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		return userRepo.save(user);
	}

	public Optional<UserDTO> findById(String id) {
		return userRepo.findById(id)
						.map(user -> new UserDTO(
										user.getId(),
										user.getEmail(),
										user.getUsername(),
										user.getFullname()
						));
	}

}
