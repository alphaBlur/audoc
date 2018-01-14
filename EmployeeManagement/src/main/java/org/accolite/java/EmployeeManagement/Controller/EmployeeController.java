package org.accolite.java.EmployeeManagement.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
//import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.accolite.java.EmployeeManagement.Model.*;
import org.accolite.java.EmployeeManagement.Services.EmployeeManagementService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("employee")
public class EmployeeController {

	static EmployeeManagementService service= new EmployeeManagementService();
	/**
	 * Method handling HTTP GET requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployeeDetails() {
		
		return service.getAllEmployee();
	}
	
	
	@GET
	@Path("{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeDetails(
			@PathParam("Id") int id) {
		return service.getEmployee(id);
	}
	*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployeeDetails() {
		
		return service.getAllEmployee();
	}
	
	
	@GET
	@Path("{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeDetails(
			@PathParam("Id") int id) {
		return service.getEmployee(id);
	}
	
	
	

	@POST
	@Consumes({"application/xml", "application/json"})
	@Path("add")
	public String insertEmployee(Employee employee) {
		for(Employee e:service.getAllEmployee()) {
			if(e.getEmployeeId()==employee.getEmployeeId()) {
				return "Employee ID exists already";
			}
		}
		System.out.println("inserting a new employee");
		return service.insert(employee);
	}
	
	
	
	@POST
	@Path("update/{param1}/{param2}")
	@Consumes({"application/xml", "application/json"})
	public String updateEmployee(@PathParam("param1") int id,@PathParam("param2") String name){
		return service.update(id, name);
	}
	
	//By send data in raw
	@POST
	@Path("update")
	@Consumes({"application/xml", "application/json"})
	public String updateEmployee2(Employee em){
		for(Employee e:service.getAllEmployee()) {
			if(e.getEmployeeId()==em.getEmployeeId()) {
				return service.update2(em);
			}
		}
		return "Employee ID does not exists";
	}
	
	
	@POST
	@Path("delete/{empId}")
	public String deleteEmployee(@PathParam("empId") int id){		
		return service.delete(id);
	}
	
//	
//	@POST
//	@Path("sss")
//	public String hello() {
//		return "Helloooo";
//	}
//	

}
