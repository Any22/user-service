package com.example.userservice.dto;

public class ResponseDTO {
	private DepartmentDTO departmentDTO;
	private UserDTO user;
	
	public ResponseDTO() {
		
	}
	public ResponseDTO(DepartmentDTO departmentDTO, UserDTO user) {
	
		this.departmentDTO = departmentDTO;
		this.user = user;
	}
	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}
	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}

	
}
