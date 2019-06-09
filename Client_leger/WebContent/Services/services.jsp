<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services</title>
<link rel="stylesheet" type="text/css" href="./css/actu.css" />
<link
	href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<%@include file="/Header/header.jsp"%>


	<div class="jumbotron jumbotron bg-transparent">
		<h1 class="display-4 text-align text-center">Nos services</h1>
		<p class="lead text-center">Découvrez les services d'E-Bank</p>

		<div id="containerSearch">
			<div class="search bar7">
				<form action="./ServiceServlet">
					<input type="text" placeholder="Recherche Service..." name="titre">
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

					<c:forEach items="${service}" var="service">

						<div class="col-md-6">
							<div class="box text-center">
								<div class="fa-container">
									<i class=" ${service.photoPath } fa-3x"></i>
								</div>
								<br>
								<div class="content">
									<header class="align-center">
										<p></p>
										<h3>
											<c:out value="${service.titre}" />
										</h3>
										<hr>
									</header>
									<p>
										<c:out value="${service.contenu}" />
										...
									</p>
									<form action="./ActuDetailsServlet" method="POST">
										<footer class="align-center">
											<a href="./ServDetailsServlet?idService=${service.id}"
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