package com.accolite.assignment.spring;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee e){  
	    String query="insert into employee values ('"+e.getEid()+"','"+e.getName()+"','"+e.getSalary()+"')";  
	    return jdbcTemplate.update(query);  
	}  
	
	public int updateEmployee(Employee e){  
	    String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where eid='"+e.getEid()+"'";  
	    return jdbcTemplate.update(query);  
	}  
	
	public int deleteEmployee(int id){  
	    String query="delete from employee where eid='"+id+"'";  
	    return jdbcTemplate.update(query);  
	}  
	
}