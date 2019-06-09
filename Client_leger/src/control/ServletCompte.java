/**
 * 
 */
package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import model.DaoClient;
import model.DaoEpargne;
import model.DaoTitre;

/**
 * @author myrthacomlan
 *
 */
@WebServlet("/ServletCompte")
public class ServletCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCompte() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		DaoTitre daoTitre = new DaoTitre();
		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient");
		int id = dao.trouverId(client.getLogin());
		int idEpargne = daoEpargne.trouverIdEpargne(id);
		int idTitre = daoTitre.trouverIdTitre(id);
		
		float soldeEpargne = daoEpargne.trouverSoldeEpargne(idEpargne);
		float soldeTitre = daoTitre.trouverSoldeTitre(idTitre);

		if (idEpargne != 0) {
			session.setAttribute("soldeEpargne", soldeEpargne);
			if (idTitre != 0) {
				session.setAttribute("soldeTitre", soldeTitre);
				this.getServletContext().getRequestDispatcher("/GererCompte/CompteAvecEpargneAvecTitre.jsp")
						.forward(request, response);
			} else {
				this.getServletContext().getRequestDispatcher("/GererCompte/CompteAvecEpargne.jsp").forward(request,
						response);
			}
		} else {
			if (idTitre != 0) {
				session.setAttribute("soldeTitre", soldeTitre);
				this.getServletContext().getRequestDispatcher("/GererCompte/CompteSansEpargneAvecTitre.jsp")
						.forward(request, response);
			} else {

				this.getServletContext().getRequestDispatcher("/GererCompte/CompteSansEpargne.jsp").forward(request,
						response);
			}
		}

	}

}
