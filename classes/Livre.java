package classes;

public class Livre extends Document {

	protected String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public void emprunter() {
		this.setBorrowed(true);
	}

	@Override
	public void retourner() {
		this.setBorrowed(false);
	}

	@Override
	public String afficherDetails() {
		return "Titre: " + titre + "\n" + "Auteur: " + auteur + "\n" + "Nombre de Pages: " + nombreDePages + "\n"
				+ "ISBN: " + isbn + "\n" + "Est emprunté: " + (borrowed ? "Yes" : "No") + "\n"
				+ "Type de Document: Livre";
	}

}
