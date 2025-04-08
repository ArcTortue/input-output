package io.gui.console;

public class ReadConsole extends Console {
	
	public int ensureInteger() {
		while (true) {
			try {
				String input = keyboard.nextLine();
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				this.message("Please enter a valid integer.");
			}
		}
	}
	
	public int ensureIntegerBetween(int minimum, int maximum) {
		while (true) {
			int value = ensureInteger();
			if (minimum <= value && value <= maximum)
				return value;
			else {
				this.message("The value must be between " + minimum + " and " + maximum);
			}
		}
	}
}