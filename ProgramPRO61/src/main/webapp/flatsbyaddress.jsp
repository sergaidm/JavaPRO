<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real estate agency</title>
<style>
#shest {
	-moz-appearance: textfield;
}

#shest::-webkit-inner-spin-button {
	display: none;
}
</style>
</head>
<body>
	<form method="post" action="flatsbyaddress">
		<h2 align="center"><b>Input address where you want to see the flats</b></h2>
		<p align="center"><input size="30" name="address" placeholder="Address" type="text" id="shest" required></p>
		<p align="center"><input type="submit" value="Show flats"></p>
	</form>
</body>
</html>