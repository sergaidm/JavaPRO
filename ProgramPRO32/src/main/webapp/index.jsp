<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Simple calculator</title>
<style>
table {
	table-layout: fixed;
	width: 600px;
	border-collapse: collapse;
	margin: 0 auto;
}

td.cellOne {
	background-color: gold;
	text-align: center;
}

td.cellTwo {
	background-color: #D790F3;
	text-align: center;
}

td.cellThree {
	background-color: #2CAD38;
}

td.cellFour {
	background-color: #ADC6C2;
	text-align: center;
	width: 25%;
}

input.textField {	
	maxlength: 20;
	width: 100%;
}

div.submit {
	height: 25px;
	position: relative
}

div.submit p {
	margin: 0;
	background: #2CAD38;
	padding: 1px 1px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%)
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
	<form method="post" action="calculation">
		<table>
			<tr>
				<td class=cellOne><h1>Calculator</h1></td>
			</tr>
		</table>
		<table>
			<tr>
				<td class=cellTwo><strong>Input the first number</strong></td>
				<td class=cellThree><input class=textField name="firstNum" placeholder="First number" type="number" id="shest" required></td>
			</tr>
			<tr>
				<td class=cellTwo><strong>Input the second number</strong></td>
				<td class=cellThree><input class=textField name="secondNum"	placeholder="Second number" type="number" id="shest" required></td>
			</tr>
		</table>
		<table>
			<tr>
				<td class=cellFour><input name="action" type="radio" value="Addition" checked>+</td>
				<td class=cellFour><input name="action" type="radio" value="Subtraction">-</td>
				<td class=cellFour><input name="action" type="radio" value="Multiplication">⋅</td>
				<td class=cellFour><input name="action" type="radio" value="Division">÷</td>
			</tr>
		</table>			
		<div class=submit>
			<p><input type="submit" value="Calculate"></p>
		</div>
	</form>
</body>
</html>