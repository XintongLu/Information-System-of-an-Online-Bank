package beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conseiller {

	private IntegerProperty id;
	private StringProperty login;
	private StringProperty password;
	private StringProperty nom;
	private StringProperty prenom;
	
	
	
	public Conseiller(String login, String password) {
		this.login = new SimpleStringProperty(login);
		this.password = new SimpleStringProperty(password);
	}
	
	
	public int getId() {
		return id.get();
	}
	public IntegerProperty idProperty() {
		return id;
	}
	public void setId(int id) {
		this.id.set(id);
	}
	
	public String getLogin() {
		return login.get();
	}
	public StringProperty LoginProperty() {
		return login;
	}
	public void setLogin(String login) {
		this.login.set(login);
	}
	
	public String getPassword() {
		return password.get();
	}
	public StringProperty passwordProperty() {
		return password;
	}
	public void setPassword(String password) {
		this.password.set(password);
	}
	
	public String getNom() {
		return nom.get();
	}
	
	public StringProperty nomProperty() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom.set(nom);
	}
	
	public String getPrenom() {
		return prenom.get();
	}
	public StringProperty prenomProperty() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}
	
}
