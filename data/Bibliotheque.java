package data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import classes.Livre;
import classes.Magazine;
import dao.DaoLivreImpl;
import dao.DaoMagazineImpl;

public class Bibliotheque {

	public static HashMap<Long, Livre> livres = new HashMap<Long, Livre>();
	public static HashMap<Long, Magazine> magazines = new HashMap<Long, Magazine>();

	public static void addLivre(long id, Livre obj) {
		livres.put(id, obj);
	}

	public static void addMagazine(long id, Magazine obj) {
		magazines.put(id, obj);
	}

	public static boolean getDocById(long id) {
		DaoLivreImpl livreObj = new DaoLivreImpl();
		DaoMagazineImpl magazineObj = new DaoMagazineImpl();
		Livre livre = livreObj.searchForDocs(id);
		Magazine magazine = magazineObj.searchForDocs(id);

		if (livre == null && magazine == null)
			System.out.println("il n'y a pas de document avec cet id");
		else {
			tableStyleUp();
			if (livre != null)
				livre.afficherDetails();
			else if (magazine != null)
				magazine.afficherDetails();
			tableStyleDown();
			return true;
		}

		return false;

	}

	public static void getAllDocs() {
		if (livres.isEmpty() && magazines.isEmpty()) {
			System.out.println("Aucun document disponible.");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		}

		tableStyleUp();

		for (Map.Entry<Long, Livre> entry : livres.entrySet()) {
			Livre livre = entry.getValue();
			livre.afficherDetails();
		}

		for (Map.Entry<Long, Magazine> entry : magazines.entrySet()) {
			Magazine magazine = entry.getValue();

			magazine.afficherDetails();
		}

		tableStyleDown();
	}

	public static boolean emprunterDoc(long id) {

		Livre livre = getLivre(id);
		Magazine magazine = getMagazine(id);

		if (livre != null && !livre.getBorrowed())
			livre.emprunter();
		else if (magazine != null && !magazine.getBorrowed())
			magazine.emprunter();
		else
			return false;

		return true;

	}

	public static boolean retournerDoc(long id) {

		Livre livre = getLivre(id);
		Magazine magazine = getMagazine(id);

		if (livre != null && livre.getBorrowed())
			livre.retourner();
		else if (magazine != null && magazine.getBorrowed())
			magazine.retourner();
		else
			return false;

		return true;

	}

	public static boolean checkIfThereIsDocs() {
		if (livres.isEmpty() && magazines.isEmpty()) {
			return false;
		}
		return true;
	}

	public static Livre getLivre(long id) {
		for (Map.Entry<Long, Livre> entry : livres.entrySet()) {
			long key = entry.getKey();
			Livre livre = entry.getValue();

			if (key == id) {
				return livre;
			}
		}
		return null;
	}

	public static Magazine getMagazine(long id) {
		for (Map.Entry<Long, Magazine> entry : magazines.entrySet()) {
			long key = entry.getKey();
			Magazine magazine = entry.getValue();

			if (key == id) {
				return magazine;
			}
		}
		return null;
	}

	public static void tableStyleUp() {
		System.out.println(" ");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-10s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | %-15s%n", "Type", "ID", "Titre",
				"Auteur", "Date de Pub", "Nb de Pages", "Emprunté", "Détails");

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public static void tableStyleDown() {
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" ");
	}
}
