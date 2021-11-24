package com.demo.stocks.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.stocks.services.BrokersService;
import com.demo.stocks.services.CompanyService;
import com.demo.stocks.services.TraderService;

@WebServlet("/")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BrokersService brokersService;
	private CompanyService companyService;
	private TraderService traderService;
	
	public void init() {
		brokersService = new BrokersService();
		companyService = new CompanyService();
		traderService = new TraderService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/broker-new":
				brokersService.showNewForm(request, response);
				break;
			case "/broker-insert":
				brokersService.insertUser(request, response);
				break;
			case "/broker-delete":
				brokersService.deleteUser(request, response);
				break;
			case "/broker-edit":
				brokersService.showEditForm(request, response);
				break;
			case "/broker-update":
				brokersService.updateUser(request, response);
				break;
			case "/broker-list":
				brokersService.listAllData(request, response);
				break;				
			case "/company-new":
				companyService.showNewForm(request, response);
				break;
			case "/company-insert":
				companyService.insertUser(request, response);
				break;
			case "/company-delete":
				companyService.deleteUser(request, response);
				break;
			case "/company-edit":
				companyService.showEditForm(request, response);
				break;
			case "/company-update":
				companyService.updateUser(request, response);
				break;	
			case "/company-list":
				companyService.listAllData(request, response);
				break;
			case "/login-submit":
				traderService.verifyLogin(request, response);
				break;	
			case "/login":
				redirectLogin(request, response);
				break;
			case "/holding":
				traderService.displayHolding(request, response);
				break;	
			case "/sell-stock":
				traderService.sellStock(request, response);
				break;
			case "/buy":
				traderService.listAllData(request, response);
				break;					
			case "/logout":
				redirectLogout(request, response);
				break;		
			default:
				redirectLogin(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void redirectLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void redirectLogout(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession(false);
		if(session != null)  
			session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}
}
