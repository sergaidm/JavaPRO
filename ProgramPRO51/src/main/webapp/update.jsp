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
	<form method="post" action="updating">
		<h2 align="center">Which entry in database you want to change?</h2>
	<p align="center"><input size="30" name="id" placeholder="Index number" type="number" min="1" required></p>
			<table align="center">			
			<tr>
				<th>Input new address</th>
				<td><input size="30" name="address" placeholder="Address"
					type="text" id="shest" required></td>
			</tr>
			<tr>
				<th>Input new number of rooms</th>
				<td><input maxlength="2" size="30" name="roomsNumber"
					placeholder="Number of rooms" type="number" min="1" required></td>
			</tr>
			<tr>
				<th>Input new floor</th>
				<td><input maxlength="2" size="30" name="floor"
					placeholder="Floor" type="number" min="1" required></td>
			</tr>
			<tr>
				<th>Input new cost</th>
				<td><input size="30" name="cost" placeholder="Cost"
					type="number" min="0" id="shest" required></td>
			</tr>
			<tr>
				<th>Select new currency</th>
				<td><select name="currency">
						<option>$</option>
						<option>€</option>
						<option>₴</option>
				</select></td>
			</tr>
		</table>		
		<p align="center"><input type="submit" value="Update entry"></p>
		<p align="center"><input type="reset" value="Clear fields"></p>
	</form>
</body>
</html>