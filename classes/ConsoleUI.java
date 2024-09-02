package classes;

import utils.Choices;

public class ConsoleUI extends Choices {

	public int choice = 0;

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
			case 4:
				clear();
				choice = this.displayDocsUI();
				break;
			case 6:
				clear();
				return;
			}
		}
	}
}
