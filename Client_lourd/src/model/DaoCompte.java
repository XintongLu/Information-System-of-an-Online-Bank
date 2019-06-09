package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Compte;

public class DaoCompte {
	
	private static Connection connexion;
	
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
	
	public ArrayList<Compte> historique(int id) throws SQLException{

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Compte> historique = new ArrayList<Compte>();

		try {
			prepSt = connexion.prepareStatement("SELECT dateVir,description,moyen_paiement,beneficiaire,montant FROM alimenter where id_client = '" + id + "'");

			rs = prepSt.executeQuery();
			while (rs.next()) {
			
				String date = rs.getString("dateVir");
				String operation = rs.getString("description");
				String paiementPar = rs.getString("moyen_paiement");
				String beneficiaire = rs.getString("beneficiaire");
				String montant = rs.getString("montant");
		
				
				Compte compte = new Compte(date,operation,paiementPar,beneficiaire, montant);
				historique.add(compte);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		System.out.println(id);
		return historique;
	}

}
