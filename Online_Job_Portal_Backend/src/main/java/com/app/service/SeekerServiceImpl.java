package com.app.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.SeekerDao;
import com.app.dao.SeekerDetailsDao;
import com.app.dto.AuthReqDTO;
import com.app.dto.SeekerDTO;
import com.app.dto.SeekerDetailsDTO;
import com.app.entities.Address;
import com.app.entities.Seeker;
import com.app.entities.SeekerDetails;

@Service 
@Transactional

public class SeekerServiceImpl implements SeekerService {
	
	@Autowired
	private SeekerDao seekerRepo;
	
	@Autowired
	private SeekerDetailsDao seekerDetRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public SeekerDTO addNewSeeker(SeekerDTO dto) {
		if(dto.getPassword().equals(dto.getConfirmPassword()))
		{
			Seeker seekerEntity = mapper.map(dto, Seeker.class);
			Seeker savedSeeker = seekerRepo.save(seekerEntity);
			SeekerDetails seekerDetailsEntity = new SeekerDetails();
			seekerDetailsEntity.setOwner(savedSeeker);
			seekerDetRepo.save(seekerDetailsEntity);
			return mapper.map(savedSeeker, SeekerDTO.class);
		}
		return null;
		//throw new ApiException("Passwords don't match");
	}

	@Override
	public SeekerDTO updateSeeker(Long js_id, SeekerDTO dto) throws ResourceNotFoundException {
		
		if(dto.getPassword().equals(dto.getConfirmPassword()))
		{
		Seeker seeker = seekerRepo.findById(js_id).orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
		Seeker updatedSeeker = mapper.map(dto, Seeker.class);
		seeker.setEmail(updatedSeeker.getEmail());
		seeker.setPh_no(updatedSeeker.getPh_no());;
		seeker.setPassword(updatedSeeker.getPassword());
		
		updatedSeeker = seekerRepo.save(seeker);
		
		return mapper.map(updatedSeeker, SeekerDTO.class);
		
		}
		return null;
	}

	
	
	@Override
	public SeekerDTO getSeeker(Long js_id) throws ResourceNotFoundException {
		
		Seeker seeker = seekerRepo.findById(js_id).orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
		
		return mapper.map(seeker, SeekerDTO.class);
	}
	
	@Override
	public SeekerDetailsDTO getSeekerDetails(Long js_id) throws ResourceNotFoundException {
		
		SeekerDetails seeker = seekerDetRepo.findById(js_id).orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
		
		return mapper.map(seeker, SeekerDetailsDTO.class);
	}

	@Override
	public SeekerDetailsDTO updateSeekerDetails(Long js_id,SeekerDetailsDTO dto) throws Exception {
		
		SeekerDetails seeker = seekerDetRepo.findById(js_id).orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
		dto.setAdr(new Address(dto.getStreet(), dto.getCity(), dto.getState(), dto.getCountry(), dto.getZipCode()));
		SeekerDetails updatedSeeker = mapper.map(dto, SeekerDetails.class);
		seeker.setCollege(updatedSeeker.getCollege());
		seeker.setDegree(updatedSeeker.getDegree());;
		seeker.setFName(updatedSeeker.getFName());
		seeker.setLName(updatedSeeker.getLName());
		seeker.setDob(updatedSeeker.getDob());
		seeker.setAdr(updatedSeeker.getAdr());
		
		updatedSeeker = seekerDetRepo.save(seeker);
		
		return mapper.map(updatedSeeker, SeekerDetailsDTO.class);
		
		
	}

	@Override
	public SeekerDetailsDTO authenticateSeeker(AuthReqDTO req) throws Exception {
		
		Seeker seeker = seekerRepo.findByEmailAndPassword(req.getEmail(),req.getPassword()).orElseThrow(()-> new ResourceNotFoundException("Invalid credentials"));
		
		SeekerDetails seekerDet = seekerDetRepo.findById(seeker.getJs_id()).orElseThrow(()-> new ResourceNotFoundException("Id not valid"));
		
		return mapper.map(seekerDet,SeekerDetailsDTO.class);
		
				
	
		
	}
	
	
	


}
