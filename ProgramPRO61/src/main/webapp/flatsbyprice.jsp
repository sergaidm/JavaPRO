<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real estate agency</title>
</head>
<body>
	<form method="post" action="flatsbyprice">
		<h2 align="center"><b>Set the price range in which you need to see the flats</b></h2><br>
			<table align="center">			
				<tr>
					<th>Input the start price value</th>
					<td><input maxlength="25" size="30" name="begin"
					placeholder="Starting price" type="number" min="0" required></td>
				</tr>	
				<tr>
					<th>Input the final price value</th>
					<td><input maxlength="25" size="30" name="end"
					placeholder="Final price" type="number" min="0" required></td>
				</tr>	
				<tr>
				<th>Select currency</th>
				<td><select name="currency">
						<option>$</option>
						<option>€</option>
						<option>₴</option>
					</select>
				</td>
				</tr>					
				</table>
		<p align="center"><input type="submit" value="Show flats"></p>
	</form>
</body>
</html>