package com.example.hibernate.jpa.demojpa.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernate.jpa.demojpa.entity.Course;
import com.example.hibernate.jpa.demojpa.entity.Review;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entity; // persistentContext

	public Course findById(Long id) {
		return entity.find(Course.class, id);
	}

	public Course save(Course course) {
		if (course.getId() == null) {
			// insert
			entity.persist(course);
		} else {
			// update
			entity.merge(course);
		}

		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		entity.remove(course);
	}

	/*
	 * public void playWithEntityManager() { Course course1=new
	 * Course("Web Services in 100 Steps"); entity.persist(course1); Course
	 * course2=new Course("Angular Js in 100 Steps"); entity.persist(course2);
	 * 
	 * 
	 * // course1.setName(null); entity.flush();
	 * 
	 * // entity.detach(course1); // entity.detach(course2); // entity.clear();
	 * 
	 * 
	 * 
	 * course1.setName("Web Services in 100 Steps - Updated");
	 * course2.setName("Angular Js in 100 Steps - Updated");
	 * 
	 * 
	 * // entity.refresh(course1); //refresh content from db }
	 */

	public void playWithEntityManager() {

		Course course1 = new Course("Web Services in 100 Steps");
		entity.persist(course1);

		Course course2 = findById(10001L);
		course2.setName("JPA in 50 Steps - Updated");
	}

	public void addHardCodedReviewsForCourse() {
		Course course = findById(10003L);
		logger.info("course.getReviews() -> {}", course.getReviews());

		Review review1 = new Review("5", "Great Hands-on Stuff.");
		Review review2 = new Review("5", "Hatsoff.");

		// setting the relationship
		course.addReviews(review1);
		review1.setCourse(course);

		course.addReviews(review2);
		review2.setCourse(course);

		entity.persist(review1);
		entity.persist(review2);

	}

	//Get it working make it good.
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		logger.info("course.getReviews() -> {}", course.getReviews());

		for (Review review : reviews) {
			course.addReviews(review);
			review.setCourse(course);
			entity.persist(review);

		}

	}

}
