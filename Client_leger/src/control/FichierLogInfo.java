package control;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import model.DaoClient;
import model.DaoHistoConn;
import objetMetier.metierConnexion;

/**
 * @author nicolas chabal
 *
 */
@WebServlet("/FichierLogInfo")
public class FichierLogInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public FichierLogInfo() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoHistoConn dao = new DaoHistoConn();

		for (int id1 : dao.getListId()) {
			request.setAttribute("listDate", dao.getListDate(id1));
			request.setAttribute("listEtat", dao.getListEtat(id1));
			request.setAttribute("listIp", dao.getListIp(id1));
			request.setAttribute("listLogin", dao.getListLogin(id1));
		}
		request.setAttribute("listId", dao.getListId());
	
		
		this.getServletContext().getRequestDispatcher("/FichierLog/Info.jsp").forward(request, response);
		
	}

}

