<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Messages</title>
</head>
				<c:if test="${empty sessionAdmin}">
					<c:redirect url="http://localhost:8080/Projet_S8/FormulaireConnexion"/>
				</c:if>
<%@include file="/Header/HeaderAdmin.jsp"%>

<div class="row">
	<!-- Grid column -->
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<br> <br> <br>



		<div class="card px-5">

			<div class="card-body px-5">
				<h3 class="text-center default-text py-3">
					<i class="fas fa-envelope"></i> Message Détaillé :
					
				</h3>
			</div>
			<h4>Informations de la personne</h4>
			<b>Prenom :</b> ${prenom } <br><br> 
			<b>Nom : </b>${nom } <br> <br> 
			<b>Civilité :</b> ${civilite } <br><br>  <br>
			
			
			<h4>Coordonnées de la personne</h4>  
			<b>Téléphone :</b> ${tel } <br><br> 
			<b>E-mail : </b>${email } <br> <br> 
			<b>Adresse :</b> ${adresse }, ${cp }, ${ville },
			${pays } <br> <br> <br> 
			
			<h4>Contenu du message </h4> 
			<b>Sujet :</b>${sujet } <br> <br> 
			<b>Message :</b> ${message } <br><br> 
			<b>Répondre par :</b> ${reponse } <br> <br> <br> 
			
			<div class="text-center">
				<a href="https://mail.google.com/mail/u/0/#inbox?compose=new">Répondre par mail ici</a>
			</div>
			<br> <br> <br>
		</div>
	</div>


</div>


<%@include file="/footer.jsp"%>