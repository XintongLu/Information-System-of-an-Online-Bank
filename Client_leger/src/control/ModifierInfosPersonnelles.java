package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Client;
import objetMetier.metierInscription;

/**
 * Servlet implementation class ModifierInfosPersonnelles
 */
@WebServlet("/ModifierInfosPersonnelles")
public class ModifierInfosPersonnelles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierInfosPersonnelles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/ModifierInfoPerso.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		metierInscription inscrire = new metierInscription();
		Client client = inscrire.modifierUtilisateur(request);
		
        request.setAttribute( "inscrire", inscrire );
        request.setAttribute( "client", client );
											
		doGet(request, response);
	}

}
