<div class="container">
	
	<div class="row">
		
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="${contextroot }/home">
					Home </a></li>
			<li class="breadcrumb-item active"><a href="${contextroot }/show/all/products">Products</a></li>
			<li class="breadcrumb-item active">${product.name}</li>
		</ol>
	
	</div>
	
	<div class="row">
		<div class="col-xs-12 col-sm-4 ">
			<div class="thumbnail">
					<img src="${images }/${product.code}.jpg" class="img img-responsive">
				</div>
		</div>
		<div class="col-xs-12 col-sm-8">
		<h3>${product.name}</h3>
				<hr>
				<p>${product.description }</p>
				<hr>
				<h4>Price : <strong>&#8377; ${product.unit_price } /-</strong></h4>
				<hr>
				<h6>Qt Ava : <strong>${product.quantity }</strong></h6>
				<hr>
				<a href="${contextroot }/cart/add/${product.id }/products" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true">&nbsp;Add to Cart</i></a>
				&nbsp;<a href="${contextroot }/show/all/products" class="btn btn-success">Back</a>
			
		</div>
	
	</div>
	
	</div>























