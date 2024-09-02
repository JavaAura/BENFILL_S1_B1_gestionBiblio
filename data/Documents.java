package data;

import java.util.HashMap;

import classes.Livre;

public class Documents {

	static HashMap<Livre, Livre> livres = new HashMap<Livre, Livre>();

	public static void addLivre(Livre obj) {

		livres.put(obj, obj);

	}
}
