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
					action="http://localhost:8080/Projet_S8/ServletAlimenter">

					<div class="col-md-25">
						<div class="text-center">
							<h2>Alimenter votre compte courant</h2>
						</div>

						<br>
						<!-- Nav tabs -->
						<ul class="nav nav-pills nav-justified" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#home">ESPECE</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#menu1">CHEQUE</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#menu2">CARTE BANCAIRE</a></li>
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
										placeholder="description" name="descriptionEspece" id="demo">

								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-primary">Valider</button>
								</div>



							</div>
							<div id="menu1" class="container tab-pane fade">
								<br> <label for="demo">MONTANT A CREDITER</label>
								<div class="input-group mb-5">
									<span class="input-group-addon"> <i class="fa fa-key"></i>
									</span><input type="number" min="0" class="form-control"
										placeholder="saisissez le montant" name="cheque" id="demo">
									<div class="input-group-append">
										<span class="input-group-text">en Euros</span>
									</div>
									<br> <span class="erreur">${alimenter.erreurs['cheque']}</span>
								</div>



								<br>
								<div class="form-group has-success">
									<label for="exampleInputFile">AJOUTEZ VOTRE CHEQUE: </label> <input
										type="file" id="exampleInputFile" name="fichier">
									<!-- <span
								class="erreur">${alimenter.erreurs['fichier']}</span> -->
								</div>
								<br> <label for="demo">DESCRIPTION</label>
								<div class="input-group mb-3">
									<span class="input-group-addon"> <i class="fas fa-pen"></i>
									</span><input type="text" class="form-control"
										placeholder="description" name="descriptionCheque" id="demo">

								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-primary">Valider</button>
								</div>
							</div>
							<div id="menu2" class="container tab-pane fade">
								<br> <label for="demo">MONTANT A CREDITER</label>
								<div class="input-group mb-5">
									<span class="input-group-addon"> <i class="fa fa-key"></i>
									</span><input type="number" min="0" class="form-control"
										placeholder="saisissez le montant" name="carte" id="demo">
									<div class="input-group-append">
										<span class="input-group-text">en Euros</span>
									</div>
									<span class="erreur">${alimenter.erreurs['carte']}</span> <br>

								</div>
								<br>
								<div class="form-inline">
									<label class="control-label mr-sm-2">Num&eacute;ro de
										carte:</label> <input class="mb-2 mr-sm-2" type="number" min="0"
										placeholder="" name="numero"> <span class="erreur">${alimenter.erreurs['numero']}</span>
									<label class="control-label mr-sm-2">CVC:</label> <input
										type="number" class="mb-2 mr-sm-2" min="0" placeholder=""
										name="cvc"> <span class="erreur">${alimenter.erreurs['cvc']}</span>
								</div>
								<br> <br> <label class="control-label ">Date
									d'expiration :</label> <input type="date"
									class="form-control1 ng-invalid ng-invalid-required"
									placeholder="MM/AAAA" name="date"> <span class="erreur">${alimenter.erreurs['date']}</span>
								<br>
								<br>
								<br>
								<label for="demo">DESCRIPTION</label>
								<div class="input-group mb-3">
									<span class="input-group-addon"> <i class="fas fa-pen"></i>
									</span><input type="text" class="form-control"
										placeholder="description" name="descriptionCarte" id="demo">

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