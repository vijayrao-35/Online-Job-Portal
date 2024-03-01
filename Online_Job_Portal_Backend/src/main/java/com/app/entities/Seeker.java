package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "seeker")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Seeker extends BaseEntity {
	
	@Column(length=30,unique=true,nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(length=10)
	private long ph_no;
	
	
	@OneToOne
	@JoinColumn(name="js_id")
	private SeekerDetails details;
	
	
	
	
	

}
