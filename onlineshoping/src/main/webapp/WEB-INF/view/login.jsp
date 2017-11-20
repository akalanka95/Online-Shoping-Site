<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextroot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shoping - ${title}</title>


<script>
	window.menu = '${title}';
	window.root = '${contextroot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootswatch theme -->
<link href="${css}/bootswatchtheme.css" rel="stylesheet">


<!-- Bootswatch for the dataTable -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">




</head>

<body style="padding-top : 0px">


	<div class="wrapper">


		<!-- Navigation -->

		<nav class="navbar navbar-fixed-top" role="navigation">


			<div class="navbar-header">
				<a class="navbar-brand" href="${contextroot }/home">Home</a>
			</div>




		</nav>

		<div class="container">

				<c:if test="${not empty message }">
				
					<div class="row">
					
					<div class="col-8 mx-auto">
						<div class="alert alert-danger">${message }</div>
					
					</div>
					
					</div>
				</c:if>


		<c:if test="${not empty logout }">
				
					<div class="row">
					
					<div class="col-8 mx-auto">
						<div class="alert alert-success">${logout }</div>
					
					</div>
					
					</div>
				</c:if>
		


			<div class="col-8 mx-auto">

				<div class="card card-primary">

					<div class="card-header">
						<h4>Login</h4>
					</div>

					<div class="card-body">

						<form method="POST" id="loginForm" action="${contextroot }/login">
							<div class="form-group row">

								<label for="username" class="col-md-3 col-form-label ">
									Email </label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="username" name="username"
								 placeholder="Enter Email" />
									
								</div>


							</div>
							
							<div class="form-group row">

								<label for="password" class="col-md-3 col-form-label ">
									Password </label>
								<div class="col-md-9">
									<input type="password" class="form-control" id="password" name="password"
								 placeholder="Enter Password" />
									
								</div>


							</div>
							
							<div class="form-group row">
							
								<div class="offset-md-4 col-md-4">
								
								<input type="submit" value="Login" class="btn btn-primary"/>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								</div>
							
							</div>							
							
							</form> 
					
					</div>
				</div>
			</div>







		</div>


		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>



		<!-- Bootstrap core JavaScript -->
		<script src="${js }/jquery.js"></script>
		<script src="${js }/jquery.validate.min.js"></script>
		<script src="${js }/bootstrap.bundle.min.js"></script>

		<script src="${js }/bootbox.min.js"></script>


		<script src="https://use.fontawesome.com/9d011fdd6d.js"></script>


		<script src="${js }/myapp.js"></script>

	</div>
</body>

</html>
