
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

@WebServlet("/ServletRecupererActions")
public class ServletRecupererActions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ServletRecupererActions() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		metierRecupererActions recuperer =  new metierRecupererActions ();
		ArrayList <Actions> array= new ArrayList <Actions>();
		array.addAll(recuperer.actions());
		HttpSession session = request.getSession(true);
		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		DaoActions daoActions= new DaoActions();
		
		Client client = (Client) session.getAttribute("sessionClient");
		int id = dao.trouverId(client.getLogin());
		
		int idEpargne = daoEpargne.trouverIdEpargne(id);
		
		 for(int i=0; i<40;i++)
         {
			 daoActions.updateDernier(array.get(i).getNom(), id, array.get(i).getDernier());
         }
			
    	//Object tab [][]=recuperer.getBody();
    	
			request.setAttribute("array", array);
			
			if(idEpargne!=0)
			{
				this.getServletContext().getRequestDispatcher("/Actions/acheterAvecEpargne.jsp").forward(request,response);
			}
			else {
				this.getServletContext().getRequestDispatcher("/Actions/acheterSansEpargne.jsp").forward(request,response);
			}
	
	
		
	}

}