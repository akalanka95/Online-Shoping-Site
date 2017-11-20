
<%@include file="../shared/flows-header.jsp" %>
<div class="container" style="padding-top: 20px">

<div class="row">
	<div class="col-xs-12 col-md-6">

		<div class="card card-primary">

			<div class="card-header">
				<h4>Personal Details</h4>
			</div>

			<div class="card-body">
			
			
				<div class="text-center">
				
					<h4>${registerModel.user.firstName } ${registerModel.user.lastName }</h4>
				
					<h5>${registerModel.user.email }</h5>
					<h5>${registerModel.user.contactNumber }</h5>
					<h5>${registerModel.user.role }</h5>
				</div>
			
			
			
			
			
			</div>
			<div class="card-footer">
				<a href="${flowExecutionUrl }&_eventId_personal" class="btn btn-primary">Edit</a>
			
			</div>

		</div>
	</div>
	
	<div class="col-xs-12 col-md-6">

		<div class="card card-primary">

			<div class="card-header">
				<h4>Billing Details</h4>
			</div>

			<div class="card-body">
			
			<div class="text-center">
				
					<h4>${registerModel.billing.addressLineOne }</h4>
				<h4>${registerModel.billing.addressLineTwo }</h4>
					<h5>${registerModel.billing.city } - ${registerModel.billing.postalCode } </h5>
					<h5>${registerModel.billing.state } - ${registerModel.billing.country} </h5>
					
				</div>
			
			
			</div>
			
			<div class="card-footer">
				<a href="${flowExecutionUrl }&_eventId_billing" class="btn btn-primary">Edit</a>
			
			</div>
			

		</div>
	</div>
	</div>
	
	<div class="row">
		<div class="offset-md-4 col-md-4">
			<div class="text-center">
			<br><br><br>
			<a href="${flowExecutionUrl }&_eventId_submit" class="btn btn-primary">Confirm</a>
			
			</div>
		
		</div>
	
	</div>
	
	
</div>

<%@include file="../shared/flows-footer.jsp" %>