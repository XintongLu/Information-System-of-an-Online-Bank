<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- CSS -->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="./css/header.css">

<link rel="stylesheet" type="text/css" href="./css/animation.css">
   
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.css">





<!-- Script -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        
        			
        <script>
        jQuery(function ($) {

            $(".sidebar-dropdown > a").click(function() {
          $(".sidebar-submenu").slideUp(200);
          if (
            $(this)
              .parent()
              .hasClass("active")
          ) {
            $(".sidebar-dropdown").removeClass("active");
            $(this)
              .parent()
              .removeClass("active");
          } else {
            $(".sidebar-dropdown").removeClass("active");
            $(this)
              .next(".sidebar-submenu")
              .slideDown(200);
            $(this)
              .parent()
              .addClass("active");
          }
        });

        $("#close-sidebar").click(function() {
          $(".page-wrapper").removeClass("toggled");
        });
        $("#show-sidebar").click(function() {
          $(".page-wrapper").addClass("toggled");
        });           
        });
        </script>
        
</head>


<body>
<%@include file="/Header/HeaderClient.jsp"%>
<div class="page-wrapper chiller-theme toggled">
<div class ="row">
  <nav id="sidebar" class="col-md-2 sidebar-wrapper">

    <div class="sidebar-content">
      <div class="sidebar-header">

        <div class="user-info">
          <span class="user-name">${sessionScope.sessionClient.prenom}
            <strong>${sessionScope.sessionClient.nom}</strong>
          </span>
          <span class="user-role">Client</span>
          <span class="user-status">
            <i class="fa fa-circle"></i>
            <span>En ligne</span><br>
          </span><br>
        </div><br>
        
       <br> <img src="./assets/images/acc2.jpg" class="img-thumbnail">
        
      </div>
      <!-- sidebar-header  -->
      <!-- sidebar-search  -->
      <div class="sidebar-menu">
        <ul>
          <li class="header-menu">
            <span>Mes comptes</span>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <i class="fas fa-euro-sign"></i>
              <span>Courant</span>
            </a>
            <div class="sidebar-submenu">
              <ul>
                <li>
                  <a href="/Projet_S8/ServletAlimenter">Alimenter
                  </a>
                </li>
              </ul>
            </div>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <i class="fas fa-piggy-bank"></i>
              <span>Epargne</span>
            </a>
            <div class="sidebar-submenu">
              <ul>
                <li>
                  <a href="/Projet_S8/ServletAlimenterEpargne">Alimenter
                  </a>
                </li>
              </ul>
            </div>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <i class="fas fa-chart-line"></i>
              <span>Titre</span>
            </a>
            <div class="sidebar-submenu">
              <ul>
                 <li>
                  <a href="/Projet_S8/Actions/coursAvecEpargne.jsp">Bourse</a>
                </li>
                <li>
                  <a href="/Projet_S8/ServletRecupererActions">Acheter des actions</a>
                </li>
                <li>
                  <a href="/Projet_S8/ServletAfficherActions">Vendre des actions</a>
                </li>
              </ul>
            </div>
          </li>
          <li class="header-menu">
            <span>Virements</span>
          </li>
          <li class="sidebar-dropdown">
  
            <a href="#">
              <i class="fas fa-external-link-alt"></i>
              <span>Virement externe</span>
            </a>
            <div class="sidebar-submenu">
              <ul>
                <li>
                  <a href="/Projet_S8/AjouterBeneficiaire">Ajouter bénéficaire</a>
                </li>
                <li>
                  <a href="/Projet_S8/VirementExterne">Mes bénéficaires</a>
                </li>    
              </ul>
            </div>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <i class="fas fa-sign-in-alt"></i>
              <span>Virement interne</span>
            </a>
            <div class="sidebar-submenu">
              <ul>
                <li>
                  <a href="/Projet_S8/VirementInterneEpargneVersCourant">Epargne vers Courant</a>
                </li>
              </ul>
            </div>
          </li>
          <li class="header-menu">
            <span>Mes transactions</span>
          </li>
          <li>
            <a href="/Projet_S8/HitoriqueTransaction">
              <i class="fa fa-book"></i>
              <span>Historique</span>
            </a>
          </li>
                    <li>
            <a href="#">
             
            </a>
          </li>
                    <li>
            <a href="#">
              
            </a>
          </li>
                    <li>
            <a href="#">
          
            </a>
          </li>
                    <li>
            <a href="#">
         
            </a>
          </li>
                    <li>
            <a href="#">
           
            </a>
          </li>
                    <li>
            <a href="#">
              
              <span></span>
            </a>
          </li>
        </ul>
      </div>
      </div>
      
      </nav>	


</body>

</html>