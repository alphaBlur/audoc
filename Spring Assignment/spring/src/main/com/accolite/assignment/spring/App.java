package com.accolite.assignment.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import com.mysql.jdbc.*;
public class App {
	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");  
	    EmployeeDao dao=(EmployeeDao)context.getBean("employeeDao");  
	    Employee employee1 = (Employee)context.getBean("employee1");
	    Employee employee2 = (Employee)context.getBean("employee2");
	    dao.saveEmployee(employee1);  
	    dao.saveEmployee(employee2);
	    dao.deleteEmployee(1);
	}
}