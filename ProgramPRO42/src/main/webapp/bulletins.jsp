<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored ="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bulletin board</title>
</head>
<body>
	<c:if test="${empty bulletins}">
		<h2 align="center">At this moment there are no bulletins on the bulletin board</h2>
	</c:if>
	<table border="1" align="center" width="100%">
		<caption>
			<b>Bulletin board</b>
		</caption>
		<tr>
			<th>Creator</th>
			<th>Bulletin</th>
		</tr>
		<c:forEach items="${bulletins}" var="bulletin">
			<tr>
				<td width="25%"><c:out value="${bulletin.getCreator()}"></c:out></td>
				<td width="75%"><c:out value="${bulletin.getText()}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
		<p align="center"><a href="index.jsp">Go to home page</a></p> 
</body>
</html>