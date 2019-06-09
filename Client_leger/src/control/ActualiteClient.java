package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Actualite;
import model.DAOActualite;

/**
 * Servlet implementation class ServletActu
 */
@WebServlet("/ActualiteClient")
public class ActualiteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String titre = null;
	
    public ActualiteClient() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		titre = request.getParameter("titre");
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOActualite daoactu = new DAOActualite();
		ArrayList<Actualite> actu = daoactu.afficherActu();	 	
		ArrayList<Actualite> actuRecherche = daoactu.rechercherActu(titre);

		if(titre!=null) {
		request.setAttribute("actu", actuRecherche);
		}
		else {
			request.setAttribute("actu", actu);
		}
		this.getServletContext().getRequestDispatcher("/Actualité/ActualiteClient.jsp").forward(request,response);
		//doGet(request,response);
	}

}
