package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lti.entity.Employee;

// Data access object
public class Employee_Dao {
    
	private Connection conn;

	public Employee_Dao() throws SQLException{
		
		this.conn = Database_Conn.getconn();
		System.out.println("Connected successfully");
	}
	
	public void addEmp(Employee e) throws SQLException
	{
		String query ="INSERT INTO employee_table values(?,?,?)";
		PreparedStatement ps = this.conn.prepareStatement(query);
		ps.setString(1,e.getUsername());
		ps.setString(2,e.getPassword());
		ps.setString(3,e.getEmail());
		
		ps.executeUpdate();
		ps.close();
		
		System.out.println("Employee added successfully");
	}
	
	public Employee getEmpByName(String username) throws SQLException
	{
		String query = String.format("select * from employee_table where username = '%s'",username);
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		Employee emp1 = new Employee();
		if(rs.next())
		{
	      emp1.setUsername(rs.getString("username"));
	      emp1.setPassword(rs.getString("password"));
	      emp1.setEmail(rs.getString("email"));
		}
		else {
			return null;
		}
		return emp1;
		
	}
	
	public void deleteEmp(String uname) throws SQLException
	{

		PreparedStatement stmt = this.conn.prepareStatement("delete from employee_table where username = ?");
		stmt.setString(1,uname);
		
		int rows = stmt.executeUpdate();
		if(rows!= 0)
			System.out.println("Employee Deleted Successfully");
		else
			System.out.println("not there in the table");
		
		stmt.close();
	
		
	}
	
	public int EmployeeList() throws SQLException
	{
		String query = "SELECT COUNT(*) FROM EMPLOYEE_TABLE";
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next())
		{
			return rs.getInt(1);
		}
		return 0;
	}

	
}
