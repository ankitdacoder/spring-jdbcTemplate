package com.webdacoder.jdbaDatabaseDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDao {

	
	/*
	 * class PersonRowMapper implements RowMapper<Person> {
	 * 
	 * @Override public Person mapRow(ResultSet rs, int rowNum) throws SQLException
	 * {
	 * 
	 * // TODO Auto-generated method stub Person person = new Person();
	 * person.setId(rs.getInt("id")); person.setName(rs.getString("name"));
	 * person.setLocation(rs.getString("location"));
	 * person.setDob(rs.getDate("birth_date")); return person; }
	 * 
	 * }
	 */
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll()
	{
		 return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));	 
	}
	
	public Person findById(int id)
	{
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id},new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findByName(String name)
	{
		return jdbcTemplate.query("select * from person where name=?",new Object[] {name},new BeanPropertyRowMapper(Person.class));
	}
	
	public int deleteById(int id,String location)
	{
		return jdbcTemplate.update("delete from person where id = ? or location= ?",new Object[] {id,location});
	}
	
	public int insertPerson(Person person)
	{
		 return jdbcTemplate.update("insert into person (id,name,location,birth_date) values(?,?,?,?)",new Object[] {person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getDob().getTime())});
	}
	
	public int updatePerson(Person person)
	{
		 return jdbcTemplate.update("update person set name=? , location=?, birth_date=? where id=?",new Object[] {person.getName(),person.getLocation(),new Timestamp(person.getDob().getTime()),person.getId()});
 	}
	
}
