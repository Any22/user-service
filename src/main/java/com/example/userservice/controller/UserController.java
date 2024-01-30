package com.example.userservice.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dto.ResponseDTO;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;

@RestController
public class UserController {
@Autowired 
private UserService userService;



private static final Log LOGGER = LogFactory.getLog(UserController.class);

@PostMapping(value="/users")
  public ResponseEntity<User> saveUser(@RequestBody User user){
	User savedUser = userService.saveUser(user);
	LOGGER.info("Saving user {}"+ savedUser);
	return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	
  }

@GetMapping(value="/users/{userId}")
  public ResponseEntity<ResponseDTO> getUser(@PathVariable Long userId){
    LOGGER.info("userId {}"+userId);
	ResponseDTO responseDTO = userService.getUser(userId);
	return ResponseEntity.ok(responseDTO);
	
  }
}