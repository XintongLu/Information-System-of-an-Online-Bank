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

		<div class="card col-md-8">
			<div class="card-body">
				<form method="post"
					action="http://localhost:8080/Projet_S8/VirementInterneEpargneVersCourant">

					<div class="col-md-25">
						<div class="text-center">
							<h2>Virement interne : Compte épargne vers compte courant</h2>
						</div>

						<br>
						<!-- Nav tabs -->
						<ul class="nav nav-pills nav-justified" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#home">VIREMENT</a></li>
						</ul>
						<hr color="green">

						<!-- Tab panes -->
						<div class="tab-content">
							<div id="home" class="container tab-pane active">
								<br> <label for="demo">MONTANT A CREDITER</label>
								<div class="input-group mb-5">
									<span class="input-group-addon"> <i class="fa fa-key"></i>
									</span><input type="number" min="0" class="form-control"
										placeholder="saisissez le montant" name="espece" id="demo">
									<div class="input-group-append">
										<span class="input-group-text">en Euros</span>
									</div>
									<span class="erreur">${alimenter.erreurs['espece']}</span>
								</div>
								<br> <label for="demo">DESCRIPTION</label>
								<div class="input-group mb-3">
									<span class="input-group-addon"> <i class="fas fa-pen"></i>
									</span><input type="text" class="form-control"
										placeholder="description" name="description" id="demo">
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-primary">Valider</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>



	<%@include file="/footer.jsp"%>