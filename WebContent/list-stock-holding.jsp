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
function clickSell(c_name,stock_qty,buyQty) {
  var buyQty = parseFloat(document.getElementById(buyQty).value);
  console.log(" ",buyQty,c_name,stock_qty);
  if(buyQty < stock_qty)
  {
	  alert('Sell Order placed for ' + buyQty + ' shares of ' + c_name + ' and shall reflet by EOD' );
  }
  else
  {
	  alert('Sell Request Order for ' + buyQty + ' shares cannot be greater than avl ' + stock_qty);
  }
  return false;
}
</script>
<body>
<%@include file="header.jsp" %>

	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Current Holding</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Trade Code</th>
						<th>Full Name</th>
						<th>Number of stocks held</th>
						<th>Average Price</th>
						<th>Current Price</th>
						<th>Quantity to Sell</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stockHolding" items="${listStockHolding}">

						<tr>
							<td><c:out value="${stockHolding.short_name}" /></td>
							<td><c:out value="${stockHolding.c_name}" /></td>
							<td><c:out value="${stockHolding.quantity}" /></td>
							<td><c:out value="${stockHolding.average_price}" /></td>
							<td><c:out value="${stockHolding.current_price}" /></td>
							<td>
								<form action="" method="post">
									<fieldset class="form-group d-inline-block form-adjust">
										<input type="text"
											class="form-control" name="quantity" required="required" id="${stockHolding.s_id}">
									</fieldset>
									<button type="submit" class="btn btn-success" onclick="clickSell('${stockHolding.c_name}','${stockHolding.quantity}','${stockHolding.s_id}')">Sell</button>
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
