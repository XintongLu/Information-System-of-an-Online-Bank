<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Bank - Services Détails</title>
<link rel="stylesheet" href="/css/main.css" />
</head>
<body>

	<%@include file="/Header/HeaderClient.jsp"%>

	<section class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">

					<c:forEach items="${service}" var="service">
						<div class="jumbotron jumbotron bg-transparent">
							<h2 class="display-4 text-align text-center">
								<c:out value="${service.titre}" />
							</h2>

							<div class="box">
								<div class="container">
									<div class="col-md-12 px-0">
									</div>
									<hr>
								</div>
								<br />
								<p style="color: black;">
									<c:out value="${service.contenu}" />
								</p>
								<br />

							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	
	</section>


	<%@include file="/footer.jsp"%>
</body>
</html>