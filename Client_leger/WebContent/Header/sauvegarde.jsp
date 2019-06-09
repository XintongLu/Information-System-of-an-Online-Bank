<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./Inscription.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
.navbar {
	min-height: 85px;
}

.navbar-header {
	margin-left: 5px;
	width: 100%;
}
</style>
</head>
<body>
<header>
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light navbar-fixed-top">
			<a class="navbar-brand">E-Bank</a>
			<div class="collapse navbar-collapse " id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="http://localhost:8080/Projet_S8/homeVisiteur.jsp">Accueil <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="">Nos
							services</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/Projet_S8/actualite.jsp">Actualités</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/Projet_S8/Contact.jsp">Nous
							contacter</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Ouvrir un compte</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<button type="button" class="btn "
								style="background-color: transparent" data-toggle="modal"
								data-target="#exampleModal">Ouvrir un compte courant</button>
							<button type="button" class="btn "
								style="background-color: transparent" data-toggle="modal"
								data-target="#exampleModal2">Ouvrir un compte épargne
								(livret A)</button>
						</div></li>
				</ul>
			</div>
		</nav>
	</header>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog text-center" role="document">
			<div class="modal-content text-center">
				<div class="modal-header text-center">
					<h5 class="modal-title text-center" id="exampleModalLabel">Etes
						vous client ?</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-footer text-center">
					<input type="button" value="Non, devenir client"
						onClick="javascript:document.location.href='http://localhost:8080/Projet_S8/control/FormulaireInscription'" />
					<input type="button" value="Oui, se connecter"
						onClick="javascript:document.location.href='http://localhost:8080/Projet_S8/FormulaireConnexion'" />
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog text-center" role="document">
			<div class="modal-content text-center">
				<div class="modal-header text-center">
					<h5 class="modal-title text-center" id="exampleModalLabel">Avez-vous
						déjà un compte courant ?</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-footer text-center">
					<input type="button" value="Je ne suis pas client, je m'inscris"
						onClick="javascript:document.location.href='http://localhost:8080/Projet_S8/control/FormulaireInscription'" /> 
						<input type="button" value="Je suis client, je me connecte"
						onClick="javascript:document.location.href='http://localhost:8080/Projet_S8/FormulaireConnexion'" />
				</div>
			</div>
		</div>
	</div>


</body>
</html>