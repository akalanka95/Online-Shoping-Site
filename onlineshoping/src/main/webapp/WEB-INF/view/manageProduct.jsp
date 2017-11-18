<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="cotainer">

	<div class="row">

		<c:if test="${not empty message}">
			<div class="col-md-12">

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message }
				</div>

			</div>

		</c:if>

		<div class="col-8 mx-auto">

			<div class="card card-primary">

				<div class="card-header">
					<h4>Product Management</h4>
				</div>

				<div class="card-body">

					<sf:form action="${contextroot }/manage/products" method="POST"
						modelAttribute="product" enctype="multipart/form-data">

						<div class="form-group row">

							<label for="name" class="col-md-3 col-form-label ">
								Product Name</label>
							<div class="col-md-9">
								<sf:input type="text" class="form-control" id="name" path="name"
									placeholder="Enter Name" />
								<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>

							</div>


						</div>


						<div class="form-group row">

							<label for="brand" class="col-md-3 col-form-label ">
								Brand Name</label>
							<div class="col-md-9">
								<sf:input type="text" class="form-control" id="brand"
									path="brand" placeholder="Enter Brand" />
								<sf:errors path="brand" cssClass="help-block" element="em"></sf:errors>

							</div>


						</div>


						<div class="form-group row">

							<label for="brand" class="col-md-3 col-form-label ">
								Product Description</label>
							<div class="col-md-9">
								<sf:textarea id="description" path="description"
									placeholder="Enter description" rows="4" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em"></sf:errors>

							</div>


						</div>


						<div class="form-group row">

							<label for="unitprice" class="col-md-3 col-form-label ">
								Enter Unit Price</label>
							<div class="col-md-9">
								<sf:input type="number" class="form-control" id="unitprice"
									path="unit_price" placeholder="Enter Unit Price in &#8377" />
								<sf:errors path="unit_price" cssClass="help-block" element="em"></sf:errors>

							</div>


						</div>


						<div class="form-group row">

							<label for="quantity" class="col-md-3 col-form-label ">
								Quantity Available </label>
							<div class="col-md-9">
								<sf:input type="number" class="form-control" id="quantity"
									path="quantity" placeholder="EnterQuantity Available" />
								<sf:errors path="quantity" cssClass="help-block" element="em"></sf:errors>

							</div>


						</div>

						<!-- File element for image -->
						<div class="form-group row">

							<label for="file" class="col-md-3 col-form-label ">
								Select an Image </label>
							<div class="col-md-9">
								<sf:input type="file" class="form-control" id="file" path="file" />
								<sf:errors path="file" cssClass="help-block" element="em"></sf:errors>

							</div>


						</div>


						<div class="form-group row">

							<label for="categoryId" class="col-md-3 col-form-label ">
								Select Category </label>
							<div class="col-md-9">
								<sf:select class="form-control" id="categoryId"
									path="category_id" items="${categories}" itemLabel="name"
									itemValue="id" />
									
									<div class="text-right">
									<c:if test="${product.id == 0}">
										<br/>
										
										<buton type="button" data-toggle="modal" data-target="#mycategoryModel" class="btn btn-warning btn-xs">Add Category</buton>
									</c:if>
									</div>
							</div>


						</div>

						<!--  <div class="form-group row">

							<label for="supplier" class="col-md-3 col-form-label ">
								Supplier </label>
							<div class="col-md-9">
									
									<sf:input type="number" class="form-control" id="supplierId"
									path="supplier_id" placeholder="EnterSupplier Available" />
							</div>


						</div>
-->


						<div class="form-group row">

							<div class="offset-md-3 col-md-9">
								<input type="submit" class="btn btn-primary" id="submit"
									name="submit" value="Sumbit">
								<sf:hidden path="id"></sf:hidden>
								<sf:hidden path="code"></sf:hidden>
								<sf:hidden path="is_active"></sf:hidden>
								<sf:hidden path="supplier_id"></sf:hidden>
								<sf:hidden path="purchases"></sf:hidden>
								<sf:hidden path="views"></sf:hidden>
							</div>


						</div>



					</sf:form>

				</div>

			</div>

		</div>
	</div>

	<div class="row">

		<div class="col-12 mx-auto">
			<div class="col-xs-12">
				<h3>Available Products</h3>
			</div>
		
	
			<div class="col-xs-12">
				<div style="overflow: auto">

					<table id="adminProductsTable"
						class="table table-stripped table-bordered">


						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>

						<!-- <tbody>

							<tr>

								<td>1</td>
								<td><img class="adminDataTableImage"
									src="${contextroot }/resources/images/PDX123456.jpg"
									alt="laptop"></td>
								<td>Drum2</td>
								<td>Yamaha</td>
								<td>0</td>
								<td>&#8377; 54000.00/-</td>
								<td class="positioning">
									 <label class="switch">
					    				 <input type="checkbox" checked="checked" value="4"/> 
					    				 <div class="slider"></div>
										</label>
								</td>
								<td><a href="${contextroot }/manage/4/products"
									class="btn btn-warning"><i class="fa fa-pencil-square-o"
										aria-hidden="true"></i> </a></td>

							</tr>


						</tbody> -->


						<tfoot>

							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</tfoot>


					</table>


				</div>



			</div>



		</div>

	</div>
	
<div class="modal fade" id="mycategoryModel" role="dialog" tabindex="-1">
  <div class="modal-dialog" role="document">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Add New Category</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      	<div class="modal-body">
      		
      		<sf:form modelAttribute="category" 
      		action="${contextroot }/manage/category" 
      		method="POST" id="categoryForm">
      		
      			<div class="form-group row">

							<label for="name" class="col-md-4 col-form-label ">
								Category Name</label>
							<div class="col-md-8">
								<sf:input type="text" class="form-control" id="category_name" path="name"
									placeholder="Enter Category Name" />
								<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>

							</div>


						</div>
						
							<div class="form-group row">

							<label for="description" class="col-md-4 col-form-label ">
								Category Description</label>
							<div class="col-md-8">
								<sf:textarea type="text" class="form-control" id="category_description" path="description"
									placeholder="Enter Category Description" rows="5" />
								<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>

							</div>


						</div>
						
      		<div class="form-group row">
      		
      		
      		<div class="offset-md-4 col-md-8">
								<input type="submit" class="btn btn-primary"
									id="category_submit" name="submit" value="Add Category">
							</div>
      		</div>
      		</sf:form>
      		</div>
      	</div>
      
      </div>
      </div>
      </div>
      
	
	
	
	
