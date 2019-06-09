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
<%@include file="/Header/HeaderAdmin.jsp" %>

<div class="jumbotron jumbotron bg-transparent text-center">
	<h1 class="display-4">Messagerie</h1>
	<p class="lead"></p>
	<hr class="my-4">
	<p class="lead">Répondez via mail ou téléphone suivant la demande
		de l'utilisateur</p>

	<br> <br> <br>
	<table class="table">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">#</th>
				<th scope="col">Nom</th>
				<th scope="col">Prénom</th>
				<th scope="col">Sujet</th>
				<th scope="col">Réponse</th>
			</tr>
		</thead>
		<c:forEach items="${listId}" var="id" varStatus="status">
			<tbody>
				<tr>
					<th scope="row"></th>
					<td><b> <c:out value="${id}" /></b></td>
					<td><a href="<c:url value="http://localhost:8080/Projet_S8/MessageDetaille?id=${id}"/>">
					<font color="black"><c:out value="${listNoms[status.index]}" /></font></a></td>
					<td><c:out value="${listPrenom[status.index]}" /></td>
					<td><c:out value="${listSujets[status.index]}" /></td>
					<td><c:out value="${listReponse[status.index]}" /></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>
<body>

	<%@include file="/footer.jsp"%>