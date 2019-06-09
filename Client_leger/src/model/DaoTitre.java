 /**
 * 
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.Titre;





/**
 * @author myrthacomlan
 *
 */
public class DaoTitre {
private Connection connexion;
	
	

	/**
	 * Permet de creer une m�thode pour la connexion a la BDD
	 */
private void loadDatabase() {
	// Chargement du driver
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	}

	try {

		String url = "jdbc:mysql://localhost/banque_en_ligne_tic3_grp1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "root";

		connexion = DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	/**
	 * @param epargne Permet d'inserer dans la BDD les informations du compte
	 *                epargne d'un client
	 */
	public void ajouterTitre(Titre titre) {
		loadDatabase();
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connexion.prepareStatement("INSERT INTO titre(id_client, solde) VALUES(?, ?);");

			preparedStatement.setInt(1, titre.getId_client());
			preparedStatement.setFloat(2, 0);
			

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public int trouverIdTitre(int id) {
		int idTitre = 0 ;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT id_client FROM titre WHERE id_client = '" + id + "';");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				idTitre = resultat.getInt("id_client");

			}
		} catch (SQLException e) {
		} finally {
			// Fermeture de la connexion
			try {
				if (resultat != null)
					resultat.close();
				if (statement != null)
					statement.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}

		return idTitre;
	}
	
	public float trouverSoldeTitre(int id) {
		float solde = 0;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();
	

		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT solde FROM titre WHERE id_client = '" + id + "';");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				solde = resultat.getFloat("solde");

			}
		} catch (SQLException e) {
		} finally {
			// Fermeture de la connexion
			try {
				if (resultat != null)
					resultat.close();
				if (statement != null)
					statement.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}
		return solde;
	}
	public void updateSoldeTitre(float solde, int id) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			
			
			preparedStatement = connexion.prepareStatement("UPDATE titre SET solde=? WHERE id_client=? ");

			preparedStatement.setFloat(1, solde);
			preparedStatement.setInt(2, id);
		

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	

}
