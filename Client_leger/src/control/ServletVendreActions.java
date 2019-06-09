/**
 * 
 */
package control;

import java.io.IOException;

import beans.Actions;

import objetMetier.metierVendreActions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
/**
 * @author myrthacomlan
 *
 */ 
@WebServlet("/ServletVendreActions")
public class ServletVendreActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public ServletVendreActions() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			
		metierVendreActions vendre=new metierVendreActions();
		Actions actions= vendre.vendre(request);
		

		request.setAttribute("vendre",vendre);
		request.setAttribute("actions", actions);

		response.sendRedirect( "/Projet_S8/ServletCompte" );
			

	}
}