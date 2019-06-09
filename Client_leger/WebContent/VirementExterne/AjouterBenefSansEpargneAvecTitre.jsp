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
	
	<style>
	form .erreur {
    color: #900;
}
form .succes {
    color: #090;
}
	</style>
</head>
<body>
	<c:if test="${empty sessionClient}">
		<c:redirect url="http://localhost:8080/Projet_S8/FormulaireConnexion" />
	</c:if>
	<%@include file="/Header/HeaderClient.jsp"%>
	<br>

	<div class="row">
	<%@include file="/GererCompte/HeaderSansEpargneAvecTitre.jsp"%>

		<div class="col-md-1"></div>

		<div class="col-md-6">
			<br>
			<br>
			<div class="card px-5">
				<form method="post">
					<div class="card-body px-5">
						<h3 class="text-center default-text py-3">
							<i class="fas fa-sign-in-alt"></i> Ajouter un bénéficiaire
						</h3>
					</div>
					<div class="form-group fg">
						<input class="form-control" id="exampleInputName1"
							placeholder="Nom" name="nom"><span class="erreur">${ajouter.erreurs['nom']}</span>
					</div>
					<div class="form-group fg">
						<input type="text" class="form-control" id="exampleInputAdresse1"
							name="iban" placeholder="IBAN"><span class="erreur"><br>${ajouter.erreurs['iban']}</span>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary fg ">Valider</button>
					</div>
					
					<br> <p class="${empty erreurs ? 'succes' : 'erreur'}">${ajouter.resultat}</p>
					
				</form>
			</div>
		</div>
	</div>


	<%@include file="/footer.jsp"%>