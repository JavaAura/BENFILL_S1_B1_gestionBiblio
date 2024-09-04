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
	public void afficherDetails() {
		System.out.printf("%-10s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | ISBN: %-15s%n", "Livre ", id, titre,
				auteur, DateUtils.toHumanDate(datePublication), nombreDePages, borrowed ? "OUI" : "NON", isbn);
	}

}
