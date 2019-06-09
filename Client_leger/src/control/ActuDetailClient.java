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
 * Servlet implementation class servlet
 */
@WebServlet("/ActuDetailClient")
public class ActuDetailClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id=0;
	
	
    public ActuDetailClient() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 id=Integer.parseInt(request.getParameter("idActu"));
		 
		 doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOActualite daoactu = new DAOActualite();
		ArrayList<Actualite> actu = daoactu.afficherActuDetails(id);
		request.setAttribute("actu", actu);
		this.getServletContext().getRequestDispatcher("/Actualité/ActDetails.jsp").forward(request,response);
	}
	
}