<div class="container">
	<div class="row">
		<div class="col-sm-3">
		
			<%@include file="./shared/sidebar.jsp" %>
			
		</div>
		<div class="col-sm-9">
			
				<div class="row">
					<div class="col-lg-12">
						
							
						<c:if test="${userclickallproducts == true}">	
							<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextroot }/home"> Home </a></li>
							<li class="breadcrumb-item active"> All Products</li>	
							</ol>					
						</c:if>
						
						<c:if test="${userclickcategoryproducts == true}">
							<ol class="breadcrumb">	
							<li class="breadcrumb-item"><a href="${contextroot }/home">Home</a></li>
							<li class="breadcrumb-item active"> Category</li>
							<li class="breadcrumb-item active">${category.name }</li>		
							</ol>				
						</c:if>
						
					</div>
				
			</div>
			
		</div>
	</div>
</div>