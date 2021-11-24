<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #2874f0; color:white">
			<div>
				<a class="navbar-brand"> Stock
					Management App </a>
			</div>

			<ul class="navbar-nav">
			<c:if test="${sessionScope.admin != null}">
				<li><a href="<%=request.getContextPath()%>/broker-list"
					class="nav-link">Brokers</a></li>
				<li><a href="<%=request.getContextPath()%>/company-list"
					class="nav-link">Company</a></li>
			</c:if>					
			<c:if test="${sessionScope.trader != null}">
				<li><a href="<%=request.getContextPath()%>/holding"
					class="nav-link">Sell</a></li>
				<li><a href="<%=request.getContextPath()%>/buy"
					class="nav-link">Buy</a></li>					
			</c:if>
		</ul>
			<ul class="navbar-nav ml-auto">
			<c:if test="${sessionScope.trader != null || sessionScope.admin != null}" > 
				<li><a href="#" class="nav-link">Hello <c:out value="${sessionScope.admin != null ? 'Admin': sessionScope.trader.l_name}" /></a></li>
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</c:if>
			<c:if test="${sessionScope.trader == null && sessionScope.admin == null}" > 
				<li><a href="<%=request.getContextPath()%>/login"
					class="nav-link">Login</a></li>
			</c:if>
			</ul>
		</nav>
	</header>
