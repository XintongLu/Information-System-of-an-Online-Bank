package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Admin;
import beans.Client;
import objetMetier.MetierConnexionAdmin;
import objetMetier.metierConnexion;


@WebServlet("/FormulaireConnexionAdmin")
public class FormulaireConnexionAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    public static final String ATT_SESSION_USER = "sessionAdmin";

    public FormulaireConnexionAdmin() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Connexion/ConnexcionAsAdmin.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MetierConnexionAdmin connexion = new MetierConnexionAdmin();
		Admin admin = connexion.connecterAdmin(request);
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( connexion.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, admin );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }
        Admin sessionAdmin = (Admin) session.getAttribute( ATT_SESSION_USER );
        request.setAttribute( "sessionAdmin", sessionAdmin );
        request.setAttribute( "connexion", connexion );
        request.setAttribute( "admin", admin );
											
		doGet(request, response);
	}

}
