package com.demo.stocks.model;

public class Stocks {
	
	protected String gender;
	protected int age; 
	protected int trader_id;
	protected String l_name; 
	protected String f_name;
	
	
	public Stocks() {
		super();
	}
	
	public Stocks(String gender, int age, int trader_id, String l_name, String f_name) {
		super();
		this.gender = gender;
		this.age = age;
		this.trader_id = trader_id;
		this.l_name = l_name;
		this.f_name = f_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTrader_id() {
		return trader_id;
	}
	public void setTrader_id(int trader_id) {
		this.trader_id = trader_id;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	
	
}
