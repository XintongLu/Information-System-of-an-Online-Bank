package view;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import beans.Client;
import beans.Compte;
import controller.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import  javafx.scene.control.Button;


/* Client overview controller et client overview doit etre dans le meme package
 * sinon le SceneBuilder ne les trouve pas 
 * 
 */


public class ClientController  implements Initializable {

	@FXML Button compteButton;
	@FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> nomColumn;
    @FXML
    private TableColumn<Client, String> prenomColumn;

    @FXML
    private Label nomLabel,prenomLabel,dateDeNaissanceLabel,nationaliteLabel,villeLabel,codePostalLabel,emailLabel,
    telLabel,soldeLabel;
    
    //menu buttons and panes
    @FXML
    private Button btnHome,btnClient,btnSignOut;

    @FXML
    private Pane pnlHome;
    @FXML
    private SplitPane pnlClient;
    @FXML
    private Pane pnlCompte;
    
    @FXML private AnchorPane ClientPane;
    
    private Login login;
    
	@FXML
    private TableView<Compte> CompteTable;
    @FXML
    private TableColumn<Compte, String> dateColumn;
    @FXML
    private TableColumn<Compte, String> operationColumn;
    @FXML
    private TableColumn<Compte, String> paiementParColumn;
    @FXML
    private TableColumn<Compte, String> beneficiaireColumn;
    @FXML
    private TableColumn<Compte, String> montantColumn;

    
 /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ClientController() {
    }


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
  @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the person table with the two columns.
    	nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
    	prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
    	
    	 // Initialize the person table with the two columns.
        nomColumn.setCellValueFactory(
                cellData -> cellData.getValue().nomProperty());
       prenomColumn.setCellValueFactory(
                cellData -> cellData.getValue().prenomProperty());

        // Clear person details.
        showClientDetails(null);
        

        // Listen for selection changes and show the person details when changed.
        clientTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showClientDetails(newValue));
        
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
    	operationColumn.setCellValueFactory(cellData -> cellData.getValue().operationProperty());
    	paiementParColumn.setCellValueFactory(cellData -> cellData.getValue().paiementParProperty());
    	beneficiaireColumn.setCellValueFactory(cellData -> cellData.getValue().beneficiaireProperty());
    	montantColumn.setCellValueFactory(cellData -> cellData.getValue().montantProperty());
    	
    	
    	 // Initialize the person table with the two columns.
        dateColumn.setCellValueFactory(
                cellData -> cellData.getValue().dateProperty());
       operationColumn.setCellValueFactory(
                cellData -> cellData.getValue().operationProperty());
       paiementParColumn.setCellValueFactory(
               cellData -> cellData.getValue().paiementParProperty());
      beneficiaireColumn.setCellValueFactory(
               cellData -> cellData.getValue().beneficiaireProperty());
      montantColumn.setCellValueFactory(
              cellData -> cellData.getValue().montantProperty());
    
    }

    /**
     * Is called by the clientOverview to give a reference back to itself.
     * 
     * @param clientList
     */  
    public void setClient(Login login) {
    	this.login=login;
        // Add observable list data to the table
        clientTable.setItems(login.getClientData());
        CompteTable.setItems(login.getCompte());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
    private void showClientDetails(Client client) {
        if (client != null) {
         
            nomLabel.setText(client.getNom());
            prenomLabel.setText(client.getPrenom());
            dateDeNaissanceLabel.setText(client.getDateDeNaissance());
            nationaliteLabel.setText(client.getNationalite());
           // addressLabel.setText(client.getAdresse());
            codePostalLabel.setText(client.getCodePostal());
            villeLabel.setText(client.getVille());
            emailLabel.setText(client.getEmail());
            telLabel.setText(client.getTel());
            soldeLabel.setText(String.valueOf(client.getSolde()));

        } else {
            // Person is null, remove all the text.
        	 nomLabel.setText("");
             prenomLabel.setText("");
             dateDeNaissanceLabel.setText("");
             nationaliteLabel.setText("");
            // addressLabel.setText(client.getAdresse());
             codePostalLabel.setText("");
             villeLabel.setText("");
             emailLabel.setText("");
             telLabel.setText("");
             soldeLabel.setText("");
          
        }
    }
   /* 
	@FXML
	public void toCompte(ActionEvent arg) throws Exception  {
	
		 login.ClientIdtoCompte(nomLabel.getText(),prenomLabel.getText());
		
	}*/

	
	 public void handleClicks(ActionEvent actionEvent) throws SQLException {
	        if (actionEvent.getSource() == btnClient) {
	            pnlClient.toFront();
	        }
	        if (actionEvent.getSource() == btnHome) {
	         
	            pnlHome.toFront();
	        }
	        if (actionEvent.getSource() == btnSignOut) {
	          login.gotologin();
	        
	        } 
	        if (actionEvent.getSource() == compteButton) {
	        	
	        	 login.ClientIdtoCompte(nomLabel.getText(),prenomLabel.getText());
	        	 pnlCompte.toFront();
	        } 
	    }



    
}
