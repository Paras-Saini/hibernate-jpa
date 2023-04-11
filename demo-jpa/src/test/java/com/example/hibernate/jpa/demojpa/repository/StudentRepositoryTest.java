package com.example.hibernate.jpa.demojpa.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernate.jpa.demojpa.DemoJpaApplication;
import com.example.hibernate.jpa.demojpa.entity.Course;
import com.example.hibernate.jpa.demojpa.entity.Passport;
import com.example.hibernate.jpa.demojpa.entity.Student;

import jakarta.persistence.EntityManager;


@SpringBootTest(classes=DemoJpaApplication.class)
class StudentRepositoryTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	//Persistence Context is something where all changes are kept track off.
	
	@Test
	@Transactional  
	public void someDummyOperation() {
		//DB Operation 1
		Student student=em.find(Student.class,20001L);
		//Persistence Context(student)
		
		
		//DB Operation 2
		Passport passport=student.getPassport();
		//Persistence Context(student,passport)
		
		
		//DB Operation 3
		passport.setNumber("E12345");
		//Persistence Context(student,passport++)
		
		
		//DB Operation 4
		student.setName("Ranga - updated");	
		//Persistence Context(student++,passport++)
	}
	

	
	
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		//eagerFetch 
		Student student=em.find(Student.class,20001L);
		logger.info("student-> {}", student);
		//LazyFetch->getDetails only when needed
		logger.info("passport-> {}",  student.getPassport());
	}
	
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		//eagerFetch 
		Passport passport=em.find(Passport.class,40001L);
		logger.info("passport-> {}", passport);
		//LazyFetch->getDetails only when needed
		logger.info("student-> {}",  passport.getStudent());
	}
	
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student=em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("courses ->{}", student.getCourses());
	}
	
	@Test
	@Transactional
	public void retrieveCourseAssociatedWithStudent() {
		Course course=em.find(Course.class, 10001);
		logger.info("course -> {}", course);
		logger.info("Student -> {}", course.getStudents());
	}
	
	
}
