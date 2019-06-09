package beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Compte {
	
	private StringProperty date;
	private StringProperty operation;
	private StringProperty paiementPar;
	private StringProperty beneficiaire;
	private StringProperty montant;
	
	
	public Compte(String date, String operation, String paiementPar, String beneficiaire, String montant) {
		this.date = new SimpleStringProperty(date);
		this.operation = new SimpleStringProperty(operation);
		this.paiementPar = new SimpleStringProperty(paiementPar);
		this.beneficiaire = new SimpleStringProperty(beneficiaire);
		this.montant = new SimpleStringProperty(montant);
	}
	
	public String getDate() {
		return date.get();
	}
	public StringProperty dateProperty() {
		return date;
	}
	public void setDate(String date) {
		this.date.set(date);
	}
	
	public String getOperation() {
		return operation.get();
	}
	public StringProperty operationProperty() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation.set(operation);
	}
	
	public StringProperty paiementParProperty() {
		return paiementPar;
	}
	public String getPaiementPar() {
		return paiementPar.get();
	}
	public void setPaiementPar(String paiementPar) {
		this.paiementPar.set(paiementPar);
	}
	
	
	public StringProperty beneficiaireProperty() {
		return beneficiaire;
	}
	public String getBeneficiaire(){
		return beneficiaire.get();
	}
	public void setBeneficiaire(StringProperty beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	public String getMontant() {
		return montant.get();
	}
	
	public StringProperty montantProperty() {
		return montant;
	}
	public void setMontant(StringProperty montant) {
		this.montant = montant;
	}

}
