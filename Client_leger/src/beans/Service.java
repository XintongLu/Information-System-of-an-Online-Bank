package beans;

public class Service {
	private int id;
	private String titre;
	private String contenu;
	private String photoPath;

	public Service(int id,String titre, String contenu, String photoPath) {
		this.id=id;
		this.titre=titre;
		this.contenu=contenu;
		this.photoPath=photoPath;
	}
	
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
