package com.aditya.employeepayrollapp.DTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseDTO {

	public String message;
	public Object object;

	public ResponseDTO(String message, Object object) {
		this.message = message;
		this.object = object;
	}

}
