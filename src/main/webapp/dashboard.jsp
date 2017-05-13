<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<p class="error">
			<c:out value="${isempty}" />
		</p>
		<p class="error">
			<c:out value="${notfound}" />
		</p>
		<p class="success">
			<c:out value="${deleted}" />
		</p>
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
			<c:if test="${not empty planes}">
				<c:forEach var="plane" items="${planes}">
					<tr>
						<td>${plane.getKey()}</td>
						<td>${plane.name}</td>
						<td>${plane.capacity}</td>
						<td>${plane.buitDate}</td>
						<td><form action="remove" method="post">
								<input value="${plane.name}" name="model"
									style="display: none" /> <input
									value="${plane.capacity}" name="capacity"
									style="display: none" />
								<button type="submit" name="delete">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>


</body>
</html>
