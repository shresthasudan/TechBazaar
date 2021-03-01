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
<title>TechBazaar - Cart</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/list/css/dataTables.bootstrap.css">


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/list/js/dataTables.bootstrap.js"></script>

<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/shop-homepage.css" rel="stylesheet">

</head>
<body>
<%@ include file="./shared/navbar.jsp" %>
<hr>
<div>
<c:choose>
	<c:when test="${not empty cartList}">
		<!-- Data Table -->
			<table id ="myTable" class="table table-striped">
		<thead >
		<tr class="danger">
		
		<td>Image </td>
		<td>Name</td>
		<td>Brand</td>
		<td>Price</td>
		<td>Quantity</td>
		<td>Sub-Total</td>
		<td>Action</td>
		</tr>
		</thead>
		
		<tbody>
		  <c:forEach var="cart"  items="${cartList}">
		    <tr class="success">
		<td><img width="100px" src="${pageContext.request.contextPath}/resources/images/${cart.product.code}.jpg"></td>
		<td>${cart.product.name}</td>
		<td>${cart.product.brand}</td>
		<td>&#8360; ${cart.product.unit_price}</td>
		<!-- <td><form>
		<input type="number" step="1" name="quantity" value="1">
		</form></td> -->
		<%-- <td><input type="number" step="1" pattern="[1-3]" name="quantity" value="${cart.quantity}" autocomplete="off" ></td> --%>
		<td>
				<input id="cart_${cart.id}" type="number" min="1" max="3" value="${cart.quantity}" autocomplete="off" size="2">
		</td>
		<td>&#8360; ${cart.subTotal}</td>
		<td>
			<c:if test="${role=='user'}">
			<button type="button" name ="refreshCart" class="btn btn-primary" value="${cart.id}">Refresh</button>
			<input type="submit" class="btn btn-success" onclick="removeProduct(${cart.id})" value="Remove">
			</c:if>
			
		</td>
		</tr>
		  
		  
		  </c:forEach>
		</tbody>
	
</table>
<div id="purchaseBtn">
<div><h2>Total : &#8360;. ${userTotal}</h2></div>
	<input type="submit" class="btn btn-primary" onclick="makeOrder()" value="Purchase ">
</div>
	</c:when>
	
	<c:otherwise>
	<div class="jumbotron">
	<div class="text-center">
	<h2>Your Cart is empty!</h2>
	</div>
	</div>
	</c:otherwise>

</c:choose>



</div>

<script type="text/javascript">
$('button[name="refreshCart"]').click(function(){
	var cartId=$(this).attr('value');
	var countElement =$('#cart_'+cartId);
	var originalQuantity=countElement.attr('value');
	var updatedQuantity=countElement.val();
	if(originalQuantity!==updatedQuantity){
		if(updatedQuantity<1||updatedQuantity>3){
			alert("Quantity should be minimum 1 and maximum 3");
			countElement.val(originalQuantity);
		}
		else{
			var updateUrl="${pageContext.request.contextPath}/"+cartId+"/updateCart?count="+updatedQuantity;
			window.location=updateUrl;
		}
		
	}
	
	
});


function removeProduct(Cid){
		 window.location= "${pageContext.request.contextPath}/"+Cid+"/removeCart";
}
function makeOrder(){
	  window.location= "${pageContext.request.contextPath}/MakeOrder";
}

$(document).ready(function(){
    $('#myTable').DataTable();
});
</script>
</body>
</html>