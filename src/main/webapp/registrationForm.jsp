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
		<li><a href ="login">Login</a></li>
	</ul>

	<h3>Registration</h3>

	<div class="parent">
		<form class="registration-form" action="registration" method="post">
			<span>Email:</span> <input type="text" name="email" placeholder="Your email">
			<c:if test="${not empty emailValidationError}">
				<div class="error">
					<c:out value="${emailValidationError }"></c:out>
				</div>
			</c:if>
			<span>Password:</span> <input type="password" name="password">
			<c:if test="${not empty passwordToShort}">
				<div class="error">
					<c:out value="${passwordToShort }"></c:out>
				</div>
			</c:if>
			<c:if test="${not empty passwordToLong}">
				<div class="error">
					<c:out value="${passwordToLong }"></c:out>
				</div>
			</c:if>
			<span>Repeat password:</span> <input type="password" name="repeatPassword">
			<c:if test="${not empty repeatPasswordToShort}">
				<div class="error">
					<c:out value="${repeatPasswordToShort }"></c:out>
				</div>
			</c:if>
			<c:if test="${not empty repeatPasswordToLong}">
				<div class="error">
					<c:out value="${repeatPasswordToLong }"></c:out>
				</div>
			</c:if>
			<c:if test="${not empty passwordsMismatch}">
				<div class="error">
					<c:out value="${passwordsMismatch }"></c:out>
				</div>
			</c:if>
			<input type="submit" value="Register">
		</form>
	</div>

</body>
</html>
