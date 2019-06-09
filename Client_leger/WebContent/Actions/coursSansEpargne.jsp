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

	<br>
	<%@include file="/GererCompte/HeaderAvecEpargneSansTitre.jsp"%>


		<br>
		<h2>Cours de la bourse</h2>
		<br>
		<br>

			<div class="col-md-4">
				<br> <br>
				<iframe
					src="https://widgets2.rt.prorealtime.com/ProRealTime_HTML5XLight/itcharts.phtml?wid=2019881841&k=25375675fb005d46d69cda7bb77b73af"
					height="400" width="700" frameborder="0" scrolling="no"></iframe>
			</div>
		
		<br>

		



	<div class="col-md-12 px-0"><%@include file="/footer.jsp"%></div>
