package com.demo.stocks.dto;

public class StockHoldingDto {
	private String short_name;
	private String c_name;
	private int quantity;
	private String average_price;
	private String s_id;
	private String current_price;
	
	public StockHoldingDto() {
		super();
	}
	public StockHoldingDto(String short_name, String c_name, int quantity,String average_price,String s_id,String current_price) {
		super();
		this.short_name = short_name;
		this.c_name = c_name;
		this.quantity = quantity;
		this.average_price = average_price;
		this.s_id = s_id;
		this.current_price = current_price;
	}
	public String getAverage_price() {
		return average_price;
	}
	public void setAverage_price(String average_price) {
		this.average_price = average_price;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(String current_price) {
		this.current_price = current_price;
	}
}
