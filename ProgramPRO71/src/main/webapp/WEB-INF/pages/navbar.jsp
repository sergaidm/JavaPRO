<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Фотохостинг</title>
</head>
<body>
	<header>
		<div class="collapse bg-dark" id="navbarHeader">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-md-7 py-4">
						<h4 class="text-white">О проекте</h4>
						<p class="text-white">Фотохостинг - веб-приложение, разработанное на фреймворке Spring и ORM Hibernate и оформленное при помощи фреймворка Bootstrap.</p>
					</div>
					<div class="col-sm-4 offset-md-1 py-4">
						<h4 class="text-white">Об авторе</h4>
						<ul class="list-unstyled">
							<li class="media">
								<div class="media-left mr-3">
									<img class="media-object" src="static/images/LinkedIn.jpg" width="19" height="19" alt="LinkedIn.jpg" />
								</div>
								<div class="media-body">
									<a href="https://www.linkedin.com/in/serhey-haidamaka-93216713a/" target="_blank" class="text-white">Профиль на LinkedIn</a>
								</div>
							</li>
							<li class="media">
								<div class="media-left mr-3">
									<img class="media-object" src="static/images/GitHub.jpg" width="19" height="19" alt="GitHub.jpg" />
								</div>
								<div class="media-body">
									<a href="https://github.com/sergaidm" target="_blank" class="text-white">Профиль на GitHub</a>
								</div>
							</li>
							<li class="media">
								<div class="media-left mr-3">
									<img class="media-object" src="static/images/Email.jpg" width="19" height="19" alt="Email.jpg" />
								</div>
								<div class="media-body">
									<a href="mailto:gsg7525@gmail.com" target="_blank" class="text-white">Email</a>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="/" class="navbar-brand d-flex align-items-center"> <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2">
						<path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path>
						<circle cx="12" cy="13" r="4"></circle></svg><strong>Фотохостинг</strong>
				</a>
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="/photo_database">Все фотографии</a></li>
				</ul>
				<div class="ml-auto p-2 bd-highlight">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarHeader" aria-controls="navbarHeader"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</div>
			</div>
		</div>
	</header>
</body>
</html>