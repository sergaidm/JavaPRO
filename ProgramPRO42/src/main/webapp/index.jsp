<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bulletin board</title>
</head>
<body>
	<h1 align="center">Bulletin board</h1>
	<form method="post" action="addbulletin.jsp">
		<p align="center"><input type="submit" value="Give new bulletin"></p>
	</form>
	<form method="post" action="bulletins.jsp">
			<p align="center"><input type="submit" value="View bulletin board"/></p>
	</form>
</body>
</html>