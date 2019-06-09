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
	<%@include file="/GererCompte/HeaderAvecEpargneAvecTitreNew.jsp"%><br>

	<div class="col-md-1"></div>
	<div class="col-md-8">
		<br> <br>
		<div class="erreur">
			<div class="alert alert-danger alert-dismissible fade show">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>${acheter.erreurs['erreur']}</strong>
			</div>
		</div>
		<div class="table-responsive">
			<table id="dtBasicExample"
				class="table table-striped table-bordered table-sm" cellspacing="0"
				width="100%">
				<thead class="thead-success">
					<tr>
						<th class="th-sm">Nom</th>
						<th class="th-sm">Ouverture</th>
						<th class="th-sm">Haut</th>
						<th class="th-sm">Bas</th>
						<th class="th-sm">Volume</th>
						<th class="th-sm">Prix d'achat</th>
						<th class="th-sm">Quantite</th>
						<th></th>

					</tr>
				</thead>
				<tbody>

					<c:forEach items="${array}" var="array">
						<form
							action="http://localhost:8080/Projet_S8/ServletAcheterActions"
							method="post">
							<tr>
								<td><c:out value="${array.nom}" /></td>
								<td><c:out value="${array.ouverture}" /></td>
								<td><c:out value="${array.haut}" /></td>
								<td><c:out value="${array.bas}" /></td>
								<td><c:out value="${array.volume}" /></td>
								<td><c:out value="${array.dernier}" /></td>
								<td><input name="nombre" type="number" min="1"></td>
								<td><input name="nom" type="hidden" value="${array.nom}">
									<input name="dernier" type="hidden" value="${array.dernier}">
									<button type="submit" class="btn btn-primary">Acheter</button>
								</td>
							</tr>
						</form>
					</c:forEach>


				</tbody>
			</table>



		</div>


	</div>


	<div class="col-md-12 px-0"><%@include file="/footer.jsp"%></div>


	<script type="text/javascript">
	/ Basic example
	$(document).ready(function () {
	  $('#dtBasicExample').DataTable({
	    "pagingType": "simple" // "simple" option for 'Previous' and 'Next' buttons only
	  });
	  $('.dataTables_length').addClass('bs-select');
	});
	</script>