package classes;

import utils.Choices;

public class ConsoleUI extends Choices {

	private int choice = 0;

	public ConsoleUI() {
		clear();
		while (true) {
			switch (this.choice) {
			case 0:
				choice = this.homeUI();
				clear();
				break;
			case 1:
				choice = this.documentUI();
				clear();
				break;
			case 2:
				try {
					choice = this.borrowingUI();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				clear();
				break;
			case 3:
				try {
					choice = this.returningUI();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				clear();
				break;
			case 4:
				clear();
				choice = this.displayDocsUI();
				break;
			case 5:
				clear();
				try {
					choice = this.searchingUI();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				clear();
				return;
			}
		}
	}

	private void clear() {
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
}
