/**
 * 
 */
package beans;

/**
 * @author myrthacomlan
 *
 */
public class Alimenter {

     
	private String montant;
	private String moyen;
	private String numero_carte;
	private String cvc;
	private String date;
	private int id_client;
	private String type;
	private String description;
	private String prenomNom;
	private String Beneficiaire;
	private String login;
	
	
	public Alimenter(String dateVir,String moyen,String prenomNom,String montant) {
		this.montant=montant;
		this.moyen=moyen;
		this.dateVir=dateVir;
		this.prenomNom=prenomNom;
		
	}
	
	public String getMoyen() {
		return moyen;
	}
	public void setMoyen(String moyen) {
		this.moyen = moyen;
	}
	
	public String getPrenomNom() {
		return prenomNom;
	}
	public void setPrenomNom(String prenomNom) {
		this.prenomNom = prenomNom;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * 
	 */
	public Alimenter() {
		super();
	}
	
	/**
	 * @param montant
	 * @param moyen
	 * @param numero_carte
	 * @param cvc
	 * @param date
	 * @param description
	 * @param beneficiaire
	 * @param login
	 * @param dateVir
	 */
	public Alimenter(String montant, String moyen, String numero_carte, String cvc, String date, String description,
			String beneficiaire, String login, String dateVir) {
		super();
		this.montant = montant;
		this.moyen = moyen;
		this.numero_carte = numero_carte;
		this.cvc = cvc;
		this.date = date;
		this.description = description;
		Beneficiaire = beneficiaire;
		this.login = login;
		this.dateVir = dateVir;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String dateVir;

	public String getDateVir() {
		return dateVir;
	}
	public void setDateVir(String dateVir) {
		this.dateVir = dateVir;
	}
	/**
	 * @return the montant
	 */
	public String getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(String montant) {
		this.montant = montant;
	}

	/**
	 * @return the numero_carte
	 */
	public String getNumero_carte() {
		return numero_carte;
	}
	/**
	 * @param numero_carte the numero_carte to set
	 */
	public void setNumero_carte(String numero_carte) {
		this.numero_carte = numero_carte;
	}
	/**
	 * @return the cvc
	 */
	public String getCvc() {
		return cvc;
	}
	/**
	 * @param cvc the cvc to set
	 */
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the id_client
	 */
	public int getId_client() {
		return id_client;
	}
	/**
	 * @param id_client the id_client to set
	 */
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return Beneficiaire;
	}
	/**
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		Beneficiaire = beneficiaire;
	}

	
}
