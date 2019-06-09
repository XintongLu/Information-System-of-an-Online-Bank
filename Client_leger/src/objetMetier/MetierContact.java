package objetMetier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.util.StringUtils;

import beans.Contact;
import model.DaoContact;

public class MetierContact {
	private static final String CHAMP_CIVILITE = "civilite";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_TEL = "tel";
	private static final String CHAMP_ADRESSE = "adresse";
	private static final String CHAMP_CP = "cp";
	private static final String CHAMP_VILLE = "ville";
	private static final String CHAMP_PAYS = "pays";
	private static final String CHAMP_SUJET = "sujet";
	private static final String CHAMP_MESSAGE = "message";
	private static final String CHAMP_REPONSE = "reponse";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	// Permet de retourner le resultat
	public String getResultat() {
		return resultat;
	}

	// Creation de la liste d'erreur
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Contact EnregistrerMessage(HttpServletRequest request) {
		String civilite = getValeurChamp(request, CHAMP_CIVILITE);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String tel = getValeurChamp(request, CHAMP_TEL);
		String adresse = getValeurChamp(request, CHAMP_ADRESSE);
		String cp = getValeurChamp(request, CHAMP_CP);
		String ville = getValeurChamp(request, CHAMP_VILLE);
		String pays = getValeurChamp(request, CHAMP_PAYS);
		String sujet = getValeurChamp(request, CHAMP_SUJET);
		String message = getValeurChamp(request, CHAMP_MESSAGE);
		String reponse = getValeurChamp(request, CHAMP_REPONSE);

		// On instencie un bean contact
		Contact contact = new Contact();
		DaoContact dao = new DaoContact();

		/**
		 * On fait appel aux méthodes de validation, et on ajoute l'attribut au contact
		 */
		contact.setCivilite(civilite);
		contact.setNom(nom);
		contact.setPrenom(prenom);
		contact.setEmail(email);
		contact.setTel(tel);
		contact.setAdresse(adresse);
		
		contact.setCp(cp);
		contact.setVille(ville);
		contact.setPays(pays);
		contact.setSujet(sujet);
		contact.setMessage(message);
		contact.setReponse(reponse);
		
		dao.ajouterMessage(contact);
		return contact;

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