<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<!-- Bootstrap core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/shop-homepage.css" rel="stylesheet">
<title>TechBazaar - ${title}</title>
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
				<hr>
				<div>
				<a href="${pageContext.request.contextPath}/AddCategory">ADD CATEGORY</a>
				</div>
				
				<hr>
				<h1 class="my-4">Suppliers</h1>
				<div class="list-group">
					<c:forEach items="${supplierList}" var="supplier">
						<p>${supplier.name}</p>
					</c:forEach>

				</div>
				<hr>
				<div>
				<a href="${pageContext.request.contextPath}/AddSupplier">ADD SUPPLIER</a>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<div class="row">
					<div class="col-lg-12">

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="breadcrumb-item active">${title}</li>
						</ol>

					</div>
				</div>
				<div class="container">
					<form action="AddProduct" class="container" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label>Name</label> <input type="text" class="form-controle"
								placeholder="Name" name="name" required>
						</div>


						<div class="form-group">
							<label>Brand</label> <input type="text" class="form-control"
								placeholder="Brand Name" name="brand" required>
						</div>
						<div class="form-group">
							<label for="file">Select An Image</label> <input type="file" path="file" name="file" class="form-control" required>
						</div>

						<div class="form-group">
							<label>Description</label>
							<textarea class="form-control" placeholder="Product Description"
								name="description" rows="3" required></textarea>
						</div>

						<div class="form-group">
							<label>Price</label> <input type="number" step="0.01"
								class="form-control" placeholder="price" name="unit_price" required>
						</div>

						<div class="form-group">
							<label>Quantity</label> <input type="number" step="1"
								class="form-control" placeholder="quantity" name="quantity" required>
						</div>

						<div class="form-group">
							<label>Select Category</label> 
							<select class="form-control"  name="categoryId" id="categoryId">
								<option>select category</option>
								<c:forEach items="${categoryList}" var="categories">
									<option value="${categories.id}">${categories.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Select Supplier</label> 
							<select class="form-control"  name="supplierId" id="supplierId">
								<option>select supplier</option>
								<c:forEach items="${supplierList}" var="supplier">
									<option value="${supplier.id}">${supplier.name}</option>
								</c:forEach>
							</select>
						</div>
						<button class="btn btn-success">ADD PRODUCT</button>
					</form>


				</div>

				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>





	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>