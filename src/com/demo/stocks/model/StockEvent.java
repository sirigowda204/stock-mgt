package com.demo.stocks.model;

import java.sql.Date;

public class StockEvent {

	protected Date event_date;
	protected int s_id; 
	protected int e_id;
	protected String event_type;
	
	
	public StockEvent() {
	}
	
	
	public StockEvent(Date event_date, int s_id, int e_id, String event_type) {
		super();
		this.event_date = event_date;
		this.s_id = s_id;
		this.e_id = e_id;
		this.event_type = event_type;
	}

	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	
}
