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

<title>Add Contacts to Web Phone Book</title>

<link rel="stylesheet" href="css/css/register.css">
<link href="css/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


	<div class="jumbotron">
		<div class="nav">
			<div class="container">
				<ul class="pull-left">

					<li><a href="index.jsp">Home</a></li>
					<li><a href="search.jsp">Search contacts</a></li>
					<li><a href="contactList.jsp">List contacts</a></li>

				</ul>
			</div>
		</div>
		<div class="container">
			<h1 style="color: #e1e1d0; text-align: center; font-size: 50px;">ADD
				CONTACTS</h1>
			

			<div class="container" align="pull-left">

				<form class="form-signin" style="text-align: left" id ="addContacts" action="AddContactsServlet" method="post" >

					<div class="form-group" style="text-align: right">
						<label for="name" class="sr-only">Name </label> <input type="text"
							id="name" name = "name" class="form-control" placeholder="Name" required
							autofocus> <br>
						 <label for="lastname" class="sr-only">Last name </label> <input type="text"
							id="lastname" name = "lastname" class="form-control" placeholder="Last name"
							required> <br> 
						<label for="email" class="sr-only">Email address </label> <input type="email"
							id="email" name= "email" class="form-control" placeholder="Email address"
							required autofocus> <br> 
						<label for="phone" class="sr-only">Phone</label> <input type="text" id="phone"
							name= "phone" class="form-control" placeholder="Phone" required autofocus><br> 
						<label for="city" class="sr-only">City </label> <input
							type="text" id="city" name = "city" class="form-control" placeholder="City"
							required autofocus> <br>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Add
							contact</button>
					</div>
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
