<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container" style="padding-top: 20px">


	<div class="col-8 mx-auto">

		<div class="card card-primary">

			<div class="card-header">
				<h4>Sign up - Personal</h4>
			</div>

			<div class="card-body">

				<sf:form method="POST" modelAttribute="user" id="registerForm">

					<div class="form-group row">

						<label for="firstname" class="col-md-3 col-form-label ">
							First Name</label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="register_name"
								path="firstName" placeholder="Enter First Name" />

						</div>


					</div>


					<div class="form-group row">

						<label for="lastname" class="col-md-3 col-form-label ">
							Last Name</label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="register_lastname"
								path="lastName" placeholder="Enter Last Name" />

						</div>


					</div>



					<div class="form-group row">

						<label for="email" class="col-md-3 col-form-label "> Email</label>
						<div class="col-md-9">
							<sf:input type="email" class="form-control" id="register_email"
								path="email" placeholder="Enter an Email" />

						</div>


					</div>


					<div class="form-group row">

						<label for="contactNumber" class="col-md-3 col-form-label ">
							Contact Number </label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="contactNumber"
								path="contactNumber" placeholder="Enter Contact Number" />

						</div>


					</div>

					<div class="form-group row">

						<label for="password" class="col-md-3 col-form-label ">
							Password </label>
						<div class="col-md-9">
							<sf:input type="password" class="form-control" id="password"
								path="password" placeholder="Enter Password" />

						</div>


					</div>

					<div class="form-group row">

						<label for="password" class="col-md-3 col-form-label ">
							Select Role </label>
						<div class="col-md-9">
							<label class="radio-inline"> <sf:radiobutton path="role"
									value="USER" checked="checked"></sf:radiobutton>User

							</label>&nbsp;&nbsp;&nbsp;&nbsp; <label class="radio-inline"> <sf:radiobutton
									path="role" value="SUPPLIER"></sf:radiobutton>SUPPLIER

							</label>
						</div>


					</div>



					<div class="form-group row">

						<div class="offset-md-3 col-md-9">
							<button type="submit" class="btn btn-primary"
								name="_eventId_billing">Next - Billing</button>
						</div>


					</div>



				</sf:form>

			</div>

		</div>

	</div>


</div>


<%@include file="../shared/flows-footer.jsp"%>