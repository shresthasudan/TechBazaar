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
<title>TechBazaar - ${title}</title>

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
		<td>Action</td>
		</tr>
		</thead>
		
		<tbody>
		
		  <c:forEach var="user"  items="${userList}">
		    <tr class="success">
		
		<td>${user.username}</td>
		<td>${user.name}</td>
		<td>${user.contact}</td>
		<td>${user.address}</td>
		<td>
			<c:if test="${list=='staff'}">
			<input type="submit" class="btn btn-primary" onclick="demoteUser(${user.id})" value="Remove from Staff">
			</c:if>
			<c:if test="${list=='user'}">
			<input type="submit" class="btn btn-primary" onclick="promoteUser(${user.id})" value="Promote to Staff">
			</c:if>
		</td>
		</tr>
		  
		  
		  </c:forEach>
		  
		</tbody>
	
</table>
</div>

<script type="text/javascript">

function demoteUser(Uid){
	  window.location= "${pageContext.request.contextPath}/"+Uid+"/DemoteUser";
}
function promoteUser(Uid){
	  window.location= "${pageContext.request.contextPath}/"+Uid+"/promoteUser";
}

$(document).ready(function(){
    $('#myTable').DataTable();
});
</script>
</body>
</html>