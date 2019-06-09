package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Alimenter;
import model.DaoManager;

/**
 * Servlet implementation class ServletActu
 */
@WebServlet("/DepotClient")
public class DepotClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public DepotClient() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoManager daomanager = new DaoManager();
		ArrayList<Alimenter> depot = daomanager.depotClient();	 	
		int somme = daomanager.somme();
		 
			request.setAttribute("depot", depot);
			request.setAttribute("somme", somme);
			

		this.getServletContext().getRequestDispatcher("/Manager/DepotClient.jsp").forward(request,response);
		//doGet(request,response);
	}

}
