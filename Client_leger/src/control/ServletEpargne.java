package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Epargne;

import objetMetier.metierEpargne;

/**
 * Servlet implementation class Client
 * @author myrthacomlan
 */
@WebServlet("/ServletEpargne")
public class ServletEpargne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    public static final String URL_REDIRECTION = "http://localhost:8080/Projet_S8/Home/homeVisiteur.jsp";


	public ServletEpargne() {
		super();

	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		metierEpargne epargner = new metierEpargne();
		Epargne epargne = epargner.creerEpargne(request);
		
        request.setAttribute( "epargner", epargner );
        request.setAttribute( "epargne", epargne);
        HttpSession session = request.getSession(true);		
        session.setAttribute("soldeEpargne", 0.0);
        
        session.invalidate();

		/* Redirection vers le Site du Z�ro ! */
		response.sendRedirect(URL_REDIRECTION);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
