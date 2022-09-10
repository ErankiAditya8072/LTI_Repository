package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Conn {
    
	public static Connection getconn() throws SQLException
	{
	   
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
	    String username = "system";
	    String password = "aditya";
	    Connection con = DriverManager.getConnection(url,username,password);
	    if(con!= null)
	    {
	    	System.out.println("Connected");
	    }
	    return con;
	}
	 
//	public static void main(String[] args) throws SQLException
//	{
//		getconn();
//	}
}
