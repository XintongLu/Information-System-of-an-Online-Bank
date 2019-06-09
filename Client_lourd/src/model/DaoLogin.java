package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoLogin {
	private static Connection connexion;

	/**
	 * Permet de creer une mÃ©thode pour la connexion a la BDD
	 */
	private  void loadDatabase() {
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
	
	public boolean Login(String login,String password) {
		boolean etat = false;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT password FROM conseiller WHERE login = '" + login + "'");

			// Récupération des données
			while (resultat.next()) {
				//int id = resultat.getInt("id");
				String password1 = resultat.getString("password");

				if (password1.equals(password)) {
					etat = true;
				} else {
					etat = false;
				}

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
		//System.out.println(etat);
		return etat;
	}
	
	 
}
