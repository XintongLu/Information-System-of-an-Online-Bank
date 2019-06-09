<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Compte Client</title>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/css/mdb.min.css"
	rel="stylesheet">
<!-- JQuery -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/js/mdb.min.js"></script>
</head>
<body>
	<c:if test="${empty sessionClient}">
		<c:redirect url="http://localhost:8080/Projet_S8/FormulaireConnexion" />
	</c:if>

	<br>
	<%@include file="/GererCompte/HeaderSansEpargneAvecTitre.jsp"%>



	<div class="col-md-8">
		<div class="table-responsive">

			<table class="table">
				<thead class="thead-success">
					<tr>
						<th>Nom</th>
						<th>Prix</th>
						<th>Nombre d'actions</th>
						<th></th>

					</tr>
				</thead>
				<tbody>

					<c:forEach items="${actions}" var="actions">
						<form
							action="http://localhost:8080/Projet_S8/ServletVendreActions"
							method="post">
							<tr>

								<td><c:out value="${actions.nom}" /></td>
								<td><c:out value="${actions.dernier}" /></td>
								<td><select name="nombre">
										<c:forEach var="i" begin="0" end="${actions.nombre-1}">
											<option value="${actions.nombre-i}"><c:out
													value="${actions.nombre-i}" /></option>
										</c:forEach>
								</select></td>
								<td><input name="nom" type="hidden" value="${actions.nom}">
									<button type="submit" class="btn btn-primary">Vendre</button></td>
							</tr>
						</form>

					</c:forEach>

				</tbody>
			</table>

		</div>
	</div>

	<br>





	<div class="col-md-12 px-0"><%@include file="/footer.jsp"%></div>