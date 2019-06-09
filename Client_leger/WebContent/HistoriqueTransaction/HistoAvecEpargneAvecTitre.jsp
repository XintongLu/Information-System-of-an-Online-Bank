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
	
<!-- DataTables CSS -->
<link href="css/addons/datatables.min.css" rel="stylesheet">
<!-- DataTables JS -->
<script href="js/addons/datatables.min.js" rel="stylesheet"></script>

<!-- DataTables Select CSS -->
<link href="css/addons/datatables-select.min.css" rel="stylesheet">
<!-- DataTables Select JS -->
<script href="js/addons/datatables-select.min.js" rel="stylesheet"></script>

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
		<%@include file="/GererCompte/HeaderAvecEpargneAvecTitreNew.jsp"%>
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<br><br><div class="card-deck">

				<div class="card">
					<div class="card-body text-center">
						<h4>Historique des transactions </h4>
					</div>
					
					
					<table id="table_id" class="table">
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
						</c:forEach>
					</table>

					
					<div class="text-center"><a href="/Projet_S8/fichiers/extrait.csv" >Extrait de compte en .csv</a></div><br>
					<div class="text-center"><a href="/Projet_S8/fichiersPDF/extrait.pdf" >Extrait de compte en format PDF</a></div><br>
					<script>
					$(document).ready( function () {
					    $('#table_id').DataTable();
					} );
					</script>
				</div>
		</div>
	</div>
</div>
<div class="col-md-12 px-0"><%@include file="/footer.jsp"%></div>