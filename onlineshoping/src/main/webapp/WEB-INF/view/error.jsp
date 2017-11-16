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

<body>
	<div class="wrapper">


		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${contextroot}/home">Online
					Shopping</a>

			</div>
		</nav>

		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
					
					<div class="jumbotron">
						<h1>${errorTitle }</h1>
						<hr>
						<blockquote style="word-wrap:break-word">
							${errorDescription }
						</blockquote>
					</div>
					
					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>



		<!-- Bootstrap core JavaScript -->
		<script src="${js }/jquery.js"></script>
		<script src="${js }/bootstrap.bundle.min.js"></script>

		<script src="${js }/jquery.dataTables.js"></script>
		<script src="${js }/dataTables.bootstrap4.js"></script>

		<script src="https://use.fontawesome.com/9d011fdd6d.js"></script>


		<script src="${js }/myapp.js"></script>

	</div>
</body>

</html>