<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
	<ul class="links">
		<li><a href="home">Home</a></li>
		<li><a href="add">Add</a></li>
		<li><a href="dashboard">Dashboard</a></li>
	</ul>

<h3>Registration</h3>

	<div class="parent">
		<form class="registration-form" action="registration" method="post">
			Email: <br> <input type="text" name="email"><br>
			<c:out value="${emailValidationError }"></c:out>
			Password:<br> <input type="password" name="password"><br>
			Repeat password:<br> <input type="password" name="repeatPassword"><br>
			<input type="submit" value="Register">
		</form>
	</div>

</body>
</html>