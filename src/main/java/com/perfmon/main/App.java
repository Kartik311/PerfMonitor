package com.perfmon.main;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perfmon.sample.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StringUtils.capitalize("heelo");
        System.out.println( StringUtils.capitalize("heelo"));
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/perfmon/config/spring-config.xml");
        Employee emp = (Employee)ctx.getBean("employee");
        emp.setId(1);
        emp.setName("Rahul");
        emp.printdetails();
    }
}
