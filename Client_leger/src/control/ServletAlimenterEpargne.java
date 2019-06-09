/**
 * 
 */
package control;

import java.io.IOException;
import com.itextpdf.text.Element;

import beans.Alimenter;
import beans.Client;
import model.DaoAlimenter;
import model.DaoClient;

import model.DaoTitre;
import objetMetier.metierAlimenterEpargne;


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
@WebServlet("/ServletAlimenterEpargne")
public class ServletAlimenterEpargne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public ServletAlimenterEpargne() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		metierAlimenterEpargne epargner=new metierAlimenterEpargne();
		
		Alimenter alimente = epargner.alimenterCompteEpargne(request);
		
		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient");
		DaoClient dao = new DaoClient();
	
		DaoAlimenter daoAlimenter = new DaoAlimenter();
		DaoTitre daoTitre = new DaoTitre();
		
		
		// On stocke l'id du client en session
		int id = dao.trouverId(client.getLogin());
		
	
		
		//On regarde si le client en session poss�de un compte titre ou non 
		int idTitre = daoTitre.trouverIdTitre(id);

		// A chaque fois que le compte est aliment� on fait appel a ces methodes pour mettre les extraits a jour
		daoAlimenter.exportHistorique(id);
		daoAlimenter.exportHistoriquePDF();

		request.setAttribute("epargner", epargner);
		request.setAttribute("alimente", alimente);

		if (epargner.getErreurs().isEmpty()) {
			response.sendRedirect( "/Projet_S8/ServletCompte" );

		} else {
			if (idTitre != 0) {

				this.getServletContext().getRequestDispatcher("/Transaction/AlimenterEpargneAvecTitre.jsp").forward(request, response);
			} else {
				this.getServletContext().getRequestDispatcher("/Transaction/AlimenterEpargne.jsp").forward(request, response);
			}
			
		}

	}
}