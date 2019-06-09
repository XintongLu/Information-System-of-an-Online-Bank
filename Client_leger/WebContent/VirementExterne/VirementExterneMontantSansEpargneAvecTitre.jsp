<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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

			<div class="card px-5">

				<div class="card-body px-5">
					<h3 class="text-center default-text py-3">
						<i class="fas fa-sign-in-alt"></i> Effectuer un virement externe
					</h3>
					<br> <b>Nom du bénéficiaire :</b> ${ nom }<br>
					<br> <b>IBAN du bénéficiaire :</b> ${ iban }<br>
					<br>

					<form method="post"
						action="/Projet_S8/VirementExterneAlimenter?nom=${ nom }">

						<div class="col-sm-20">
							<div class="container">
								<br>
								<div class="tab-content">
									<div id="home" class="container tab-pane active">
										<label for="demo">MONTANT A CREDITER</label>
										<div class="input-group mb-3">
											<span class="input-group-addon"> <i class="fa fa-key"></i>
											</span><input type="number" class="form-control"
												placeholder="saisissez le montant" name="espece" id="demo">
											<div class="input-group-append">
												<span class="input-group-text">en Euros</span>
											</div>
											<span class="erreur">${alimenter.erreurs['espece']}</span>
										</div>
										<br> <label for="demo">DESCRIPTION</label>
										<div class="input-group mb-3">
											<span class="input-group-addon"> <i class="fa fa-key"></i>
											</span><input type="text" class="form-control"
												placeholder="description" name="description" id="demo">
											<span class="erreur">${alimenter.erreurs['espece']}</span>
										</div>

										<div class="text-center">
											<button type="submit" class="btn btn-primary">Valider</button>
										</div>
									</div>
								</div>


							</div>
						</div>
					</form>


				</div>
			</div>
		</div>
	</div>
	
	<%@include file="/footer.jsp"%>