package com.controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	private static DatabaseConnection dbconnection;

	private Connection con;
	private DatabaseConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/REST","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getCon() {
		return con;
	}

	public static DatabaseConnection getConnection()
	{
		if(dbconnection == null)
			dbconnection = new DatabaseConnection();
		return dbconnection;
	}
}
