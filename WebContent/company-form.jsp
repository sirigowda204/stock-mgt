<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Company Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<%@include file="header.jsp" %>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${company != null}">
					<form action="company-update" method="post">
				</c:if>
				<c:if test="${company == null}">
					<form action="company-insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${company != null}">
            			Edit Company
            		</c:if>
						<c:if test="${company == null}">
            			Add New Company
            		</c:if>
					</h2>
				</caption>

				<c:if test="${company != null}">
					<input type="hidden" name="stock_id" value="<c:out value='${company.stock_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Company Id</label> <input type="text"
						value="<c:out value='${company.stock_id}' />" class="form-control"
						name="stock_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Company Name</label> <input type="text"
						value="<c:out value='${company.c_name}' />" class="form-control"
						name="c_name">
				</fieldset>

				<fieldset class="form-group">
					<label>Company Short Name</label> <input type="text"
						value="<c:out value='${company.short_name}' />" class="form-control"
						name="short_name">
				</fieldset>

				<fieldset class="form-group">
					<label>Company Number of Stocks</label> <input type="text"
						value="<c:out value='${company.number_of_stocks}' />" class="form-control"
						name="number_of_stocks">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="footer.jsp" %>		
</body>
</html>
