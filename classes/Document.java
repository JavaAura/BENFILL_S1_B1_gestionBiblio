package classes;

import java.time.LocalDateTime;

abstract class Document {

	protected long id;
	protected String titre;
	protected String auteur;
	protected LocalDateTime datePublication;
	protected int nombreDePages;
	protected boolean borrowed = false;

	protected abstract void emprunter();

	protected abstract void retourner();

	protected abstract String afficherDetails();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public boolean getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(Boolean borrowed) {
		this.borrowed = borrowed;
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
