package beans;

import java.util.*;

public class Actualite {

	private int id;
	private String titre;
	private Date date;
	private String auteur;
	private String contenu;
	private String photoPath;

	public Actualite(int id2, String titre2, java.sql.Date date2, String auteur2, String contenu2, String photoPath2) {
		this.id = id2;
		this.titre = titre2;
		this.date = date2;
		this.auteur = auteur2;
		this.contenu = contenu2;
		this.photoPath = photoPath2;
	}
	public Actualite(int id2, String titre2,  String contenu2, String photoPath2) {
		this.id = id2;
		this.titre = titre2;
		this.contenu = contenu2;
		this.photoPath = photoPath2;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
}
