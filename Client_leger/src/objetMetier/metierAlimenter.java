package objetMetier;

import java.time.LocalDateTime;
import com.itextpdf.text.Element;
import java.time.format.DateTimeFormatter;
/**
 * @author myrthacomlan
 */
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Alimenter;
import beans.Client;
import model.DaoAlimenter;
import model.DaoClient;

public class metierAlimenter {
	private static final String CHAMP_ESPECE = "espece";
	private static final String CHAMP_CHEQUE = "cheque";
	private static final String CHAMP_CARTE = "carte";
	private static final String CHAMP_NUMERO = "numero";
	private static final String CHAMP_DATE = "date";
	private static final String CHAMP_CVC = "cvc";
	private static final String CHAMP_DESCRIPTIONESPECE = "descriptionEspece";
	private static final String CHAMP_DESCRIPTIONCARTE= "descriptionCarte";
	private static final String CHAMP_DESCRIPTIONCHEQUE = "descriptionCheque";




	
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String dateVir = now.format(formatter);
	
	
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

	/*
	 * Ajoute un message correspondant au champ spÃˆcifiÃˆ â€¡ la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	

	public Alimenter alimenterCompte(HttpServletRequest request) {
		

		String espece = getValeurChamp(request, CHAMP_ESPECE);;
		String cheque = getValeurChamp(request, CHAMP_CHEQUE);
		String carte = getValeurChamp(request, CHAMP_CARTE);
		String numero = getValeurChamp(request, CHAMP_NUMERO);
		String cvc = getValeurChamp(request, CHAMP_CVC);
		String date = getValeurChamp(request, CHAMP_DATE);
		String descriptionEspece = getValeurChamp(request, CHAMP_DESCRIPTIONESPECE);
		String descriptionCarte = getValeurChamp(request, CHAMP_DESCRIPTIONCARTE);
		String descriptionCheque = getValeurChamp(request, CHAMP_DESCRIPTIONCHEQUE);
		
		Alimenter alimenter = new Alimenter();

		DaoClient dao = new DaoClient();
		DaoAlimenter daoAlimenter= new DaoAlimenter();

		HttpSession session = request.getSession(true);

		Client client = (Client) session.getAttribute("sessionClient");
		int id_client = dao.trouverId(client.getLogin());
		float solde_client = dao.trouverSolde(client.getLogin());

		float Nouveau_solde = 0 ;


		/**
		 * On fait appel aux mÃˆthodes de validation, et on ajoute l'attribut au client
		 */
		alimenter.setId_client(id_client);
		alimenter.setType("COMPTE COURANT");
		



		if (espece != null) {
			alimenter.setMontant(espece);
			Nouveau_solde = Integer.parseInt(espece) + solde_client;

			alimenter.setMoyen("ESPECE");
			alimenter.setNumero_carte("null");
			alimenter.setCvc("null");
			alimenter.setDate("null");
			alimenter.setDateVir(dateVir);
			alimenter.setDescription(descriptionEspece);
		
		} else if (carte != null) {
			alimenter.setMontant(carte);
			Nouveau_solde = Integer.parseInt(carte) + solde_client;
			try {
				validationNumero(numero);
			} catch (Exception e) {
				setErreur(CHAMP_NUMERO, e.getMessage());
			}
			alimenter.setNumero_carte(numero);

			try {
				validationCvc(cvc);
			} catch (Exception e) {
				setErreur(CHAMP_CVC, e.getMessage());
			}
			alimenter.setCvc(cvc);

			try {
				validationDate(date);
			} catch (Exception e) {
				setErreur(CHAMP_DATE, e.getMessage());
			}
			alimenter.setDate(date);
			alimenter.setMoyen("CARTE");
			alimenter.setDateVir(dateVir);
			alimenter.setDescription(descriptionCarte);
			
		} else if (cheque != null) {
			alimenter.setMontant(cheque);
			Nouveau_solde = Integer.parseInt(cheque) + solde_client;

			alimenter.setMoyen("CHEQUE");
			alimenter.setNumero_carte("null");
			alimenter.setCvc("null");
			alimenter.setDate("null");
			alimenter.setDateVir(dateVir);
			alimenter.setDescription(descriptionCheque);

		
			
		} 
		
		else {
			setErreur(CHAMP_ESPECE, "Insérez une valeur");
			setErreur(CHAMP_CARTE, "Insérez une valeur");
			setErreur(CHAMP_CHEQUE, "Insérez une valeur");
		}

		if (erreurs.isEmpty()) {
			resultat = "Succes.";
			daoAlimenter.ajouterAlimenter(alimenter);
			dao.updateSolde(Nouveau_solde, id_client);
			client.setSolde(Nouveau_solde);
			session.setAttribute("sessionClient", client);
		} else {
			resultat = "Echec";
		}
		
		
		return alimenter;
	}

	private void validationNumero(String numero) throws Exception {
		if (numero != null && numero.length() != 16) {
			throw new Exception("16 chiffres");
		}
		if (numero.equals(null)) {
			throw new Exception("Merci de saisir le numero de votre  carte.");
		}
	} 

	private void validationCvc(String cvc) throws Exception {
		if (cvc != null && cvc.length() != 3) {
			throw new Exception("3 chiffres");
		}
		if (cvc.equals(null)) {
			throw new Exception("Merci de saisir votre CVC");
		}
	}

	private void validationDate(String date) throws Exception {
		if (date != null && date.length() != 7) {
			throw new Exception("Date d'expiration invalide");
		}
		if (date.equals(null)) {
			throw new Exception("Date d'expiration invalide");
		}
	}

	/*
	 * MÃˆthode utilitaire qui retourne null si un champ est vide, et son contenu
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