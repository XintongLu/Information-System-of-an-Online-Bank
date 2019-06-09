package control;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import beans.Client;
import model.DaoAlimenter;
import model.DaoClient;
import model.DaoEpargne;
import model.DaoHistoConn;
import model.DaoHistoDeconn;
import objetMetier.metierConnexion;

/**
 * Servlet implementation class Deco
 */
@WebServlet("/Deco")
public class Deco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String URL_REDIRECTION = "http://localhost:8080/Projet_S8/Home/homeVisiteur.jsp";
    static final Logger infoUser = Logger.getLogger("info");

	public Deco() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Récupération et destruction de la session en cours  */
		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient");

		String login =  client.getLogin();
		DaoHistoDeconn daoHisto = new DaoHistoDeconn();
		DaoClient daoClient = new DaoClient();
	    LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
        /* On defenit les elements de la fonctions ajouterConnexion*/
        int idClient = daoClient.trouverId(login);
        String date = now.format(formatter); // retourne la date a laquelle le client s'est connecté
        String etat = "Deconnecté";
        System.out.println(login);
        
        /* On récupère l'adresse IP du client */
        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
        if (ipAddress == null) {  
            ipAddress = request.getRemoteAddr();  
        }
        
        /* On écrit dans la table HistoConn qui permet de recuperer l'historique de connexion pour un admin*/
        daoHisto.ajouterConnexion(idClient, login, ipAddress, etat, date);
        
        /* On écrit dans le fichier log */
        infoUser.info("L'utilisateur n°"+ idClient + " : " + login + " vient de se deconnecter - Adresse IP : " + ipAddress);
	    
		session.invalidate();

		/* Redirection vers le Site du Zéro ! */
		response.sendRedirect(URL_REDIRECTION);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
