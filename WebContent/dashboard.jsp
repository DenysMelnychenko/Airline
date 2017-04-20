<!DOCTYPE html>
<%@page import="com.airlineweb.repository.ProductStorage"%>
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
		<li><a href="find">Dashboard</a></li>
	</ul>
	<form class="search_form" action="find" method="post">
		<input type="text"> <input type="submit" value="Search">
	</form>
	<div class="output">
		<table>
			<tr>
				<th>Number</th>
				<th>Model</th>
				<th>Capacity</th>
				<th>Build date</th>
				<th></th>
			</tr>
			
			<% ProductStorage storage = ProductStorage.getInstance();%>
				<% Map<Integer, Plane> planes = storage.getAll();%>
				<%for(Map.Entry<Integer, Plane> plane : planes.entrySet()) { %>
			<tr>
				<td><%plane.getKey(); %></td>
				<td><%plane.getValue().getName(); %></td>
				<td><%plane.getValue().getCapacity(); %></td>
				<td><%plane.getValue().getBuiltDate(); %></td>
				<td><button>delete</button></td>
			</tr>
			 <%
                }
            %>
			
		</table>
	</div>

</body>
</html>
