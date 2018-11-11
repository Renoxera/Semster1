package Aufgabe1Palindrom;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Überprüfung einer Texteingabe hinsichtlich Palindrome
 * 
 * @author Timo
 *
 */
public class PalindromTimo {

	/**
	 * @param args ein String zur überprüfung (optional)
	 */
	public static void main(String[] args) {
		String eingabe;

		if (args.length == 1) {
			eingabe = args[0];
		} else {
			SimpleReader reader = new SimpleReader();
			eingabe = reader.liesText();
		}

		String[] woerterArray = eingabe.split(" ");
		Boolean[] ausgabeArray = new Boolean[woerterArray.length];
		int maxWortLaenge = 0;
		for (int i = 0; i < woerterArray.length; i++) {
			String wort = woerterArray[i];
			maxWortLaenge = maxWortLaenge < wort.length() ? wort.length() : maxWortLaenge;
			boolean flag = true;
			for (int j = 0; j < wort.length() / 2 && flag; j++) {
				if (wort.toLowerCase().charAt(j) != wort.toLowerCase().charAt(wort.length() - 1 - j))
					flag = false;
			}
			if (flag)
				ausgabeArray[i] = true;
			else
				ausgabeArray[i] = false;

		}
		System.out.printf("%" + (maxWortLaenge + 1) + "s | %-6s%n", "Wort" , "Palindrom?");
		for (int i = 0; i < woerterArray.length; i++)
			System.out.printf("%" + (maxWortLaenge + 1) + "s | %-6s%n", woerterArray[i], ausgabeArray[i]);
	}
}
