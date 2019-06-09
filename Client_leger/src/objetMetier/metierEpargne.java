package objetMetier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Client;
import beans.Epargne;
import model.DaoClient;
import model.DaoEpargne;

/**
 * @author Myrtha COMLAN Les classes metiers permettent, pour un formulaire il
 *         faut creer une classe m�tier afin de traiter et valider les donn�es
 *         saisies par l'utilisateur
 *
 */
public final class metierEpargne {

	// Ces attributs permettent de stocker les elements rentr�s par l'utilisateur
	// dans le formlaire (attriubut "name")
	
	DaoClient dao = new DaoClient();
	DaoEpargne daoEpargne= new DaoEpargne(); 
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs; 
	}

	public Epargne creerEpargne(HttpServletRequest request) {
		/* R�cup�ration des valeurs */
		 HttpSession session = request.getSession(true);
	       
		Client client =(Client) session.getAttribute("sessionClient");
		String nom = dao.trouverNom(client.getLogin());
		
		String prenom = dao.trouverPrenom(client.getLogin());
		int id = dao.trouverId(client.getLogin());
		
		Epargne epargne = new Epargne();

		epargne.setId(id);
		epargne.setNom(nom);
	
		epargne.setPrenom(prenom);
		
		daoEpargne.ajouterEpargne(epargne);
		return epargne;
	}

	
	

}
