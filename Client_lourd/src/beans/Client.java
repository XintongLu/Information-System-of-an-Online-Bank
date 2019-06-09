package beans;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
/*
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
*/
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//Property nous permet de synchronizer les donnees entre view et bdd

public class Client {
//	private StringProperty sexe;
	private StringProperty nom;
	private StringProperty prenom;
//	private StringProperty login;
	private StringProperty nationalite;
	private StringProperty dateDeNaissance;
	private StringProperty tel;
//	private StringProperty adresse;
	private StringProperty ville;
	private StringProperty codePostal;
	private StringProperty email;
//	private StringProperty motdepasse;

//	private int etat;  // etat de l'activation par mail
//	private String code;
	private FloatProperty solde;





	public Client(String nom, String prenom,String nationalite,String date,String adresse,String ville,String cp,String tel,String email,float solde) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.nationalite = new SimpleStringProperty(nationalite);
		this.dateDeNaissance = new SimpleStringProperty(date);
		//this.adresse = new SimpleStringProperty(adresse);
		this.ville = new SimpleStringProperty(ville);
		this.codePostal = new SimpleStringProperty(cp);
		this.tel = new SimpleStringProperty(tel);
		this.email = new SimpleStringProperty(email);
		this.solde = new SimpleFloatProperty(solde);
	}

	// nom
	public String getNom() {
		return nom.get();
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}

	public StringProperty nomProperty() {
		return nom;
	}

	// prenom
	public String getPrenom() {
		return prenom.get();
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}

	public StringProperty prenomProperty() {
		return prenom;
	}

	// date de naissance
	public String getDateDeNaissance() {
		return dateDeNaissance.get();
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance.set(dateDeNaissance);
	}

	public StringProperty DateDeNaissanceProperty() {
		return dateDeNaissance;
	}


	/*
	//address
	public String getAdresse() {
		return adresse.get();
	}

	public StringProperty AdresseProperty() {
		return adresse;
	}

	public void setAdresse(StringProperty adresse) {
		this.adresse = adresse;
	}*/

	// ville
	public String getVille() {
		return ville.get();
	}

	public StringProperty VilleProperty() {
		return ville;
	}

	public void setVille(StringProperty ville) {
		this.ville = ville;
	}

	// code postal
	public String getCodePostal() {
		return codePostal.get();
	}

	public StringProperty CodePostalProperty() {
		return codePostal;
	}
	
	public void setCodePostal(StringProperty codePostal) {
		this.codePostal = codePostal;
	}

	
	//nationalite
	public String getNationalite() {
		return codePostal.get();
	}
	
	public StringProperty getNationaliteProperty() {
		return nationalite;
	}

	public void setNationalite(StringProperty nationalite) {
		this.nationalite = nationalite;
	}

	//tel
	public String getTel() {
		return tel.get();
	}
	
	public StringProperty getTelProperty() {
		return tel;
	}

	public void setTel(StringProperty tel) {
		this.tel = tel;
	}

	//mail
	public String getEmail() {
		return email.get();
	}
	
	public StringProperty getEmailProperty() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	//solde
	public float getSolde() {
		return solde.get();
	}
	public FloatProperty getSoldeProperty() {
		return solde;
	}
	public void setSolde(FloatProperty solde) {
		this.solde = solde;
	}

	
}
