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
import java.util.ArrayList;

import beans.Actions;

/**
 * @author myrthacomlan
 *
 */
public class DaoActions { 
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

	public void ajouterActions(Actions action) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(
					"INSERT INTO actions (nom,dernier,id_client , nombre) VALUES(?,?,?,?);");

			preparedStatement.setString(1, action.getNom());
			preparedStatement.setFloat(2, action.getDernier());
			preparedStatement.setInt(3, action.getId_client());
			preparedStatement.setInt(4, action.getNombre());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public ArrayList<Actions> afficherAction(int id) {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Actions> actions = new ArrayList<Actions>();

		try {
			prepSt = connexion.prepareStatement("SELECT * FROM actions where id_client = " + id + ";");

			rs = prepSt.executeQuery();
			while (rs.next()) {
				String nom = rs.getString("nom");
				float dernier = rs.getFloat("dernier");
				int nombre = rs.getInt("nombre");

				Actions action = new Actions(nom, dernier, nombre);

				actions.add(action);

			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return actions;
	}
	
	public int trouverNombre(String nom, int id) {
		int nombre=0;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();


		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT nombre FROM actions WHERE nom = '" + nom + "' AND id_client= '" + id + "';");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				nombre = resultat.getInt("nombre");

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

		return nombre;
	}
	public float trouverDernier(String nom, int id) {
		float dernier=0;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();


		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT dernier FROM actions WHERE nom = '" + nom + "' AND id_client= '" + id + "';");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				dernier = resultat.getFloat("dernier");

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

		return dernier;
	}

	public String trouverAction(String nom, int id) {
		String action=null;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();


		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT nom FROM actions WHERE nom = '" + nom + "' AND id_client= '" + id + "';");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				action = resultat.getString("nom");

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
		return action;
	}
	
	public void updateNombre(String nom, int id, int nombre) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {

			preparedStatement = connexion.prepareStatement("UPDATE actions SET nombre=? WHERE id_client=? AND nom=?");

			preparedStatement.setInt(1, nombre);
			preparedStatement.setInt(2, id);
			preparedStatement.setString(3, nom);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
		public void updateDernier(String nom, int id,float dernier) {
			loadDatabase();
			PreparedStatement preparedStatement;
			try {

				preparedStatement = connexion.prepareStatement("UPDATE actions SET dernier=? WHERE id_client=? AND nom=?");

				preparedStatement.setFloat(1, dernier);
				preparedStatement.setInt(2, id);
				preparedStatement.setString(3, nom);

				preparedStatement.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		public void deleteAction(String nom, int id) {
			loadDatabase();
			PreparedStatement preparedStatement;
			try {

				preparedStatement = connexion.prepareStatement(" DELETE FROM actions WHERE id_client=? AND nom=? ");

				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, nom);
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

}
