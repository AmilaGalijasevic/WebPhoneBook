<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete contact</title>
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
			<h1 style="color: #e1e1d0; text-align: center; font-size: 50px;">DELETE
				CONTACT</h1>
			<br>
		<p>Are you sure you want to delete ${contactList.name}
			${contactList.lastname}?</p>


		<form class="form-horizontal" action="delete" method="post">

			<input type="hidden" class="form-control" id="name" name="name"
				value="${contactList.name }" /> <input type="hidden"
				class="form-control" id="lastname" name="lastname"
				value="${contactList.lastname}"> <input type="hidden"
				class="form-control" id="email" name="email"
				value="${contactList.email}"> <input type="hidden"
				class="form-control" id="phone" name="phone"
				value="${contactList.phone}">
				 <input type="hidden"
				class="form-control" id="city" name="city"
				value="${contactList.city}">
				 <input type="hidden" name="id"
				value="${contactList.contactId}">

					<input type="submit" class="btn btn-primary" value="Delete Contact">
						
		</form>
		
</div>
</div>

</body>
</html>