package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import dao.DaoLivreImpl;
import dao.DaoMagazineImpl;
import data.Bibliotheque;

public class Choices {

	private Scanner sc = new Scanner(System.in);

	public int homeUI() {
		int input = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.println("============================================");
			System.out.println("|                                          |");
			System.out.println("|            ✨ Menu Principale ✨         |");
			System.out.println("|                                          |");
			System.out.println("============================================");
			System.out.println("|                                          |");
			System.out.println("|  1. 📄 Ajouter un document               |");
			System.out.println("|  2. 📖 Emprunter un document             |");
			System.out.println("|  3. 🔄 Retourner un document             |");
			System.out.println("|  4. 📑 Afficher tous les documents       |");
			System.out.println("|  5. 🔎 Rechercher un document            |");
			System.out.println("|  6. ❌ Quitter                           |");
			System.out.println("|                                          |");
			System.out.println("============================================");
			System.out.println("Veuillez entrer votre choix (1-6) : ");
			System.out.println("============================================");

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
			System.out.println("============================================");
			System.out.println("|                                          |");
			System.out.println("|          📚 Choix de Document 📚          |");
			System.out.println("|                                          |");
			System.out.println("============================================");
			System.out.println("|                                          |");
			System.out.println("|  1. ➕ Ajouter un livre                   |");
			System.out.println("|  2. ➕ Ajouter un magazine                |");
			System.out.println("|  3. 🔙 Retourner                         |");
			System.out.println("|  0. ❌ Quitter                           |");
			System.out.println("|                                          |");
			System.out.println("============================================");
			System.out.println("Veuillez entrer votre choix (0-3) : ");
			System.out.println("============================================");

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
			this.addDocumentUI(true);
			break;

		case 2:
			this.addDocumentUI(false);
			break;
		case 3:
			return 0;

		}
		return 0;

	}

	public int addDocumentUI(boolean checker) {
		System.out.println("=====================================");
		System.out.println("");
		System.out.println("            Ajouter un Document");
		System.out.println("");
		System.out.println("=====================================");

		sc.nextLine(); // Clear the buffer before starting

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
		sc.nextLine(); // Consume the newline after nextInt()

		LocalDate date = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		while (date == null) {
			System.out.print("Date de publication (format yyyy-MM-dd): ");
			String input = sc.nextLine();

			try {
				date = LocalDate.parse(input, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("La date ne peut pas être vide ou invalide. Veuillez entrer une date valide.");
			}
		}

		if (checker) {
			String isbn = "";
			while (isbn.isEmpty()) {
				System.out.print("ISBN: ");
				isbn = sc.nextLine();
				if (isbn.isEmpty()) {
					System.out.println("L'ISBN ne peut pas être vide. Veuillez entrer un ISBN.");
				}
			}
			DaoLivreImpl daoLivre = new DaoLivreImpl();
			daoLivre.addLivre(titre, auteur, nombreDePages, isbn, date);
			System.out.println("Livre ajouté avec succès!");
		} else {
			int numero = 0;
			validInput = false;
			while (!validInput) {
				System.out.print("Le numero du magazine: ");
				if (sc.hasNextInt()) {
					numero = sc.nextInt();
					validInput = true;
				} else {
					System.out.println("Veuillez entrer un numero valide pour le numero du magazine.");
					sc.next(); // Consume the invalid input
				}
			}
			sc.nextLine(); // Consume the newline after nextInt()
			DaoMagazineImpl daoMagazine = new DaoMagazineImpl();
			daoMagazine.addMagazine(titre, auteur, nombreDePages, numero, date);
			System.out.println("Magazine ajoutée avec succès!");
		}

		System.out.println("Titre: " + titre);
		return 0;
	}

	public int displayDocsUI() {
		Bibliotheque.getAllDocs();

		boolean validInput = false;
		int choice = 10;
		while (!validInput) {
			System.out.print("Entrez 0 pour retourner au menu principal: ");
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
				if (choice == 0)
					validInput = true;
			} else {
				System.out.println("Veuillez entrer 0 pour retourner au menu principal");
				sc.next();
			}
		}
		return choice;
	}

	public int borrowingUI() throws InterruptedException {
		if (!Bibliotheque.checkIfThereIsDocs()) {
			System.out.println("il n'y a pas encore de documents");
			TimeUnit.SECONDS.sleep(2);
			return 0;
		}
		boolean validInput = false;
		long id = 0;
		while (!validInput) {
			System.out.print("Id du Document: ");
			if (sc.hasNextInt()) {
				id = sc.nextInt();
				validInput = Bibliotheque.emprunterDoc(id);
				if (!validInput) {
					System.out.println("Veuillez essayer une autre fois");
					return 0;
				}
			} else {
				System.out.println("Veuillez entrer un id valide.");
				sc.next();
			}
		}
		return 0;
	}

	public int returningUI() throws InterruptedException {
		if (!Bibliotheque.checkIfThereIsDocs()) {
			System.out.println("il n'y a pas encore de documents");
			TimeUnit.SECONDS.sleep(2);
			return 0;
		}
		boolean validInput = false;
		long id = 0;
		while (!validInput) {
			System.out.print("Id du Document: ");
			if (sc.hasNextInt()) {
				id = sc.nextInt();
				validInput = Bibliotheque.retournerDoc(id);
				if (!validInput) {
					System.out.println("Veuillez essayer une autre fois");
					return 0;
				}
			} else {
				System.out.println("Veuillez entrer un id valide.");
				sc.next();
			}
		}
		return 0;
	}

	public int searchingUI() throws InterruptedException {
		if (!Bibliotheque.checkIfThereIsDocs()) {
			System.out.println("il n'y a pas encore de documents");
			TimeUnit.SECONDS.sleep(2);
			return 0;
		}
		boolean validInput = false;
		long id = 0;
		while (!validInput) {
			System.out.print("Id du Document: ");
			if (sc.hasNextInt()) {
				id = sc.nextInt();
				validInput = Bibliotheque.getDocById(id);
				if (!validInput) {
					System.out.println("Veuillez essayer une autre fois");
					return 0;
				}
			} else {
				System.out.println("Veuillez entrer un id valide.");
				sc.next();
			}
		}

		validInput = false;
		int choice = 10;
		while (!validInput) {
			System.out.print("Entrez 0 pour retourner au menu principal: ");
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
				if (choice == 0)
					validInput = true;
			} else {
				System.out.println("Veuillez entrer 0 pour retourner au menu principal");
				sc.next();
			}
		}
		return choice;
	}
}
