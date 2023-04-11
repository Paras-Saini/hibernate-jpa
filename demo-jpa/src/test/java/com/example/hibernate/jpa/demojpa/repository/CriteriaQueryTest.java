package com.example.hibernate.jpa.demojpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.hibernate.jpa.demojpa.DemoJpaApplication;
import com.example.hibernate.jpa.demojpa.entity.Course;
import com.example.hibernate.jpa.demojpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


@SpringBootTest(classes=DemoJpaApplication.class)
class CriteriaQueryTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entity;
	
	
	@Test
	public void all_courses() {
		
		CriteriaBuilder cb=entity.getCriteriaBuilder();
		CriteriaQuery<Course> cq=cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		TypedQuery<Course> query=entity.createQuery(cq.select(courseRoot));
		
		List<Course> resultList=query.getResultList();
		
		logger.info("Typed Query -> {}", resultList);
	}
	
	
	@Test
	public void all_courses_having_100_steps() {
		
		CriteriaBuilder cb=entity.getCriteriaBuilder();
		CriteriaQuery<Course> cq=cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");
		
		cq.where(like100Steps);
		
		TypedQuery<Course> query=entity.createQuery(cq.select(courseRoot));
		
		List<Course> resultList=query.getResultList();
		
		logger.info("Typed Query -> {}", resultList);
	}
	
	
	@Test
	public void all_courses_without_students() {
		
		CriteriaBuilder cb=entity.getCriteriaBuilder();
		CriteriaQuery<Course> cq=cb.createQuery(Course.class);
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
		
		cq.where(studentsIsEmpty);
		
		TypedQuery<Course> query=entity.createQuery(cq.select(courseRoot));
		
		List<Course> resultList=query.getResultList();
		
		logger.info("Typed Query -> {}", resultList);
	}
	
	
	
	@Test
	public void join() {
		
		CriteriaBuilder cb=entity.getCriteriaBuilder();
		CriteriaQuery<Course> cq=cb.createQuery(Course.class);
		
		Root<Course> courseRoot=cq.from(Course.class);
		
		Join<Object, Object> join = courseRoot.join("students");
		
		TypedQuery<Course> query=entity.createQuery(cq.select(courseRoot));
		
		List<Course> resultList=query.getResultList();
		
		logger.info("Typed Query -> {}", resultList);
	}

	
	@Test
	public void left_join() {
		
		CriteriaBuilder cb=entity.getCriteriaBuilder();
		CriteriaQuery<Course> cq=cb.createQuery(Course.class);
		
		Root<Course> courseRoot=cq.from(Course.class);
		
		
		 Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

		TypedQuery<Course> query=entity.createQuery(cq.select(courseRoot));
		
		List<Course> resultList=query.getResultList();
		
		logger.info("Typed Query -> {}", resultList);
	}



	
	

}
