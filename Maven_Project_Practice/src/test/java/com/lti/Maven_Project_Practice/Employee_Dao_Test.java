package com.lti.Maven_Project_Practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.lti.dao.Database_Conn;
import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;

public class Employee_Dao_Test {
   
    private static Employee_Dao dao;
    
    @BeforeAll
   static void getEmployeeDao() throws SQLException
    {
    	dao = new Employee_Dao();
    }
//	@Test
//	void getConnectionTest() throws SQLException
//	{
//		Connection conn = Database_Conn.getconn();
//		assertNotNull(conn,"connection successfull");
//	}
//	
//	@Test
//	public void addEmpTest() throws SQLException
//	{
//		Employee e = new Employee();
//		e.setUsername("empaditya");
//		e.setPassword("emppass");
//		e.setEmail("emp@empapp.com");
//	    
//	    Employee_Dao dao = new Employee_Dao();
//	    dao.addEmp(e);
//	    
//        Employee empfromdb = dao.getEmpByName("emp");
//	    
//	    assertEquals("emppass",empfromdb.getPassword(),"password checked successfully");
//	}
	
	@Test
	public void deleteEmpTest() throws SQLException
	{
		
		Employee e = new Employee();
		e.setUsername("emp1");
		e.setPassword("emp1");
		e.setEmail("emp@mail.com");
		
		dao.addEmp(e);
		
		dao.deleteEmp("emp1");
		
		Employee empfromdb =  dao.getEmpByName("emp1");
		
		assertNull(empfromdb,"delete checked successfully");
		
	
	}
	
	@Test
	public void Emplist() throws SQLException
	{
		assertEquals(dao.EmployeeList(),2);
		
		
		
	}

}
