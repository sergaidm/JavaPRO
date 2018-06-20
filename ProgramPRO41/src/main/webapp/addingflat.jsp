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
	<h1 align="center">Set up flat for sale</h1>
	<form method="post" action="adding">	
	<table align="center">
		<tr>
			<th>Input address of new flat</th>
			<td><input maxlength="25" size="30" name="address"
				placeholder="Address" type="text" id="shest" required></td>
		</tr>
		<tr>
			<th>Input number of rooms of new flat</th>
			<td><input maxlength="1" size="30" name="roomsnumber"
				placeholder="Number of rooms" type="number" min="1" step="1" max="6" required></td>
		</tr>
		<tr>
			<th>Input floor of new flat</th>
			<td><input maxlength="2" size="30" name="floor"
				placeholder="Floor" type="number" min="1" step="1" max="99" required></td>
		</tr>
		<tr>
			<th>Input cost of new flat</th>
			<td><input maxlength="25" size="30" name="cost"
				placeholder="Cost" type="number" min="0" step="500" required></td>
		</tr>
		<tr>
			<th>Input currency of new flat</th>
			<td><input maxlength="25" size="30" name="currency"
				placeholder="Currency" type="text" id="shest" required></td>
		</tr>
	</table>	
		<p align="center"><input type="submit" value="Add flat"></p>			
		<p align="center"><input type="reset" value="Clear fields"></p>
		</form>
</body>
</html>