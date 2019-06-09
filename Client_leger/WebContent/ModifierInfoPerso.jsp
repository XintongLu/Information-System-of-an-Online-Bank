<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Modifier</title>
</head>
<c:if test="${empty sessionClient}">
	<c:redirect url="http://localhost:8080/Projet_S8/FormulaireConnexion" />
</c:if>
<%@include file="/Header/HeaderClient.jsp"%>
<body>

	<div class="row">
		<!-- Grid column -->
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<br> <br> <br>


			<form method="post">
				<div class="card px-5">

					<div class="card-body px-5">
						<h3 class="text-center default-text py-3">
							<i class="fas fa-sign-in-alt"></i> Modification des informations
						</h3>
					</div>



					<div class="form-group fg">
						<input class="form-control" id="exampleInputName1"
							placeholder="Login" name="login"
							value="${sessionScope.sessionClient.login}"><span
							class="erreur">${inscrire.erreurs['login']}</span>
					</div>


					<div class="form-group fg">
						<input type="text" class="form-control" id="exampleInputAdresse1"
							name="adresse" placeholder="Entrer adresse"
							value="${sessionScope.sessionClient.adresse}">
					</div>

					<div class="form-group fg">
						<input type="text" class="form-control" id="exampleInputVille1"
							name="ville" placeholder="Ville"
							value="${sessionScope.sessionClient.ville}">
					</div>

					<div class="form-group fg">
						<input type="text" class="form-control"
							id="exampleInputCodePostal1" name="cp" placeholder="Code Postal"
							value="${sessionScope.sessionClient.codePostal}"><span
							class="erreur">${inscrire.erreurs['cp']}</span>
					</div>

					<div class="form-group fg">
						<input type="email" name="email" class="form-control"
							id="exampleInputEmail" placeholder="Email"
							value="${sessionScope.sessionClient.email}"><span
							class="erreur">${inscrire.erreurs['email']}</span>
					</div>
					<div class="form-group fg">
						<input type="text" name="tel" class="form-control"
							id="exampleInputEmail" placeholder="Numéro de téléphone"
							value="${sessionScope.sessionClient.numerodetelephone}"><span
							class="erreur">${inscrire.erreurs['tel']}</span>
					</div>
					<div class="form-group fg">
						<input type="password" class="form-control"
							id="exampleInputPassword1" name="password"
							placeholder="Mot de passe"
							value="${sessionScope.sessionClient.motdepasse}"><span
							class="erreur">${inscrire.erreurs['password']}</span>
					</div>

					<div class="form-group fg">
						<input type="password" class="form-control"
							id="exampleInputPassword1" name="confirmation"
							placeholder="Confirmation"
							value="${sessionScope.sessionClient.motdepasse}"><span
							class="erreur">${inscrire.erreurs['confirmation']}</span>
					</div>


					<button type="submit" class="btn btn-primary fg ">Valider</button>

				</div>
			</form>
		</div>
	</div>

</body>


<div class="leftmenu">
	<%@include file="/footer.jsp"%>
</div>


</html>