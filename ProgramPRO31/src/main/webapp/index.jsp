<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Анкета</title>
</head>
<body>
		<form method="post" action="questions">
		<h2>Добро пожаловать! Примите участие в небольшой анкете.</h2>
		<h2>Для прохождения введите свои имя и фамилию:</h2>
			<table>
				<tr>
					<td><strong>Ваше имя</strong></td>
					<td><input maxlength="25" size="40" name="name" value="Имя"></td>
				</tr>	
				<tr>
					<td><strong>Ваша фамилия</strong></td>
					<td><input maxlength="25" size="40" name="surname" value="Фамилия"></td>
					
				</tr>				
			</table>
			<input type="submit" value="Начать">
		</form>
</body>
</html>