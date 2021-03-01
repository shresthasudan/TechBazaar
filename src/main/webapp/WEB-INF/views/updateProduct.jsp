<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %> 
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>TechBazaar - Add Quantity</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/list/css/dataTables.bootstrap.css">
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
<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>
	<br>
	
	<div class ="container">
	<div class="row">
	<div class="col-sm-4">
	<a href="${pageContext.request.contextPath}/${product.id}/updateproductinfo">Update Product Information</a>
	</div>
	<div class="col-sm-8">
	<spring:form action="${pageContext.request.contextPath}/updateQuantity" modelAttribute="product" method="post">
	<div class="form-group">
	<spring:label class="col-sm-3 control-label" path="quantity">Add Quantity</spring:label>
	 <div class="col-sm-9">
	 <spring:input class="form-control" path="quantity"/>
     </div>
	</div>
	
	<div class="form-group">
	<input type="submit"value="update"/>
	</div>
	<spring:hidden path="id"/>
	<spring:hidden path="code"/>
	<spring:hidden path="brand"/>
	<spring:hidden path="category"/>
	<spring:hidden path="name"/>
	<spring:hidden path="description"/>
	<spring:hidden path="unit_price"/>
	<spring:hidden path="views"/>
	<spring:hidden path="supplier_name"/>
	<spring:hidden path="supplier_email"/>
	<spring:hidden path="quantity_limit"/>
	
	
	
	</spring:form>
	</div>
	</div>
	</div>
</body>
</html>