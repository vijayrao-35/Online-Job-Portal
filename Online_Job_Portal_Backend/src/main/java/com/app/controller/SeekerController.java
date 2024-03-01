package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SeekerDTO;
import com.app.dto.SeekerDetailsDTO;
import com.app.service.SeekerService;

@RestController
@RequestMapping("/seeker")
//@CrossOrigin(origins="http://localhost:3000")

public class SeekerController {
	@Autowired
	private SeekerService seekerService;
	
	@GetMapping("/{js_id}")
	public ResponseEntity<?> getSeeker(@PathVariable Long js_id) throws Exception
	{
		return ResponseEntity.ok(seekerService.getSeeker(js_id));
	}
	
	@GetMapping("/details/{js_id}")
	public ResponseEntity<?> getSeekerDetails(@PathVariable Long js_id) throws Exception
	{
		return ResponseEntity.ok(seekerService.getSeekerDetails(js_id));
	}
	
	@PostMapping
	public ResponseEntity<?> addSeeker(@RequestBody @Valid SeekerDTO dto) throws Exception
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(seekerService.addNewSeeker(dto));
		
	}
	
	@PutMapping("/{js_id}")
	public ResponseEntity<?> updateSeeker(@PathVariable Long js_id,@RequestBody @Valid SeekerDTO dto) throws Exception
	{
		return ResponseEntity.ok(seekerService.updateSeeker(js_id,dto));
	}
	
	@PutMapping("/details/{js_id}")
	public ResponseEntity<?> updateSeekerDetails(@PathVariable Long js_id,@RequestBody @Valid SeekerDetailsDTO dto) throws Exception
	{
		return ResponseEntity.ok(seekerService.updateSeekerDetails(js_id,dto));
	}

}
