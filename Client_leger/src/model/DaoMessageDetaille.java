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
public class DaoMessageDetaille {
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

	public String getMessage(int id){
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String message= null;
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT message FROM contact WHERE id="+id);

	            // Récupération des données
	            while (resultat.next()) {
	            	 message = resultat.getString("message");
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
	        return message;
	    }
	
	public String getPays(int id){
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String pays= null;
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT pays FROM contact WHERE id="+id);

	            // Récupération des données
	            while (resultat.next()) {
	            	 pays = resultat.getString("pays");

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
	        return pays;
	    }
	
	
	public String getVille(int id){
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String ville= null;
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT ville FROM contact WHERE id="+id);

	            // Récupération des données
	            while (resultat.next()) {
	            	 ville = resultat.getString("ville");

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
	        return ville;
	    }
	
	
	public String getCp(int id){
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String cp= null;
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT cp FROM contact WHERE id="+id);

	            // Récupération des données
	            while (resultat.next()) {
	            	 cp = resultat.getString("cp");

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
	        return cp;
	    }
	
	public String getAdresse(int id){
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String adresse= null;
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT adresse FROM contact WHERE id="+id);

	            // Récupération des données
	            while (resultat.next()) {
	            	 adresse = resultat.getString("adresse");

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
	        return adresse;
	    }
	
	
	public String getTel(int id){
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String tel= null;
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT tel FROM contact WHERE id="+id);

	            // Récupération des données
	            while (resultat.next()) {
	            	 tel = resultat.getString("tel");
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
	        return tel;
	    }
	
	public String getEmail(int id){
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String email = null;
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT email FROM contact WHERE id="+id);

	            // Récupération des données
	            while (resultat.next()) {
	            	 email = resultat.getString("email");

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
	        return email;
	    }
	
	public String getCivilite(int id){
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String civilite= null;
		  try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT civilite FROM contact WHERE id="+id);

	            // Récupération des données
	            while (resultat.next()) {
	            	 civilite = resultat.getString("civilite");

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
	        return civilite;
	    }
	
public String getNoms(int id){
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String nom = null;
	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT nom FROM contact WHERE id="+id);

            // Récupération des données
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

public String getPrenoms(int id){
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String prenom = null;

	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT prenom FROM contact WHERE id="+id);

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

public String getSujets(int id){
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String sujet = null;

	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT sujet FROM contact WHERE id = "+id);

            // Récupération des données
            while (resultat.next()) {
            	 sujet = resultat.getString("sujet");

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
        return sujet;
    }


public String getReponse(int id){
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String reponse = null;
	  try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT reponse FROM contact WHERE id="+id);

            // Récupération des données
            while (resultat.next()) {
            	reponse = resultat.getString("reponse");
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
        return reponse;
    }



}
	
	  
	  
	


