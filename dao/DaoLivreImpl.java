package dao;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import classes.Livre;
import data.Documents;

public class DaoLivreImpl implements DaoLivre {

	public boolean addLivre(String titre, String auteur, int nombreDePages, String isbn) {
		Livre livre = new Livre();
		LocalDateTime time = LocalDateTime.now();
		long id = Instant.now().getEpochSecond();

		livre.setId(id);
		livre.setTitre(titre);
		livre.setAuteur(auteur);
		livre.setDatePublication(time);
		livre.setNombreDePages(nombreDePages);
		livre.setIsbn(isbn);

		Documents.addLivre(id, livre);

		return true;
	}

	public void getLivres() {

	}

	@Override
	public Livre searchForDocs(long id) {
		HashMap<Long, Livre> livres = Documents.livres;

		for (Map.Entry<Long, Livre> entry : livres.entrySet()) {
			long key = entry.getKey();
			Livre livre = entry.getValue();
			if (key == id)
				return livre;
		}
		return null;
	}
}