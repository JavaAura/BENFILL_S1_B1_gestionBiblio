package dao;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import classes.Magazine;
import data.Documents;

public class DaoMagazineImpl {

	public boolean addMagazine(String titre, String auteur, int nombreDePages, int numero, LocalDate time) {
		Magazine magazine = new Magazine();
		long id = Instant.now().getEpochSecond();

		magazine.setId(id);
		magazine.setTitre(titre);
		magazine.setAuteur(auteur);
		magazine.setDatePublication(time);
		magazine.setNombreDePages(nombreDePages);
		magazine.setNumero(numero);

		Documents.addMagazine(id, magazine);

		return true;
	}

	public Magazine searchForDocs(long id) {
		HashMap<Long, Magazine> magazines = Documents.magazines;

		for (Map.Entry<Long, Magazine> entry : magazines.entrySet()) {
			long key = entry.getKey();
			Magazine magazine = entry.getValue();
			if (key == id)
				return magazine;
		}
		return null;
	}
}
