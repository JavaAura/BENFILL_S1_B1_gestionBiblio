package data;

import java.util.HashMap;
import java.util.Map;

import classes.Livre;

public class Documents {

	public static HashMap<Long, Livre> livres = new HashMap<Long, Livre>();

	public static void addLivre(long id, Livre obj) {
		livres.put(id, obj);
	}

	public static void getAllDocs() {
		if (livres.isEmpty()) {
			System.out.println("Aucun livre disponible.");
			return;
		}
		System.out.println("Liste des Livres:");
		System.out.println("=================");

		for (Map.Entry<Long, Livre> entry : livres.entrySet()) {
			long key = entry.getKey();
			Livre livre = entry.getValue();

			System.out.println(key);
			System.out.println(livre.afficherDetails());
			System.out.println("=====================================");
		}
	}
}
