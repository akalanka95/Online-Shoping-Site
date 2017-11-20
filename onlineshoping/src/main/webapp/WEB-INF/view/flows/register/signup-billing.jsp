<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>
				<div class="container" style="padding-top : 20px">
				
					<div class="col-8 mx-auto">

		<div class="card card-primary">

			<div class="card-header">
				<h4>Sign up - Address</h4>
			</div>

			<div class="card-body">

				<sf:form method="POST" modelAttribute="billing" id="billingForm">

					<div class="form-group row">

						<label for="address1" class="col-md-3 col-form-label ">
							Address Line One</label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="address"
								path="addressLineOne" placeholder="Enter Address Line One " />
							<sf:errors path="addressLineOne" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>


					<div class="form-group row">

						<label for="address2" class="col-md-3 col-form-label ">
							Address Line Two</label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="address2"
								path="addressLineTwo" placeholder="Enter Address Line Two" />
							<sf:errors path="addressLineTwo" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>



					<div class="form-group row">

						<label for="city" class="col-md-3 col-form-label "> City</label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="city"
								path="city" placeholder="Enter City" />
							<sf:errors path="city" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>


					<div class="form-group row">

						<label for="state" class="col-md-3 col-form-label ">
							State </label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="state"
								path="state" placeholder="Enter State" />
							<sf:errors path="state" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>

					<div class="form-group row">

						<label for="country" class="col-md-3 col-form-label ">
							Country </label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="country"
								path="country" placeholder="Enter Country" />
							<sf:errors path="country" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>

					<div class="form-group row">

						<label for="postalCode" class="col-md-3 col-form-label ">
							Postal Code </label>
						<div class="col-md-9">
							<sf:input type="text" class="form-control" id="postalCode"
								path="postalCode" placeholder="Enter Postal Code" />
							<sf:errors path="postalCode" cssClass="help-block" element="em"></sf:errors>
							
						</div>


					</div>




					<div class="form-group row">

						<div class="offset-md-3 col-md-9">
							<button type="submit" class="btn btn-primary"
								name="_eventId_personal"> Previous - Personal</button>
								
								&nbsp; &nbsp; &nbsp; &nbsp;
								
								<button type="submit" class="btn btn-primary"
								name="_eventId_confirm">Next - Confirm</button>
						</div>
						


					</div>



				</sf:form>

			</div>

		</div>

	</div>

					
					
					
					
				
				</div>			

		

		<%@include file="../shared/flows-footer.jsp" %>
		