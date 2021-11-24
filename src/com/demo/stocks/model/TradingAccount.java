package com.demo.stocks.model;

public class TradingAccount {
	protected int account_number; 
	protected float funds;
	protected float portfolio_value;
	protected float tax;
	protected float net_profit; 
	protected int b_id;
	protected int trader_id;
	
	
	public TradingAccount() {
		super();
	}
	public TradingAccount(int account_number, float funds, float portfolio_value, float tax, float net_profit, int b_id,
			int trader_id) {
		super();
		this.account_number = account_number;
		this.funds = funds;
		this.portfolio_value = portfolio_value;
		this.tax = tax;
		this.net_profit = net_profit;
		this.b_id = b_id;
		this.trader_id = trader_id;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public float getFunds() {
		return funds;
	}
	public void setFunds(float funds) {
		this.funds = funds;
	}
	public float getPortfolio_value() {
		return portfolio_value;
	}
	public void setPortfolio_value(float portfolio_value) {
		this.portfolio_value = portfolio_value;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getNet_profit() {
		return net_profit;
	}
	public void setNet_profit(float net_profit) {
		this.net_profit = net_profit;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getTrader_id() {
		return trader_id;
	}
	public void setTrader_id(int trader_id) {
		this.trader_id = trader_id;
	}
	
	
}
