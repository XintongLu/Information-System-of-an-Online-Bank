<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

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

<title>Acceuil Client</title>
</head>
<body>
	<%@include file="/Header/HeaderAdmin.jsp"%>

<script>
	AOS.init();
</script>
	<img src="../assets/images/126.jpg" class="img-fluid" alt="...">

	<div class="container1 fadeInLeftBig">
		<div class="content1">
			<h1>E-BANK - Votre banque en ligne</h1>
			<h4>Effectuez vos transactions en toute sérénité</h4>
		</div>
	</div>




	<div class="jumbotron jumbotron bg-transparent">
		<h1 class=" display-4 text-align text-center">Notre actualité</h1>
		<p class="lead text-center">Découvrez nos actualités du moment,
			afin d'en savoir plus visitez notre page dédiée</p>
		<hr class="my-4">
		<p class="lead"></p>


		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" src="../assets/images/actualite1.PNG"
						alt="First slide">

					<div class="container2">
						<div class="content2 carousel-caption d-none d-md-block">
							<h2>Accelerate Business For Good : rendez-vous le 2 avril à Lyon</h2>
						
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="../assets/images/actualite2.PNG"
						alt="Second slide">

					<div class="container2">
						<div class="content2 carousel-caption d-none d-md-block">
							<h2>La semaine économique : Etats-Unis, les « dots » créent le malaise</h2>
							
						</div>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>




	<div class="jumbotron jumbotron bg-transparent">
		<h1 class="display-4 text-align text-center">Nos services</h1>
		<p class="lead text-center">Découvrez nos services du moment, afin
			d'en savoir plus visitez notre page dédiée</p>
		<hr class="my-4">
		<p class="lead"></p>


		<div class="section-container border-section-container">
			<br>
			<div class="container">
				<div class="row">

					<div class="col-md-4">

						<div  data-aos="fade-right" class="text-center">
							<div class="fa-container">
								<i class="far fa-credit-card fa-3x"></i>
							</div>
							<br>
							<h3>Carte bancaire virtuelle</h3>
						
						<div>
							<p>Le service fonctionne avec les cartes de paiement
								délivrées par votre banque. Le service Payweb Card génère les
								données nécessaires pour acheter sur internet. Demandé
								l'activation de ce service a votre conseiller.</p>
						</div>
						</div>
					</div>
					<div class="col-md-4">

						<div  data-aos="fade-up" class="text-center ">
							<div class="fa-container">
								<i class="fas fa-wifi fa-3x"></i>
							</div>
							<br>
							<h3>Factures en lignes</h3>
						
						<div>
							<p>Si vous avez opté pour ce service, vos factures sur vos
								frais bancaires sont mises à disposition directement dans votre
								espace client. Ce service est gratuit, sauf si vous optez pour
								une fréquence d'envoi de vos extraits de comptes journalière ou
								hebdomadaire.</p>
						</div>
						</div>
					</div>
					<div class="col-md-4">

						<div  data-aos="fade-left" class="text-center">
							<div class="fa-container">
								<i class="fas fa-money-check-alt fa-3x"></i>
							</div>
							<br>
							<h3>Gérer vos comptes</h3>
						
						<div>
							<p>On vous propose le service Transfert Facile qui prend en
								charge gratuitement et à votre place le transfert des opérations
								domiciliées sur votre compte actuel (prélèvements, virements
								permanents...) vers votre nouveau compte</p>
						</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		
		
		
<br><br>
		<div  class="jumbotron jumbotron bg-transparent">
			<h1 class="display-4 text-align text-center">Ouverture d'un
				compte</h1>
			<p class="lead text-center">L'ouverture d'un compte courant
				depuis chez vous</p>
			<hr class="my-4">
			<p class="lead"></p>
			<img data-aos="fade-up" class="d-block w-100" src="../assets/images/ouvertureCompte.PNG">
		</div>






	</div>




	<%@include file="/footer.jsp"%>