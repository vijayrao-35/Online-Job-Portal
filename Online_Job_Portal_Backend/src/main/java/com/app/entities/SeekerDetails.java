package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="seeker_details")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SeekerDetails extends BaseEntity{
	
	@Column(length=30)
	private String fName;
	
	@Column(length=30)
	private String lName;
	
	private LocalDate dob;
	@Column(length=30)
	private String college;
	
	@Column(length=30)
	private String degree;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_id")
	@MapsId
	private Seeker owner;
	
	@Embedded
	private Address adr;
	

	
	

}
