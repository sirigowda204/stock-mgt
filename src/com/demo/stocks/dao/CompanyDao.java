package com.demo.stocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.stocks.model.Company;
import com.demo.stocks.model.Stockinfo;

public class CompanyDao extends BaseDao{
	private static final String INSERT_COMPANYS_SQL = "INSERT INTO company" + "  (stock_id, c_name, short_name,number_of_stocks) VALUES "
			+ " (?, ?, ?,?);";

	private static final String SELECT_COMPANY_BY_ID = "select stock_id,c_name,short_name,number_of_stocks from company where stock_id = ?";
	private static final String SELECT_ALL_COMPANYS = "select * from company left outer join stock_info on company.stock_id = stock_info.stk_id";
	private static final String DELETE_COMPANYS_SQL = "delete from company where stock_id = ?;";
	private static final String UPDATE_COMPANYS_SQL = "update company set stock_id = ?,c_name= ?, short_name =?,number_of_stocks=? where stock_id = ?;";

	public CompanyDao() {
	}

	public void insertCompany(Company company) throws SQLException {
		System.out.println(INSERT_COMPANYS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPANYS_SQL)) {
			preparedStatement.setInt(1, company.getStock_id());
			preparedStatement.setString(2, company.getC_name());
			preparedStatement.setString(3, company.getShort_name());
			preparedStatement.setInt(4, company.getNumber_of_stocks());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Company selectUser(int id) {
		Company company = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMPANY_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int stock_id = rs.getInt("stock_id");
				String c_name = rs.getString("c_name");
				String short_name = rs.getString("short_name");
				int number_of_stocks = rs.getInt("number_of_stocks");
				company = new Company(stock_id, c_name, short_name,number_of_stocks);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return company;
	}

	public List<Company> selectAllCompanys() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Company> companys = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPANYS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int stock_id = rs.getInt("stock_id");
				String c_name = rs.getString("c_name");
				String short_name = rs.getString("short_name");
				int number_of_stocks = rs.getInt("number_of_stocks");
				int current_price = rs.getInt("current_price");
				Stockinfo stockinfo = new Stockinfo();
				stockinfo.setCurrent_price(current_price);
				companys.add(new Company(stock_id, c_name,short_name,number_of_stocks,stockinfo));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return companys;
	}

	public boolean deleteCompany(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_COMPANYS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateCompany(Company company) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_COMPANYS_SQL);) {
			statement.setInt(1, company.getStock_id());
			statement.setInt(5, company.getStock_id());
			statement.setString(2, company.getC_name());
			statement.setString(3, company.getShort_name());
			statement.setInt(4, company.getNumber_of_stocks());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
