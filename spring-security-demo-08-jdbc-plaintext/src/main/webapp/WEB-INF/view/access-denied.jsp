<html>

<head>

	<title>Access Denied</title>
	
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

	<style>
		.error-template {padding: 40px 15px;text-align: center;}
		.error-actions {margin-top:15px;margin-bottom:15px;}
		.error-actions .btn { margin-right:10px; }
	</style>
</head>

<body>

	<div class="container">
	    <div class="row">
	        <div class="col-md-12">
	            <div class="error-template">
	                <h1>
	                    Oops!</h1>
	                <h2>
	                    Access Denied</h2>
	                <div class="error-details">
	                    You are not authorized to access this resource.
	                </div>
	                <div class="error-actions">
	                    <a href="${ pageContext.request.contextPath }/" 
	                    	class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
	                        Take Me Home </a>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>

</body>

</html>