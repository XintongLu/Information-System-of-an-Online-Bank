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
import objetMetier.MetierVirementExterne;
import objetMetier.metierAlimenterEpargne;


@WebServlet("/VirementExterneAlimenter")
public class VirementExterneAlimenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";
	
    public VirementExterneAlimenter() {
        super();
    }

    public String getNom(HttpServletRequest request) {
    	String nom	= (String) request.getParameter("nom");
    	System.out.println("kaaka" + nom);
    	return nom;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MetierVirementExterne alimenter=new MetierVirementExterne();
		String nom	= (String) request.getParameter("nom");
		System.out.println("lolilol " + nom);
		Alimenter alimente = alimenter.AlimenterExterne(request);
		
		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient");
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		DaoAlimenter daoAlimenter = new DaoAlimenter();

		
		// On stocke l'id du client en session
		int id = dao.trouverId(client.getLogin());
		
		//On regarde si le client en session possède un compte épargne ou non 
		int idEpargne = daoEpargne.trouverIdEpargne(id);

		// A chaque fois que le compte est alimenté on fait appel a ces methodes pour mettre les extraits a jour
		daoAlimenter.exportHistorique(id);
		daoAlimenter.exportHistoriquePDF();
		
		request.setAttribute("epargner", alimenter);
		request.setAttribute("alimente", alimente);

		if (alimenter.getErreurs().isEmpty()) {
			response.sendRedirect( "/Projet_S8/ServletCompte" );

		} else {
			this.getServletContext().getRequestDispatcher("/Transaction/AlimenterEpargne.jsp").forward(request, response);
		}
		
		
	
	}

}
