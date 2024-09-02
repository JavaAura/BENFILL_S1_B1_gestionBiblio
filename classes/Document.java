package classes;

import java.time.LocalDateTime;

abstract class Document {

	protected LocalDateTime id;
	protected String titre;
	protected String auteur;
	protected LocalDateTime datePublication;
	protected int nombreDePages;

	protected abstract void emprunter();

	protected abstract void retourner();

	protected abstract void afficherDetails();

	public LocalDateTime getId() {
		return id;
	}

	public void setId(LocalDateTime id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public LocalDateTime getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(LocalDateTime datePublication) {
		this.datePublication = datePublication;
	}

	public int getNombreDePages() {
		return nombreDePages;
	}

	public void setNombreDePages(int nombreDePages) {
		this.nombreDePages = nombreDePages;
	}
}
