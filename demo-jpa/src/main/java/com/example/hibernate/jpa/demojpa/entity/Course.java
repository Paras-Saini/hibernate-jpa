package com.example.hibernate.jpa.demojpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
//@Table(name="CourseDetails")
//@NamedQuery(name="query_get_all_courses", query="Select c from Course c")
//@NamedQuery(name="query_get_100_Steps_Courses", query="Select c from Course c where name like '%100 Steps'")
//OR

@NamedQueries(
		value= {
				@NamedQuery(name="query_get_all_courses", query="Select c from Course c"),
				@NamedQuery(name="query_get_100_Steps_Courses", query="Select c from Course c where name like '%100 Steps'")	
		}
		)

public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	//name="fullname",
	@Column( nullable=false)
	private String name;
	
	//fetch=FetchType.EAGER
	//ToOne is always Eager Fetching by default
		//ToMany is always lazy Fetching by default
	@OneToMany(mappedBy="course")
	private List<Review> reviews=new ArrayList<>();
	
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students=new ArrayList<>();
	
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	public Course() {
		
	}
	
	
	public Course(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}


	public void addReviews(Review reviews) {
		this.reviews.add(reviews);
	}
	
	public void removeReviews(Review reviews) {
		this.reviews.remove(reviews);
	}
	

	public List<Student> getStudents() {
		return students;
	}


	public void addStudents(Student student) {
		 students.add(student);
	}

	

	public Long getId() {
		return id;
	}
	
	



	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
	

	
	
	

}
