package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Seeker;

public interface SeekerDao  extends JpaRepository<Seeker,Long> {
	
	
	public Optional<Seeker> findByEmailAndPassword(String email,String password);
	
	

}
