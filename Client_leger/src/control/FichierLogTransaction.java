package control;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import objetMetier.logTransactions;

/**
 * @author myrthacomlan
 *
 */
@WebServlet("/FichierLogTransaction")
public class FichierLogTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public FichierLogTransaction() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		logTransactions log = new logTransactions();
		
		log.enregistrer();
		response.sendRedirect("/Projet_S8/ServRecupererTransactions");
		
	}

}

