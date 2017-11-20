<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextroot}/home">Online Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav">
				<li class="nav-item " id="home"><a class="nav-link"
					href="${contextroot}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextroot}/about">About</a></li>
					
				<li class="nav-item" id="products"><a class="nav-link"
					href="${contextroot}/show/all/products">Products</a></li>
					
				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextroot}/contact">Contact</a></li>
					
				<security:authorize access="hasAuthority('ADMIN')">	
					
				<li class="nav-item" id="manageProducts"><a class="nav-link"
					href="${contextroot}/manage/products">Manage Products</a></li>
				</security:authorize>
			
			</ul>
			
			
			<ul class="nav navbar-nav ml-auto">
				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="register"><a class="nav-link"
						href="${contextroot}/register">Sign Up</a></li>
					<li class="nav-item" id="login"><a class="nav-link"
						href="${contextroot}/login">Login</a></li>
				</security:authorize>

				<!--  <li class="dropdown"><a href="javascript:void(0)"
					class="btn btn-default dropdown-toggle" id="dropdownMenu1"
					data-toggle="dropdown"> Full Name <span class="caret"></span>
				</a>

					<ul class="dropdown-menu">

						<li><a href="${contexroot }/cart"> <i
								class="fa fa-shopping-cart" aria-hidden="true"></i> <span
								class="badge">0</span> - &#8377; 0.0
						</a></li>
						<li class="divider" role="seperator"></li>
						<li><a href="${contextroot }/logout">Logout</a></li>

					</ul></li>-->
				&nbsp;&nbsp;&nbsp;

				<security:authorize access="isAuthenticated()">
					<div class="dropdown" id="userCart">
						<button type="button" class="btn btn-success dropdown-toggle"
							data-toggle="dropdown" id="dropdownMenu1">
							${userModel.fullName } <span class="caret"></span>
						</button>
						<div class="dropdown-menu">
						
						<security:authorize access="hasAuthority('USER')">
						
							<a class="dropdown-item" href="${contextroot }/cart/show"> <i
								class="fa fa-shopping-cart" aria-hidden="true"></i><span
								class="badge">${userModel.cart.cartLines} </span> - &#8377;
								${userModel.cart.grandTotal }
							</a>

							<div class="dropdown-divider"></div>
							
							</security:authorize>
							<a class="dropdown-item" href="${contextroot }/perform-logout">Logout</a>
						</div>
					</div>



				</security:authorize>


			</ul>
		</div>
	</div>
</nav>



<script>


window.userRole = '${userModel.role}';

</script>









