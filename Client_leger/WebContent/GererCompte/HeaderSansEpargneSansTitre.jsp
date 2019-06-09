<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div class="col-md-3">
			<!-- menu -->
			<h4>&nbsp;Bienvenue ${sessionScope.sessionClient.prenom}
				${sessionScope.sessionClient.nom}</h4> 
			<div id="MainMenu">
				<div class="list-group panel">
					<a href="/Projet_S8/ServletCompte" class="list-group-item list-group-item-success"	data-parent="#MainMenu">Mes comptes</a> 
					<a href="/Projet_S8/HitoriqueTransaction" class="list-group-item list-group-item-success" data-parent="#MainMenu">Historique des Transactions</a> 
					<a href="#demo3" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Compte courant &nbsp; <i class="fa fa-caret-down"></i> </a>
					<div class="collapse" id="demo3">
						<a href="/Projet_S8/ServletAlimenter" class="list-group-item">Alimenter</a>
					</div>
					<a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Compte Ãˆpargne &nbsp; <i class="fa fa-caret-down"></i></a>
					 <div class="collapse" id="demo4">
          				<a class="list-group-item" data-toggle="modal" data-target="#exampleModal" >Créˆer</a>
         			 </div>
         			 <a href="#demo6" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Compte titre &nbsp; <i class="fa fa-caret-down"></i></a>
					 <div class="collapse" id="demo6"> 
          				<a class="list-group-item" data-toggle="modal" data-target="#exampleModal1" >Créˆer</a>
         			 </div>
					<a href="#demo5" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Virement externe &nbsp; <i class="fa fa-caret-down"></i></a>
					<div class="collapse" id="demo5"> <a href="/Projet_S8/AjouterBeneficiaire" class="list-group-item">Ajouter un bénéˆficiaire</a> 
					<a href="/Projet_S8/VirementExterne" class="list-group-item">Virement externe</a>
					</div>
					<a href="#" class="list-group-item list-group-item-success" data-parent="#MainMenu"></a> <a href="#" class="list-group-item list-group-item-success" data-parent="#MainMenu"></a>
				</div>
			</div>
		</div>

	<form method="post"
		action="http://localhost:8080/Projet_S8/ServletEpargne">
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog text-center" role="document">
				<div class="modal-content text-center">
					<div class="modal-header text-center">
						<h5 class="modal-title text-center" id="exampleModalLabel">Etes
							vous sËšr(e) ?</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-footer text-center">
						<input type="button" value="Abandonner"
							onClick="javascript:document.location.href='GererCompte/CompteSansEpargne.jsp'" />
						<input type="submit" value="Oui" />
					</div>
				</div>
			</div>
		</div>
	</form>
	<form method="post"
		action="http://localhost:8080/Projet_S8/ServletTitre">
		<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog text-center" role="document">
				<div class="modal-content text-center">
					<div class="modal-header text-center">
						<h5 class="modal-title text-center" id="exampleModalLabel">Etes
							vous sËšr(e) ?</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-footer text-center">
						<input type="button" value="Abandonner"
							onClick="javascript:document.location.href='GererCompte/CompteSansEpargne.jsp'" />
						<input type="submit" value="Oui" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>