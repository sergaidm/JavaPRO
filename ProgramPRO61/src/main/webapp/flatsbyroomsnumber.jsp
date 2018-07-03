<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real estate agency</title>
</head>
<body>
		<form method="post" action="flatsbyrooms">
		<h2 align="center"><b>Input number of rooms for which you want to see the flats</b></h2><br>
			<table align="center">			
				<tr>
					<th>Input number of rooms</th>
					<td><input maxlength="25" size="30" name="rooms"
					placeholder="Number of rooms" type="number" min="1" max="50" required></td>
				</tr>					
			</table>
		<p align="center"><input type="submit" value="Show flats"></p>
	</form>
</body>
</html>