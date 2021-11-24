package com.demo.stocks.model;

import java.sql.Date;

public class Orders {

	protected String order_type;
	protected int quantity; 
	protected String order_id;
	protected float limit_price;
	protected int st_id; 
	protected Date order_date;
	
	public Orders()
	{}
	
	public Orders(String order_type, int quantity, String order_id, float limit_price, int st_id, Date order_date) {
		super();
		this.order_type = order_type;
		this.quantity = quantity;
		this.order_id = order_id;
		this.limit_price = limit_price;
		this.st_id = st_id;
		this.order_date = order_date;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public float getLimit_price() {
		return limit_price;
	}
	public void setLimit_price(float limit_price) {
		this.limit_price = limit_price;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	
}
