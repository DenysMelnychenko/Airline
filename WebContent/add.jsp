<!DOCTYPE html>
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
		<%
			String message = "";
		%>
		<%
			if (request.getAttribute("added") != null) {
				message = (String) request.getAttribute("added");
		%>

		<p class="success"><%=message%></p>
		<%
			} else if (request.getAttribute("wrong input") != null) {
				message = (String) request.getAttribute("wrong input");
		%>

		<p class="error"><%=message %></p>
		<%
			}
		%>
	</div>


</body>
</html>
