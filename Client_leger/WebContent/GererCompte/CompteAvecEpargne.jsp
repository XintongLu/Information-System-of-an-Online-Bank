<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Compte Client</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<c:if test="${empty sessionClient}">
		<c:redirect url="http://localhost:8080/Projet_S8/FormulaireConnexion" />
	</c:if>
	<%@include file="/Header/HeaderClient.jsp"%>
	<br>
  <div class="row">
<%@include file="/GererCompte/HeaderAvecEpargneSansTitre.jsp"%>

		<div class="col-md-1"></div>
		<div class="col-md-6">
			<div class="card-deck">

				<div class="card">
					<img src="assets/images/courant.png" class="img-thumbnail"
						alt="Cinque Terre" width="350" height="230">
					<div class="card-body text-center">
						<c:if test="${!empty sessionScope.sessionClient}">
							<h2>${sessionScope.sessionClient.solde}Euro(s)</h2>
						</c:if>
					</div>
				</div>


				<div class="card">
					<img src="assets/images/epargner.png" class="img-thumbnail"
						alt="Cinque Terre" width="350" height="230">
					<div class="card-body text-center">
						<c:if test="${!empty sessionScope.soldeEpargne}">
							<h2>${sessionScope.soldeEpargne}Euro(s)</h2>
						</c:if>
					</div>

				</div>
				<div></div>

			</div>

	</div>
	</div>
	

	<%@include file="/footer.jsp"%>