package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import beans.Client;


/**
 * @author Xintong LU
 * Cette class controle permet d'Ã©xecuter les requetes SQL permettant de traiter les requetes d'un client
 *
 */
public class DaoClient {
	private static Connection connexion;

	/**
	 * Permet de creer une mÃ©thode pour la connexion a la BDD
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
	
	
	
	public ArrayList<Client> clientDetails() throws SQLException{

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Client> clientList = new ArrayList<Client>();

		try {
			prepSt = connexion.prepareStatement("SELECT nom,prenom,nationalite,date,adresse,ville,cp,tel,email,solde FROM client");

			rs = prepSt.executeQuery();
			while (rs.next()) {
			
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String nationalite = rs.getString("nationalite");
				String date = rs.getString("date");
				String adresse = rs.getString("adresse");
				String ville = rs.getString("ville");
				String cp = rs.getString("cp");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				float solde = rs.getFloat("solde");
				
				Client client = new Client(nom,prenom,nationalite,date,adresse,ville,cp,tel,email,solde);
				clientList.add(client);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return clientList;
	}
	
	public int trouverId(String nom,String prenom) {
		int id =0;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT id FROM client WHERE nom = '" + nom + "' AND prenom = '" + prenom + "' ");

			// Récupération des données
			while (resultat.next()) {
				//int id = resultat.getInt("id");
				id = resultat.getInt("id");

			}

			}catch (SQLException e) {
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
		return id;
	}
  


	}


