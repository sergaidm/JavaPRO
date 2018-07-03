<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flats database</title>
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
	<form method="post" action="adding">
		<h2 align="center">Adding of flat to database for sale</h2>
		<table align="center">
			<tr>
				<th>Input address of new flat</th>
				<td><input size="30" name="address" placeholder="Address"
					type="text" id="shest" required></td>
			</tr>
			<tr>
				<th>Input number of rooms of new flat</th>
				<td><input size="30" name="roomsNumber"
					placeholder="Number of rooms" type="number" min="1" max="50" required></td>
			</tr>
			<tr>
				<th>Input floor of new flat</th>
				<td><input size="30" name="floor"
					placeholder="Floor" type="number" min="1" max="99" required></td>
			</tr>
			<tr>
				<th>Input cost of new flat</th>
				<td><input size="30" name="cost" placeholder="Cost"
					type="number" min="0" id="shest" required></td>
			</tr>
			<tr>
				<th>Select currency of new flat</th>
				<td><select name="currency">
						<option>$</option>
						<option>€</option>
						<option>₴</option>
				</select></td>
			</tr>
		</table>		
		<p align="center"><input type="submit" value="Add new flat"></p>
		<p align="center"><input type="reset" value="Clear fields"></p>
	</form>
</body>
</html>