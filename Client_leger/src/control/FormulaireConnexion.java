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
import model.DaoClient;
import model.DaoHistoConn;
import objetMetier.metierConnexion;
import objetMetier.metierInscription;

@WebServlet("/FormulaireConnexion")
public class FormulaireConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    public static final String ATT_SESSION_USER = "sessionClient";
    static final Logger infoUser = Logger.getLogger("info");
	
       
    public FormulaireConnexion() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Connexion/Connexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		metierConnexion connexion = new metierConnexion();
		Client client = connexion.connecterUtilisateur(request);
		DaoHistoConn daoHisto = new DaoHistoConn();
		DaoClient daoClient = new DaoClient();
	    LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    
		
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        /* On defenit les elements de la fonctions ajouterConnexion*/
        String login = client.getLogin();
        int idClient = daoClient.trouverId(login);
        String etat = connexion.etatConnection(client.getMotdepasse(), login); // Retourne l'etat de la connexion i.i echouee ou reussie
        String date = now.format(formatter); // retourne la date a laquelle le client s'est connecté
        
        
        /* On récupère l'adresse IP du client */
        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
        if (ipAddress == null) {  
            ipAddress = request.getRemoteAddr();  
        }
        
        /* On écrit dans la table HistoConn qui permet de recuperer l'historique de connexion pour un admin*/
        daoHisto.ajouterConnexion(idClient, login, ipAddress, etat, date);
        
        /* On écrit dans le fichier log */
        infoUser.info("L'utilisateur n°"+ idClient + " : " + login + " vient de se connecter - Adresse IP : " + ipAddress + "Etat de la connexion : " + etat);
        
        
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        
        System.out.println(connexion.compteEpargne()); 
        
        if ( connexion.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, client );

   		 if(connexion.compteEpargne()=="oui")
   	        {
   			
   			 session.setAttribute("soldeEpargne", connexion.soldeEpargne(client));
   	        }

        } else {
            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher("/Connexion/Connexion.jsp").forward(request, response);
        }
        Client sessionClient = (Client) session.getAttribute( ATT_SESSION_USER );
        request.setAttribute( "sessionClient", sessionClient );
        request.setAttribute( "connexion", connexion );
        request.setAttribute( "client", client );
        

											
		doGet(request, response);
	}

}
