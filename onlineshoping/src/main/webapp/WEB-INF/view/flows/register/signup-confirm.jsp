<%@include file="../shared/flows-header.jsp" %>
<div class="container" style="padding-top: 20px">

<div class="row">
	<div class="col-xs-12 col-md-6">

		<div class="card card-primary">

			<div class="card-header">
				<h4>Personal Details</h4>
			</div>

			<div class="card-body"></div>
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

			<div class="card-body"></div>
			
			<div class="card-footer">
				<a href="${flowExecutionUrl }&_eventId_billing" class="btn btn-primary">Edit</a>
			
			</div>
			

		</div>
	</div>
	</div>
	
	<div class="row">
		<div class="offset-md-4 col-md-4">
			<div class="text-center">
			
			<a href="${flowExecutionUrl }&_eventId_success" class="btn btn-primary">Confirm</a>
			
			</div>
		
		</div>
	
	</div>
	
	
</div>

<%@include file="../shared/flows-footer.jsp" %>