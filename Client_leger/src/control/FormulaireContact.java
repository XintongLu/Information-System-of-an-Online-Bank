package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Contact;
import objetMetier.MetierContact;

/**
 * Servlet implementation class FormulaireContact
 */
@WebServlet("/FormulaireContact")
public class FormulaireContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Contact/Contact.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MetierContact ajouter = new MetierContact();
		Contact contact = ajouter.EnregistrerMessage(request);
		
        request.setAttribute( "ajouter", ajouter );
        request.setAttribute( "contact", contact );

											
		doGet(request, response);
	}

}
