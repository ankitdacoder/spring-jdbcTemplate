package com.webdacoder.jdbaDatabaseDemo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	
     private PersonJdbcDao personJdbcDao; 
	
	@GetMapping(value="/persons")
	public Person getAllPerson()
	{
		return  personJdbcDao.findById(103);
	}
	
}
