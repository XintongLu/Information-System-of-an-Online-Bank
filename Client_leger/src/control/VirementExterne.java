package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Beneficiaire;
import beans.Client;
import model.DaoAjouterBenef;
import model.DaoClient;
import model.DaoEpargne;
import model.DaoTitre;
import objetMetier.MetierAjouterBenef;

/**
 * Servlet implementation class VirementExterne
 */
@WebServlet("/VirementExterne")
public class VirementExterne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VirementExterne() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// On ecrit dans le bean beneficaire via la classe metiert);

		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient"); // On recupere le client en session
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		DaoAjouterBenef daoAjouter = new DaoAjouterBenef();


		// On recupere l'id du client en session
		int id = dao.trouverId(client.getLogin());

		// On regarde si le client en session possède un compte épargne ou non
		int idEpargne = daoEpargne.trouverIdEpargne(id);
		
		request.setAttribute("listIban", daoAjouter.getlistIban(id));
		request.setAttribute("listNom", daoAjouter.getListNom(id));
		/*request.setAttribute("nom", daoAjouter.getNom(id));
		request.setAttribute("iban", daoAjouter.getIban(id));
		System.out.println(daoAjouter.getIban(id));*/
		DaoTitre daoTitre = new DaoTitre();
		int idTitre = daoTitre.trouverIdTitre(id);
		
		
		if (idEpargne != 0) {
			if (idTitre != 0) {
				this.getServletContext().getRequestDispatcher("/VirementExterne/VirementExterneAvecEpargneAvecTitre.jsp")
						.forward(request, response); // Avec Epargne + avec titre **
			} else {
				this.getServletContext().getRequestDispatcher("/VirementExterne/VirementExterneAvecEpargneSansTitre.jsp").forward(request,
						response); //Avec Epargne + Sans titre
			}
		} else {
			if (idTitre != 0) {
				this.getServletContext().getRequestDispatcher("/VirementExterne/VirementExterneSansEpargneAvecTitre.jsp")
						.forward(request, response); // Sans Epargne + avec titre ** 
			} else {

				this.getServletContext().getRequestDispatcher("/VirementExterne/VirementExterneSansEpargneSansTitre.jsp").forward(request,
						response); //Sans Epargne + Sans titre
			}
		}

	}

}
