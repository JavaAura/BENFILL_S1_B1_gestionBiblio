package dao;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import classes.Livre;
import data.Bibliotheque;

public class DaoLivreImpl implements DaoLivre {

	public boolean addLivre(String titre, String auteur, int nombreDePages, String isbn, LocalDate time) {
		Livre livre = new Livre();
		long id = Instant.now().getEpochSecond();

		livre.setId(id);
		livre.setTitre(titre);
		livre.setAuteur(auteur);
		livre.setDatePublication(time);
		livre.setNombreDePages(nombreDePages);
		livre.setIsbn(isbn);

		Bibliotheque.addLivre(id, livre);

		return true;
	}

	@Override
	public Livre searchForDocs(long id) {
		HashMap<Long, Livre> livres = Bibliotheque.livres;

		for (Map.Entry<Long, Livre> entry : livres.entrySet()) {
			long key = entry.getKey();
			Livre livre = entry.getValue();
			if (key == id)
				return livre;
		}
		return null;
	}
}