package org.accolite.java.EmployeeManagement.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.accolite.java.EmployeeManagement.Model.*;

public class EmployeeManagementService {
	
	static List<Employee> employeeList=new ArrayList<Employee>();
	
	public EmployeeManagementService() {
		employeeList.add(new Employee(1,"Payal",new Date(),1000));
		employeeList.add(new Employee(2,"Nishant",new Date(),1000));
		employeeList.add(new Employee(3,"Saurabh",new Date(),1000));
	}
	
	public List<Employee> getAllEmployee(){
		return employeeList;
	}
	
	public Employee getEmployee(int Id) {
		
		Optional<Employee> matchingEmployee= employeeList.stream().filter(p ->p.getEmployeeId()==Id).findFirst();
		if(matchingEmployee.isPresent())
			return matchingEmployee.get();
		else
			return null;
	}

	public String insert(Employee employee) {
		employeeList.add(employee);
		return "New employee added successfully with salary: "+employee.getEmployeeId();
	}
	
	public String update(int id, String name) {
		for(Employee e: employeeList){
			if(e.getEmployeeId() == id){
				e.setEmployeeName(name);
				return "Name updated to " + name;
			}
		}
		
		return "No employee found with id:" + id;
	}
	
	public String update2(Employee em) {
		for(Employee e: employeeList){
			if(e.getEmployeeId() == em.getEmployeeId()){
				e.setEmployeeName(em.getEmployeeName());
				e.setEmployeeId(em.getEmployeeId());
				e.setDOB(em.getDOB());
				e.setSalary(em.getSalary());

			}
		}
		return "Successfully updated the employee with id: " + em.getEmployeeId();
	}
	
	public String delete(int id) {
		Iterator<Employee> i = employeeList.iterator();
		while(i.hasNext())
		{
		    if (i.next().getEmployeeId() == id)
		    {
		        i.remove();
		        return "Deleted employee with ID:";
		    }
		}
		return "No employee found with id:" + id;
	}
	
}
