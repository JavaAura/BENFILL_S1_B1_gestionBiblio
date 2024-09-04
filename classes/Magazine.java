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

	public String afficherDetails() {
		return "Titre: " + titre + "\n" + "Auteur: " + auteur + "\n" + "Nombre de Pages: " + nombreDePages + "\n"
				+ "Numero: " + numero + "\n" + "Est emprunté: " + (borrowed ? "Yes" : "No") + "\n"
				+ "Type de Document: Magazine";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
