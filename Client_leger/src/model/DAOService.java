package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Service;

public class DAOService {
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
	
	public ArrayList<Service> afficherServiceDetails(int id) {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Service> ListService = new ArrayList<Service>();

		try {
			prepSt = connexion.prepareStatement("SELECT * FROM service where id = " + id + ";");

			rs = prepSt.executeQuery();
			while (rs.next()) {
				String titre = rs.getString("titre");
				String contenu = rs.getString("contenu");
				String photoPath = rs.getString("photoPath");

				Service service = new Service(id, titre, contenu, photoPath);
				ListService.add(service);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return ListService;
	}

	public ArrayList<Service> afficherService() {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Service> ListService = new ArrayList<Service>();

		try {
			prepSt = connexion.prepareStatement("SELECT id,titre,substring(contenu,1,150) as \"contenu\",photoPath FROM service");

			rs = prepSt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id");
				String titre = rs.getString("titre");
				String contenu = rs.getString("contenu");
				String photoPath = rs.getString("photoPath");

				Service service = new Service(id,titre,contenu, photoPath);
				ListService.add(service);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return ListService;
	}

	public ArrayList<Service> rechercherService(String titre) {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Service> ListService = new ArrayList<Service>();
		try {
			prepSt = connexion.prepareStatement("SELECT id,titre,substring(contenu,1,150) as \"contenu\",photoPath FROM service WHERE titre LIKE '%" + titre + "%'");

			rs = prepSt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id");
				titre = rs.getString("titre");
				String contenu = rs.getString("contenu");
				String photoPath = rs.getString("photoPath");
				Service service = new Service(id, titre, contenu, photoPath);
				ListService.add(service);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return ListService;
	}


}
