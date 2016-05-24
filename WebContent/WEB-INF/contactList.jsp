<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="mobile-web-app-capable" content="yes">
<link rel="stylesheet" href="css/css/register.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Contacts</title>

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
			<h1 style="color: #e1e1d0; text-align: center; font-size: 50px;">EDIT
				CONTACTS</h1>
			<br>
<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Edit</th>
					<th>Delete</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach items="${contacts}" var="contact" varStatus="counter">
					<tr>
						<td>${counter.count}</td>
						<td>${contact.name}</td>
						<td>${contact.lastname}</td>
						<td>${contact.email}</td>
						<td>${contact.phone}</td>
						<td><a href="edit?id=${contact.contactId}">Edit Contact</a></td>
						<td><a href="delete?id=${contact.contactId}">Delete Contact</a></td>
						<td></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>


			
		</div>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
