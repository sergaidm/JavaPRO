<%@ page import="ru.yandex.sergaidm.FlatsList"%>
<%@ page import="ru.yandex.sergaidm.Flat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real estate agency</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>№</th>
			<th>Address</th>
			<th>Number of rooms</th>
			<th>Floor</th>
			<th>Price</th>
		</tr>
		<%
			FlatsList flats = (FlatsList) session.getAttribute("flats");
			int number = 0;
			for (Flat flat : flats) {
		%>
		<tr>
			<td align="center"><%=++number%></td>
			<td align="center"><%=flat.getAddress()%></td>
			<td align="center"><%=flat.getRoomsNumber()%></td>
			<td align="center"><%=flat.getFloor()%></td>
			<td align="center"><%=flat.getPrice()%></td>
		</tr>
		<%
			}
		%>
	</table><br>
	<form method="post" action="sale">
		<p align="center">What flat from list do you want to sell?</p>
		<p align="center"><input maxlength="10" size="30" name="number" placeholder="Flat number" type="number" min="1" step="1" required></p>
		<p align="center"><input type="submit" value="Sale flat"></p>
	</form>
</body>
</html>