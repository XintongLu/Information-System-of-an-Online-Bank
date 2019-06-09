package view;


import java.net.URL;
import java.util.ResourceBundle;

import controller.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

	@FXML
	private Button loginButton;
	@FXML
	private AnchorPane LoginPane;

	@FXML
	private TextField loginField;
	@FXML
	private TextField passwordField;
	
	private Login login;
	
	@FXML
	private GridPane grid;
	@FXML 
	private Label actiontarget;

	public LoginController() {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void setLogin(Login login) {
		this.login=login;
	
	}

	@FXML
	public void Login_Conseil(ActionEvent arg) throws Exception  {
	
		 login.userLogin(loginField.getText(),passwordField.getText());
			
	}
	@FXML
	public void Logout_Conseil(ActionEvent arg) {
		//login.userLogout();
	}
	@FXML
	public void Clean_Conseil(ActionEvent arg) {
		loginField.setText(null);
		passwordField.setText(null);
	}

}
