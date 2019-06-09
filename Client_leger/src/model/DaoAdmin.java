package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Client;

/**
 * @author Nicolas CHABAL Cette class controle permet d'éxecuter les requetes
 *         SQL permettant de traiter les requetes d'un admin
 *
 */
public class DaoAdmin {
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

	/**
	 * @param login Permet d'inserer dans la BDD les informations d'un admin lors de
	 *              son inscription
	 */

	public boolean trouverEmail(String login) {
		boolean etat = false;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT login FROM admin WHERE login = '" + login + "';");

			// Récupération des données
			while (resultat.next()) {
				String mail = resultat.getString("email");

				if (mail.equals(mail)) {
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
		System.out.println(etat);
		return etat;
	}

	public String trouverPrenom(String login) {
		String prenom = null;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT prenom FROM admin WHERE login = '" + login + "';");

			// Récupération des données
			while (resultat.next()) {
				prenom = resultat.getString("prenom");

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
		return prenom;
	}

	public boolean trouverPassword(String mdp, String login) {
		boolean etat = false;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT password FROM admin WHERE login = '" + login + "';");

			// Récupération des données
			while (resultat.next()) {
				String passwd = resultat.getString("password");

				if (passwd.equals(mdp)) {
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
		System.out.println(etat);
		return etat;
	}

}
