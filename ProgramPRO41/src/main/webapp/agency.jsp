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
	<form method="post" action="execute">
		<table align="center">
			<tr><td><input name="method" type="radio" value="addFlat">Set up flat for sale</td></tr>
			<tr><td><input name="method" type="radio" value="saleFlat">Sell flat</td></tr>
			<tr><td><input name="method" type="radio" value="setPrice">Change price of flat</td></tr>
			<tr><td><input name="method" type="radio" value="flatsByPrice">Find flats by the price range</td></tr>
			<tr><td><input name="method" type="radio" value="flatsByRoomsNumber">Find flats by the number of rooms</td></tr>
		</table>	
			<p align="center"><input type="submit" value="Execute action" /></p>
	</form>
	<form method="post" action="index.jsp">
		<p align="center"><input type="submit" value="Select another file" /></p>
	</form>
</body>
</html>