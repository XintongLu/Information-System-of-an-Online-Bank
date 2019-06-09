package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoHistoConn {
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
	
	
	public void ajouterConnexion(int idClient, String login, String ip, String etat, String date) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement("INSERT INTO histor_conn(id_client, login, ip, etat, date) VALUES(?, ?, ?, ?, ?);");

			preparedStatement.setInt(1, idClient);
			preparedStatement.setString(2, login);
			preparedStatement.setString(3, ip);
			preparedStatement.setString(4, etat);
			preparedStatement.setString(5, date);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
public ArrayList<Integer> getListId() {
		ArrayList<Integer> listId = new ArrayList<Integer>();
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    int idClient=0;
		  try {
	            statement = connexion.createStatement();

	            // Ex�cution de la requ�te
	            resultat = statement.executeQuery("SELECT id_client FROM histor_conn");

	            // R�cup�ration des donn�es
	            while (resultat.next()) {
	            	idClient = resultat.getInt("id_client");
	            	listId.add(idClient);
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
		return listId;
	}


public ArrayList<String> getListLogin(int id) {
	ArrayList<String> listLogin = new ArrayList<String>();
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String login=null;
	  try {
            statement = connexion.createStatement();

            // Ex�cution de la requ�te
            resultat = statement.executeQuery("SELECT login FROM histor_conn");

            // R�cup�ration des donn�es
            while (resultat.next()) {
            	login = resultat.getString("login");
            	listLogin.add(login);
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
	return listLogin;
}

public ArrayList<String> getListEtat(int id) {
	ArrayList<String> getListEtat = new ArrayList<String>();
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String etat=null;
	  try {
            statement = connexion.createStatement();

            // Ex�cution de la requ�te
            resultat = statement.executeQuery("SELECT etat FROM histor_conn");

            // R�cup�ration des donn�es
            while (resultat.next()) {
            	etat = resultat.getString("etat");
            	getListEtat.add(etat);
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
	return getListEtat;
}


public ArrayList<String> getListIp(int id) {
	ArrayList<String> getListIp = new ArrayList<String>();
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String ip=null;
	  try {
            statement = connexion.createStatement();

            // Ex�cution de la requ�te
            resultat = statement.executeQuery("SELECT ip FROM histor_conn");

            // R�cup�ration des donn�es
            while (resultat.next()) {
            	ip = resultat.getString("ip");
            	getListIp.add(ip);
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
	return getListIp;
}
	
public ArrayList<String> getListDate(int id) {
	ArrayList<String> getListDate = new ArrayList<String>();
	loadDatabase();
    Statement statement = null;
    ResultSet resultat = null;
    String date=null;
	  try {
            statement = connexion.createStatement();

            // Ex�cution de la requ�te
            resultat = statement.executeQuery("SELECT date FROM histor_conn");

            // R�cup�ration des donn�es
            while (resultat.next()) {
            	date = resultat.getString("date");
            	getListDate.add(date);
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
	return getListDate;
}	
	
	
}
