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
<script>
function clickBuy(c_name,stock_qty,buyQty) {
  var buyQty = document.getElementById(buyQty).value;
  if(buyQty < stock_qty)
  {
	  alert('Order placed for ' + buyQty + ' shares of ' + c_name + ' and shall reflet by EOD' );
  }
  else
  {
	  alert('Request Order for ' + buyQty + ' shares cannot be greater than avl ' + stock_qty);
  }
}
</script>
<body>
<%@include file="header.jsp" %>

	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Stocks</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Short Name</th>
						<th>Number of stocks</th>
						<th>Current Price</th>
						<th>Quantity to Buy</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="company" items="${listCompany}">

						<tr>
							<td><c:out value="${company.stock_id}" /></td>
							<td><c:out value="${company.c_name}" /></td>
							<td><c:out value="${company.short_name}" /></td>
							<td><c:out value="${company.number_of_stocks}" /></td>
							<td><c:out value="${company.stockinfo.current_price}" /></td>
							<td>
								<form action="" method="post">
								<input type="hidden" id="c_name" value="<c:out value='${company.c_name}' />" />
								<input type="hidden" id="stock_qty" value="<c:out value='${company.number_of_stocks}' />" />
									<fieldset class="form-group d-inline-block form-adjust">
										 <input type="text"
											class="form-control" name="quantity" required="required" id="${company.stock_id}">
									</fieldset>
									<button type="submit" class="btn btn-success" onclick="clickBuy('${company.c_name}','${company.number_of_stocks}','${company.stock_id}')">Buy</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
<%@include file="footer.jsp" %>		
</body>
</html>
