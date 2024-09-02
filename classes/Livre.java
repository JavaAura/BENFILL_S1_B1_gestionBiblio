package classes;

public class Livre extends Document {

	protected String isbn;

	@Override
	protected void emprunter() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void retourner() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void afficherDetails() {
		// TODO Auto-generated method stub

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
