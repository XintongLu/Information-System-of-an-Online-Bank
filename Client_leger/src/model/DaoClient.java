package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Alimenter;
import beans.Client;
import beans.Epargne;

/**
 * @author Nicolas CHABAL
 * Cette class controle permet d'éxecuter les requetes SQL permettant de traiter les requetes d'un client
 *
 */
public class DaoClient {
	private Connection connexion;

	/**
	 * Permet de creer une méthode pour la connexion a la BDD
	 */
	
	public void loadDataBase() {
		//Chargement du driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		try {
			String url ="";
			String user = "root";
			String password = "root";
			
			connexion = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
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
	 * @param client
	 * Permet d'inserer dans la BDD les informations d'un client lors de son inscription
	 */
	
	public void ajouterEpargne(Epargne epargne) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement("INSERT INTO Epargne(id, nom, prenom, solde) VALUES(?, ?, ?, ?);");

			preparedStatement.setInt(1, epargne.getId());
			preparedStatement.setString(2, epargne.getNom());
			preparedStatement.setString(3, epargne.getPrenom());
			preparedStatement.setInt(4, 0);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void ajouterAlimenter(Alimenter alimenter) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement("INSERT INTO Alimenter(montant,moyen_paiement,numero_carte,cvc,date,id_client) VALUES(?, ?, ?, ?, ?, ?);");

			preparedStatement.setString(1, alimenter.getMontant());
			preparedStatement.setString(2, alimenter.getMoyen());
			preparedStatement.setString(3, alimenter.getNumero_carte());
			preparedStatement.setString(4, alimenter.getCvc());
			preparedStatement.setString(5, alimenter.getDate());
		/*	preparedStatement.setBlob(8, inputStream);*/
			preparedStatement.setInt(6, alimenter.getId_client());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void updateSolde(float solde, int id) {
		loadDatabase();
		PreparedStatement preparedStatement;
		try {
			
			
			preparedStatement = connexion.prepareStatement("UPDATE client SET solde=? WHERE id=? ");

			preparedStatement.setFloat(1, solde);
			preparedStatement.setInt(2, id);
		

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public int ajouterClient(Client client) {
		loadDatabase();
		PreparedStatement preparedStatement;
		int num=0;
		try {
		preparedStatement = connexion.prepareStatement(
					"INSERT INTO client(sexe, nom, prenom, login, nationalite, date, tel, adresse, ville, cp, email, password, solde, etatEpargne) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?);");

			preparedStatement.setString(1, client.getSexe());
			preparedStatement.setString(2, client.getNom());
			preparedStatement.setString(3, client.getPrenom());
			preparedStatement.setString(4, client.getLogin());
			preparedStatement.setString(5, client.getNationalite());
			preparedStatement.setString(6, client.getDateDeNaissance());
			preparedStatement.setString(7, client.getNumerodetelephone());
			preparedStatement.setString(8, client.getAdresse());
			preparedStatement.setString(9, client.getVille());
			preparedStatement.setString(10, client.getCodePostal());
			preparedStatement.setString(11, client.getEmail());
			preparedStatement.setString(12, client.getMotdepasse());
			preparedStatement.setFloat(13,0);
			preparedStatement.setFloat(14,0);

		num=preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return num;
	}
	
	
	public void modifierClient(Client client){
		loadDatabase();
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connexion.prepareStatement ("INSERT INTO client(sexe, nom, prenom, login, nationalite, date, tel, adresse, ville, cp, email, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
				
				preparedStatement.setString(1, client.getSexe());
				preparedStatement.setString(2, client.getNom());
				preparedStatement.setString(3, client.getPrenom());
				preparedStatement.setString(4, client.getLogin());
				preparedStatement.setString(5, client.getNationalite());
				preparedStatement.setString(6, client.getDateDeNaissance());
				preparedStatement.setString(7, client.getNumerodetelephone());
				preparedStatement.setString(8, client.getAdresse());
				preparedStatement.setString(9, client.getVille());
				preparedStatement.setString(10, client.getCodePostal());
				preparedStatement.setString(11, client.getEmail());
				preparedStatement.setString(12, client.getMotdepasse());
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
	}
	
	public int trouverEtatEpargne(int id) {
		int etat = 0;
		Statement statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT etatEpargne FROM client WHERE id = '" + id + "';");
			while (resultat.next()) {
				etat = resultat.getInt("etat");
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
		return etat;
	}
	
	public float trouverSolde(String login) {
		float solde = 0;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();


		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT solde FROM client WHERE login = '" + login + "';");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				solde = resultat.getFloat("solde");

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
		return solde;
	}
	
	public String trouverIdEpargne(int id) {
		String idEpargne = null;
		Statement statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT id FROM Epargne WHERE id = '" + id + "';");
			while (resultat.next()) {
				idEpargne = resultat.getString("id");
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
		return idEpargne;
	}
	
	public float trouverSoldeEpargne(int id) {
		float solde = 0;
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Ex�cution de la requ�te
			resultat = statement.executeQuery("SELECT solde FROM Epargne WHERE id = '" + id + "';");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				solde = resultat.getFloat("solde");

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
		return solde;
	}

	public boolean trouverLogin(String login) {
		  	boolean etat = false;
	        Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT login FROM client WHERE login = '"+login+"';");

	            // Récupération des données
	            while (resultat.next()) {
	            	String log = resultat.getString("login");
	            	
	            	if(log.equals(login)) {
	            		etat =true;
	            	}
	            	else {
	            		etat=false;
	            	}

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
	        System.out.println(etat);
	        return etat;
	    }
	  
	public boolean trouverPassword(String mdp, String login) {
		  	boolean etat = false;
	        Statement statement = null;
	        ResultSet resultat = null;
	        DaoClient dao = new DaoClient();

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT password FROM client WHERE login = '"+login+"';");

	            // Récupération des données
	            while (resultat.next()) {
	            	String passwd = resultat.getString("password");
	            	
	            	if(passwd.equals(mdp) && dao.trouverLogin(login)) {
	            		etat =true;
	            	}
	            	else {
	            		etat=false;
	            	}

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
	        System.out.println(etat);
	        return etat;
	    }
	  
	  // Retourne le prénom d'un utilisateur depuis son login
	  public String trouverPrenom(String login) {
	        String prenom = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT prenom FROM client WHERE login = '"+login+"';");

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
	  
	  public String trouverNom(String login) {
	        String nom = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT nom FROM client WHERE login = '"+login+"';");

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
	  
	  public String trouverSexe(String login) {
	        String sexe = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT sexe FROM client WHERE login = '"+login+"';");

	            // Récupération des données
	            while (resultat.next()) {
	            	sexe = resultat.getString("sexe");

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
	        return sexe;
	    }
	  
	  public String trouverNationalite(String login) {
	        String nationalite = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT nationalite FROM client WHERE login = '"+login+"';");

	            // Récupération des données
	            while (resultat.next()) {
	            	nationalite = resultat.getString("nationalite");

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
	        return nationalite;
	    }
	  
	  public String trouverDateDeNaissance(String login) {
	        String dateDeNaissance = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT date FROM client WHERE login = '"+login+"';");

	            // Récupération des données
	            while (resultat.next()) {
	            	dateDeNaissance = resultat.getString("date");

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
	        return dateDeNaissance;
	    }
	  
	  public String trouverNumeroDeTelephone(String login) {
	        String numerodetelephone = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT tel FROM client WHERE login = '"+login+"';");

	            // Récupération des données
	            while (resultat.next()) {
	            	numerodetelephone = resultat.getString("tel");

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
	        return numerodetelephone;
	    }
	  
	  public String trouverAdresse(String login) {
	        String adresse = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT adresse FROM client WHERE login = '"+login+"';");

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
	  
	  public String trouverVille(String login) {
	        String ville = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT ville FROM client WHERE login = '"+login+"';");

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
	  public String trouverCodePostal(String login) {
	        String codePostal = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT cp FROM client WHERE login = '"+login+"';");

	            // Récupération des données
	            while (resultat.next()) {
	            	codePostal = resultat.getString("cp");

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
	        return codePostal;
	    }
	  
	  public String trouverMail(String login) {
	        String email = null;
		  	Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT email FROM client WHERE login = '"+login+"';");

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
	  
	  public int trouverId(String login) {
			int id = 0;
			Statement statement = null;
			ResultSet resultat = null;

			loadDatabase();

			try {
				statement = connexion.createStatement();

				// Ex�cution de la requ�te
				resultat = statement.executeQuery("SELECT id FROM client WHERE login = '" + login + "';");

				// R�cup�ration des donn�es
				while (resultat.next()) {
					id = resultat.getInt("id");

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
			return id;
		}
	  
		public int activeClient(String code) {
			int num=0;
			Statement statement = null;
			ResultSet resultat = null;
			PreparedStatement prepSt;

			loadDatabase();

			try {
				prepSt = connexion.prepareStatement("UPDATE client SET etat=1 where code = '" + code + "'; ");

				num=prepSt.executeUpdate();
				
				
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
			return num;
		}
	}


