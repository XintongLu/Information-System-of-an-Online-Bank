package objetMetier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Alimenter;
import beans.Client;
import model.DaoAlimenter;
import model.DaoClient;
import model.DaoEpargne;

public class MetierVirementInterneEpargneVersCourant {
	private static final String CHAMP_ESPECE = "espece";
	private static final String CHAMP_DESCRIPTION = "description";

	/** Date du virement */
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
	 * Ajoute un message correspondant au champ spÈcifiÈ ‡ la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	

	public Alimenter alimenterCompte(HttpServletRequest request) {
		
		/** On r�cup�re les donn�es rent�s par le client*/ 
		String espece = getValeurChamp(request, CHAMP_ESPECE);
		String description = getValeurChamp(request, CHAMP_DESCRIPTION);
		System.out.println(espece);
		
		Alimenter alimenter = new Alimenter();

		DaoClient dao = new DaoClient();
		DaoAlimenter daoAlimenter= new DaoAlimenter();
		DaoEpargne daoEpargne = new DaoEpargne();

		HttpSession session = request.getSession(true);

		Client client = (Client) session.getAttribute("sessionClient");
		int id_client = dao.trouverId(client.getLogin());
		float solde_client = dao.trouverSolde(client.getLogin());
		float soldeClientEpargne = daoEpargne.trouverSoldeEpargne(id_client);
		System.out.println("le solde epargne du client est a : " + soldeClientEpargne);

		float Nouveau_solde_Epargne = 0;
		float Nouveau_solde_Courant = 0;


		/**
		 * On fait appel aux m�thodes de validation, et on ajoute l'attribut au client
		 */
		alimenter.setId_client(id_client);
		alimenter.setType("COMPTE COURANT");
		
		if (espece != null) {
			alimenter.setMontant(espece);
			Nouveau_solde_Epargne = soldeClientEpargne - Integer.parseInt(espece);
			Nouveau_solde_Courant = solde_client + Integer.parseInt(espece);
			alimenter.setMoyen("VIR INTERNE DEPUIS EPARNGE");
			alimenter.setNumero_carte("null");
			alimenter.setCvc("null");
			alimenter.setDate("null");
			alimenter.setDateVir(dateVir);
			alimenter.setDescription(description);
		}
		else {
			setErreur(CHAMP_ESPECE, "Ins�rez une valeur");

		}

		if (erreurs.isEmpty()) {
			resultat = "Succes.";
			System.out.println("sucess");
			daoAlimenter.ajouterAlimenter(alimenter);
			dao.updateSolde(Nouveau_solde_Epargne, id_client);
			daoEpargne.updateSoldeEpargne(Nouveau_solde_Epargne, id_client);
			client.setSolde(Nouveau_solde_Courant);
			session.setAttribute("sessionClient", client);
		} else {
			resultat = "Echec";
		}
		
		return alimenter;
	}


	/*
	 * MÈthode utilitaire qui retourne null si un champ est vide, et son contenu
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
