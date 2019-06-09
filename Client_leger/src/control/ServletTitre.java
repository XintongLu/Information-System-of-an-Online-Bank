package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Titre;
import objetMetier.metierTitre;

/**
 * Servlet implementation class Client
 * 
 * @author myrthacomlan
 */
@WebServlet("/ServletTitre")
public class ServletTitre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";
	public static final String URL_REDIRECTION = "http://localhost:8080/Projet_S8/Home/homeVisiteur.jsp";

	public ServletTitre() {
		super();

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		metierTitre titre = new metierTitre();
		Titre creertitre = titre.creerTitre(request);

		request.setAttribute("titre", titre);
		request.setAttribute("creertitre", creertitre);
		HttpSession session = request.getSession(true);
		session.setAttribute("soldeTitre", 0.0);

		session.invalidate();

		/* Redirection vers le Site du Z�ro ! */
		response.sendRedirect(URL_REDIRECTION);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
