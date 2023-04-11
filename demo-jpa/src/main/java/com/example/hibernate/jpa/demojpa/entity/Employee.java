package com.example.hibernate.jpa.demojpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;


//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="Employee_Type")
//@Entity
@MappedSuperclass
public abstract class  Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column( nullable=false)
	private String name;
	
	
	
	
	public Employee() {
		
	}
	
	
	public Employee(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Long getId() {
		return id;
	}
	

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
}
