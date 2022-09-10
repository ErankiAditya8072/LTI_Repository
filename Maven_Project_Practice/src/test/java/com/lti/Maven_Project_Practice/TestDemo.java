package com.lti.Maven_Project_Practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestDemo {

	@Test
	void strCheck()
	{
		String s1 = "demo1";
		System.out.println("This is the test case for String Check");
		assertEquals("demo1",s1);
		
	}
}
