package classes;

import utils.Choices;

public class ConsoleUI extends Choices {

	public int choice = 0;

	public ConsoleUI() {
		clear();
		while (true) {
			switch (this.choice) {
			case 0:
				choice = this.home();
				clear();
				break;
			case 1:
				choice = this.document();
				clear();
				break;
			case 6:
				clear();
				return;
			}
		}
	}
}
