package com.demo.stocks.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.stocks.dao.BrokerDao;
import com.demo.stocks.model.Broker;


public class BrokersService {
	private BrokerDao brokerDAO;
	
	public BrokersService() {
		brokerDAO = new BrokerDao();
	}

	public void listAllData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Broker> listBroker = brokerDAO.selectAllBrokers();
		request.setAttribute("listBroker", listBroker);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/broker-list-details.jsp");
		dispatcher.forward(request, response);
	}

	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("broker-form.jsp");
		dispatcher.forward(request, response);
	}

	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Broker existingBroker = brokerDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("broker-form.jsp");
		request.setAttribute("broker", existingBroker);
		dispatcher.forward(request, response);

	}

	public void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		String b_name = request.getParameter("b_name");
		String commission = request.getParameter("commission");
		Broker newBroker = new Broker(b_id, b_name, commission);
		brokerDAO.insertBroker(newBroker);
		response.sendRedirect("broker-list");
	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		String b_name = request.getParameter("b_name");
		String commission = request.getParameter("commission");

		Broker broker = new Broker(b_id, b_name, commission);
		brokerDAO.updateBroker(broker);
		response.sendRedirect("broker-list");
	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		brokerDAO.deleteBroker(id);
		response.sendRedirect("broker-list");

	}

}
