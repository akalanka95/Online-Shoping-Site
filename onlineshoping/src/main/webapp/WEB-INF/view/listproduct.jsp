<div class="container">
	<div class="row">
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>
		<div class="col-md-9">

			<div class="row">
				<div class="col-sm-12">


					<c:if test="${userclickallproducts == true}">

						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextroot }/home">
									Home </a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userclickcategoryproducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextroot }/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name }</li>
						</ol>
					</c:if>

				</div>
			</div>


			<div class="row">
				<div class="col-sm-12">

					<table id="productListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
						 	    <th ></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Ava</th>
								<th></th>
							</tr>
						</thead>
						<tfooter>
								<tr>
								<th ></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Ava</th>
								<th></th>
							</tr>
						</tfooter>

					</table>
				</div>
			</div>

		</div>




	</div>
</div>
