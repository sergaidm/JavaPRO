<%@page import="java.io.File"%>
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
	<br>
	<p align="center"><b>
		<% 
			String information = (String)session.getAttribute("information");
			out.println(information);
		%>
	</b></p>
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
			File file = new File(System.getProperty("user.dir")+"\\List of flats.xml");
			flats.saveToXMLFile(file);
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
	</table>	
	<form method="post" action="agency.jsp">
		<p align="center"><input type="submit" value="Select another method"/></p>
	</form>
</body>
</html>