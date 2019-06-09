<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css"
	integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX"
	crossorigin="anonymous">
	
	
<style>
/* Style the navigation bar */
.navbar {
  width: 100%;
  background-color: #555;
  overflow: auto;
  margin-bottom: 0 !important;
border: 0 !important;
}

/* Navbar links */
.navbar a {
  float: left;
  text-align: center;
  padding: 12px;
  color: white;
  text-decoration: none;
  font-size: 17px;
}

/* Navbar links on mouse-over */
.navbar a:hover {
  background-color: #000;
}


/* Add responsiveness - will automatically display the navbar vertically instead of horizontally on screens less than 500 pixels */
@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
  }
}
</style>

<title>Insert title here</title>
</head>
<body>
<div class="navbar">
  <a class="active" href="http://localhost:8080/Projet_S8/Home/HomeAdmin.jsp"><i class="fa fa-fw fa-home"></i> Accueil </a> 
  <a href="http://localhost:8080/Projet_S8/AffichageMessage"><i class="fa fa-fw fa-envelope"></i> Mes messages</a> 
    <a href="http://localhost:8080/Projet_S8/ServRecupererTransactions"><i class="fa fa-download" aria-hidden="true"></i>Transaction</a>
     <a href="http://localhost:8080/Projet_S8/FichierLogInfo"><i class="fa fa-download" aria-hidden="true"></i>Connexions</a>
  
  <!--  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-download" aria-hidden="true"></i> Fichiers Logs</a> 
  
      <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
        <a class="dropdown-item" href="http://localhost:8080/Projet_S8/ServRecupererTransactions">Connexion</a>
        <a class="dropdown-item" href="#">Transaction</a>
      </div>-->
<a href="http://localhost:8080/Projet_S8/DecoAdmin"><i class="fa fa-fw fa-user"></i> Deconnexion</a>
 
</div>


</body>
</html>