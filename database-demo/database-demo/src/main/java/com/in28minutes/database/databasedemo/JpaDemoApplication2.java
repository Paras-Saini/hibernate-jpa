package com.in28minutes.database.databasedemo;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;


@SpringBootApplication
public class JpaDemoApplication2 implements CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public void run(String... args) throws Exception{
		
		 logger.info("User id 10001 - > {} ", repository.findById(10001));
		 logger.info("Inserting 10003 -> {} ", repository.insert(new Person(10004,"Tara", "Berlin", new Date(1))));
		  
		  logger.info("Update 10003 -> {} ", repository.update(new Person(10002,"Peter", "Damkok", new Date(1))));
		  
		 repository.deleteById(10003);
		 
		 logger.info("All users -> {} ", repository.findAll());
		
		
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication2.class, args);
	}
	
	

}
