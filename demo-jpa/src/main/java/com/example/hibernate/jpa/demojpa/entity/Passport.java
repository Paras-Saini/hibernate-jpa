package com.example.hibernate.jpa.demojpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column( nullable=false)
	private String number;
	
	//mapped by make passport non owning side of the relationship
	//means StudentIs is not visible in the Passport Table
	//Bi-Directional Relationship
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport") 
	private Student student;
	
	
	public Passport() {
		
	}
	


	public Passport(String number) {
		this.number=number;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}
	
	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Passport [number=" + number + "]";
	}
	
	

	
	
	

}
