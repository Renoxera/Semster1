package Aufgabe1Palindrom;

import de.hsw.gdp.helper.SimpleReader;

public class Palindrom2 {
	public static void main(String args[]) {
		System.out.println("Eingabe: ");
		String eingabe = new SimpleReader().liesText();

		String[] woerterArray = eingabe.replaceAll("[^a-zA-Z 0-9]", "").split(" ");

		for (String wort : woerterArray) {
			String wortKlein = wort.toLowerCase();
			System.out.println(wort + " : " + wortKlein.equals(new StringBuffer(wortKlein).reverse().toString()));
		}

	}
}
