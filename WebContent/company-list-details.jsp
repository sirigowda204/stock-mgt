<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Stock Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@include file="header.jsp" %>

	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Companies</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/company-new" class="btn btn-success">Add
					New Company</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Short Name</th>
						<th>Number of stocks</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="company" items="${listCompany}">

						<tr>
							<td><c:out value="${company.stock_id}" /></td>
							<td><c:out value="${company.c_name}" /></td>
							<td><c:out value="${company.short_name}" /></td>
							<td><c:out value="${company.number_of_stocks}" /></td>
							<td><a href="company-edit?id=<c:out value='${company.stock_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="company-delete?id=<c:out value='${company.stock_id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
<%@include file="footer.jsp" %>		
</body>
</html>
