<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="mobile-web-app-capable" content="yes">

<link rel="stylesheet" href="css/css/register.css">
<link href="css/css/bootstrap.min.css" rel="stylesheet">
<title>Search Web Phone Book</title>

</head>
<body>


	<div class="jumbotron">
		<div class="nav">
			<div class="container">
				<ul class="pull-left">

					<li><a href="index.jsp">Home</a></li>
					<li><a href="addContacts.jsp">Add contacts</a></li>
					<li><a href="contactList.jsp">List Contacts</a></li>

				</ul>
			</div>
		</div>
		<div class="container">
			<h1 style="color: #e1e1d0; text-align: center; font-size: 50px;">SEARCH</h1>
			<br></br>

			<div class="container">
					
				<form class="form-signin" action="SearchServlet" method="get" >
					<h2 class="form-signin-heading"></h2>
					<label for="inputEmail" class="sr-only">Search contacts</label> <input
						type="text" id="name" name ="name" class="form-control"
						placeholder="Enter name" required autofocus>
<br>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
				</form>

			</div>
			<!-- /container -->


		</div>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>