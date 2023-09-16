package com.valpoSystems.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valpoSystems.domain.models.UserModel;
import com.valpoSystems.domain.request.UserRequest;
import com.valpoSystems.domain.response.UserResponse;
import com.valpoSystems.exception.InvalidPasswordException;
import com.valpoSystems.exception.UserException;
import com.valpoSystems.service.UserServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	private final UserServiceImpl userService;

	public UserController(final UserServiceImpl userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> save(@Valid @RequestBody final UserRequest userRequest)
			throws UserException, InvalidPasswordException {
		UserModel userCreated = userService.save(userRequest);
		UserResponse userResponse = new UserResponse(userCreated);

		return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> updatePersona( @PathVariable UUID id, @Valid @RequestBody final UserModel user) throws UserException, InvalidPasswordException {
		user.setId(id);
		UserModel userCreated = userService.UpdateUser(user);
		UserResponse userResponse = new UserResponse(userCreated);
		return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
	}
}
