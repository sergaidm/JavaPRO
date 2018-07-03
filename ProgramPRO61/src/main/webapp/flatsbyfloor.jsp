<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real estate agency</title>
</head>
<body>
		<form method="post" action="flatsbyfloor">
		<h2 align="center"><b>Input floor number for which you want to see the flats</b></h2><br>
			<table align="center">			
				<tr>
					<th>Input floor number</th>
					<td><input maxlength="25" size="30" name="floor"
					placeholder="Floor number" type="number" min="1" max="99" required></td>
				</tr>					
			</table>
		<p align="center"><input type="submit" value="Show flats"></p>
	</form>
</body>
</html>