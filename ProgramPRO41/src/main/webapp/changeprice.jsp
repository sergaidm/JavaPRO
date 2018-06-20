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
	<form method="post" action="changeprice">
		<p align="center">Which flat from the list need to change the price?</p>
		<p align="center"><input maxlength="10" size="30" name="number" placeholder="Flat number" type="number" min="1" step="1" required></p>
			<table align="center">
				<tr>
					<th>Input the new cost of the flat</th>
					<td><input maxlength="25" size="30" name="cost"
					placeholder="Cost" type="number" min="0" step="500" required></td>
				</tr>	
				<tr>
					<th>Input the new currency of the flat</th>
					<td><input maxlength="25" size="30" name="currency"
					placeholder="Currency" type="text" required></td>
				</tr>		
				</table>
		<p align="center"><input type="submit" value="Change price"></p>
	</form>
</body>
</html>