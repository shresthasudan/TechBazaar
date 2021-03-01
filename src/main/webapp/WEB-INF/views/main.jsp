
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
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

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="d-block img-fluid" src="${pageContext.request.contextPath}/resources/images/1.jpg"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid" src="${pageContext.request.contextPath}/resources/images/2.jpg"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid" src="${pageContext.request.contextPath}/resources/images/3.jpg"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
			<hr>
			<c:if test="${role=='user'}">
				<a href="${pageContext.request.contextPath}/recommendation">Recommendation</a>
			</c:if>
			
			<hr>
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