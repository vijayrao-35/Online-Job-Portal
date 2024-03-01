package com.app.service;

import com.app.dto.AuthReqDTO;
import com.app.dto.SeekerDTO;
import com.app.dto.SeekerDetailsDTO;

public interface SeekerService {
	
	SeekerDTO addNewSeeker(SeekerDTO dto) throws Exception;
	
	SeekerDTO updateSeeker(Long js_id,SeekerDTO dto) throws Exception;
	
	SeekerDTO getSeeker(Long js_id) throws Exception;
	
	SeekerDetailsDTO getSeekerDetails(Long js_id) throws Exception;
	
	SeekerDetailsDTO updateSeekerDetails(Long js_id,SeekerDetailsDTO dto) throws Exception;
	
	SeekerDetailsDTO authenticateSeeker(AuthReqDTO req) throws Exception;

}
