<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bulletin board</title>
<style>
textarea {
	width: 100%;
}

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
		<h2 align="center">Adding of bulletin</h2>
		<table align="center">
			<tr>
				<th>Input creator of bulletin</th>
				<td><input maxlength="25" size="30" name="creator"
					placeholder="Creator" type="text" id="shest" required></td>
			</tr>
		</table>
		<p align="center"><b>Input the text of bulletin</b></p>
		<textarea name="text" rows="20" id="shest" required></textarea>
		<p align="center"><input type="submit" value="Give new bulletin"></p>
	</form>
</body>
</html>