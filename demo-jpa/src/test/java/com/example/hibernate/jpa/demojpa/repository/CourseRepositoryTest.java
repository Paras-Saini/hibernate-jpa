package com.example.hibernate.jpa.demojpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.hibernate.jpa.demojpa.DemoJpaApplication;
import com.example.hibernate.jpa.demojpa.entity.Course;
import com.example.hibernate.jpa.demojpa.entity.Review;

import jakarta.persistence.EntityManager;


@SpringBootTest(classes=DemoJpaApplication.class)
class CourseRepositoryTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	
	
	@Test
	public void findById_basic() {
		Course course=repository.findById(10001L);
		
		assertEquals("JPA in 50 Steps", course.getName());
		
		logger.info("Testing is Running:");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
		
		logger.info("Testing is Running:");
	}
	
	
	@Test
	@DirtiesContext
	public void save_basic() {
		
		//get a course
		Course course=repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
		
		
		//update details
		course.setName("JPA in 50 Steps - Updated");
		repository.save(course);
		
		
		//check the value
		Course course1=repository.findById(10001L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
		
		logger.info("Testing is Running:");
	}
	
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	
	@Test
	public void retrieveReviewsForCourse() {
		Course course=repository.findById(10001L);
		logger.info("{}",course.getReviews());
	}
	
	@Test
	public void retrieveCourseForReview() {
		Review review=em.find(Review.class,50001L);
		logger.info("{}",review.getCourse());
	}
	
	
	
	

}
