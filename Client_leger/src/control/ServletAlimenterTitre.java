/**
 * 
 */
package control;

import java.io.IOException;


import beans.Alimenter;
import beans.Client;
import model.DaoAlimenter;
import model.DaoClient;
import model.DaoEpargne;

import objetMetier.metierAlimenterTitre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author myrthacomlan
 *
 */
@WebServlet("/ServletAlimenterTitre")
public class ServletAlimenterTitre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public ServletAlimenterTitre() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		metierAlimenterTitre titre= new metierAlimenterTitre();
		Alimenter alimente= titre.alimenterCompteTitre(request);
		
	
		
		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient");
		DaoClient dao = new DaoClient();
	
		DaoAlimenter daoAlimenter = new DaoAlimenter();
	
		DaoEpargne daoEpargne= new DaoEpargne();
		
		
		// On stocke l'id du client en session
		int id = dao.trouverId(client.getLogin());
		
	
		
		//On regarde si le client en session poss�de un compte epargne ou non 
		int idEpargne = daoEpargne.trouverIdEpargne(id);

		// A chaque fois que le compte est aliment� on fait appel a ces methodes pour mettre les extraits a jour
		daoAlimenter.exportHistorique(id);
		daoAlimenter.exportHistoriquePDF();

		request.setAttribute("titre", titre);
		request.setAttribute("alimente", alimente);

		if (titre.getErreurs().isEmpty()) {
			response.sendRedirect( "/Projet_S8/ServletCompte" );

		} else {
			if (idEpargne != 0) {

				this.getServletContext().getRequestDispatcher("/Transaction/AlimenterTitreAvecEpargne.jsp").forward(request, response);
			} else {
				this.getServletContext().getRequestDispatcher("/Transaction/AlimenterTitre.jsp").forward(request, response);
			}
			
		}

	}
}