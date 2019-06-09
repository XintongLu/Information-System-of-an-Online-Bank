package beans;


/**
 * @author Nicolas CHABAL
 * Cette classe est un Java Bean qui permet de rassembler les donn�es d'un client dans un bean.
 *
 */
public class Client {
	private String sexe;
	private String nom;
	private String prenom;
	private String login;
	private String nationalite;
	private String dateDeNaissance;
	private String numerodetelephone;
	private String adresse;
	private String ville;
	private String codePostal;
	private String email;
	private String motdepasse;
	private String confirmation;	
	private int etat;  // etat de l'activation par mail
	private String code;
	private float solde;
	private String ip;
	public int etatEpargne;
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getEtatEpargne() {
		return etatEpargne;
	}
	public void setEtatEpargne(int etatEpargne) {
		this.etatEpargne = etatEpargne;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getNumerodetelephone() {
		return numerodetelephone;
	}
	public void setNumerodetelephone(String numerodetelephone) {
		this.numerodetelephone = numerodetelephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	/**
	 * @return the solde
	 */
	public float getSolde() {
		return solde;
	}
	/**
	 * @param solde the solde to set
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}
	

	
	
}

