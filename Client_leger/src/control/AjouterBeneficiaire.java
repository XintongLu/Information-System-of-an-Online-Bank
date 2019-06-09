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


@WebServlet("/AjouterBeneficiaire")
public class AjouterBeneficiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjouterBeneficiaire() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MetierAjouterBenef ajouter = new MetierAjouterBenef();
		
		// On ecrit dans le bean beneficaire via la classe metier
		Beneficiaire benef = ajouter.ajouterBenef(request);

		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient"); // On recupere le client en session
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		

		DaoAjouterBenef daoAjouter = new DaoAjouterBenef();

		// On recupere l'id du client en session
		int id = dao.trouverId(client.getLogin());//69++954+zerzergh
		
		
		// On stocke l'id du client en session
		
		//On regarde si le client en session possède un compte épargne ou non 
		int idEpargne = daoEpargne.trouverIdEpargne(id);
		System.out.println(idEpargne);
		request.setAttribute("ajouter", ajouter);
		request.setAttribute("benef", benef);

		DaoTitre daoTitre = new DaoTitre();
		int idTitre = daoTitre.trouverIdTitre(id);
		if (ajouter.getErreurs().isEmpty()) {
			
			
			
			if (idEpargne != 0) {
				if (idTitre != 0) {
					System.out.println("Avec Epargne + avec titre *");
					this.getServletContext().getRequestDispatcher("/VirementExterne/AjouterBenefAvecEpargneAvecTitre.jsp")
							.forward(request, response);
					System.out.println("je suis ici");// Avec Epargne + avec titre **
				} else {
					System.out.println("Avec Epargne + Sans titre *");
					this.getServletContext().getRequestDispatcher("/VirementExterne/AjouterBenefAvecEpargneSansTitre.jsp").forward(request,
							response); //Avec Epargne + Sans titre
				}
			} else {
				System.out.println("ASans Epargne + avec titre  *");
				if (idTitre != 0) {
					this.getServletContext().getRequestDispatcher("/VirementExterne/AjouterBenefSansEpargneAvecTitre.jsp")
							.forward(request, response); // Sans Epargne + avec titre ** 
				} else {
					System.out.println("Sans Epargne + Sans titre");
					this.getServletContext().getRequestDispatcher("/VirementExterne/AjouterBenefSansEpargneSansTitre.jsp").forward(request,
							response); //Sans Epargne + Sans titre
				}
			}
			
			
			
		}
		else {
			if (idEpargne != 0) {
				if (idTitre != 0) {
					System.out.println("Avec Epargne + avec titre *");
					this.getServletContext().getRequestDispatcher("/VirementExterne/AjouterBenefAvecEpargneAvecTitre.jsp")
							.forward(request, response);
					System.out.println("je suis ici");// Avec Epargne + avec titre **
				} else {
					System.out.println("Avec Epargne + Sans titre *");
					this.getServletContext().getRequestDispatcher("/VirementExterne/AjouterBenefAvecEpargneSansTitre.jsp").forward(request,
							response); //Avec Epargne + Sans titre
				}
			} else {
				System.out.println("ASans Epargne + avec titre  *");
				if (idTitre != 0) {
					this.getServletContext().getRequestDispatcher("/VirementExterne/AjouterBenefSansEpargneAvecTitre.jsp")
							.forward(request, response); // Sans Epargne + avec titre ** 
				} else {
					System.out.println("Sans Epargne + Sans titre");
					this.getServletContext().getRequestDispatcher("/VirementExterne/AjouterBenefSansEpargneSansTitre.jsp").forward(request,
							response); //Sans Epargne + Sans titre
				}
			}
		}
		
	}

}
