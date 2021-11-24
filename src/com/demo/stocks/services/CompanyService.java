package com.demo.stocks.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.stocks.dao.CompanyDao;
import com.demo.stocks.model.Company;


public class CompanyService {
	private CompanyDao companyDao;
	
	public CompanyService() {
		companyDao = new CompanyDao();
	}

	public void listAllData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Company> listCompany = companyDao.selectAllCompanys();
		request.setAttribute("listCompany", listCompany);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/company-list-details.jsp");
		dispatcher.forward(request, response);
	}

	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("company-form.jsp");
		dispatcher.forward(request, response);
	}

	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Company existingCompany = companyDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("company-form.jsp");
		request.setAttribute("company", existingCompany);
		dispatcher.forward(request, response);

	}

	public void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int stock_id = Integer.parseInt(request.getParameter("stock_id"));
		String c_name = request.getParameter("c_name");
		String short_name = request.getParameter("short_name");
		int number_of_stocks = Integer.parseInt(request.getParameter("number_of_stocks"));
		Company newCompany = new Company(stock_id, c_name, short_name,number_of_stocks);
		companyDao.insertCompany(newCompany);
		response.sendRedirect("company-list");
	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int stock_id = Integer.parseInt(request.getParameter("stock_id"));
		String c_name = request.getParameter("c_name");
		String short_name = request.getParameter("short_name");
		int number_of_stocks = Integer.parseInt(request.getParameter("number_of_stocks"));
		Company company = new Company(stock_id, c_name, short_name,number_of_stocks);
		companyDao.updateCompany(company);
		response.sendRedirect("company-list");
	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		companyDao.deleteCompany(id);
		response.sendRedirect("company-list");

	}

}
