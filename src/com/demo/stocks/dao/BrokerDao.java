package com.demo.stocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.stocks.model.Broker;

public class BrokerDao extends BaseDao{
	private static final String INSERT_BROKERS_SQL = "INSERT INTO broker" + "  (b_id, b_name, commission) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_BROKER_BY_ID = "select b_id,b_name,commission from broker where b_id = ?";
	private static final String SELECT_ALL_BROKERS = "select * from broker";
	private static final String DELETE_BROKERS_SQL = "delete from broker where b_id = ?;";
	private static final String UPDATE_BROKERS_SQL = "update broker set b_id = ?,b_name= ?, commission =? where b_id = ?;";

	public BrokerDao() {
	}

	public void insertBroker(Broker broker) throws SQLException {
		System.out.println(INSERT_BROKERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BROKERS_SQL)) {
			preparedStatement.setInt(1, broker.getB_id());
			preparedStatement.setString(2, broker.getB_name());
			preparedStatement.setString(3, broker.getCommission());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Broker selectUser(int id) {
		Broker broker = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BROKER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int b_id = rs.getInt("b_id");
				String b_name = rs.getString("b_name");
				String commission = rs.getString("commission");
				broker = new Broker(b_id, b_name, commission);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return broker;
	}

	public List<Broker> selectAllBrokers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Broker> brokers = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BROKERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int b_id = rs.getInt("b_id");
				String b_name = rs.getString("b_name");
				String commission = rs.getString("commission");
				brokers.add(new Broker(b_id, b_name,commission));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return brokers;
	}

	public boolean deleteBroker(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BROKERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateBroker(Broker broker) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BROKERS_SQL);) {
			statement.setInt(1, broker.getB_id());
			statement.setInt(4, broker.getB_id());
			statement.setString(2, broker.getB_name());
			statement.setString(3, broker.getCommission());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
