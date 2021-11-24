package com.demo.stocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.stocks.dto.StockHoldingDto;
import com.demo.stocks.model.Company;
import com.demo.stocks.model.Trader;

public class TraderDao extends BaseDao{

	private static final String SELECT_TRADER_BY_ID = "select * from trader where trader_id = ?";
	
	private static final String STOCK_BUY_BY_ID = "select * from trader where trader_id = ?";
	
	private static final String STOCK_HOLDING_BY_TRADER =  "select short_name,c_name,quantity,average_price,stocks.stock as s_id,current_price from trading_account,trader,stocks,company,stock_info where stocks.owner_id = trading_account.account_number and trading_account.trader_id = trader.trader_id and trader.trader_id = ? and company.stock_id = stocks.stock and company.stock_id = stock_info.stk_id";
	
	private static final String STOCK_HOLDING_BY_TRADER_STOCK =  "select short_name,c_name,quantity,average_price,stocks.stock as s_id,current_price from trading_account,trader,stocks,company,stock_info where stocks.owner_id = trading_account.account_number and trading_account.trader_id = trader.trader_id and trader.trader_id = ? and company.stock_id = ? and company.stock_id = stocks.stock and company.stock_id = stock_info.stk_id";
	
	public TraderDao() {
	}

	
	public Trader selectUser(int id) {
		Trader trader = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRADER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int age = rs.getInt("age");
				int trader_id = rs.getInt("trader_id");
				String gender = rs.getString("gender");
				String l_name = rs.getString("l_name");
				String f_name = rs.getString("f_name");
				String password = rs.getString("password");
				f_name = gender.compareTo("M") == 0 ? "Mr.":"Ms." + f_name; 
				trader = new Trader(gender, age, trader_id, l_name,f_name, password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return trader;
	}
	
	public List<StockHoldingDto> selectHoldingById(int id) {
		List<StockHoldingDto> stockHoldingDtos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(STOCK_HOLDING_BY_TRADER);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int quantity = rs.getInt("quantity");
				String short_name = rs.getString("short_name");
				String c_name = rs.getString("c_name");
				String average_price = rs.getString("average_price");
				String s_id = rs.getString("s_id");
				String current_price = rs.getString("current_price");
				StockHoldingDto stockHoldingDto = new StockHoldingDto(short_name, c_name, quantity,average_price,s_id,current_price);
				stockHoldingDtos.add(stockHoldingDto);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return stockHoldingDtos;
	}


	public StockHoldingDto selectHoldingByIdAndStock(int trader_id, int stock_id) {
		StockHoldingDto stockHoldingDto = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(STOCK_HOLDING_BY_TRADER);) {
			preparedStatement.setInt(1, trader_id);
			preparedStatement.setInt(1, stock_id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int quantity = rs.getInt("quantity");
				String short_name = rs.getString("short_name");
				String c_name = rs.getString("c_name");
				String average_price = rs.getString("average_price");
				String s_id = rs.getString("s_id");
				String current_price = rs.getString("current_price");
				stockHoldingDto = new StockHoldingDto(short_name, c_name, quantity,average_price,s_id,current_price);
				break;
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return stockHoldingDto;
	}
	
}
