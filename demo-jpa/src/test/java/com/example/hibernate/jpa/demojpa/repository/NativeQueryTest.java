package com.example.hibernate.jpa.demojpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernate.jpa.demojpa.DemoJpaApplication;
import com.example.hibernate.jpa.demojpa.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SpringBootTest(classes = DemoJpaApplication.class)
class NativeQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entity;

	@Test
	public void native_queries_basic() {
		Query query = entity.createNativeQuery("Select * From Course", Course.class);
		List resultList = query.getResultList();
		logger.info("Select * From Course -> {}", resultList);
	}

	@Test
	public void native_queries_with_parameter() {
		Query query = entity.createNativeQuery("Select * From Course where id=?", Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		logger.info("Select * From Course where id=? -> {}", resultList);
	}
	
	@Test
	public void native_queries_with_named_parameter() {
		Query query = entity.createNativeQuery("Select * From Course where id= :id", Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info("Select * From Course where id= :id -> {}", resultList);
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = entity.createNativeQuery("Update Course set last_updated_date=current_date()", Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated ->{}", noOfRowsUpdated );
	}
}
