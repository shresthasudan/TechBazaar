<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>TechBazaar -${title}</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/list/css/dataTables.bootstrap.css">



<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/shop-homepage.css" rel="stylesheet">

<script  type="text/javascript" src="${pageContext.request.contextPath}/resources/list/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/list/js/dataTables.bootstrap.js"></script>
	

</head>
<body>
<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>
	
	<div class="container">

	<div class="row">

		<div class="col-lg-3">

			<h1 class="my-4">Categories</h1>
			<div class="list-group">
				<c:forEach items="${categoryList}" var="category">
					<a href="${pageContext.request.contextPath}/category/${category.id}/all"
						class="list-group-item">${category.name}</a>
				</c:forEach>

			</div>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
						<c:if test="${clickedId==true}">
							<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="breadcrumb-item">Category</li>
							<li class="breadcrumb-item active">${breadcrumTagName}</li>
							
						</c:if>
						<c:if test="${clickedCategory==true}">
							<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
							
							<li class="breadcrumb-item active">${breadcrumTag}</li>
						</c:if>
						
						</ol>

					</div>
				</div>
			<!-- Data Table -->
			<table id ="myTable" class="table table-striped">
		<thead >
		<tr class="danger">
		
		<td>Image </td>
		<td>Name</td>
		<td>Brand</td>
		<td>Price</td>
		<td>Action</td>
		</tr>
		</thead>
		
		<tbody>
		
		  <c:forEach var="product"  items="${productList}">
		    <tr class="success">
		<td><img width="100px" src="${pageContext.request.contextPath}/resources/images/${product.code}.jpg"></td>
		<td>${product.name}</td>
		<td>${product.brand}</td>
		<td>&#8360; ${product.unit_price}</td>
		<td>
			<input type="submit" class="btn btn-primary" onclick="viewProduct(${product.id})" value="View">
			<c:if test="${role=='user'}">
			<input type="submit" class="btn btn-success" onclick="addProduct(${product.id})" value="Add to Cart">
			</c:if>
			<c:if test="${role=='staff'}">
			<input type="submit" class="btn btn-success" onclick="updateProduct(${product.id})" value="Update Product">
			</c:if>
		
			
		</td>
		</tr>
		  
		  
		  </c:forEach>
		  
		</tbody>
	
</table>

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>
<script type="text/javascript">

function viewProduct(Pid){
	  window.location= "${pageContext.request.contextPath}/"+Pid+"/view";
}
function addProduct(Pid){
		 window.location= "${pageContext.request.contextPath}/"+Pid+"/addToCart";
}
function updateProduct(Pid){
	 window.location= "${pageContext.request.contextPath}/"+Pid+"/updateProduct";
}

$(document).ready(function(){
    $('#myTable').DataTable();
});
</script>

</body>
</html>