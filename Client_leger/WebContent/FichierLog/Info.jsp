<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enregistrer Les Transactions</title>
<style>.my-custom-scrollbar {
position: relative;
height: 400px;
overflow: auto;
}
.table-wrapper-scroll-y {
display: block;
}</style>
</head>


<body class="body">
	<c:if test="${empty sessionAdmin}">
		<c:redirect url="http://localhost:8080/Projet_S8/FormulaireConnexion" />
	</c:if>
	<%@include file="/Header/HeaderAdmin.jsp"%>

	<div class="jumbotron jumbotron bg-transparent text-center ">
		<h1 class="display-3">FICHIERS LOGS - CONNEXIONS</h1>
		<br> <br> <a href="/Projet_S8/fichiers/loginfo.txt"><i class="fas fa-download"></i> Télécharger
			fichier log des connexions</a>
		<hr size=100 align=center width="100%">

		<br> <br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="table-wrapper-scroll-y my-custom-scrollbar">
				<table
					class="table table-hover table-bordered mb-5">

					<thead>
						<tr>
							<!--  <th scope="col"></th>-->
							<th>LOGIN</th>
							<th>ETAT</th>
							<th>DATE</th>
							<th>ADRESSE IP</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listId}" var="transactions" varStatus="status">
							<tr>
								<!-- 	<td><b> <c:out value="${id}" /></b></td> -->
								<td><font color="black"><c:out
											value="${listLogin[status.index]}" /></font></td>
								<td><c:out value="${listEtat[status.index]}" /></td>
								<td><c:out value="${listDate[status.index]}" /></td>
								<td><c:out value="${listIp[status.index]}" /></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>
		</div>
	</div>
<body>

	<%@include file="/footer.jsp"%>