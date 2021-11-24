package com.demo.stocks.model;


public class Company {
	protected int stock_id; 
	protected String c_name; 
	protected String short_name;
	protected int number_of_stocks;
	protected Stockinfo stockinfo;
	
	public Company(int stock_id, String c_name, String short_name, int number_of_stocks) {
		super();
		this.stock_id = stock_id;
		this.c_name = c_name;
		this.short_name = short_name;
		this.number_of_stocks = number_of_stocks;
	}
	
	public Company(int stock_id, String c_name, String short_name, int number_of_stocks,Stockinfo stockinfo) {
		super();
		this.stock_id = stock_id;
		this.c_name = c_name;
		this.short_name = short_name;
		this.number_of_stocks = number_of_stocks;
		this.stockinfo = stockinfo;
	}
	
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public int getNumber_of_stocks() {
		return number_of_stocks;
	}
	public void setNumber_of_stocks(int number_of_stocks) {
		this.number_of_stocks = number_of_stocks;
	}
	public Stockinfo getStockinfo() {
		return stockinfo;
	}
	public void setStockinfo(Stockinfo stockinfo) {
		this.stockinfo = stockinfo;
	}
	
}
