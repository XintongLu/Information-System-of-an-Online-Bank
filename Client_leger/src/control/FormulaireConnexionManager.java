package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Manager;
import objetMetier.MetierConnexionManager;



@WebServlet("/FormulaireConnexionManager")
public class FormulaireConnexionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    public static final String ATT_SESSION_USER = "sessionManager";

    public FormulaireConnexionManager() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Connexion/ConnexionAsManager.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MetierConnexionManager connexion = new MetierConnexionManager();
		Manager manager = connexion.connecterManager(request);
        /* R閏up閞ation de la session depuis la requ阾e */
        HttpSession session = request.getSession();
        
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur � la session, sinon suppression du bean de la session.
         */
        if ( connexion.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, manager );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }
        Manager sessionManager = (Manager) session.getAttribute( ATT_SESSION_USER );
        request.setAttribute( "sessionManager", sessionManager );
        request.setAttribute( "connexion", connexion );
        request.setAttribute( "manager", manager );
											
		doGet(request, response);
	}

}
