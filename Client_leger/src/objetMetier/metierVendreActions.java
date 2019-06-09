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

public class metierVendreActions {
	
	private static final String CHAMP_NOM = "nom";
	
	
	private static final String CHAMP_NOMBRE = "nombre";
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	
	public Actions vendre(HttpServletRequest request) {

		
		String nom = getValeurChamp(request, CHAMP_NOM);
		String nombre = getValeurChamp(request, CHAMP_NOMBRE);
		
		Actions action=new Actions(); 
		
		HttpSession session = request.getSession(true);
		DaoClient dao = new DaoClient();
		DaoTitre daoTitre= new DaoTitre();
		DaoActions daoActions=new DaoActions();
				
		Client client = (Client) session.getAttribute("sessionClient");
		int id_client = dao.trouverId(client.getLogin());
		
		float solde_courant= dao.trouverSolde(client.getLogin());
		
		float solde_Titre= daoTitre.trouverSoldeTitre(id_client);

		float dernier= daoActions.trouverDernier(nom, id_client);
		
		
		
		float nouveau_solde_courant= solde_courant+(dernier*Float.parseFloat(nombre)); 
		
		float nouveau_solde_titre= solde_Titre-(dernier*Float.parseFloat(nombre)); 
	
			daoTitre.updateSoldeTitre(nouveau_solde_titre, id_client);
			dao.updateSolde(nouveau_solde_courant, id_client);
			client.setSolde(nouveau_solde_courant);
			session.setAttribute("sessionClient", client);

			action.setNom(nom);
			action.setId_client(id_client);
			
			int nbre=daoActions.trouverNombre(nom, id_client);
		
	
			if(Integer.parseInt(nombre)==nbre)
			{
				daoActions.deleteAction(nom, id_client);
			
			}
			else
			{
				daoActions.updateNombre(nom, id_client, nbre-Integer.parseInt(nombre));
				action.setNombre(nbre-Integer.parseInt(nombre));
			}
			
	
	 
		return action;
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
	// Creation de la liste d'erreur
		public Map<String, String> getErreurs() {
			return erreurs;
		}

	

}
