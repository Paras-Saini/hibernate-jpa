package com.in28minutes.database.databasedemo;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;


//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public void run(String... args) throws Exception{
		  logger.info("All users -> {} ", dao.findAll());
		  logger.info("User id 10001 - > {} ", dao.findById(10001));
		  logger.info("Find name Rohit -> {} ", dao.findByName("Rohit"));
		  logger.info("Deleting 10002 -> No of Rows Deleted - {} ", dao.deleteById(10003));
		  logger.info("Inserting 10003 -> {} ", dao.insert(new Person(10004,"Tara", "Berlin", new Date(1))));
		  
		  logger.info("Update 10003 -> {} ", dao.update(new Person(10002,"Peter", "Damkok", new Date(1))));
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}
	
	
}
