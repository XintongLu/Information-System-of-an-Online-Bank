package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoContact;

@WebServlet("/AffichageMessage")
public class AffichageMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AffichageMessage() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoContact contact = new DaoContact();

		request.setAttribute("listNoms", contact.getNoms());
		request.setAttribute("listSujets", contact.getSujets());
		request.setAttribute("listId", contact.listeIdMessages());
		request.setAttribute("listReponse", contact.getReponse());
		request.setAttribute("listPrenom", contact.getPrenoms());
		this.getServletContext().getRequestDispatcher("/Contact/AffichageMessage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
