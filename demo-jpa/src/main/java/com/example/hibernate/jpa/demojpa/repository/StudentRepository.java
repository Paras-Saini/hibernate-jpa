package com.example.hibernate.jpa.demojpa.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernate.jpa.demojpa.entity.Course;
import com.example.hibernate.jpa.demojpa.entity.Passport;
import com.example.hibernate.jpa.demojpa.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entity; // persistentContext

	public Student findById(Long id) {
		return entity.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			// insert
			entity.persist(student);
		} else {
			// update
			entity.merge(student);
		}

		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		entity.remove(student);
	}

	
	public void saveStudentWithPassport() {
		
		Passport passport=new Passport("Z12345");
		entity.persist(passport);
		
		Student student = new Student("Mike");
		student.setPassport(passport);
		entity.persist(student);
	}
	
	
	public void insertHardCodedStudentAndCourse() {
		Student student=new Student("Jack");
		Course course=new Course("Microservices in 100 setps");
		
		entity.persist(student);
		entity.persist(course);
		
		student.addCourse(course);
		course.addStudents(student);
		entity.persist(student);
		
	}
	
	public void insertStudentAndCourse(Student student, Course course) {
		
		student.addCourse(course);
		course.addStudents(student);
		
		entity.persist(student);
		entity.persist(course);
		
		
	}

}
