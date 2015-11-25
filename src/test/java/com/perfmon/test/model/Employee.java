package com.perfmon.test.model;

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
	
	@Perfmon
	public void printdetails1(){
		System.out.println(id + "" + name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Perfmon(markerName="PrintDetailsCustomName")
	public void printdetails2(){
		System.out.println(id + "" + name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Perfmon(metaData="Testing Meta Data")
	public void printMetaData(){
		System.out.println(id + "" + name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
