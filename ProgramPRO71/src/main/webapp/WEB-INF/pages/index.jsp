<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster&effect=outline">
<link rel="stylesheet" href="static/styles/files_selection_button.css">
<link rel="stylesheet" href="static/styles/photohosting.css">
<link rel="stylesheet" href="static/styles/title.css">
<link rel="stylesheet" href="static/styles/background.css">
<link rel="stylesheet" href="static/styles/font.css">
<link rel="stylesheet" href="static/styles/buttons.css">
<title>Фотохостинг</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<c:import url="navbar.jsp" />
	<main role="main">
	<section class="jumbotron text-center">
		<div class="container">
			<div class="title">
				<span>Ф</span><span>о</span><span>т</span><span>о</span>
				<div>
					<span>Х</span><span>о</span><span>с</span><span>т</span><span>и</span><span>н</span><span>г</span>
				</div>
			</div>
			<div class="font-effect-outline">
				<p class="lead">Добро пожаловать на фотохостинг! В данной версии
					Вы можете добавлять, просматривать и удалять загруженные
					изображения. В будущих версиях приложения добавится много новых
					полезных функций и возможностей! Следите за обновлениями!</p>
			</div>
		</div>
	</section>
	<form method="post" action="add_photos" id="add_photos" enctype="multipart/form-data">
		<div class="d-flex justify-content-center align-items-center mt-2">
			<div class="selection_button flex-grow-1 mr-4">
				<label for="custom-file-upload" class="filupp"><span class="filupp-file-name js-value">Выбрать фотографии для загрузки</span>
				<input type="file" name="images" id="custom-file-upload" multiple="multiple" accept="image/*" onchange="var filesLength = this.files.length; if (filesLength > 0) {document.getElementById('button').style.display = 'block';} else if (filesLength == 0){return false;}">
				</label>
			</div>
			<button class="glo" type="submit" id="button">Загрузить фотографии</button>
		</div>
	</form>
	</main>
	<script src="static/scripts/files_length.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
</body>
</html>