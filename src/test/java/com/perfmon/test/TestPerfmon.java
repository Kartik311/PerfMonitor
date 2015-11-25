package com.perfmon.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.perfmon.test.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/perfmon/config/spring-config.xml")
public class TestPerfmon {
	
	@Autowired
	Employee emp;
	
	@Before
	public void setUp(){
		emp.setId(1);
		emp.setName("TEST NAME");
	}
	
	@Test
	public void testPermonDefaultNameMethod(){
		emp.printdetails1();
	}
	
	@Test
	public void testPermonCustomStringMethod(){
		emp.printdetails2();
	}
	
	@Test
	public void testPermonMetaDataFlow(){
		emp.printMetaData();
	}
}
