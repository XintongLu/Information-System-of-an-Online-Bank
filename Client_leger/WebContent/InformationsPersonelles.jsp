<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informations Personelles</title>
</head>
<body>
				<c:if test="${empty sessionClient}">
					<c:redirect url="http://localhost:8080/Projet_S8/FormulaireConnexion"/>
				</c:if>
<%@include file="/Header/HeaderClient.jsp" %>
	<div class="row">
		<!-- Grid column -->
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<br> <br> <br>
			<div class="card">

				<div class="card-body px-5">
					<h3 class="text-center default-text py-3">
						<i class="fa fa-user"></i> Informations Personnelles
					</h3>
					<h5 class="text-center">	
						Bienvenue  ${sessionScope.sessionClient.prenom} ${sessionScope.sessionClient.nom}
					</h5>
					
					<br><h5>Personnelle</h5>
					Identifiant : ${sessionScope.sessionClient.login}<br>
					Nationalité : ${sessionScope.sessionClient.nationalite}<br>
					Date de naissance : ${sessionScope.sessionClient.dateDeNaissance}<br><br>
					
					<h5>Localisation</h5>
					Adresse : ${sessionScope.sessionClient.adresse}<br>
					Ville : ${sessionScope.sessionClient.ville}<br>
					Code postal : ${sessionScope.sessionClient.codePostal}<br><br>
					
					<h5>Coordonnées</h5>
					E-mail : ${sessionScope.sessionClient.email}<br> 
					Numéro de téléphone : ${sessionScope.sessionClient.numerodetelephone}<br><br>
					
					<div class="text-center">
							<a	href="http://localhost:8080/Projet_S8/ModifierInfosPersonnelles">Modifier mes informations</a>
					</div>
				</div>
			</div>
		</div>
	</div>
<br><br><br><br><br>
<%@include file="/footer.jsp" %>
</body>
</html>