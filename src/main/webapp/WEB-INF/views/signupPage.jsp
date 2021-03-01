<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TechBazaar Signup Page</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/list/css/dataTables.bootstrap.css">


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/list/js/dataTables.bootstrap.js"></script>

<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
<link href="resources/css/shop-homepage.css" rel="stylesheet">
</head>
<body>
<div class="container">
            <form class="form-horizontal" method="post" action="signup" role="form">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Full Name</label>
                    <div class="col-sm-9">
                        <input type="text" placeholder="Full Name" name="name" class="form-control" required autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" name="email" required class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">Username</label>
                    <div class="col-sm-9">
                        <input type="text" name="username" placeholder="Username" required class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-9">
                        <input type="password" placeholder="Password" name="password" required class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-3 control-label">Address</label>
                    <div class="col-sm-9">
                        <input type="text"  placeholder="Address" name="address" required class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="contact" class="col-sm-3 control-label">Contact</label>
                    <div class="col-sm-9">
                        <input type="text" name="contact" placeholder="Contact" required class="form-control">
                    </div>
                </div>
              
                
               
              
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" required>I accept <a href="#">terms</a>
                            </label>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->


</body>
</html>