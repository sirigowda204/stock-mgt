<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Broker Management</title>
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
				<c:if test="${broker != null}">
					<form action="broker-update" method="post">
				</c:if>
				<c:if test="${broker == null}">
					<form action="broker-insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${broker != null}">
            			Edit Broker
            		</c:if>
						<c:if test="${broker == null}">
            			Add New Broker
            		</c:if>
					</h2>
				</caption>

				<c:if test="${broker != null}">
					<input type="hidden" name="b_id" value="<c:out value='${broker.b_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Broker Id</label> <input type="text"
						value="<c:out value='${broker.b_id}' />" class="form-control"
						name="b_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Broker Name</label> <input type="text"
						value="<c:out value='${broker.b_name}' />" class="form-control"
						name="b_name">
				</fieldset>

				<fieldset class="form-group">
					<label>Broker commission</label> <input type="text"
						value="<c:out value='${broker.commission}' />" class="form-control"
						name="commission">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="footer.jsp" %>		
</body>
</html>
