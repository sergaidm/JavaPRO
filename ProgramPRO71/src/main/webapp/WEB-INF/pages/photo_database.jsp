<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" href="static/styles/selection_images.css">
<link rel="stylesheet" href="static/styles/background.css">
<link rel="stylesheet" href="static/styles/buttons.css">
<link rel="stylesheet" href="static/styles/checkboxes.css">
<title>Фотохостинг</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<c:import url="navbar.jsp" />
	<main role="main">
	<div class="album py-5 bg-light">
		<div class="container">
			<c:set var="allPhotos" value="${fn:length(photos)}"/>
			<c:if test="${allPhotos == 0}">
				<form method="post" action="add_photos" id="add_photos" enctype="multipart/form-data">
					<div class="d-flex justify-content-center align-items-center">
						<div class="selection_button flex-grow-1 mr-4">
							<label for="custom-file-upload" class="filupp"><span class="filupp-file-name js-value">Выбрать фотографии для загрузки</span>
							<input type="file" name="images" id="custom-file-upload" multiple="multiple" accept="image/*" onchange="var filesLength = this.files.length; if (filesLength > 0) {document.getElementById('button').style.display = 'block';} else if (filesLength == 0){return false;}">
							</label>
						</div>
						<button class="glo" type="submit" id="button">Загрузить фотографии</button>
					</div>
				</form>
			</c:if>
			<c:if test="${allPhotos > 0}">
				<div class="d-flex justify-content-center mb-4">
					<label class="main_checkbox"><input type="checkbox" id="selection_checkboxes" name="checkbox" class="checkbox">
						<div class="checkbox_text font-effect-outline">Выбрать все фотографии</div>
					</label>
				</div>
			</c:if>
			<form method="post" action="delete_photos">
				<c:if test="${allPhotos > 0}">
					<div class="row">
						<c:forEach items="${photos}" var="photo">
							<c:set var="photo_id" scope="session" value="${photo.getId()}"/>
							<div class="col-md-4">
								<div class="card mb-4">
									<label><img class="card-img-top img-thumbnail etu" src="/view_photo/${photo_id}" width="100" height="300" alt="Загруженная фотография">
									<input type="checkbox" id="selection_checkboxes" name="checkbox" value="${photo_id}" class="checkbox">
									</label>
									<div class="card-body">
										<div class="d-flex justify-content-center align-items-center">
											<div class="btn-group">
												<input type="button" class="btn btn-sm btn-outline-secondary" value="Просмотр фото" onclick="window.open('/view_photo/${photo_id}', '_blank')"/>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${allPhotos > 0}">
					<div class="d-flex justify-content-center align-items-center">
						<div id="body_button">
							<button class="delete_button" id="delete_button" type="submit">
								<span>Удалить фотографии</span>
							</button>
						</div>
					</div>
				</c:if>
			</form>
		</div>
	</div>
	</main>
	<c:import url="footer.jsp" />
	<script src="static/scripts/files_length.js"></script>
	<script src="static/scripts/selection_checkboxes.js"></script>
	<script src="static/scripts/checking_checkboxes_selection.js"></script>
	<script src="static/scripts/selection_images.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
</body>
</html>