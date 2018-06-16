<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Letters counter</title>
<style>
table {
	table-layout: fixed;
	width: 100%;
	border-collapse: collapse;
	margin: 0 auto;
}

td.cellOne {
	color: #CD5C5C;
	background-color: DeepSkyBlue;
	text-align: center;
}

textarea
{
  width:99.6%;
}
.textwrapper
{
  border:3px solid #4B0082;
  margin:3px 0;
  padding:5px;
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
	<form method="post" action="counting">
		<table>
			<tr>
				<td class=cellOne><h1>Counter of letters in the text</h1></td>
			</tr>
		</table>		
		<div class="textwrapper"><textarea name="text" placeholder="Input text for counting the number of repeated letters" rows="20" id="shest" required></textarea></div>
		<div class=submit>
			<p><input type="submit" value="Count"></p>
		</div>
	</form>
</body>
</html>