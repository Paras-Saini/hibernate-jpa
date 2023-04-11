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


@SpringBootTest(classes=DemoJpaApplication.class)
class JPQLTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entity;
	
	
	@Test
	public void jpql_basic() {
		//Query query=entity.createQuery("Select c From Course c");
		Query query=entity.createNamedQuery("query_get_all_courses");
		List resultList=query.getResultList();
		logger.info("Select c From Course c -> {}", resultList);
	}
	
	@Test
	public void jpql_typed() {
		//TypedQuery<Course> query=entity.createQuery("Select c from Course c", Course.class);
		TypedQuery<Course> query=entity.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList=query.getResultList();
		logger.info("Select c From Course c -> {}", resultList);
	}
	
	
	@Test
	public void jpql_where() {
		//TypedQuery<Course> query=entity.createQuery("Select c from Course c where name like '%100 Steps'", Course.class);
		TypedQuery<Course> query=entity.createNamedQuery("query_get_100_Steps_Courses",Course.class);
        List<Course> resultList=query.getResultList();
       
		logger.info("Select c from Course c where name like '%100 Steps'-> {}", resultList);
	}
	
	

	@Test
	public void jpql_courses_without_student() {

		TypedQuery<Course> query=entity.createQuery("Select c from Course c where c.students is empty",Course.class);
        List<Course> resultList=query.getResultList();
		logger.info("Results -> {}", resultList);
	}
	
	@Test
	public void jpql_courses_with_atleast_2_students() {

		TypedQuery<Course> query=entity.createQuery("Select c from Course c where size(c.students) >=2",Course.class);
        List<Course> resultList=query.getResultList();
		logger.info("Results -> {}", resultList);
	}
	
	@Test
	public void jpql_courses_ordered_by_students() {

		TypedQuery<Course> query=entity.createQuery("Select c from Course c order by size(c.students)",Course.class);
        List<Course> resultList=query.getResultList();
		logger.info("Results -> {}", resultList);
	}
	
	
	@Test
	public void jpql_students_with_passports_in_a_certain_pattern() {

		TypedQuery<Student> query=entity.createQuery("Select s from Student s where s.passport.number like '%1234%'",Student.class);
        List<Student> resultList=query.getResultList();
		logger.info("Results -> {}", resultList);
	}
	
	
	@Test
	public void join() {
		
		Query query=entity.createQuery("Select c,s from Course c JOIN c.students s");
        List<Object[]> resultList=query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for(Object[] result:resultList) {
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}
	
	
	@Test
    public void left_join() {
		
		Query query=entity.createQuery("Select c,s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList=query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for(Object[] result:resultList) {
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}
	
	
	@Test
    public void cross_join() {
		
		Query query=entity.createQuery("Select c,s from Course c, Student s");
        List<Object[]> resultList=query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for(Object[] result:resultList) {
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}
	
	
	
	
	

	
	

}
