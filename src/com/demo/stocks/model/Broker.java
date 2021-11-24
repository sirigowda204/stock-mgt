package com.demo.stocks.model;


public class Broker {
	protected int b_id;
	protected String b_name;
	protected String commission;
	
	
	public Broker(int b_id, String b_name, String commission) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.commission = commission;
	}
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}

	
}
