<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real estate agency</title>
</head>
<body>
	<h1 align="center">Real estate agency</h1>
	<p align="center">To get started, upload the list of flats in XML-format</p>			
	<form method="post" action="upload" enctype="multipart/form-data">
		<p align="center"><input type="file" name="file" accept=".xml"></p> 		
		<p align="center"><input type="submit" value="Upload file"/></p>
	</form>
</body>
</html>