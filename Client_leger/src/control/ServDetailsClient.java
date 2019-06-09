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
 * Servlet implementation class ServDetailsServlet
 */
@WebServlet("/ServDetailsClient")
public class ServDetailsClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id=0;
    
    public ServDetailsClient() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=Integer.parseInt(request.getParameter("idService"));
		 doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOService daoServ = new DAOService();
		ArrayList<Service> service = daoServ.afficherServiceDetails(id);
		request.setAttribute("service", service);
		this.getServletContext().getRequestDispatcher("/Services/ServDetails.jsp").forward(request,response);
	
	}

}
