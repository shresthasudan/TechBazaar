<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %> 
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>TechBazaar - update User</title>

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
	<div class="container">
	<spring:form action="${pageContext.request.contextPath}/updateUser" modelAttribute="user" method="post">
	<div class="form-group">
	<spring:label class="col-sm-3 control-label" path="name">Name</spring:label>
	 <div class="col-sm-9">
	 <spring:input class="form-control" path="name"/>
     </div>
	</div>
	<div class="form-group">
	<spring:label class="col-sm-3 control-label" path="email">E-mail</spring:label>
	 <div class="col-sm-9">
	 <spring:input class="form-control" path="email"/>
     </div>
	</div>
	<div class="form-group">
	<spring:label class="col-sm-3 control-label" path="address">Adderss</spring:label>
	 <div class="col-sm-9">
	 <spring:input class="form-control" path="address"/>
     </div>
	</div>
	<div class="form-group">
	<spring:label class="col-sm-3 control-label" path="contact">Contact</spring:label>
	 <div class="col-sm-9">
	 <spring:input class="form-control" path="contact"/>
     </div>
	</div>
	
	<div class="form-group">
	<input type="submit"value="update"/>
	</div>
	
	<spring:hidden path="username"/>
	<spring:hidden path="password"/>
	
	<spring:hidden path="role"/>
	<spring:hidden path="id"/>
	</spring:form>
	</div>
	


</body>
</html>