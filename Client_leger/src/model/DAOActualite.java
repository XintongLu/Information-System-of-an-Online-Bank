package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Actualite;

public class DAOActualite {

	private static Connection connexion;
	private static String url;
	private static String user;
	private static String password;

	public static void loadDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}

		try {

			url = "jdbc:mysql://localhost:3306/banque_en_ligne_tic3_grp1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			user = "root";
			password = "root";

			connexion = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(
					"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}

	public void ajouterActualite(Actualite actu) {
		loadDatabase();
		PreparedStatement prepSt;

		try {
			prepSt = connexion
					.prepareStatement("INSERT INTO actualite(id,titre,date,auteur,contenu) VALUES(?,?,?,?,?);");

			prepSt.setInt(1, actu.getId());
			prepSt.setString(2, actu.getTitre());
			prepSt.setDate(3, (Date) actu.getDate());
			prepSt.setString(4, actu.getAuteur());
			prepSt.setString(5, actu.getContenu());

			prepSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Actualite> afficherActuDetails(int id) {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Actualite> actu = new ArrayList<Actualite>();

		try {
			prepSt = connexion.prepareStatement("SELECT * FROM actualite where id = " + id + ";");

			rs = prepSt.executeQuery();
			while (rs.next()) {
				String titre = rs.getString("titre");
				Date date = rs.getDate("date");
				String auteur = rs.getString("auteur");
				String contenu = rs.getString("contenu");
				String photoPath = rs.getString("photoPath");

				Actualite actualite = new Actualite(id, titre, date, auteur, contenu, photoPath);
				actu.add(actualite);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return actu;
	}

	public ArrayList<Actualite> afficherActu() {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Actualite> actu = new ArrayList<Actualite>();

		try {
			prepSt = connexion.prepareStatement("SELECT id,titre,substring(contenu,1,150) as \"contenu\",photoPath FROM actualite");

			rs = prepSt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id");
				String titre = rs.getString("titre");
				String contenu = rs.getString("contenu");
				String photoPath = rs.getString("photoPath");

				Actualite actualite = new Actualite(id,titre,contenu, photoPath);
				actu.add(actualite);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return actu;
	}

	public ArrayList<Actualite> rechercherActu(String titre) {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Actualite> actu = new ArrayList<Actualite>();
		try {
			prepSt = connexion.prepareStatement("SELECT id,titre,substring(contenu,1,150) as \"contenu\",photoPath FROM actualite WHERE titre LIKE '%" + titre + "%'");

			rs = prepSt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id");
				titre = rs.getString("titre");
				String contenu = rs.getString("contenu");
				String photoPath = rs.getString("photoPath");
				Actualite actualite = new Actualite(id, titre, contenu, photoPath);
				actu.add(actualite);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return actu;
	}

}
