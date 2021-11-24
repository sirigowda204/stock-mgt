package com.demo.stocks.model;

import java.sql.Date;

public class Stockinfo {
	protected int stk_id;
	protected Date info_date;
	protected int qty_available;
	protected float open_price;
	protected float close_price;
	protected float current_price;
	
	
	public Stockinfo() {
		super();
	}
	
	public Stockinfo(int stk_id, Date info_date, int qty_available, float open_price, float close_price,
			float current_price) {
		super();
		this.stk_id = stk_id;
		this.info_date = info_date;
		this.qty_available = qty_available;
		this.open_price = open_price;
		this.close_price = close_price;
		this.current_price = current_price;
	}
	public int getStk_id() {
		return stk_id;
	}
	public void setStk_id(int stk_id) {
		this.stk_id = stk_id;
	}
	public Date getInfo_date() {
		return info_date;
	}
	public void setInfo_date(Date info_date) {
		this.info_date = info_date;
	}
	public int getQty_available() {
		return qty_available;
	}
	public void setQty_available(int qty_available) {
		this.qty_available = qty_available;
	}
	public float getOpen_price() {
		return open_price;
	}
	public void setOpen_price(float open_price) {
		this.open_price = open_price;
	}
	public float getClose_price() {
		return close_price;
	}
	public void setClose_price(float close_price) {
		this.close_price = close_price;
	}
	public float getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(float current_price) {
		this.current_price = current_price;
	}
	
	
}
