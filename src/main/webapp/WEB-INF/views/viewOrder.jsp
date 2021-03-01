<%@page import="com.majorProject.techbazaar.model.Product"%>
<%@page import="com.majorProject.techbazaar.daos.ProductDaos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TechBazaar - Order List</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/list/css/dataTables.bootstrap.css">
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/shop-homepage.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->

<script  type="text/javascript" src="${pageContext.request.contextPath}/resources/list/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/list/js/dataTables.bootstrap.js"></script>
	

</head>
<body>
<%@ include file="./shared/navbar.jsp" %>
<hr>
<div>
<!-- Data Table -->
			<table id ="myTable" class="table table-striped">
		<thead >
		<tr class="danger">
		
		<td>UserName</td>
		<td>Full Name</td>
		<td>Contact</td>
		<td>Address</td>
		<td>Product Name</td>
		<td>Brand</td>
		<td>Quantity</td>
		<td>Order Date</td>
		<td>Action</td>
		</tr>
		</thead>
		
		<tbody>
		
		  <c:forEach var="purchased"  items="${orderList}">
		    <tr class="success">
		
		<td>${purchased.cart.user.username}</td>
		<td>${purchased.cart.user.name}</td>
		<td>${purchased.cart.user.contact}</td>
		<td>${purchased.cart.user.address}</td>
		<td>${purchased.cart.product.name}</td>
		<td>${purchased.cart.product.brand}</td>
		<td>${purchased.cart.quantity}</td>
		<td>${purchased.orderedDate}</td>
		<td>
			<input type="submit" class="btn btn-primary" onclick="deliverItem(${purchased.id})" value="Deliver">
		</td>
		</tr>
		  
		  
		  </c:forEach>
		  
		</tbody>
	
</table>
</div>

<script type="text/javascript">

function deliverItem(Pid){
	  window.location= "${pageContext.request.contextPath}/"+Pid+"/Deliver";
}

$(document).ready(function(){
    $('#myTable').DataTable();
});
</script>
</body>
</html>