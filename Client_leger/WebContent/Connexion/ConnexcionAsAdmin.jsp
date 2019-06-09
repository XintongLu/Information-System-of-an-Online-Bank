<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Connexion - Admin</title>
</head>
<%@include file="/Header/header.jsp"%>

<style>
@import
	url(https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css)
	;

@import
	url(https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.3/css/mdb.min.css)
	;
</style>

<!------ Include the above in your HEAD tag ---------->
<div class="container mt-4">


	<!-- Grid row -->
	<div class="row">
		<!-- Grid column -->
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<br> <br> <br>
			<form method="post">
				<div class="card">

					<div class="card-body px-5">
						<h3 class="text-center default-text py-3">
							<i class="fa fa-lock"></i> Administrateur :
						</h3>
						<!--Body-->
						<div class="md-form">
							<i class="fa fa-envelope prefix grey-text"></i> <input
								type="text" id="defaultForm-email" class="form-control"
								name="login" placeholder="Identifiant">

						</div>
						<div class="md-form">
							<i class="fa fa-lock prefix grey-text"></i> <input
								type="password" id="defaultForm-pass" class="form-control"
								name="password" placeholder="Mot de passe">
						</div>

						<div class="text-center">
							<button class="btn btn-default waves-effect waves-light"
								type="submit">Valider</button>
						</div>


					</div>
				</div>
				<br> <br> <br> <br>
				<div><p class="${empty connexion.erreurs ? 'succes' : 'erreur'}">
				</div>

				<c:if test="${!empty sessionScope.sessionAdmin}">
					<c:redirect url="/Home/HomeAdmin.jsp"/>
				</c:if>
			</form>
		</div>
	</div>
</div>
<%@include file="/footer.jsp"%>
</body>


</html>




<!-- Grid column -->
