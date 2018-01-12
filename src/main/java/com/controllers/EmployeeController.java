package com.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.classes.Employee;
import com.classes.Implementation;


@Path("employee")
public class EmployeeController {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertEmployee(Employee employee) throws SQLException
	{
		new Implementation().insert(employee);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> displayEmployees() throws SQLException
	{
		return new Implementation().getAllEmployee();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmployee(@PathParam("id") String id) throws SQLException
	{
		new Implementation().deleteEmployee(id);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployee(@PathParam("id") String id) throws SQLException
	{
		return new Implementation().getEmployee(id);
	}
	
	
}
