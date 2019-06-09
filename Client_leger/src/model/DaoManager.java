package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Alimenter;



/**
 * @author Xintong LU
 *  Cette class controle permet d'éxecuter les requetes
 *         SQL permettant de traiter les requetes d'un admin
 *
 */
public class DaoManager {
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

	

	public String trouverPrenom(String login) {
		String prenom = null;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT prenom FROM manager WHERE login = '" + login + "';");

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
			resultat = statement.executeQuery("SELECT password FROM manager WHERE login = '" + login + "';");

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
	//	System.out.println(etat);
		return etat;
	}
	
	public ArrayList<Alimenter> depotClient() {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Alimenter> depotList = new ArrayList<Alimenter>();

		try {
			prepSt = connexion.prepareStatement("SELECT dateVir,moyen_paiement,concat(concat(prenom,' '),nom)as \"prenomNom\",montant FROM alimenter INNER JOIN client on client.id = alimenter.id_client where moyen_paiement in (\"ESPECE\",\"CHEQUE\")");
		
			rs = prepSt.executeQuery();
			while (rs.next()) {
				String dateVir = rs.getString("dateVir");
				String moyen = rs.getString("moyen_paiement");
				String prenomNom = rs.getString("prenomNom");
				String montant = rs.getString("montant");
				
				//String nom = rs.getString("prenomNom");

				//Alimenter depot = new Alimenter(dateVir,montant,moyen,prenomNom);
				Alimenter depot = new Alimenter(dateVir,moyen,prenomNom, montant);
				depotList.add(depot);
				
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return depotList;
	}
	
	public int somme() {
		boolean etat = false;
		Statement statement = null;
		ResultSet resultat = null;
		int somme = 0;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT sum(montant) from alimenter where moyen_paiement in (\"ESPECE\",\"CHEQUE\",\"VIREMENT EXTERNE\");");

			// Récupération des données
			while (resultat.next()) {
				somme = resultat.getInt("sum(montant)");
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
		//System.out.println(somme);
		return somme;
	}
	

}
