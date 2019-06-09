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
		<%@include file="/GererCompte/HeaderSansEpargneSansTitre.jsp"%>

		<div class="col-md-1"></div>

		<div class="col-md-6">
			<br> <br>
			<div class="card px-5">

				<div class="card-body px-5">
					<h3 class="text-center default-text py-3">
						<i class="fas fa-user"></i> Choisir un bénéficiaire
					</h3>
					
					
					<table class="table">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">#</th>
								<th scope="col">Nom</th>
								<th scope="col">IBAN</th>
							</tr>
						</thead>
						<c:forEach items="${listNom}" var="nom" varStatus="status">
							<tbody>
								<tr>
									<th scope="row"></th>
									<td><b><c:out value="${status.index}" /></b></td>
										<td><a
										href="<c:url value="/VirementExterneMontant?nom=${nom}&iban=${listIban[status.index]}"/>"><font
											color="black"><c:out value="${listNom[status.index]}" /></font></a></td>
									<td><c:out value="${listIban[status.index]}" /></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					
				</div>
			</div>
		</div>
	</div>