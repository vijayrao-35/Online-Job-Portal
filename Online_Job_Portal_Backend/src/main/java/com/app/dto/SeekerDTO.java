package com.app.dto;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeekerDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long js_id;
	@Email
	private String email;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String confirmPassword;
	
	private Long ph_no;
	

	
	
	
}
