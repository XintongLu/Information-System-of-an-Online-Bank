package objetMetier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Admin;
import beans.Client;
import model.DaoAdmin;
import model.DaoClient;

public class MetierConnexionAdmin {

	// Ces attributs permettent de stocker les elements rentrés par l'utilisateur
	// dans le formlaire (attriubut "name")
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASS = "password";
	DaoAdmin dao = new DaoAdmin();
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Admin connecterAdmin(HttpServletRequest request) {
		/* Récupération des champs du formulaire */
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String prenom = dao.trouverPrenom(login);
		Admin admin = new Admin();

		try {
			validationMotDePasse(motDePasse, login);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		admin.setLogin(login);
		admin.setMotdepasse(motDePasse);
		admin.setPrenom(prenom);

		if (erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}
		return admin;
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
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
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
