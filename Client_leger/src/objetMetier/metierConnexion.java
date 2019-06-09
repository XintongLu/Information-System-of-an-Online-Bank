package objetMetier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Client;
import model.DaoClient;

/**
 * @author Nicolas CHABAL Les classes metiers permettent, pour un formulaire il
 *         faut creer une classe métier afin de traiter et valider les données
 *         saisies par l'utilisateur
 *
 */
public final class metierConnexion {

	// Ces attributs permettent de stocker les elements rentrés par l'utilisateur
	// dans le formlaire (attriubut "name")
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASS = "password";
	DaoClient dao = new DaoClient();
	private String resultat;
	private String statut;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}
	public String compteEpargne()
	{
	 return statut;	
	}
	public float soldeEpargne(Client client)
	{
		float solde=dao.trouverSoldeEpargne(dao.trouverId(client.getLogin()));;
		return solde;
	}

	public Client connecterUtilisateur(HttpServletRequest request) {
		/* Récupération des champs du formulaire */
		String login 			= getValeurChamp(request, CHAMP_LOGIN);
		String motDePasse 		= getValeurChamp(request, CHAMP_PASS);
		String sexe 			= dao.trouverSexe(login);
		String nom 				= dao.trouverNom(login);
		String prenom 			= dao.trouverPrenom(login);
		String nationalite 		= dao.trouverNationalite(login);
		String dateDeNaissance 	= dao.trouverDateDeNaissance(login);
		String numerodetelephone= dao.trouverNumeroDeTelephone(login);
		String adresse 			= dao.trouverAdresse(login);
		String ville 			= dao.trouverVille(login);
		String codePostal 		= dao.trouverCodePostal(login);
		String email 			= dao.trouverMail(login);
		float solde				= dao.trouverSolde(login);
		int idCourant			= dao.trouverId(login);
		String idEpargne		= dao.trouverIdEpargne(idCourant);
		Client client 			= new Client();

		try {
			validationMotDePasse(motDePasse, login);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		client.setLogin(login);
		client.setMotdepasse(motDePasse);
		client.setSexe(sexe);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setNationalite(nationalite);
		client.setDateDeNaissance(dateDeNaissance);
		client.setNumerodetelephone(numerodetelephone);
		
		client.setAdresse(adresse);
		client.setVille(ville);
		client.setCodePostal(codePostal);
		client.setEmail(email);
		System.out.println(client.getEmail());
		client.setSolde(solde);
		
		if (idEpargne==null) {
			statut="non";
		} else {
			statut = "oui";
		}
		
		if (erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}
		return client;
	}
	
	
	public String etatConnection(String mdp, String login) {
		String etat = null;
		if(dao.trouverPassword(mdp, login)) {
			etat="Connexion réussie";
		}
		else {
			etat="connexion échouée";
		}
		return etat;
	}
	
	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse, String login) throws Exception {
		if(!dao.trouverPassword(motDePasse, login)) {
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
