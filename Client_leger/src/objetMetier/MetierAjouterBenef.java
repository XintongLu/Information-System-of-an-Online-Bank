package objetMetier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.cj.util.StringUtils;

import beans.Beneficiaire;
import beans.Client;
import model.DaoAjouterBenef;
import model.DaoClient;
import model.DaoModifier;

import org.apache.commons.validator.routines.*;

public class MetierAjouterBenef {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_IBAN = "iban";

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

	public Beneficiaire ajouterBenef(HttpServletRequest request) {

		String nom = getValeurChamp(request, CHAMP_NOM);
		String iban = getValeurChamp(request, CHAMP_IBAN);
		
		Beneficiaire benef = new Beneficiaire();
		DaoAjouterBenef dao = new DaoAjouterBenef();
		DaoClient daoClient = new DaoClient();
		HttpSession session = request.getSession(true);
		Client client = (Client) session.getAttribute("sessionClient");
		int id_client = daoClient.trouverId(client.getLogin());
		
		try {
			validationIban(iban);
		} catch (Exception e) {
			setErreur(CHAMP_IBAN, e.getMessage());
		}
		benef.setIban(iban);
		
		
		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_IBAN, e.getMessage());
		}
		
		benef.setNom(nom);
		benef.setIdClient(id_client);
		if (erreurs.isEmpty()) {
			resultat = "Bénéficiaire enregistré";
			dao.AjouterBenef(benef);
		} else {
		}
		
		return benef;
		
	}
	
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}
	
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	    String valeur = request.getParameter( nomChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}
	
	private void validationNom(String nom) throws Exception {
    	
		if(nom.equals(null)) {
			throw new Exception("Merci de saisir un nom");
		}
	}
	
	private void validationIban(String iban) throws Exception {
    	IBANValidator validation = new IBANValidator();
		if (validation.isValid(iban) == false) {
			throw new Exception("L'IBAN saisi est incorrect");
		}
		if(iban.equals(null)) {
			throw new Exception("Merci de saisir un IBAN");
		}
	}
}
