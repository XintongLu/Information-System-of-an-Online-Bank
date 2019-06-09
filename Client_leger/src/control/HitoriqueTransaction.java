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
import objetMetier.metierAlimenter;

@WebServlet("/HitoriqueTransaction")
public class HitoriqueTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HitoriqueTransaction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient");
		DaoClient dao = new DaoClient();
		DaoAlimenter daoAlimenter = new DaoAlimenter();
		DaoEpargne daoEpargne = new DaoEpargne();
		int id = dao.trouverId(client.getLogin());
		int idEpargne = daoEpargne.trouverIdEpargne(id);
		
		
		request.setAttribute("listBenef", 			daoAlimenter.getListBeneficiaire(id));
		request.setAttribute("listMontant", 		daoAlimenter.getListMontant(id));
		request.setAttribute("listMoeyn", 			daoAlimenter.getListMoyen(id));
		request.setAttribute("listeDescription", 	daoAlimenter.getListDescription(id));
		request.setAttribute("listDate", 			daoAlimenter.getListDate(id));
		
		
		
		
		System.out.println(daoAlimenter.getListBeneficiaire(id));
		System.out.println(daoAlimenter.getListMontant(id));
		System.out.println(daoAlimenter.getListMoyen(id));
		System.out.println(daoAlimenter.getListDescription(id));
		System.out.println(daoAlimenter.getListDate(id));
		DaoTitre daoTitre = new DaoTitre();
		int idTitre = daoTitre.trouverIdTitre(id);
		
		
		
		if (idEpargne != 0) {
			if (idTitre != 0) {
				this.getServletContext().getRequestDispatcher("/HistoriqueTransaction/HistoAvecEpargneAvecTitre.jsp")
						.forward(request, response); // Avec Epargne + avec titre **
			} else {
				this.getServletContext().getRequestDispatcher("/HistoriqueTransaction/HistoAvecEpargneSansTitre.jsp").forward(request,
						response); //Avec Epargne + Sans titre
			}
		} else {
			if (idTitre != 0) {
				this.getServletContext().getRequestDispatcher("/HistoriqueTransaction/HistoSansEpargneAvecTitre.jsp")
						.forward(request, response); // Sans Epargne + avec titre ** 
			} else {

				this.getServletContext().getRequestDispatcher("/HistoriqueTransaction/HistoSansEpargneSansTitre.jsp").forward(request,
						response); //Sans Epargne + Sans titre
			}
		}
		

	}
}
