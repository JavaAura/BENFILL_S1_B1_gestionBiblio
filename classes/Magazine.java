package classes;

public class Magazine extends Document {

	protected int numero;

	@Override
	public void emprunter() {
		this.setBorrowed(true);
	}

	@Override
	public void retourner() {
		this.setBorrowed(false);
	}

	public void afficherDetails() {
		System.out.printf("%-10s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | Numero: %-15s%n", "Magazine ", id,
				titre, auteur, DateUtils.toHumanDate(datePublication), nombreDePages, borrowed ? "OUI" : "NON", numero);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
