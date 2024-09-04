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
				this.clear();
				break;
			case 1:
				choice = this.documentUI();
				this.clear();
				break;
			case 2:
				try {
					choice = this.borrowingUI();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				this.clear();
				break;
			case 3:
				try {
					choice = this.returningUI();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				this.clear();
				break;
			case 4:
				this.clear();
				choice = this.displayDocsUI();
				break;
			case 5:
				this.clear();
				try {
					choice = this.searchingUI();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				this.clear();
				return;
			}
		}
	}
}
