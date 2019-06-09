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
					<a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Compte pargne &nbsp; <i class="fa fa-caret-down"></i></a>
					<div class="collapse" id="demo4">
						<a href="/Projet_S8/ServletAlimenterEpargne" class="list-group-item">Alimenter</a>
					</div>
					 <a href="#demo7" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Compte titre &nbsp; <i class="fa fa-caret-down"></i></a>
					 <div class="collapse" id="demo7">
					 <a href="/Projet_S8/ServletAlimenterTitre" class="list-group-item">Alimenter</a>
						<a href="/Projet_S8/Actions/coursAvecEpargne.jsp" class="list-group-item">Cours de la bourse</a>
						<a href="/Projet_S8/ServletRecupererActions" class="list-group-item">Acheter des actions</a>
						<a href="/Projet_S8/ServletAfficherActions" class="list-group-item">Vendre des actions</a>
					</div>
					<a href="#demo5" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Virement externe &nbsp; <i class="fa fa-caret-down"></i></a>
					<div class="collapse" id="demo5"> <a href="/Projet_S8/AjouterBeneficiaire" class="list-group-item">Ajouter un bnficiaire</a> 
					<a href="/Projet_S8/VirementExterne" class="list-group-item">Virement externe</a>
					</div>
					<a href="#demo6" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Virement interne &nbsp; <i class="fa fa-caret-down"></i> </a>
					<div class="collapse" id="demo6">
						<a href="#" class="list-group-item">Compte pargne vers compte courant</a> 
						<a href="#" class="list-group-item">Compte titre vers compte courant </a> 
						<a href="#" class="list-group-item">Compte titre vers compte pargne</a> 
						<a href="#" class="list-group-item">Compte pargne vers compte titre </a>
					</div>
					<a href="#" class="list-group-item list-group-item-success" data-parent="#MainMenu"></a> <a href="#" class="list-group-item list-group-item-success" data-parent="#MainMenu"></a>
				</div>
			</div>
		</div>
</body>
</html>
