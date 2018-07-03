<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real estate agency</title>
</head>
<body>
		<form method="post" action="flatbyid">
		<h2 align="center"><b>Input the flat index number about which you want to receive information</b></h2><br>
			<table align="center">			
				<tr>
					<th>Input index number</th>
					<td><input size="30" name="id" placeholder="Index number" type="number" min="1" required></td>
				</tr>					
			</table>
		<p align="center"><input type="submit" value="Show flats"></p>
	</form>
</body>
</html>