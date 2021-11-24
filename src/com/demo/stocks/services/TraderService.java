package com.demo.stocks.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.stocks.dao.CompanyDao;
import com.demo.stocks.dao.TraderDao;
import com.demo.stocks.dto.StockHoldingDto;
import com.demo.stocks.model.Company;
import com.demo.stocks.model.Trader;


public class TraderService {
	private TraderDao traderDao;
	private CompanyDao companyDao;
	
	public TraderService() {
		traderDao = new TraderDao();
		companyDao = new CompanyDao();
	}

	public void verifyLogin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String username = request.getParameter("trader_id");
		String password = request.getParameter("password");
		if(username.equalsIgnoreCase("admin"))
		{
			if(password.equals("@admin123"))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("admin", "admin");
				response.sendRedirect("company-list");
			}
			else
			{
				response.sendRedirect("login");
			}
		}
		else
		{
			int trader_id = Integer.parseInt(request.getParameter("trader_id"));
			Trader trader = traderDao.selectUser(trader_id);
			if(trader.getPassword().equals(password))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("trader", trader);
				response.sendRedirect("holding");
			}
			else
			{
				response.sendRedirect("login");
			}
		}
		
	}
	
	public void displayHolding(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession(false);
		Trader trader =  (Trader) session.getAttribute("trader");
		if(null == trader)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			List<StockHoldingDto> stockHoldingDtos = traderDao.selectHoldingById(trader.getTrader_id());
			request.setAttribute("listStockHolding", stockHoldingDtos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-stock-holding.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public void listAllData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Company> listCompany = companyDao.selectAllCompanys();
		request.setAttribute("listCompany", listCompany);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-stock-buying.jsp");
		dispatcher.forward(request, response);
	}

	public void sellStock(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		HttpSession session = request.getSession(false);
		Trader trader =  (Trader) session.getAttribute("trader");
		if(null == trader)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int stock_id = Integer.parseInt(request.getParameter("stock_id"));
			
			StockHoldingDto stockHoldingDto = traderDao.selectHoldingByIdAndStock(trader.getTrader_id(),stock_id);
			if(stockHoldingDto.getQuantity()>quantity)
			{
				
			}
		}
		
	}

}
