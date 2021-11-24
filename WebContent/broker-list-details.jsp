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
			<h3 class="text-center">List of Brokers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/broker-new" class="btn btn-success">Add
					New Broker</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>commission</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="broker" items="${listBroker}">

						<tr>
							<td><c:out value="${broker.b_id}" /></td>
							<td><c:out value="${broker.b_name}" /></td>
							<td><c:out value="${broker.commission}" /></td>
							<td><a href="broker-edit?id=<c:out value='${broker.b_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="broker-delete?id=<c:out value='${broker.b_id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
<%@include file="footer.jsp" %>	
</body>
</html>
