<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
	<ul class="links">
		<li><a href="home">Home</a></li>
		<li><a href="add">Add</a></li>
		<li><a href="dashboard">Dashboard</a></li>
		<li><a href ="login">Login</a></li>
	</ul>

	<h3>Add product</h3>

	<div class="parent">
		<form class="add-form" action="add" method="post">
			Model: <br> <input type="text" name="model"><br>
			Capacity:<br> <input type="text" name="capacity"><br>
			Build date:<br> <input type="date" name="date"><br>
			<input type="submit" value="Add">
		</form>
	</div>
	<div>
		<p class="error">
			<c:out value="${wronginput}" />
		</p>
		<p class="success">
			<c:out value="${added}" />
		</p>
		
	</div>


</body>
</html>
