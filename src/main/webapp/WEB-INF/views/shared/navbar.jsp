<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">TechBazaar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
      			<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" id="searchTag">
            </li>
            <li class="nav-item">
            	<button class="btn btn-outline-success my-2 my-sm-0" onclick="search()">Search</button>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/category/all">View Products</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/report">Report</a>
            </li>
          
            <c:if test="${login==true}">
            <c:if test="${role=='admin'}">
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/${id}/updateUserInfo">Update Info</a>
            </li>
               <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/StaffList">Staff List</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/UserList">User List</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/PurchasedList">Purchased List</a>
            </li>
               	 <li class="nav-item">
              <a class="nav-link" href="#">${username}</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </li>
            </c:if>
            <c:if test="${role=='staff'}">
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/${id}/updateUserInfo">Update Info</a>
            </li>
               <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/AddProduct">Add Products</a>
            </li>
               <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/ViewOrders">View Orders</a>
            </li>
               	 <li class="nav-item">
              <a class="nav-link" href="#">${username}</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </li>
            </c:if>
            <c:if test="${role=='user'}">
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/${id}/updateUserInfo">Update Info</a>
            </li>
            	   	 <li class="nav-item">
              <a class="nav-link" href="#">${username}</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/${id}/cart"><span id="shoppingCart" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Cart</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </li>
            </c:if>
  
            </c:if>
            
            <c:if test="${!login==true}">
            		<li class="dropdown nav-item">
          <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
			<ul id="login-dp" class="dropdown-menu">
				<li>
					 <div class="row">
							<div class="col-md-12">
								Login info
								 <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											 <label class="sr-only" for="exampleInputEmail2">Username</label>
											 <input type="text" class="form-control" placeholder="Username" name="username" required>
										</div>
										<div class="form-group">
											 <label class="sr-only" for="exampleInputPassword2">Password</label>
											 <input type="password" class="form-control" name="password" placeholder="Password" required>
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
										</div>
								 </form>
							</div>
							<div class="bottom text-center">
								New here ? <a href="${pageContext.request.contextPath}/signup"><b>Join Us</b></a>
							</div>
					 </div>
				</li>
			</ul>
        </li>
            </c:if>
           
             
            
          </ul>
        </div>
      </div>
</nav>
<script type="text/javascript">

	function search(){
		var searchKey = $(document).getElementById("searchTag");
	    var key = searchKey.value();
	    alert(key);
	    if(key!=null){
	    	window.location= "${pageContext.request.contextPath}/searchProduct?key="+key;
	    }
	}
</script>
