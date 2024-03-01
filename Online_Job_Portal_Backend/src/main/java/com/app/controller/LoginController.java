package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthReqDTO;
import com.app.service.SeekerService;

@RestController

public class LoginController {
	
	@Autowired
	SeekerService seekerServ;
	
	
	@PostMapping("/login")
	
	public ResponseEntity<?> authenticateEmp(@RequestBody @Valid AuthReqDTO req)
	{
		try
		{
			return new ResponseEntity<>(seekerServ.authenticateSeeker(req),HttpStatus.OK);
			
		}
		catch (Exception e)
		{
			System.out.println("Login Controller");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			
		}
		
		
		
	}
	

}
