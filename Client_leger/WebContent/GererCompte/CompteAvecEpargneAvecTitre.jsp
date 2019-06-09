<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Compte Client</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="./css/header.css">

<link rel="stylesheet" type="text/css" href="./css/animation.css">
   
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.css">





<!-- Script -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        
        			
</head>
<body>
	<c:if test="${empty sessionClient}">
		<c:redirect url="http://localhost:8080/Projet_S8/FormulaireConnexion" />
	</c:if>
<%@include file="/GererCompte/HeaderAvecEpargneAvecTitreNew.jsp"%>
		<div class="col-md-1"></div>	
		<div class="col-md-8">
		<div class="text-center"><br><br><h2> Mes comptes bancaires</h2><br><hr><br></div>
			<div class="card-deck">

				<div class="card zoomInRight">
					<div class="card-body text-center">
					<h3>Solde Courant</h3>
					<canvas id="doughnut-chart" width="90" height="90"></canvas> <br>
						<c:if test="${!empty sessionScope.sessionClient}">
							<h2>${sessionScope.sessionClient.solde}Euro(s)</h2>
						</c:if>
					</div>
				</div>

				<div class="card zoomInRight">
					<div class="card-body text-center">
					<h3>Solde Epargne</h3>
					<canvas id="doughnut-chart1" width="90" height="90"></canvas> <br>
						<c:if test="${!empty sessionScope.soldeEpargne}">
							<h2>${sessionScope.soldeEpargne}Euro(s)</h2>
						</c:if>
					</div>
				</div>
				
				<div class="card zoomInRight">
					<div class="card-body text-center">
					<h3>Solde Titre</h3>
					<canvas id="doughnut-chart2" width="90" height="90"></canvas><br>
						<c:if test="${!empty sessionScope.soldeTitre}">
							<h2>${sessionScope.soldeTitre}Euro(s)</h2>
						</c:if>
					</div>

				</div>

			</div>
</div>
	</div>

	<div class="col-md-12 px-0"><%@include file="/footer.jsp"%></div>
	
				<script>new Chart(document.getElementById("doughnut-chart"), {
			    type: 'doughnut',
			    data: {
			      labels: ["Solde courant", "Total"],
			      datasets: [
			        {
			          label: "Population (millions)",
			          backgroundColor: ["#c45850", "#3e95cd"],
			          data: [${sessionScope.sessionClient.solde }, ${sessionScope.soldeTitre} + ${sessionScope.soldeEpargne} + ${sessionScope.sessionClient.solde }]
			        }
			      ]
			    },
			    options: {

			    }
			});</script>
			
			
			
						<script>new Chart(document.getElementById("doughnut-chart1"), {
			    type: 'doughnut',
			    data: {
			      labels: ["Solde épargne", "Total"],
			      datasets: [
			        {
			          label: "Population (millions)",
			          backgroundColor: ["#c45850", "#3e95cd"],
			          data: [${sessionScope.soldeEpargne}, ${sessionScope.sessionClient.solde} + ${sessionScope.soldeTitre} + ${sessionScope.soldeEpargne}]
			        }
			      ]
			    },
			    options: {

			    }
			});</script>

				<script>new Chart(document.getElementById("doughnut-chart2"), {
			    type: 'doughnut',
			    data: {
			      labels: ["Solde titre", "Total"],
			      datasets: [
			        {
			          label: "Population (millions)",
			          backgroundColor: ["#c45850", "#3e95cd"],
			          data: [${sessionScope.soldeTitre }, ${sessionScope.sessionClient.solde} + ${sessionScope.soldeEpargne} + ${sessionScope.soldeTitre }]
			        }
			      ]
			    },
			    options: {

			    }
			});</script> 