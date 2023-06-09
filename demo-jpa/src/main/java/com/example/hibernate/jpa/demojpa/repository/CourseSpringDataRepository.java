package com.example.hibernate.jpa.demojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.hibernate.jpa.demojpa.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByName(String name,Long id);
	
	List<Course> findByName(String name);
	
	List<Course> countByName(String name);
	
	List<Course> findByNameOrderByIdDesc(String name);
	
	List<Course> deleteByName(String name);

	@Query("Select c from Course c where name like '%100 Steps'")
	List<Course> courseWith100StepsInName();
	
	@Query(value="Select * from Course c where name like '%100 Steps'", nativeQuery=true)
	List<Course> courseWith100StepsInNameUsingNativeQuery();
	
	@Query(name="query_get_all_courses")
	List<Course> courseWith100StepsInNameUsingNamedQuery();
}
