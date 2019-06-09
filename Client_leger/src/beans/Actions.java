/**
 * 
 */
package beans;

/**
 * @author myrthacomlan
 *
 */
public class Actions {
	private String nom;
	private float ouverture;
	private float haut;
	private float bas;
	private float volume;

	private float dernier;
	private int id_client;
	private int nombre;

	/**
	 * @param nom
	 * @param ouverture
	 * @param haut
	 * @param bas
	 * @param volume

	 * @param dernier
	
	 */
	public Actions(String nom, float ouverture, float haut, float bas, float volume, float dernier,int nombre) {
		super();
		this.nom = nom;
		this.ouverture = ouverture;
		this.haut = haut;
		this.bas = bas;
		this.volume = volume;
		this.dernier = dernier;
		this.nombre= nombre;

	}
	/**
	 * @param nom
	 * @param dernier
	 * @param nombre
	 */
	public Actions(String nom, float dernier, int nombre) {
		super();
		this.nom = nom;
		this.dernier = dernier;
		this.nombre = nombre;
	}
	/**
	 * @param nom
	 * @param ouverture
	 * @param haut
	 * @param bas
	 * @param volume
	 * @param dernier
	 * @param id_client
	 */
	public Actions(String nom, float ouverture, float haut, float bas, float volume, float dernier) {
		super();
		this.nom = nom;
		this.ouverture = ouverture;
		this.haut = haut;
		this.bas = bas;
		this.volume = volume;
		this.dernier = dernier;
	}
	public Actions() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the ouverture
	 */
	public float getOuverture() {
		return ouverture;
	}
	
	public void setOuverture(float ouverture) {
		this.ouverture = ouverture;
	}
	
	public float getHaut() {
		return haut;
	}
	
	public void setHaut(float haut) {
		this.haut = haut;
	}
	
	public float getBas() {
		return bas;
	}
	
	public void setBas(float bas) {
		this.bas = bas;
	}
	
	public float getVolume() {
		return volume;
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	

	/**
	 * @return the dernier
	 */
	public float getDernier() {
		return dernier;
	}
	/**
	 * @param dernier the dernier to set
	 */
	public void setDernier(float dernier) {
		this.dernier = dernier;
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
	 * @return the nombre
	 */
	public int getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
}
