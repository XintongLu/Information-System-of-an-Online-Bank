package controller;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Client;
import beans.Compte;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DaoClient;
import model.DaoCompte;
import model.DaoLogin;
import view.ClientController;
import view.LoginController;

public class Login extends Application {

	private Stage stage;
	private DaoLogin daoLogin = new DaoLogin();
	private DaoClient daoClient = new DaoClient();
	private DaoCompte daoCompte = new DaoCompte();
	private ObservableList<Client> clientData = FXCollections.observableArrayList();
	private ObservableList<Compte> compte = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		stage.setTitle("E-bank");
		

		gotologin();
		stage.show();
	}

	public void gotologin() {
		try {
			LoginController login = (LoginController) replaceSceneContent("/view/Login.fxml");
			login.setLogin(this);
		} catch (Exception ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void gotohome() {
		try {
			ClientController client = (ClientController) replaceSceneContent("/view/Home.fxml");
			client.setClient(this);
		} catch (Exception ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void userLogin(String login, String password) {
		if (daoLogin.Login(login, password)) {
			gotohome();
		}
	}
	
	private int id;
	
	public void ClientIdtoCompte(String nom,String prenom) throws SQLException {
	
		id = daoClient.trouverId(nom,prenom);
		compte.clear();
		compte.addAll(daoCompte.historique(id));

	}

	public Stage getPrimaryStage() {
		return stage;
	}

	public Login() throws SQLException {
		clientData.addAll(daoClient.clientDetails());
		
	}
	
	public ObservableList<Client> getClientData() {
		return clientData;
	}
	
	public ObservableList<Compte> getCompte() {
		return compte;
	}
	
	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = Login.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(Login.class.getResource(fxml));
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page);
		stage.setScene(scene);
		stage.sizeToScene();
		return (Initializable) loader.getController();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
