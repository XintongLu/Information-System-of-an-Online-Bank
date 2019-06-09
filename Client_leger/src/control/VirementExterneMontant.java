package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import model.DaoAjouterBenef;
import model.DaoClient;
import model.DaoEpargne;
import model.DaoTitre;

/**
 * Servlet implementation class VirementExterneMontant
 */
@WebServlet("/VirementExterneMontant")
public class VirementExterneMontant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VirementExterneMontant() {
        super();

    }


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On recupêre le nom et l'iban du beneficiaire qui sont passés en parametre de l'url
		String nom	= (String)request.getParameter("nom");
		String iban	= (String)request.getParameter("iban");
		System.out.println("servlet :" + nom+ iban);
		//Activation de la session
		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient"); // On recupere le client en session
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		
		// On recupere l'id du client en session
		int id = dao.trouverId(client.getLogin());

		// On regarde si le client en session possède un compte épargne ou non
		int idEpargne = daoEpargne.trouverIdEpargne(id);
		
		request.setAttribute("nom", nom);
		request.setAttribute("iban", iban);
		
		
		DaoTitre daoTitre = new DaoTitre();
		int idTitre = daoTitre.trouverIdTitre(id);
		
		
		if (idEpargne != 0) {
			if (idTitre != 0) {
				this.getServletContext().getRequestDispatcher("/VirementExterne/VirementExterneMontantAvecEpargneAvecTitre.jsp")
						.forward(request, response); // Avec Epargne + avec titre **
			} else {
				this.getServletContext().getRequestDispatcher("/VirementExterne/VirementExterneMontantAvecEpargneSansTitre.jsp").forward(request,
						response); //Avec Epargne + Sans titre
			}
		} else {
			if (idTitre != 0) {
				this.getServletContext().getRequestDispatcher("/VirementExterne/VirementExterneMontantSansEpargneAvecTitre.jsp")
						.forward(request, response); // Sans Epargne + avec titre ** 
			} else {

				this.getServletContext().getRequestDispatcher("/VirementExterne/VirementExterneMontantSansEpargneSansTitre.jsp").forward(request,
						response); //Sans Epargne + Sans titre
			}
		}
		
		
		
	}
	
	
	
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
