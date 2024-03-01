package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeekerDetailsDTO {
	
	
	private String fName;
	
	
	private String lName;
	
	
	private LocalDate dob;
	

	private String college;
	

	private String degree;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String street;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String city;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String state;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String country;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String zipCode;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Address adr;
	
	
	

}
