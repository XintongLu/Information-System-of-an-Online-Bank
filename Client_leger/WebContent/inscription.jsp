<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Inscription</title>
</head>
<%@include file="/Header/header.jsp"%>


<body>

	<div class="row">
		<!-- Grid column -->
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<br> <br> <br>
			
			
			<form method="post" >
			
		
				<div class="card px-5">
					
					<div class="card-body px-5">
						<h3 class="text-center default-text py-3">
							<i class="fas fa-sign-in-alt"></i> Inscription :
						</h3>
											</div>

					<div class="form-group fg">
						<label for="exampleInputDateDeNaissance">Date de naissance</label>
						<input type="text" class="form-control"
							id="exampleInputDateDeNaissance11" placeholder="dd/mm/yyyy"
							name="date"><span class="erreur">${inscrire.erreurs['date']}</span>
					</div>
					<div class="form-group">
						<select class="form-control" id="exampleSelect1">
							<option value="homme">Homme</option>
							<option value="femme">Femme</option>

						</select>
					</div>

					<div class="form-group fg">
						<input class="form-control" id="exampleInputName1"
							placeholder="Login" name="login"><span class="erreur">${inscrire.erreurs['login']}</span>
					</div>

					<div class="form-group fg">
						<input class="form-control" id="exampleInputName1"
							placeholder="Nom" name="nom"><span class="erreur">${inscrire.erreurs['nom']}</span>
					</div>
					<div class="form-group fg">
						<input class="form-control" id="exampleInputPrenom1" name="prenom"
							placeholder="Prenom"><span class="erreur">${inscrire.erreurs['prenom']}</span>
					</div>
					<div class="form-group fg">
						<input type="text" class="form-control"
							id="exampleInputNationalité1" placeholder="Nationalité"
							name="nationalite">
					</div>

					<div class="form-group fg">
						<input type="text" class="form-control" id="exampleInputAdresse1"
							name="Adresse" placeholder="Entrer adresse">
					</div>

					<div class="form-group fg">
						<input type="text" class="form-control" id="exampleInputVille1"
							name="ville" placeholder="Ville">
					</div>
					<div class="form-group fg">
						<input type="text" class="form-control"
							id="exampleInputCodePostal1" name="cp" placeholder="Code Postal"><span
							class="erreur">${inscrire.erreurs['cp']}</span>
					</div>
					<div class="form-group fg">
						<input type="email" name="email" class="form-control"
							id="exampleInputEmail" placeholder="Email"><span
							class="erreur">${inscrire.erreurs['email']}</span>
					</div>
					<div class="form-group fg">
						<input type="text" name="tel" class="form-control"
							id="exampleInputEmail" placeholder="Numéro de téléphone"><span
							class="erreur">${inscrire.erreurs['tel']}</span>
					</div>
					<div class="form-group fg">
						<input type="password" class="form-control"
							id="exampleInputPassword1" name="password"
							placeholder="Mot de passe"><span class="erreur">${inscrire.erreurs['password']}</span>
					</div>

					<div class="form-group fg">
						<input type="password" class="form-control"
							id="exampleInputPassword1" name="confirmation"
							placeholder="Confirmation"><span class="erreur">${inscrire.erreurs['confirmation']}</span>
					</div>
				
					<button type="submit" class="btn btn-primary fg">Envoyer Mail et Valider</button>
					
		
  	</div>
			</form>
			
		
		</div>
	</div>

</body>


<div class="leftmenu">
<%@include file="/footer.jsp" %>
</div>


</html>