package objetMetier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Client;

import beans.Titre;
import model.DaoClient;

import model.DaoTitre;

/**
 * @author Myrtha COMLAN Les classes metiers permettent, pour un formulaire il
 *         faut creer une classe m�tier afin de traiter et valider les donn�es
 *         saisies par l'utilisateur
 *
 */
public final class metierTitre {

	// Ces attributs permettent de stocker les elements rentr�s par l'utilisateur
	// dans le formlaire (attriubut "name")
	
	DaoClient dao = new DaoClient();
	DaoTitre daoTitre=new DaoTitre();

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs; 
	}

	public Titre creerTitre(HttpServletRequest request) {
		/* R�cup�ration des valeurs */
		 HttpSession session = request.getSession(true);
	       
		Client client =(Client) session.getAttribute("sessionClient");
		
		int id = dao.trouverId(client.getLogin());
		Titre titre =new Titre();
		
		titre.setId_client(id);
		
		
	daoTitre.ajouterTitre(titre);
		

		return titre;
	}

	
	

}
