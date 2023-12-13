package com.example.userservice.service;

import org.springframework.stereotype.Service;

import com.example.userservice.dto.ResponseDTO;
import com.example.userservice.entity.User;
@Service
public interface UserService {
	
	User saveUser (User user);
	ResponseDTO getUser(Long userId);

}
