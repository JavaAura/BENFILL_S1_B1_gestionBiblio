package classes;

import java.time.LocalDate;

abstract class Document {

	protected long id;
	protected String titre;
	protected String auteur;
	protected LocalDate datePublication;
	protected int nombreDePages;
	protected boolean borrowed = false;

	public abstract void emprunter();

	public abstract void retourner();

	public abstract void afficherDetails();

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

	public LocalDate getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(LocalDate datePublication) {
		this.datePublication = datePublication;
	}

	public int getNombreDePages() {
		return nombreDePages;
	}

	public void setNombreDePages(int nombreDePages) {
		this.nombreDePages = nombreDePages;
	}

}
