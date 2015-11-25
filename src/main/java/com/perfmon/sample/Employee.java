package com.perfmon.sample;

import com.perfmon.annotation.Perfmon;

public class Employee {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Perfmon(methodMarkerName="PrintDetails")
	public void printdetails(){
		System.out.println(id + "" + name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
