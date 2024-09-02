package classes;

class Magazine extends Document {

	protected int numero;

	@Override
	protected void emprunter() {
		this.setBorrowed(true);
	}

	@Override
	protected void retourner() {
		this.setBorrowed(false);
	}

	@Override
	protected String afficherDetails() {
		return auteur;
		// TODO Auto-generated method stub

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
