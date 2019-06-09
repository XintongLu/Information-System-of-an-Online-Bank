package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Alimenter;
import beans.Client;
import model.DaoAlimenter;
import model.DaoClient;
import model.DaoEpargne;
import model.DaoTitre;
import objetMetier.MetierVirementInterneEpargneVersTitre;
import objetMetier.MetierVirementInterneTitreVersCourant;
import objetMetier.MetierVirementInterneTitreVersEpargne;

/**
 * Servlet implementation class VirementInterneEpargneVersCourant
 */
@WebServlet("/VirementInterneEpargneVersTitre")
public class VirementInterneEpargneVersTitre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public VirementInterneEpargneVersTitre() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MetierVirementInterneEpargneVersTitre alimenter = new MetierVirementInterneEpargneVersTitre();
		
		// On ecrit dans le bean alimente via la classe metier
		Alimenter alimente = alimenter.alimenterCompte(request);

		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient"); // On recupere le client en session
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		DaoTitre daoTitre = new DaoTitre();
		DaoAlimenter daoAlimenter = new DaoAlimenter();
		
		// On recupere l'id du client en session
		int id = dao.trouverId(client.getLogin());
		
		
		// A chaque fois que le compte est alimenté on fait appel a ces methodes pour mettre les extraits a jour
		daoAlimenter.exportHistorique(id);
		daoAlimenter.exportHistoriquePDF();
		
		// On stocke l'id du client en session
		
		//On regarde si le client en session possède un compte épargne ou non 
		int idEpargne = daoEpargne.trouverIdEpargne(id);
		int idTitre = daoTitre.trouverIdTitre(id);
		//Cette méthode de la classe DaoAlimenter permet d'écrire dans le .csv la nouvelle transaction et ne retrounera que les transaction du client en session

		request.setAttribute("alimenter", alimenter);
		request.setAttribute("alimente", alimente);

		if (idEpargne != 0) {
			if (idTitre != 0) {
				this.getServletContext().getRequestDispatcher("/VirementInterne/VirementInterneEpargneVersTitreAvecEpargneAvecTitre.jsp")
						.forward(request, response); // Avec Epargne + avec titre
			} else {
				this.getServletContext().getRequestDispatcher("/VirementInterne/VirementInterneEpargneVersTitreAvecEpargneSansTitre.jsp").forward(request,
						response); //Avec Epargne + Sans titre
			}
		} else {
			if (idTitre != 0) {
				this.getServletContext().getRequestDispatcher("/VirementInterne/VirementInterneEpargneVersTitreSansEpargneAvecTitre.jsp")
						.forward(request, response); // Sans Epargne + avec titre
			} else {

				this.getServletContext().getRequestDispatcher("/VirementInterne/VirementInterneEpargneVersTitreSansEpargneSansTitre.jsp").forward(request,
						response); //Sans Epargne + Sans titre
			}
		}
		

	}

}
