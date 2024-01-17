package com.example.userservice.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import com.example.userservice.dto.DepartmentDTO;
import com.example.userservice.dto.ResponseDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;

import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRepository userRepository;
	
	
	@Autowired 
	private WebClient webClient ;
	
	private static final Log LOGGER = LogFactory.getLog(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	
	@Override
	public ResponseDTO getUser(Long userId) {
	    ResponseDTO responseDTO = new ResponseDTO();
	    
	    // Retrieve user information
	    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

	    // Map user entity to DTO
	    UserDTO userDTO = mapToUser(user);
	    responseDTO.setUser(userDTO);

	    // Retrieve department information using WebClient
	    DepartmentDTO departmentDTO = getDepartmentDetails(user.getDepartmentId());
	    responseDTO.setDepartmentDTO(departmentDTO);

	    return responseDTO;
	}

	private DepartmentDTO getDepartmentDetails(String departmentId) {
	    try {
	        return webClient.get()
	                .uri("http://localhost:8081/departments/" + departmentId)
	                .retrieve()
	                .onStatus(HttpStatusCode::isError, response -> {
	                    // Log or handle error status
	                    return Mono.error(new RuntimeException("Error status: " + response.statusCode()));
	                })
	                .bodyToMono(DepartmentDTO.class)
	                .block();
	    } catch (Exception e) {
	  
	    	LOGGER.error("The data is not available");
	        throw e;
	    }
	}

	
private UserDTO mapToUser (User user) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setEmailId(user.getEmailId());
		
		return userDTO;
		
	}
	
	
	

}
