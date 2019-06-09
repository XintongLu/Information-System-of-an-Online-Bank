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
			<br> 
			<h2>Cours de la bourse</h2>
		<div class="col-md-8">
			<br> <br>
			<iframe
				src="https://widgets2.rt.prorealtime.com/ProRealTime_HTML5XLight/itcharts.phtml?wid=2019881841&k=25375675fb005d46d69cda7bb77b73af"
				height="400" width="700" frameborder="0" scrolling="no"></iframe>
		</div>
			
		
		</div>
	</div>

</body>


<div class="leftmenu">
<%@include file="/footer.jsp" %>
</div>


</html>