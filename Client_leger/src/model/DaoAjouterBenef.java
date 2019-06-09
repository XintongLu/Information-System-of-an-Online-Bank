package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Beneficiaire;
import beans.Client;

public class DaoAjouterBenef {
	private Connection connexion;
	
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
	
	public void AjouterBenef(Beneficiaire benef){
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement("INSERT INTO beneficiaire(nom, iban, idClient) VALUES(?, ?, ?);");

			preparedStatement.setString(1, benef.getNom());
			preparedStatement.setString(2, benef.getIban());
			preparedStatement.setInt(3, benef.getIdClient());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
/**
 * @param id : correspond à l'id du client
 * @return listNom
 * 
 * Ces methodes sont utilisées directement dans la servlet afin d'afficher le nom ou l'iban des benificaires d'un client dans un tableau
 */


public ArrayList<String> getlistIban(int id) {
	
	ArrayList<String> listIban = new ArrayList<String>();
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String iban=null;
	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT iban FROM beneficiaire WHERE idClient="+id);

            // Récupération des données
            while (resultat.next()) {
            	iban = resultat.getString("iban");
            	listIban.add(iban);
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
	return listIban;
}

public ArrayList<String> getListNom(int id) {
	
	ArrayList<String> listNom = new ArrayList<String>();
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String nom=null;
	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT nom FROM beneficiaire WHERE idClient="+id);

            // Récupération des données
            while (resultat.next()) {
            	nom = resultat.getString("nom");
            	listNom.add(nom);
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
	return listNom;
}

public String getNom(int id) {
	String nom = null;
	Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	try {
		statement = connexion.createStatement();

		resultat = statement.executeQuery("SELECT nom FROM beneficiaire WHERE id = '" + id + "';");
		
		while (resultat.next()) {
			nom = resultat.getString("nom");
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
	return nom;
}

public String getIban(int id) {
	String iban = null;
	Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	try {
		statement = connexion.createStatement();

		resultat = statement.executeQuery("SELECT iban FROM beneficiaire WHERE id = '" + id + "';");
		
		while (resultat.next()) {
			iban = resultat.getString("iban");
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
	return iban;
}





}
