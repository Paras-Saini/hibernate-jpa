package com.example.hibernate.jpa.demojpa.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernate.jpa.demojpa.entity.Employee;
import com.example.hibernate.jpa.demojpa.entity.FullTimeEmployee;
import com.example.hibernate.jpa.demojpa.entity.PartTimeEmployee;
import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entity; // persistentContext
	
	public void insert(Employee employee) {
		entity.persist(employee);
	}

	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		return entity.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
		return entity.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

	

}
