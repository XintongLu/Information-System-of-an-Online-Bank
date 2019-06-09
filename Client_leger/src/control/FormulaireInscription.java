package control;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Client;
import model.EnvoyeMail;
import objetMetier.metierInscription;

/**
 * Servlet implementation class Client
 */
@WebServlet("/control/FormulaireInscription")
public class FormulaireInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";
	private String email = null;
	private int con = 2;
	private int mail=2;
	private Client client = new Client();
	

	public FormulaireInscription() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		if(mail!=0 && client!=null) {
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
		}else 
			this.getServletContext().getRequestDispatcher("/ConfirmationMail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		metierInscription inscrire = new metierInscription();
		EnvoyeMail envMail = new EnvoyeMail();
		
		
		email = request.getParameter("email");
		System.out.println("get email:" + email);
		
		 con = inscrire.ConfirmationClient(request);
		System.out.println(con);

		request.setAttribute("inscrire", inscrire);
		request.setAttribute("con", con);
		
		  
		if (con == 0) {

			System.out.println("post email:" + email);
			
			try {
				envMail.EnvoyerMail(email);
				mail = 0;
						
			} catch (AddressException e) {
				mail =1;
				e.printStackTrace();
			} catch (MessagingException e) {
				mail=1;
				e.printStackTrace();
			}
			if(mail==0) {
			client = inscrire.inscrireUtilisateur(request);
			  request.setAttribute( "client", client );
			}
		}						
		
		doGet(request, response);

			
	}

}
