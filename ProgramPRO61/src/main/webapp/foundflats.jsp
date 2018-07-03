<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real estate agency</title>
</head>
<body>
	<h2 align="center"><c:out value="${information}"/></h2>
	<table border="1" align="center" width="100%">
		<caption>
			<b>Flats database</b>
		</caption>
		<tr>
			<th>ID</th>
			<th>Address</th>
			<th>Number of rooms</th>
			<th>Floor</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${foundFlats}" var="flat">
			<tr>
				<td width="10%"><c:out value="${flat.getId()}"></c:out></td>
				<td width="55%"><c:out value="${flat.getAddress()}"></c:out></td>
				<td width="10%" align="center"><c:out value="${flat.getRoomsNumber()}"></c:out></td>
				<td width="10%" align="center"><c:out value="${flat.getFloor()}"></c:out></td>
				<td width="15%" align="center"><c:out value="${flat.getPrice()}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
		<p align="center"><a href="index.jsp">Go to home page</a></p> 
</body>
</html>