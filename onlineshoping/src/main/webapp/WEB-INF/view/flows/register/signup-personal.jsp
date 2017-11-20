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
							<sf:errors path="firstName" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>


					<div class="form-group row">

						<label for="lastname" class="col-md-3 col-form-label ">
							Last Name</label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="register_lastname"
								path="lastName" placeholder="Enter Last Name" />
							<sf:errors path="lastName" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>



					<div class="form-group row">

						<label for="email" class="col-md-3 col-form-label "> Email</label>
						<div class="col-md-9">
							<sf:input type="email" class="form-control" id="register_email"
								path="email" placeholder="Enter an Email" />
							<sf:errors path="email" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>


					<div class="form-group row">

						<label for="contactNumber" class="col-md-3 col-form-label ">
							Contact Number </label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="contactNumber"
								path="contactNumber" placeholder="Enter Contact Number" />
							<sf:errors path="contactNumber" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>

					<div class="form-group row">

						<label for="password" class="col-md-3 col-form-label ">
							Password </label>
						<div class="col-md-9">
							<sf:input type="password" class="form-control" id="password"
								path="password" placeholder="Enter Password" />
							<sf:errors path="password" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>
					
					<div class="form-group row">

						<label for="conpassword" class="col-md-3 col-form-label ">
							Confirm Password </label>
						<div class="col-md-9">
							<sf:input type="password" class="form-control" id="conpassword"
								path="confirmPassword" placeholder="Confirm Password" />
							<sf:errors path="confirmPassword" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>

					<div class="form-group row">

						<label for="password" class="col-md-3 col-form-label ">
							Select Role </label>
						<div class="col-md-9">
							<label class="radio-inline"> <sf:radiobutton path="role"
									value="USER" checked="checked"></sf:radiobutton>&nbsp;User

							</label>&nbsp;&nbsp;&nbsp;&nbsp; <label class="radio-inline"> <sf:radiobutton
									path="role" value="SUPPLIER"></sf:radiobutton>&nbsp;SUPPLIER

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