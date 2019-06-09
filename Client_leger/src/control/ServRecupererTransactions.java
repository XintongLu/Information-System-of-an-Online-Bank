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

import beans.Alimenter;

import model.DaoAlimenter;

/**
 * @author myrthacomlan
 *
 */
@WebServlet("/ServRecupererTransactions")
public class ServRecupererTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ServRecupererTransactions() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Alimenter> transactions = new ArrayList<Alimenter>();
		DaoAlimenter dao = new DaoAlimenter();
	
		transactions.addAll(dao.uploadTransaction());
			
			request.setAttribute("transactions", transactions);

			
				this.getServletContext().getRequestDispatcher("/FichierLog/Transaction.jsp").forward(request,response);
			
		
	}

}
