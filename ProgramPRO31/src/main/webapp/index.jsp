<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Questionnaire</title>
</head>
<body>
		<form method="post" action="questions">
		<h2>Welcome! Take part in a short questionnaire.</h2>
		<h2>To get started, input your name and surname:</h2>
			<table>
				<tr>
					<td><strong>Your name</strong></td>
					<td><input maxlength="25" size="40" name="name" value="Name"></td>
				</tr>	
				<tr>
					<td><strong>Your surname</strong></td>
					<td><input maxlength="25" size="40" name="surname" value="Surname"></td>
					
				</tr>				
			</table>
			<input type="submit" value="Start">
		</form>
</body>
</html>