<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Depots des clients</title>
</head>

<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>


<link rel="stylesheet" type="text/css" href="../css/animation.css">
<link rel="stylesheet" type="text/css" href="../css/home.css">

<body>
	<%@include file="/Header/HeaderManager.jsp"%>
	<div class="row d-flex justify-content-center">


		<div class="jumbotron bg-transparent">
			<p class="display-4 text-align text-center">LIQUIDITE de la
				banque :</p>
				<c:choose>
<c:when test="${somme > 0}">
			<p class="display-4 text-align text-center text-success">
				<c:out value="${somme}" />
				euros
			</p>
			</c:when>
			<c:when test="${somme < 0}">
			<p class="display-4 text-align text-center text-danger">
				<c:out value="${somme}" />
				euros
			</p>
			</c:when>
			</c:choose>
		</div>
		<div class="col-md-10">



			<div class="card-deck">
				<div class="card">
					<div class="card-body text-center">
						<h4>Depots des clients</h4>
					</div>



					<table id="table_id" class="table table-hover table-fixed">
						<thead>
							<tr>

								<th scope="col">Date</th>
								<th scope="col">Depot Par</th>
								<th scope="col">Nom du client</th>
								<th scope="col">montant(euros)</th>


							</tr>
						</thead>
						<c:forEach items="${depot}" var="depot">
							<tbody>
								<tr>

									<td><c:out value="${depot.dateVir}" /></td>
									<td><c:out value="${depot.moyen}" /></td>
									<td><c:out value="${depot.prenomNom}" /></td>
									<td><c:out value="${depot.montant}" /></td>

								</tr>
							</tbody>
						</c:forEach>
					</table>


				</div>
			</div>
		</div>

	</div>

	<%@include file="/footer.jsp"%>
</body>
</html>