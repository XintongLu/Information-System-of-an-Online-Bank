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
<%@include file="/GererCompte/HeaderAvecEpargneAvecTitre.jsp"%>

		
		<div class="col-md-9">
			<div class="card-deck">

				<div class="card">
					<div class="card-body text-center">
						<h4>Historique des transactions </h4>
					</div>
					
					
					<table id="dtBasicExample" class="table">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Montant EUROS</th>
								<th scope="col">Paiement par</th>
								<th scope="col">Bénéficiaire</th>
								<th scope="col">Opération</th>
								<th scope="col">Date</th>
							</tr>
						</thead>
						<c:forEach items="${listBenef}" var="nom" varStatus="status">
							<tbody>								<tr>
									<th scope="row"></th>
									<td><c:out value="${listMontant[status.index]}" /></td>
									<td><c:out value="${listMoeyn[status.index]}" /></td>
									<td><c:out value="${listBenef[status.index]}" /></td>
									<td><c:out value="${listeDescription[status.index]}" /></td>
									<td><c:out value="${listDate[status.index]}" /></td>
							</tbody>
					<script>
					</script>
						</c:forEach>
					</table>

					
					<div class="text-center"><a href="/Projet_S8/fichiers/extrait.csv" >Extrait de compte en .csv</a></div><br>
					<div class="text-center"><a href="/Projet_S8/fichiersPDF/extrait.pdf" >Extrait de compte en format PDF</a></div><br>
					
				</div>
		</div>
	</div>
</div>



	<%@include file="/footer.jsp"%>