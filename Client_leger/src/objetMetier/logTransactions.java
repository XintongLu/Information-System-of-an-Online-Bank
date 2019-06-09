/**
 * 
 */
package objetMetier;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import beans.Alimenter;
import model.DaoAlimenter;

/**
 * @author myrthacomlan
 *
 */
public class logTransactions {
	static final Logger logger = Logger.getLogger("transaction");
	public void enregistrer(){
		
		ArrayList<Alimenter> transactions = new ArrayList<Alimenter>();
		DaoAlimenter dao = new DaoAlimenter();

		transactions.addAll(dao.uploadTransaction());
		System.out.println(transactions);
		logger.info("-----------------------------------Nouvel enregistrement------------------------------------------");
		for (int i = 0; i < transactions.size(); i++) {

			logger.info("LOGIN : "		+ transactions.get(i).getId_client() 	+ " -- " +
						"BENEFICIAIRE :"+ transactions.get(i).getMoyen() 		+ " -- " + 
						"MOYEN :"		+ transactions.get(i).getBeneficiaire()	+ " -- " + 
						"DATE : "		+ transactions.get(i).getDateVir() 		+ " -- " +
						"MONTANT : "	+ transactions.get(i).getMontant() 		+ " -- " + 
						"DESCRIPTION : "+ transactions.get(i).getDescription());
		}
	}

}
