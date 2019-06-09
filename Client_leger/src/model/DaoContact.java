package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Contact;

/**
 * @author Nicolas CHABAL
 * Cette class controle permet d'éxecuter les requetes SQL permettant de traiter les requetes d'un client
 *
 */
public class DaoContact {
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
	 * @param contact
	 * Permet d'inserer dans la BDD les informations d'un message
	 */
	public void ajouterMessage(Contact contact){
		loadDatabase();
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connexion.prepareStatement ("INSERT INTO contact	(civilite, nom, prenom, email, tel, adresse, cp, ville, pays, sujet, message, reponse) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
				
				preparedStatement.setString(1, contact.getCivilite());
				preparedStatement.setString(2, contact.getNom());
				preparedStatement.setString(3, contact.getPrenom());
				preparedStatement.setString(4, contact.getEmail());
				preparedStatement.setString(5, contact.getTel());
				preparedStatement.setString(6, contact.getAdresse());
				preparedStatement.setString(7, contact.getCp());
				preparedStatement.setString(8, contact.getVille());
				preparedStatement.setString(9, contact.getPays());
				preparedStatement.setString(10, contact.getSujet());
				preparedStatement.setString(11, contact.getMessage());
				preparedStatement.setString(12, contact.getReponse());
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
	}


	
	public ArrayList<Integer> listeIdMessages(){
		loadDatabase();
        Statement statement = null;
        ResultSet resultat = null;
		ArrayList<Integer> idList = new ArrayList<Integer>();
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT id FROM contact");

	            // Récupération des données
	            while (resultat.next()) {
	            	int id = resultat.getInt("id");
	            	idList.add(id);


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
		  for(int c : idList) {
			  System.out.println(c);
		  }
	        return idList;
	    }


public ArrayList<String> getNoms(){
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
	ArrayList<String> nomList = new ArrayList<String>();
	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT nom FROM contact");

            // Récupération des données
            while (resultat.next()) {
            	String nom = resultat.getString("nom");
            	nomList.add(nom);


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
        return nomList;
    }

public ArrayList<String> getPrenoms(){
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
	ArrayList<String> prenomList = new ArrayList<String>();
	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT prenom FROM contact");

            // Récupération des données
            while (resultat.next()) {
            	String prenom = resultat.getString("prenom");
            	prenomList.add(prenom);


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
        return prenomList;
    }

public ArrayList<String> getSujets(){
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
	ArrayList<String> sujetList = new ArrayList<String>();
	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT sujet FROM contact");

            // Récupération des données
            while (resultat.next()) {
            	String sujet = resultat.getString("sujet");
            	sujetList.add(sujet);


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
        return sujetList;
    }


public ArrayList<String> getReponse(){
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
	ArrayList<String> reponseList = new ArrayList<String>();
	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT reponse FROM contact");

            // Récupération des données
            while (resultat.next()) {
            	String reponse = resultat.getString("reponse");
            	reponseList.add(reponse);


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
        return reponseList;
    }



}
	
	  
	  
	


