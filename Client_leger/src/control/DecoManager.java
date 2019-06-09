package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Deco
 */
@WebServlet("/DecoManager")
public class DecoManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String URL_REDIRECTION = "http://localhost:8080/Projet_S8/Home/homeVisiteur.jsp";
    static final Logger infoUser = Logger.getLogger("info");

	public DecoManager() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Récupération et destruction de la session en cours  */
		HttpSession session = request.getSession();

		session.invalidate();

		/* Redirection vers le Site du Zéro ! */
		response.sendRedirect(URL_REDIRECTION);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
