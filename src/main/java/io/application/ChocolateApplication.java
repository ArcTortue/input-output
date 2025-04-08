package io.application;

import java.util.HashMap;
import java.util.Map;

import io.gui.console.Console;
import io.gui.console.DisplayConsole;
import io.gui.console.ReadConsole;

public class ChocolateApplication {
	
		private static final String EMOJI_THUMBS_UP = "\uD83D\uDC4D";
		private static final String EMOJI_THUMBS_DOWN = "\uD83D\uDC4E";
		private static final String EMOJI_OK_HAND = "\uD83D\uDC4C";
		private static final String EMOJI_CHOCOLATE_BAR = "\uD83C\uDF6B";
		private static final String EMOJI_SMILING_FACE = "\u263A";
		private static final String EMOJI_GRINNING_FACE = "\uD83E\uDD2A";
		private static final String EMOJI_FACE_WITH_ROLLING_EYES ="\uD83D\uDE44";
		//TODO refacto: use an HashMap or something else ?
		
		Console console;
		DisplayConsole display;
		ReadConsole read;
		Map<String, String> chocolateMenu;


		public ChocolateApplication() {
			this.console = new Console();
			this.display = new DisplayConsole();
			createChocolateMenu();
		
			this.read = new ReadConsole();

			
		}

		public void aboutYourFavoriteChocolate() {

			console.title("Welcome ! What is your favourite chocolate ?");
			console.message(display.menu(chocolateMenu));
			
			console.message(" Your choice: ");
			console.lineBreak();
			int option = read.ensureIntegerBetween(display.exitKey(), chocolateMenu.size());
			
			answerChocolateMenuFor(option);

		}

		private void answerChocolateMenuFor(int option) {
			switch (option) {
			case 1:
				console.message(EMOJI_CHOCOLATE_BAR + " Healthy chocolate !" + EMOJI_OK_HAND+EMOJI_THUMBS_UP);
				break;
			case 2:
				console.message(display.showContentFile("C:\\Users\\tourr\\eclipse\\javabut1\\input-output\\src\\main\\resources\\easter.txt"));
				console.message(EMOJI_CHOCOLATE_BAR+ " The best chocolate for easter !" + EMOJI_SMILING_FACE);
				break;
			case 3:
				console.message(EMOJI_CHOCOLATE_BAR +" Sugar and fat : unhealthy !"+ EMOJI_THUMBS_DOWN+EMOJI_GRINNING_FACE);
				break;
			default:
				console.message(EMOJI_FACE_WITH_ROLLING_EYES+" Maybe you dislike chocolate...");
				break;
			}
		}

		private void createChocolateMenu() {

			chocolateMenu = new HashMap<>();
			chocolateMenu.put("1", "Dark Chocolate");
			chocolateMenu.put("2", "Milk Chocolate");
			chocolateMenu.put("3", "White Chocolate");
		}

		public static void main(String[] args) {

			ChocolateApplication chocolateApplication= new ChocolateApplication();
			chocolateApplication.aboutYourFavoriteChocolate();
		}

	}


