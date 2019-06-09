package objetMetier;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.util.StringUtils;

import beans.Client;
import model.DaoModifier;

public class MetierModifier {
	
	private static final String CHAMP_SEXE 		= "sexe";
	private static final String CHAMP_LOGIN 	= "login";
	private static final String CHAMP_NOM 		= "nom";
	private static final String CHAMP_PRENOM 	= "prenom";
	private static final String CHAMP_NATIONALITE = "nationalite";
	private static final String CHAMP_DATE 		= "date";
	private static final String CHAMP_ADRESSE 	= "adresse";
	private static final String CHAMP_VILLE 	= "ville";
	private static final String CHAMP_CP 		= "cp";
	private static final String CHAMP_EMAIL 	= "email";
	private static final String CHAMP_PASS 		= "password";
	private static final String CHAMP_CONF 		= "confirmation";
	private static final String CHAMP_tel 		= "tel";

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
	
	public Client modifierUtilisateur(HttpServletRequest request) {

		String login 		= getValeurChamp(request, CHAMP_LOGIN);
		String adresse 		= getValeurChamp(request, CHAMP_ADRESSE);
		String ville 		= getValeurChamp(request, CHAMP_VILLE);
		String cp 			= getValeurChamp(request, CHAMP_CP);
		String email 		= getValeurChamp(request, CHAMP_EMAIL);
		String password 	= getValeurChamp(request, CHAMP_PASS);
		String confirmation = getValeurChamp(request, CHAMP_CONF);
		String tel 			= getValeurChamp(request, CHAMP_tel);
		
		Client client = new Client();
		DaoModifier dao = new DaoModifier();

		try {
			validationLogin(login);
		} catch (Exception e) {
			setErreur(CHAMP_LOGIN, e.getMessage());
		}
		client.setLogin(login);

		client.setAdresse(adresse);
		
		client.setVille(ville);
		
		try {
			validationCp(cp);
		} catch (Exception e) {
			setErreur(CHAMP_CP, e.getMessage());
		}
		client.setCodePostal(cp);
		
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		client.setEmail(email);

		try {
			validationMotsDePasse(password, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, null);
		}
		client.setMotdepasse(password);
		
		try {
			validationTel(tel);
		} catch (Exception e) {
			setErreur(CHAMP_tel, e.getMessage());
		}
		client.setNumerodetelephone(tel);

		if (erreurs.isEmpty()) {
			resultat = "Succ�s de l'inscription.";
			dao.ModifierClient(client, login);
		} else {
			resultat = "�chec de l'inscription.";
		}
		
		return client;
	}

private void validationNom(String nom) throws Exception {
	if (nom != null && nom.length() < 3) {
		throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caract�res.");
	}
	if(nom.equals(null)) {
		throw new Exception("Merci de saisir un nom.");
	}
}

private void validationPrenom(String prenom) throws Exception {
	if (prenom != null && prenom.length() < 3) {
		throw new Exception("Le prenom d'utilisateur doit contenir au moins 3 caract�res.");
	}
	if(prenom.equals(null)) {
		throw new Exception("Merci de saisir un pr�nom.");
	}
}

private void validationLogin(String login) throws Exception {
	if (login != null && login.length() < 6 && (!login.contains("1"))) {
		throw new Exception("Le login d'utilisateur doit contenir au moins 6");
	}
	if(login.equals(null)) {
		throw new Exception("Merci de saisir un identifiant.");
	}
}

private void validationCp(String cp) throws Exception {
	if (cp != null && cp.length() !=5 && !StringUtils.isStrictlyNumeric(cp)) {
		throw new Exception("Le code postal n'est pas correct");
	}
	if(cp.equals(null)) {
		throw new Exception("Merci de saisir un code postal.");
	}
}

private void validationTel(String tel) throws Exception {
	if (tel != null && tel.length() !=10 && !StringUtils.isStrictlyNumeric(tel)) {
		throw new Exception("Le num�ro de t�l�phone n'est pas correct");
	}
	if(tel.equals(null)) {
		throw new Exception("Merci de saisir un num�ro de t�l�phone.");
	}
}

private void validationEmail(String email) throws Exception {
	if (email != null) {
		if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	} else {
		throw new Exception("Merci de saisir une adresse mail.");
	}
}

private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
	if (motDePasse != null && confirmation != null) {
		if (!motDePasse.equals(confirmation)) {
			throw new Exception("Les mots de passe entr�s sont diff�rents, merci de les saisir � nouveau.");
		} else if (motDePasse.length() < 6) {
			throw new Exception("Les mots de passe doivent contenir au moins 6 caract�res.");
		}
	} else {
		throw new Exception("Merci de saisir et confirmer votre mot de passe.");
	}
}

private void validationAge(String date) throws Exception {

	Date date1 = new Date();
	LocalDate localDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year = localDate.getYear();
	int month = localDate.getMonthValue();
	int day = localDate.getDayOfMonth();
	Calendar calendar = new GregorianCalendar();

	Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
	calendar.setTime(date2);
	int ageYear = calendar.get(Calendar.YEAR);
	int ageMonth = calendar.get(Calendar.MONTH); // month commence � 0(Jan). 1(Feb)
	int ageDay = calendar.get(Calendar.DAY_OF_MONTH);

	if ((year - ageYear) < 18) {
		throw new Exception("Vous avez moins de 18 ans. Vous ne pouvez pas cr�er un compte.");
	} else if ((year - ageYear) == 18) {
		if ((month - ageMonth) < 0) {
			throw new Exception("Vous avez moins de 18 ans. Vous ne pouvez pas cr�er un compte.");
		} else if ((month - ageMonth) == 1) {
			if ((day - ageDay) < 0) {
				throw new Exception("Vous avez moins de 18 ans. Vous ne pouvez pas cr�er un compte.");
			}
		}

	}
}

/*
 * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
 */
private void setErreur(String champ, String message) {
	erreurs.put(champ, message);
}

/*
 * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
 * sinon.
 */
private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
    String valeur = request.getParameter( nomChamp );
    if ( valeur == null || valeur.trim().length() == 0 ) {
        return null;
    } else {
        return valeur.trim();
    }
}



}
