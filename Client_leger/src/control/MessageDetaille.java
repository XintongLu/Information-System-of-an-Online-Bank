package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoMessageDetaille;

@WebServlet("/MessageDetaille")
public class MessageDetaille extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MessageDetaille() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		if (idString != null) {
			try {
				int idInt = Integer.parseInt(idString.trim());

				DaoMessageDetaille dao = new DaoMessageDetaille();
				request.setAttribute("civilite"		, dao.getCivilite(idInt));
				request.setAttribute("nom"			, dao.getNoms(idInt));
				request.setAttribute("prenom"		, dao.getPrenoms(idInt));
				request.setAttribute("email"		, dao.getEmail(idInt));
				request.setAttribute("tel"			, dao.getTel(idInt));
				request.setAttribute("cp"			, dao.getCp(idInt));
				request.setAttribute("ville"		, dao.getVille(idInt));
				request.setAttribute("pays"			, dao.getPays(idInt));
				request.setAttribute("sujet"		, dao.getSujets(idInt));
				request.setAttribute("message"		, dao.getMessage(idInt));
				request.setAttribute("reponse"		, dao.getReponse(idInt));
			} catch (NumberFormatException nbe) {
				nbe.printStackTrace();
			}
		}
		this.getServletContext().getRequestDispatcher("/Contact/MessageDetaille.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
