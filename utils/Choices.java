package utils;

import java.util.Scanner;

import dao.DaoLivreImpl;
import data.Documents;

public class Choices {

	public void clear() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Scanner sc = new Scanner(System.in);

	public int homeUI() {
		int input = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.println("=====================================");
			System.out.println("");
			System.out.println(" Menu principale");
			System.out.println("");
			System.out.println("=====================================");
			System.out.println("1. Ajouter un document");
			System.out.println("2. Emprunter un document");
			System.out.println("3. Retourner un document");
			System.out.println("4. Afficher tous les documents");
			System.out.println("5. Rechercher un document");
			System.out.println("6. Quitter");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Veuillez entrer votre choix (0-6) :");
			System.out.println("=====================================");

			if (sc.hasNextInt()) {
				input = sc.nextInt();
				if (input >= 0 && input <= 6) {
					validInput = true;
				} else {
					System.out.println("Veuillez entrer un nombre entre 0 et 6.");
				}
			} else {
				System.out.println("Ce n'est pas un nombre valide. Veuillez réessayer.");
				sc.next();
			}
		}

		return input;

	}

	public int documentUI() {
		int input = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.println("=====================================");
			System.out.println("");
			System.out.println("            Choix de document");
			System.out.println("");
			System.out.println("=====================================");
			System.out.println("1. Ajouter un livre");
			System.out.println("2. Ajouter une magazine");
			System.out.println("3. Retourner");
			System.out.println("0. Quitter");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Veuillez entrer votre choix (0-3) :");
			System.out.println("=====================================");

			if (sc.hasNextInt()) {
				input = sc.nextInt();
				if (input >= 0 && input <= 3) {
					validInput = true;
				} else {
					System.out.println("Veuillez entrer un nombre entre 0 et 3.");
				}
			} else {
				System.out.println("Ce n'est pas un nombre valide. Veuillez réessayer.");
				sc.next();
			}
		}

		switch (input) {
		case 0:
			return 6;
		case 1:
			this.addLivreUI();
			break;
		case 3:
			return 0;

		}
		return 0;

	}

	public int addLivreUI() {
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("            Ajouter un Livre");
		System.out.println("");
		System.out.println("=====================================");

		// Consume the leftover newline after reading the choice
		sc.nextLine();

		String titre = "";
		while (titre.isEmpty()) {
			System.out.print("Titre: ");
			titre = sc.nextLine();
			if (titre.isEmpty()) {
				System.out.println("Le titre ne peut pas être vide. Veuillez entrer un titre.");
			}
		}

		String auteur = "";
		while (auteur.isEmpty()) {
			System.out.print("Auteur: ");
			auteur = sc.nextLine();
			if (auteur.isEmpty()) {
				System.out.println("L'auteur ne peut pas être vide. Veuillez entrer un auteur.");
			}
		}

		boolean validInput = false;
		int nombreDePages = 0;
		while (!validInput) {
			System.out.print("Nombre de Pages: ");
			if (sc.hasNextInt()) {
				nombreDePages = sc.nextInt();
				validInput = true;
			} else {
				System.out.println("Veuillez entrer un nombre valide pour le nombre de pages.");
				sc.next(); // Consume the invalid input
			}
		}

		sc.nextLine(); // Consume the leftover newline

		String isbn = "";
		while (isbn.isEmpty()) {
			System.out.print("ISBN: ");
			isbn = sc.nextLine();
			if (isbn.isEmpty()) {
				System.out.println("L'ISBN ne peut pas être vide. Veuillez entrer un ISBN.");
			}
		}

		DaoLivreImpl daoLivre = new DaoLivreImpl();
		daoLivre.addLivre(titre, auteur, nombreDePages, isbn);
		System.out.println("Livre ajouté avec succès!");
		System.out.println("Titre: " + titre);
		return 0;
	}

	public int displayDocsUI() {
		Documents.getAllDocs();
		return 0;
	}
}
