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
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/list/css/dataTables.bootstrap.css">
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/shop-homepage.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/singleProduct.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/rating.css">
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
	
	
<div class="container">
<br>

	<div class="row">
		<div class="col-sm-4 item-photo">
        	<img  src="${pageContext.request.contextPath}/resources/images/${p.code}.jpg" id="productImage" />
        </div>
        <div class="col-xm-3">
        </div>
        <div class="col-xm-5" style="border:0px solid gray">
                    <h1>${p.name}</h1><br><br>
                    <h2>Brand : ${p.brand}</h2><br>
                    <h3>Description:</h3>
                    <h3>${p.description}</h3>
                    <br>
                    <h3>Price : &#8360; ${p.unit_price}</h3>
                    <br>
                    <c:if test="${role=='user'}">
                    <div class="section" style="padding-bottom:20px;">
                        <input type="submit" class="btn btn-success" onclick="addProduct(${p.id})" value="Add to Cart">
                    </div> 
                    </c:if>                                       
                </div> 
		

	</div>
	<br><br>
	<h3>Total Rating : ${totalRating} star(s).</h3>
	<c:if test="${role=='user'}">
	<div class="row">
		<div class="col-lg-12">
		<div class="star-rating">
        	<span class="fa fa-star-o" data-rating="1"></span>
        	<span class="fa fa-star-o" data-rating="2"></span>
        	<span class="fa fa-star-o" data-rating="3"></span>
        	<span class="fa fa-star-o" data-rating="4"></span>
        	<span class="fa fa-star-o" data-rating="5"></span>
        	<input type="hidden" name="whatever1" class="rating-value" value="${yourRating}">
      </div>
      
			<textarea id="reviewArea" placeholder="Write A review" rows="3" type="text"></textarea>
				<button id="postbtn" type="button" name="postbtn">
					Post
				</button>
			
				
			
		</div>
	</div>
	</c:if>
		
	
	<div class="row">
		<div class="col-xs-8">
		<label style="color=rgb(20,200,50)">User's Reviews</label>
		<c:forEach items="${productReview}" var="review">
			<hr style="width=100%">
			<div><strong><span id="usernameArea">${review.user.username}</span></strong><br>
			<label style="width=100%">${review.comment}.</label></div>
		
		</c:forEach>
			
		</div>
	</div>
	</div>
	
 <script type="text/javascript">
$('button[name="postbtn"]').click(function (){
	var commentElement=$('#reviewArea');
	var comment=commentElement.val();
	//alert(comment);
	commentElement.val("");
		 window.location= "${pageContext.request.contextPath}/addComment?cmt="+comment;
});

var $star_rating = $('.star-rating .fa');

var SetRatingStar = function() {
  return $star_rating.each(function() {
    if (parseInt($star_rating.siblings('input.rating-value').val()) >= parseInt($(this).data('rating'))) {
      
      return $(this).removeClass('fa-star-o').addClass('fa-star');
    } else {
      return $(this).removeClass('fa-star').addClass('fa-star-o');
    }
  });
};

$star_rating.on('click', function() {
  $star_rating.siblings('input.rating-value').val($(this).data('rating'));
  //alert($(this).data('rating')+" hello");
  var rate=$(this).data('rating');
  window.location= "${pageContext.request.contextPath}/addRating?rate="+rate;
  return SetRatingStar();
});

SetRatingStar();

$(document).ready(function() {

});

</script> 
<!--  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/rating.js"></script>-->
</body>
</html>