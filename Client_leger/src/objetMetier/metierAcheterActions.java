/**
 * 
 */
package objetMetier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Actions;
import beans.Client;
import model.DaoActions;
import model.DaoClient;
import model.DaoTitre;


/**
 * @author myrthacomlan
 *  
 */

public class metierAcheterActions {
	
	private static final String CHAMP_NOM = "nom";
	
	private static final String CHAMP_DERNIER = "dernier";
	private static final String CHAMP_NOMBRE = "nombre";
	
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	
	public Actions acheter(HttpServletRequest request) {
		String nom = getValeurChamp(request, CHAMP_NOM);
		String dernier= getValeurChamp(request, CHAMP_DERNIER);
		String nombre = getValeurChamp(request, CHAMP_NOMBRE);
		int nbre=0;
		
		float nouveau_solde_titre=0;
		
		Actions action=new Actions(); 
		
		HttpSession session = request.getSession(true);
		DaoClient dao = new DaoClient();
		DaoTitre daoTitre= new DaoTitre();
		DaoActions daoActions=new DaoActions();
				
		Client client = (Client) session.getAttribute("sessionClient");
		int id_client = dao.trouverId(client.getLogin());
		
		float solde_courant=dao.trouverSolde(client.getLogin());
		float nouveau_solde_courant= solde_courant-Float.parseFloat( dernier);
		
		float solde_Titre= daoTitre.trouverSoldeTitre(id_client);
		
		
		
		if(nombre==null)
		{
			setErreur("erreur", "CHOISISSEZ LA QUANTITE A ACHETER");
		}
		
		else if(nouveau_solde_courant<0)
		{
			setErreur("erreur", "SOLDE INSUFFISANT");
		}
		else
		{
			nouveau_solde_titre= solde_Titre+ Float.parseFloat( dernier)*Float.parseFloat(nombre);
			
			daoTitre.updateSoldeTitre(nouveau_solde_titre, id_client);
			dao.updateSolde(nouveau_solde_courant, id_client);
			client.setSolde(nouveau_solde_courant);
			session.setAttribute("sessionClient", client);

			action.setNom(nom);
			action.setDernier(Float.parseFloat( dernier));
			action.setId_client(id_client);
			
			nbre=daoActions.trouverNombre(nom, id_client);
		
			if(nbre==0)
			{
				action.setNombre(Integer.parseInt(nombre));
				daoActions.ajouterActions(action);
			}
			else
			{
				daoActions.updateNombre(nom, id_client, nbre+Integer.parseInt(nombre));
			}
			
		}
	
		return action;
	}
	
	/*
	 *  utilitaire qui retourne null si un champ est vide, et son contenu
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
	// Creation de la liste d'erreur
		public Map<String, String> getErreurs() {
			return erreurs;
		}

		/*
		 * Ajoute un message correspondant au champ  la map des erreurs.
		 */
		private void setErreur(String champ, String message) {
			erreurs.put(champ, message);
		}

	

}
