<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualités</title>
<link rel="stylesheet" type="text/css" href="./css/actu.css" />
<link
	href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

	<%@include file="/Header/header.jsp"%>


	<div class="jumbotron jumbotron bg-transparent">
		<h1 class="display-4 text-align text-center">Nos actualités</h1>
		<p class="lead text-center">Découvrez les actualités d'E-Bank</p>

		<div id="containerSearch">
			<div class="search bar7">
				<form action= "./ActuServlet">
					<input type="text" placeholder="Recherche Actualité..." name="titre">
					<button type="submit"></button>
				</form>
			</div>
		</div>
		<hr class="my-4">
		<p class="lead"></p>



		<div class="section-container border-section-container">
			<br>
			<div class="container">
				<div class="row">

					<c:forEach items="${actu}" var="actu">
						<div class="col-md-6">
							<div class="box text-center">
								<div class="container">
									<div class="col-md-12 px-0">
										<img src="./assets/images/${actu.photoPath }"
											class="img-fluid">
									</div>
									<hr>
								</div>

								<div class="content">
									<header class="align-center">
										<p></p>
										<h3>
											<c:out value="${actu.titre}" />
										</h3>
										<hr>
									</header>
									<p>
										<c:out value="${actu.contenu}" />...
									</p>
									<form action="./ActuDetailsServlet" method="POST">
										<footer class="align-center">
											<a href="./ActuDetailsServlet?idActu=${actu.id}"
												class="button alt">Learn More</a>
												<br><br>
										</footer>
									</form>

								</div>
							</div>
						</div>


					</c:forEach>


				</div>
			</div>
			
		</div>


	</div>


	<%@include file="/footer.jsp"%>
</body>
</html>