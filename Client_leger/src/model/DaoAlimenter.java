/**
 * 
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import au.com.bytecode.opencsv.CSVReader;
import beans.Actions;
import beans.Alimenter;

/**
 * @author myrthacomlan
 *
 */
public class DaoAlimenter {
	private Connection connexion;

	/**
	 * Permet de creer une m�thode pour la connexion a la BDD
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
	 * @param epargne Permet d'inserer dans la BDD les informations du compte
	 *                epargne d'un client
	 * @throws IOException
	 */
	public void ajouterAlimenter(Alimenter alimenter) {

		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(
					"INSERT INTO Alimenter(montant, moyen_paiement, numero_carte, cvc, date, id_client, beneficiaire, description,dateVir) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?);");

			preparedStatement.setString(1, alimenter.getMontant());
			preparedStatement.setString(2, alimenter.getMoyen());
			preparedStatement.setString(3, alimenter.getNumero_carte());
			preparedStatement.setString(4, alimenter.getCvc());
			preparedStatement.setString(5, alimenter.getDate());
			preparedStatement.setInt(6, alimenter.getId_client());
			preparedStatement.setString(7, alimenter.getType());
			preparedStatement.setString(8, alimenter.getDescription());
			preparedStatement.setString(9, alimenter.getDateVir());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void exportHistorique(int id) {
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();
		try {
			// Chemin du fichier
			/**
			 * !! IL FAUT CHANGER LE CHEMIN SUIVANT LA LOCALISATION DE VOTRE WORKSPACE !!
			 */
			PrintWriter pw = new PrintWriter(new File(
					"C:\\Program Files\\eclipse\\eclipse-workspace\\worskpace_advancedJava\\Projet S8\\fichiers\\extrait.csv"));
			StringBuilder sb = new StringBuilder();
			statement = connexion.createStatement();
			resultat = statement.executeQuery(
					"SELECT montant, moyen_paiement, beneficiaire, description, dateVir  FROM alimenter WHERE id_client = " + id);

			// On met le nom des colonnes
			sb.append("Montant EUROS, Paiement par, B�n�ficiaire, Op�ration, Date \r\n");

			// On recupere les donn�es de la bdd
			while (resultat.next()) {
				sb.append(resultat.getString("montant"));
				sb.append(",");
				sb.append(resultat.getString("moyen_paiement"));
				sb.append(",");
				sb.append(resultat.getString("beneficiaire"));
				sb.append(",");
				sb.append(resultat.getString("description"));
				sb.append(",");
				sb.append(resultat.getString("dateVir"));
				sb.append("\r\n");
			}

			pw.write(sb.toString());
			pw.close();
			System.out.println("finished");

		} catch (SQLException | FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	
	public ArrayList<String> getListMontant(int id) {
		
		ArrayList<String> listMontant = new ArrayList<String>();
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String montant=null;
		  try {
	            statement = connexion.createStatement();

	            // Ex�cution de la requ�te
	            resultat = statement.executeQuery("SELECT montant FROM alimenter WHERE id_client="+id);

	            // R�cup�ration des donn�es
	            while (resultat.next()) {
	            	montant = resultat.getString("montant");
	            	listMontant.add(montant);
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
		return listMontant;
	}
	
	public ArrayList<String> getListMoyen (int id) {
		
		ArrayList<String> listMoyen = new ArrayList<String>();
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String moyen=null;
		  try {
	            statement = connexion.createStatement();

	            // Ex�cution de la requ�te
	            resultat = statement.executeQuery("SELECT moyen_paiement FROM alimenter WHERE id_client="+id);

	            // R�cup�ration des donn�es
	            while (resultat.next()) {
	            	moyen = resultat.getString("moyen_paiement");
	            	listMoyen.add(moyen);
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
		return listMoyen;
	}
	
	public ArrayList<String> getListBeneficiaire (int id) {
		
		ArrayList<String> listBeneficiaire = new ArrayList<String>();
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String beneficiaire=null;
		  try {
	            statement = connexion.createStatement();

	            // Ex�cution de la requ�te
	            resultat = statement.executeQuery("SELECT beneficiaire FROM alimenter WHERE id_client="+id);

	            // R�cup�ration des donn�es
	            while (resultat.next()) {
	            	beneficiaire = resultat.getString("beneficiaire");
	            	listBeneficiaire.add(beneficiaire);
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
		return listBeneficiaire;
	}
	
	public ArrayList<String> getListDescription (int id) {
		
		ArrayList<String> listDescription = new ArrayList<String>();
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String description=null;
		  try {
	            statement = connexion.createStatement();

	            // Ex�cution de la requ�te
	            resultat = statement.executeQuery("SELECT description FROM alimenter WHERE id_client="+id);

	            // R�cup�ration des donn�es
	            while (resultat.next()) {
	            	description = resultat.getString("description");
	            	listDescription.add(description);
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
		return listDescription;
	}
	
	public ArrayList<String> getListDate(int id) {
		
		ArrayList<String> listDate = new ArrayList<String>();
		loadDatabase();
	    Statement statement = null;
	    ResultSet resultat = null;
	    String date=null;
		  try {
	            statement = connexion.createStatement();

	            // Ex�cution de la requ�te
	            resultat = statement.executeQuery("SELECT dateVir FROM alimenter WHERE id_client="+id);

	            // R�cup�ration des donn�es
	            while (resultat.next()) {
	            	date = resultat.getString("dateVir");
	            	listDate.add(date);
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
		return listDate;
	}
	


	public void exportHistoriquePDF() {
		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
		Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
        
        /* Step -1 : Read input CSV file in Java */
        String inputCSVFile = "C:\\Program Files\\eclipse\\eclipse-workspace\\worskpace_advancedJava\\Projet S8\\fichiers\\extrait.csv";
        CSVReader reader;
	try {
		
	
			reader = new CSVReader(new FileReader(inputCSVFile));
		
        /* Variables to loop through the CSV File */
        String [] nextLine; /* for every line in the file */            
        int lnNum = 0; /* line number */
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_data = new Document();
        PdfWriter.getInstance(my_pdf_data, new FileOutputStream("C:\\Program Files\\eclipse\\eclipse-workspace\\worskpace_advancedJava\\Projet S8\\fichiersPDF\\extrait.pdf"));
        my_pdf_data.open();
        my_pdf_data.add(new Paragraph("Extrait de compte - E-BANK"));
        my_pdf_data.add(new Paragraph(" "));
        my_pdf_data.add(new Paragraph("Pour toutes questions veuillez contacter nos conseillers via la messagerie du site. "));
        my_pdf_data.add(new Paragraph(" "));
        PdfPTable my_first_table = new PdfPTable(5);
        PdfPCell table_cell;
        /* Step -3: Loop through CSV file and populate data to PDF table */
        while ((nextLine = reader.readNext()) != null) {
                lnNum++;        
                table_cell=new PdfPCell(new Phrase(nextLine[0], normalFont));
                my_first_table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase(nextLine[1], normalFont));
                my_first_table.addCell(table_cell);       
                table_cell=new PdfPCell(new Phrase(nextLine[2], normalFont));
                my_first_table.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase(nextLine[3], normalFont));
                my_first_table.addCell(table_cell); 
                table_cell=new PdfPCell(new Phrase(nextLine[4], normalFont));
                my_first_table.addCell(table_cell);
        } 

        /* Step -4: Attach table to PDF and close the document */
        my_pdf_data.add(my_first_table);                       
        my_pdf_data.close(); 
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public ArrayList<Alimenter> uploadTransaction() {

		loadDatabase();
		PreparedStatement prepSt = null;
		ResultSet rs = null;

		ArrayList<Alimenter> transactions = new ArrayList<Alimenter>();
		DaoClient dao= new DaoClient();

		try {
			prepSt = connexion.prepareStatement("SELECT * FROM alimenter ");

			rs = prepSt.executeQuery();
			while (rs.next()) {
				String montant= rs.getString("montant");
				String moyen= rs.getString("moyen_paiement");
				String numero_carte= rs.getString("numero_carte");
				String cvc = rs.getString("cvc");
				String date = rs.getString("date");
				String beneficiaire = rs.getString("beneficiaire"); 
				String description = rs.getString("description");
				String dateVir = rs.getString("dateVir");
				String idClient= rs.getString("id_client");
				
				if(description==null)
				{
					description="Aucune description";
				}

				Alimenter transaction=new Alimenter(montant,moyen,numero_carte,cvc,date, description,beneficiaire,idClient, dateVir);
				
				transactions.add(transaction);

			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return transactions;
	}

	

}
