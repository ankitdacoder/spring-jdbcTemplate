package com.webdacoder.jdbaDatabaseDemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbaDatabaseDemoApplication implements CommandLineRunner {
   
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbaDatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {} ",personJdbcDao.findAll());
		logger.info("Get Person with ID 100 -> {} ",personJdbcDao.findById(100));
		logger.info("Get Person with Name Ankit -> {} ",personJdbcDao.findByName("Nidhi"));
		logger.info("Delete Person with ID 102 -> {} ",personJdbcDao.deleteById(102,"Indore"));
		
		logger.info("Insert New Person Record",personJdbcDao.insertPerson(new Person(103, "Prateek", "indore", new Date())));
		
		logger.info("Update Record",personJdbcDao.updatePerson(new Person(103, "Prateek", "England", new Date())));
		
		
		
		

	}

}
