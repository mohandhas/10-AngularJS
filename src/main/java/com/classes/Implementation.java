package com.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controllers.DatabaseConnection;

public class Implementation {

	public void insert(Employee emp) throws SQLException
	{
		DatabaseConnection connection = DatabaseConnection.getConnection();
		String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?,?);";
		java.sql.PreparedStatement statement = connection.getCon().prepareStatement(sql);
		statement.setString(1, emp.getId());
		statement.setString(2, emp.getName());
		statement.setString(3, emp.getEmail());
		statement.setString(4, emp.getPhone());
		statement.executeUpdate();	
	}
	
	public List<Employee> getAllEmployee() throws SQLException
	{
		DatabaseConnection connection = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEE;";
		java.sql.PreparedStatement statement = connection.getCon().prepareStatement(sql);
		ResultSet rs=statement.executeQuery();
		
		List<Employee> list = new ArrayList<>();
		 while(rs.next())
		 {
			 Employee employee= new Employee(rs.getString("ID"),rs.getString("NAME"),rs.getString("EMAIL"),
						rs.getString("PHONE"));
			 list.add(employee);
		}
		 System.out.println(list.toString());
		 return list;
	}
	
	public void deleteEmployee(String id) throws SQLException
	{
		DatabaseConnection connection = DatabaseConnection.getConnection();
		String sql = "DELETE FROM EMPLOYEE WHERE ID=?;";
		java.sql.PreparedStatement statement = connection.getCon().prepareStatement(sql);
		statement.setString(1, id);
		statement.executeUpdate();	
	}

	public List<Employee> getEmployee(String id) throws SQLException 
	{
		DatabaseConnection connection = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE ID=?;";
		java.sql.PreparedStatement statement = connection.getCon().prepareStatement(sql);
		statement.setString(1, id);
		ResultSet rs=statement.executeQuery();
		
		List<Employee> list = new ArrayList<>();
		 while(rs.next())
		 {
			 Employee employee= new Employee(rs.getString("ID"),rs.getString("NAME"),rs.getString("EMAIL"),
						rs.getString("PHONE"));
			 list.add(employee);
		}
		
		 return list;		
	}
}
