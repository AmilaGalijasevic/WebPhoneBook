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
<link href="css/css/bootstrap.min.css" rel="stylesheet">
<title>Contact List</title>

</head>
<body>

	<div class="jumbotron">
		<div class="nav">
			<div class="container">
				<ul class="pull-left">

					<li><a href="index.jsp">Home</a></li>
					<li><a href="search.jsp">search contacts</a></li>
					<li><a href="addContacts.jsp">add contacts</a></li>

				</ul>
			</div>
		</div>
		<div class="container">
			<h1 style="color: #e1e1d0; text-align: center; font-size: 50px;">CONTACTS</h1>

			<table class="table table-hover" >
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

					<c:forEach items="${contactList}" var="contact" varStatus="counter">
						<tr>
							<td>${counter.count}</td>
							<td>${contactList.name}</td>
							<td>${contactList.lastname}</td>
							<td>${contactList.email}</td>
							<td>${contactList.phone}</td>
							<td>${contactList.city}</td>
							<td><a href="editContactServlet?id=${contactList.contactID}">Edit Contact</a></td>
							<td><a href="deleteServlet?id=${contact.contactId}">Delete
									Contact</a></td>
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
