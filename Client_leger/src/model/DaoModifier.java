package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Alimenter;
import beans.Client;
import beans.Epargne;

public class DaoModifier {
	private Connection connexion;

	/**
	 * Permet de creer une méthode pour la connexion a la BDD
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


	
	public void updateSolde(float solde, int id) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			
			
			preparedStatement = connexion.prepareStatement("UPDATE client SET solde=? WHERE id=? ");

			preparedStatement.setFloat(1, solde);
			preparedStatement.setInt(2, id);
		

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void ModifierClient(Client client, String login){
		loadDatabase();
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connexion.prepareStatement ("UPDATE client SET login=?, tel=?, adresse=?, ville=?, cp=?, email=?, password=? WHERE login=?;");
		
				preparedStatement.setString(1, client.getLogin());
				preparedStatement.setString(2, client.getNumerodetelephone());
				preparedStatement.setString(3, client.getAdresse());
				preparedStatement.setString(4, client.getVille());
				preparedStatement.setString(5, client.getCodePostal());
				preparedStatement.setString(6, client.getEmail());
				preparedStatement.setString(7, client.getMotdepasse());
				preparedStatement.setString(8, client.getLogin());
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
	}

}
