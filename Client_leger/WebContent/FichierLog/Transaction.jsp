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
		<h1 class="display-3">FICHIERS LOGS - TRANSACTIONS</h1>
		<br> <br> <a href="/Projet_S8/fichiers/log.txt"><i class="fas fa-download"></i> Télécharger
			fichier log des transactions</a>
		<hr size=100 align=center width="100%">

		<br> <br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="table-wrapper-scroll-y my-custom-scrollbar">
				<table
					class="table table-hover table-bordered mb-5">
			<tfoot>
					<tr>
						<td colspan="15"><a
							href="http://localhost:8080/Projet_S8/FichierLogTransaction"
							type="button" class="btn btn-link">ENREGISTRER</a></td>
						<td></td>
					</tr>
				</tfoot>
					<thead>
						<tr>
							<!--  <th scope="col"></th>-->
											<th>LOGIN</th>
											<th>MOYEN</th>
											<th>DATE</th>
											<th>MONTANT</th>
											<th>DESCRIPTION</th>
										</tr>
									</thead>
									<c:forEach items="${transactions}" var="transactions">
										<tr>
											<!-- 	<td><b> <c:out value="${id}" /></b></td> -->
											<td><font color="black"><c:out
														value="${transactions.login}" /></font></td>
											<td><c:out value="${transactions.moyen}" /></td>
											<td><c:out value="${transactions.dateVir}" /></td>
											<td><c:out value="${transactions.montant}" /></td>
											<td><c:out value="${transactions.description}" /></td>
										</tr>
									</c:forEach>
							
					</tbody>
				</table>

			</div>
		</div>
	</div>
<body>

	<%@include file="/footer.jsp"%>