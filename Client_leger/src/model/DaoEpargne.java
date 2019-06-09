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

import beans.Epargne;





/**
 * @author myrthacomlan
 *
 */
public class DaoEpargne {
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
	public void ajouterEpargne(Epargne epargne) {
		loadDatabase();
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connexion.prepareStatement("INSERT INTO Epargne(id, nom, prenom, solde) VALUES(?, ?, ?, ?);");

			preparedStatement.setInt(1, epargne.getId());
			preparedStatement.setString(2, epargne.getNom());
			preparedStatement.setString(3, epargne.getPrenom());
			preparedStatement.setInt(4, 0);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public int trouverIdEpargne(int id) {
		int idEpargne = 0 ;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT id FROM Epargne WHERE id = '" + id + "';");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				idEpargne = resultat.getInt("id");

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
		return idEpargne;
	}
	
	public float trouverSoldeEpargne(int id) {
		float solde = 0;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT solde FROM Epargne WHERE id = '" + id + "';");

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
	public void updateSoldeEpargne(float solde, int id) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			
			
			preparedStatement = connexion.prepareStatement("UPDATE Epargne SET solde=? WHERE id=? ");

			preparedStatement.setFloat(1, solde);
			preparedStatement.setInt(2, id);
		

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	

}
