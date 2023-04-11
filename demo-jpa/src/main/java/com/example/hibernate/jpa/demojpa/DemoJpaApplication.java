package com.example.hibernate.jpa.demojpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hibernate.jpa.demojpa.entity.Course;
import com.example.hibernate.jpa.demojpa.entity.FullTimeEmployee;
import com.example.hibernate.jpa.demojpa.entity.PartTimeEmployee;
import com.example.hibernate.jpa.demojpa.entity.Review;
import com.example.hibernate.jpa.demojpa.entity.Student;
import com.example.hibernate.jpa.demojpa.repository.CourseRepository;
import com.example.hibernate.jpa.demojpa.repository.EmployeeRepository;
import com.example.hibernate.jpa.demojpa.repository.StudentRepository;


@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner{
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	//@Override
	/*public void run(String... args) throws Exception {
		
		 Course course=repository.findById(10001L);
		 
		 logger.info("Course 10001 {}", course);
		 
		 //repository.deleteById(10001L);
		 
		 repository.save(new Course("Microservices in 100 steps"));
	}*/
	
	/*@Override
		public void run(String... args) throws Exception {
		    studentRepository.saveStudentWithPassport();
			//repository.playWithEntityManager();
		}*/
	
	@Override
	public void run(String... args) throws Exception {
		//courseRepository.addHardCodedReviewsForCourse();
		
		
	   // List<Review> reviews=new ArrayList<>();
	    
	   // reviews.add(new Review("5", "Great Hands-on Stuff."));
	   // reviews.add(new Review("5", "Hatsoff."));
	    
	   //	courseRepository.addReviewsForCourse(10003L, reviews);
		
	//	studentRepository.insertHardCodedStudentAndCourse();
		
		//studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 steps."));
		
	//	employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal(50)));
		
	//   employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal(10000)));

		
	//	logger.info("All Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());
	//	logger.info("All Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
		
		
		
	}
	
	

}
