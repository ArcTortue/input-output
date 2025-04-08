package io.gui.console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class DisplayConsole extends Console {

	private static final String EXIT_KEY = "0";
	private static final String EXIT_TEXT = "Exit";
	private static final String EXIT_OPTION_LINE = EXIT_KEY + "." + EXIT_TEXT;

	public String showChocolateMenu() {
		String menu = "";
		menu = menu + "1.Dark Chocolate" + LINE_BREAK;
		menu = menu + "2.Milk Chocolate" + LINE_BREAK;
		menu = menu + "3.White Chocolate" + LINE_BREAK;
		menu = menu + EXIT_OPTION_LINE + LINE_BREAK;
		return menu;
	}
	
	public String menu(String... options) {

		StringBuilder menuBuilder = new StringBuilder();
		for (int i = 1; i <= options.length; i++) {
			String optionText = options[i - 1];
			String optionLine = i + "." + optionText + LINE_BREAK;
			menuBuilder.append(optionLine);
		}
		return menuBuilder.toString() + EXIT_OPTION_LINE + LINE_BREAK;
	}

	public String menu(Map<String, String> entranceMenu) {

		StringBuilder menuBuilder = new StringBuilder();
		for (Map.Entry<String, String> option : entranceMenu.entrySet()) {
			String key = option.getKey();
			String text = option.getValue();

			String optionLine = key + "." + text + LINE_BREAK;
			menuBuilder.append(optionLine);
		}
		return menuBuilder.toString() + EXIT_OPTION_LINE + LINE_BREAK;

	}
	
    public String showContentFile(String nameFile) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
        	int caracter;
        	while ((caracter = reader.read()) != -1) {
                content.append((char) caracter );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
	
	public int exitKey() {
		return Integer.parseInt(EXIT_KEY);
	}
}