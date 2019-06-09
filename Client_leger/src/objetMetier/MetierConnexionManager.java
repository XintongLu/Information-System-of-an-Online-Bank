package objetMetier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Manager;
import model.DaoManager;

public class MetierConnexionManager {

	// Ces attributs permettent de stocker les elements rentr閟 par l'utilisateur
	// dans le formlaire (attriubut "name")
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASS = "password";
	DaoManager dao = new DaoManager();
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Manager connecterManager(HttpServletRequest request) {
		/* R閏up閞ation des champs du formulaire */
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String prenom = dao.trouverPrenom(login);
		Manager manager = new Manager();

		try {
			validationMotDePasse(motDePasse, login);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		manager.setLogin(login);
		manager.setMotdepasse(motDePasse);
		manager.setPrenom(prenom);

		if (erreurs.isEmpty()) {
			resultat = "Succ鑣 de la connexion.";
		} else {
			resultat = "蒫hec de la connexion.";
		}
		return manager;
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse, String login) throws Exception {
		if (!dao.trouverPassword(motDePasse, login)) {
			throw new Exception("");
		}

	}

	/*
	 * Ajoute un message correspondant au champ sp閏ifi� � la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * M閠hode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();

		}
	}

}
