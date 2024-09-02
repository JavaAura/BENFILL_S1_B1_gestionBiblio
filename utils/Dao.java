package utils;

import java.time.LocalDateTime;

import classes.Livre;
import data.Documents;

public class Dao {

	public boolean addLivre(String titre, String auteur, int nombreDePages, String isbn) {
		Livre livre = new Livre();
		LocalDateTime id = LocalDateTime.now();

		livre.setId(id);
		livre.setTitre(titre);
		livre.setAuteur(auteur);
		livre.setDatePublication(id);
		livre.setNombreDePages(nombreDePages);
		livre.setIsbn(isbn);

		Documents.addLivre(livre);

		return true;
	}
}