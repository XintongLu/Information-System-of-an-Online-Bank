package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Service;
import model.DAOService;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String titre = null;
  
    public ServiceServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		titre = request.getParameter("titre");
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOService daoserv = new DAOService();
		ArrayList<Service> service = daoserv.afficherService();	 	
		ArrayList<Service> servRecherche = daoserv.rechercherService(titre);
		
		if(titre!=null) {
		request.setAttribute("service", servRecherche);
		}
		else {
			request.setAttribute("service", service);
		}
		this.getServletContext().getRequestDispatcher("/Services/services.jsp").forward(request,response);
	}

}
