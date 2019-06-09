<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Bank - Actualités Détails</title>
<link rel="stylesheet" href="/css/main.css" />
</head>
<body>

	<%@include file="/Header/header.jsp"%>

	<section class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">

					<c:forEach items="${actu}" var="actu">
						<div class="jumbotron jumbotron bg-transparent">
							<h2 class="display-4 text-align text-center">
								<c:out value="${actu.titre}" />
							</h2>
							<p class="lead text-center">
								<c:out value="${actu.date}" />
								|
								<c:out value="${actu.auteur}" />
							</p>

							<div class="box">
								<div class="container">
									<div class="col-md-12 px-0">
										<img src="./assets/images/${actu.photoPath}" alt=""
											class="img-fluid" />
									</div>
									<hr>
								</div>
								<br />
								<p style="color: black;">
									<c:out value="${actu.contenu}" />
								</p>
								<br />

							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	
	</section>


	<%@include file="/footer.jsp"%>
</body>
</html>