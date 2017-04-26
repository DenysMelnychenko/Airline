<!DOCTYPE html>

<%@page import="com.airlineweb.models.Plane"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>dashboard</title>
</head>
<body>
	<ul class="links">
		<li><a href="home">Home</a></li>
		<li><a href="add">Add</a></li>
		<li><a href="dashboard">Dashboard</a></li>
	</ul>

	<form class="search_form" action="find" method="POST">
		<input type="text" name="search"> <input type="submit"
			value="Search">
	</form>

	<div>
		<%
			if (request.getAttribute("Is empty") != null) {
				String message = (String) request.getAttribute("Is empty");
		%>
		<p class="error"><%= message%></p>
		<%
			} else
		%>
		<%
			if (request.getAttribute("Not found") != null) {
				String message = (String) request.getAttribute("Not found");
		%>

		<p class="error"><%= message%></p>
		<%
			} else
		%>

		<%
			if (request.getAttribute("success") != null) {
				String message = (String) request.getAttribute("success");
		%>
		<%
			if (message.equals("success"))
		%>
		<p class="success">SUCCESSFULLY DELETED</p>
		<%
			}
		%>
	</div>


	<div class="output">
		<table>
			<tr>
				<th>ID Number</th>
				<th>Model</th>
				<th>Capacity</th>
				<th>Build date</th>
				<th></th>
			</tr>
			<%
				if (request.getAttribute("planes") != null) {

					Map<Integer, Plane> planes = (Map<Integer, Plane>) request.getAttribute("planes");

					for (Map.Entry<Integer, Plane> plane : planes.entrySet()) {
			%>
			<tr>
				<td><%=plane.getKey()%></td>
				<td><%=plane.getValue().getName()%></td>
				<td><%=plane.getValue().getCapacity()%></td>
				<td><%=plane.getValue().getBuiltDate()%></td>
				<td><form action="remove" method="post">
						<input value="<%=plane.getValue().getName()%>" name="model"
							style="display: none" /> <input
							value="<%=plane.getValue().getCapacity()%>" name="capacity"
							style="display: none" />
						<button type="submit" name="delete">Delete</button>
					</form></td>
			</tr>
			<%
				}
			%>
			<%
				}
			%>

		</table>
	</div>


</body>
</html>
