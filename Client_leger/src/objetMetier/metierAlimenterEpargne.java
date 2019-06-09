package objetMetier;

import java.time.LocalDateTime;
import com.itextpdf.text.Element;
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

public class metierAlimenterEpargne {
	private static final String CHAMP_ESPECE = "espece";
	private static final String CHAMP_DESCRIPTION = "description";
	
	
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

	public Alimenter alimenterCompteEpargne(HttpServletRequest request) {

		String espece = getValeurChamp(request, CHAMP_ESPECE);
		String description = getValeurChamp(request, CHAMP_DESCRIPTION);

		Alimenter alimenter = new Alimenter();

		DaoClient dao = new DaoClient();
		DaoEpargne daoEpargne = new DaoEpargne();
		DaoAlimenter daoAlimenter = new DaoAlimenter();

		HttpSession session = request.getSession(true);

		Client client = (Client) session.getAttribute("sessionClient");
		int id_client = dao.trouverId(client.getLogin());
		float solde_client = dao.trouverSolde(client.getLogin());

		float Nouveau_solde_Courant = 0;
		float Nouveau_solde_Epargne = (float) session.getAttribute("soldeEpargne");


		/**
		 * On fait appel aux mÈthodes de validation, et on ajoute l'attribut au client
		 */
		alimenter.setId_client(id_client);
		alimenter.setType("COMPTE EPARGNE");
		alimenter.setDescription(description);
		System.out.println(alimenter.getType());
		if (espece != null) {
			alimenter.setMontant(espece);
			Nouveau_solde_Courant = solde_client - Integer.parseInt(espece);
			Nouveau_solde_Epargne = Nouveau_solde_Epargne + Integer.parseInt(espece);

			alimenter.setMoyen("VIREMENT");
			alimenter.setNumero_carte("null");
			alimenter.setCvc("null");
			alimenter.setDate("null");
			alimenter.setDateVir(dateVir);
			/* alimenter.setFichier(null); */
		} else {
			setErreur(CHAMP_ESPECE, "Ins�rez une valeur");

		}

		if (erreurs.isEmpty()) {
			resultat = "Succes.";
			daoAlimenter.ajouterAlimenter(alimenter);
			dao.updateSolde(Nouveau_solde_Courant, id_client);
			daoEpargne.updateSoldeEpargne(Nouveau_solde_Epargne, id_client);
			client.setSolde(Nouveau_solde_Courant);
			session.setAttribute("sessionClient", client);
			session.setAttribute("soldeEpargne", Nouveau_solde_Epargne);
		} else {
			resultat = "Echec";
		}

		return alimenter;
	}

	/*
	 * MÈthode utilitaire qui retourne null si un champ est vide, et son contenu
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