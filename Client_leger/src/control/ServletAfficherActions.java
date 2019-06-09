/**
 * 
 */
package control;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Actions;
import beans.Client;
import model.DaoActions;
import model.DaoClient;
import model.DaoEpargne;
import objetMetier.metierRecupererActions;


/**
 * @author myrthacomlan
 *
 */

@WebServlet("/ServletAfficherActions")
public class ServletAfficherActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id_client= 0;
	
    public ServletAfficherActions() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient");
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();

		id_client = dao.trouverId(client.getLogin());
		
		int idEpargne = daoEpargne.trouverIdEpargne(id_client);
		DaoActions daoActions=new DaoActions();
		ArrayList<Actions> actions =daoActions.afficherAction(id_client);
		
			request.setAttribute("actions", actions);
			
				
				if(idEpargne!=0) 
				{
					this.getServletContext().getRequestDispatcher("/Actions/vendreAvecEpargne.jsp").forward(request,response);
				}
				else {
					this.getServletContext().getRequestDispatcher("/Actions/vendreSansEpargne.jsp").forward(request,response);
				}
		 
	}

}