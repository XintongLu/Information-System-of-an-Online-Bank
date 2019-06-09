package control;

import java.io.IOException;
import com.itextpdf.text.Element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.DocumentException;

import beans.Alimenter;
import beans.Client;
import model.DaoAlimenter;
import model.DaoClient;
import model.DaoEpargne;
import model.DaoTitre;
import objetMetier.metierAlimenter;

/**
 * Servlet implementation class Client
 * 
 * @author myrthacomlan
 */
@WebServlet("/ServletAlimenter")
public class ServletAlimenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public ServletAlimenter() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		metierAlimenter alimenter = new metierAlimenter();

		// On ecrit dans le bean alimente via la classe metier
		Alimenter alimente = alimenter.alimenterCompte(request);

		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient"); // On recupere le client en session
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		DaoAlimenter daoAlimenter = new DaoAlimenter();
		DaoTitre daoTitre = new DaoTitre();

		// On recupere l'id du client en session
		int id = dao.trouverId(client.getLogin());

		// A chaque fois que le compte est aliment� on fait appel a ces methodes pour
		// mettre les extraits a jour
		daoAlimenter.exportHistorique(id);
		daoAlimenter.exportHistoriquePDF();

		// On stocke l'id du client en session

		// On regarde si le client en session poss�de un compte �pargne ou non
		int idEpargne = daoEpargne.trouverIdEpargne(id);
		int idTitre = daoTitre.trouverIdTitre(id);

		// Cette m�thode de la classe DaoAlimenter permet d'�crire dans le .csv la
		// nouvelle transaction et ne retrounera que les transaction du client en
		// session

		request.setAttribute("alimenter", alimenter);
		request.setAttribute("alimente", alimente);

		if (alimenter.getErreurs().isEmpty()) {

			response.sendRedirect("/Projet_S8/ServletCompte");
			// this.getServletContext().getRequestDispatcher("/GererCompte/CompteAvecEpargne.jsp").forward(request,
			// response);

		} else {
			if (idEpargne != 0) {

				if (idTitre != 0) {

					this.getServletContext()
							.getRequestDispatcher("/Transaction/AlimenterCourantAvecEpargneAvecTitre.jsp")
							.forward(request, response);
				} else {
					this.getServletContext().getRequestDispatcher("/Transaction/AlimenterCourantAvecEpargne.jsp")
							.forward(request, response);
				}

			} else {

				if (idTitre != 0) {

					this.getServletContext()
							.getRequestDispatcher("/Transaction/AlimenterCourantSansEpargneAvecTitre.jsp")
							.forward(request, response);
				} else {
					this.getServletContext().getRequestDispatcher("/Transaction/AlimenterCourantSansEpargne.jsp")
							.forward(request, response);
				}
			}
		}

	}
}
