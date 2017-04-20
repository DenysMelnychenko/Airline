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
		<li><a href="find">Dashboard</a></li>
	</ul>

	<h3>Add product</h3>

	<div class="parent">
		<form class="add-form" action="add" method="post">
			Model: <br> <input type="text" name="model"><br>
			Capacity:<br> <input type="text" name="capacity"><br>
			Build date:<br> <input type="text" name="date"><br>
			<input type="submit" value="Add">
		</form>
	</div>
	<div>
		<%
			String message = "";
		%>
		<%
			if (request.getAttribute("successfully") != null) {
				message = (String) request.getAttribute("successfully");
		%>
		<%
			if (message.equals("successfully"))
		%>
		<p class="success">SUCCESSFULLY</p>
		<%
			} else if (request.getAttribute("error") != null) {
				message = (String) request.getAttribute("error");
		%>
		<%
			if (message.equals("error"))
		%>
		<p class="error">SOMETHING WENT WRONG! CHECK YOUR INPUT PLEASE!</p>
		<%
			}
		%>
	</div>


</body>
</html>
