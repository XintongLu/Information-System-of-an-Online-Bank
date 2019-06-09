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
	

	<div class="row">
		<%@include file="/GererCompte/HeaderSansEpargneAvecTitre.jsp"%>

	
		<div class="col-md-8">
			
			<div class="erreur">
				<div class="alert alert-danger alert-dismissible fade show">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>${acheter.erreurs['erreur']}</strong>
				</div>
			</div>
			<div class="table-responsive">

				<table class="table">
					<thead class="thead-success">
						<tr>
							<th>Nom</th>
							<th>Ouverture</th>
							<th>Haut</th>
							<th>Bas</th>
							<th>Volume</th>
							<th>Prix d'achat</th>
							<th></th>

						</tr>
					</thead>
					<tbody>

						<c:forEach items="${array}" var="array">
							<tr>
								<td><c:out value="${array.nom}" /></td>
								<td><c:out value="${array.ouverture}" /></td>
								<td><c:out value="${array.haut}" /></td>
								<td><c:out value="${array.bas}" /></td>
								<td><c:out value="${array.volume}" /></td>
								<td><c:out value="${array.dernier}" /></td>
								<td>
									<form
										action="http://localhost:8080/Projet_S8/ServletAcheterActions"
										method="post">
										<input name="nom" type="hidden" value="${array.nom}">
										<input name="dernier" type="hidden" value="${array.dernier}">
										<button type="submit" class="btn btn-primary">Acheter</button>

									</form>
								</td>
							</tr>

						</c:forEach>


					</tbody>
				</table>

			</div>


		</div>
	</div>





	<%@include file="/footer.jsp"%>