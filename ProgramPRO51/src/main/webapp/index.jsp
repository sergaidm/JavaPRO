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
	<h1 align="center">Real estate agency</h1>
	<form method="get" action="start">
			<p align="center"><input type="submit" value="View flats database"/></p>
	</form>
	<form method="post" action="addflat.jsp">
		<p align="center"><input type="submit" value="Set up new flat for sale"></p>
	</form>
	<form method="post" action="update.jsp">
		<p align="center"><input type="submit" value="Change entry in database"></p>
	</form>
	<form method="post" action="delete.jsp">
		<p align="center"><input type="submit" value="Sell flat"></p>
	</form>
	<form method="post" action="flatsbyaddress.jsp">
		<p align="center"><input type="submit" value="Find flats by address"></p>
	</form>
	<form method="post" action="flatsbyprice.jsp">
		<p align="center"><input type="submit" value="Find flats by price range"></p>
	</form>	
	<form method="post" action="flatbyid.jsp">
		<p align="center"><input type="submit" value="Find flat by ID"></p>
	</form>
	<form method="post" action="flatsbyroomsnumber.jsp">
		<p align="center"><input type="submit" value="Find flats by number of rooms"></p>
	</form>
	
	<form method="post" action="flatsbyfloor.jsp">
		<p align="center"><input type="submit" value="Find flats by floor"></p>
	</form>	
</body>
</html>