package Aufgabe1Palindrom;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Überprüfung, ob die einzelnen Wörter einer Eingabe ein Palindrom
 * sind.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Palindrom {
	/**
	 * Hauptmethode
	 * 
	 * @param args Übergabe eines Strings zur Überprüfung
	 */
	public static void main(String[] args) {
		String eingabe;

		// Eingabe
		if (args.length == 1) {
			// Aus Startparametern
			eingabe = args[0];
		} else {
			if (args.length > 0) // Abfangen, wenn mehr als 1 Startparameter an das Programm übergeben wird.
				System.out.println("Es wurde mehr als 1 Startparamter übergeben. Wechsel auf Konsoleneingabe.\n");
			
			// Durch Konsole
			System.out.println("Bitte geben Sie einen Satz oder ein Wort zur Überprüfung ein.");
			SimpleReader reader = new SimpleReader();
			eingabe = reader.liesText();
		}

		// Teilen der Eingabe in ein Stringarray
		String formatierteEingabe = eingabe.replaceAll("[^a-zA-Z 0-9]", ""); // Damit Satzzeichen nicht im Array mit
																				// eingetragen werden
		String[] woerterArray = formatierteEingabe.split(" "); // Aufteilen und belegen des String-Arrays
		Boolean[] ausgabeArray = new Boolean[woerterArray.length]; // Parallel dazu liegendes Boolean Array

		// Überprüfung
		int maxWortLaenge = 0; // Merker für spätere Formatierung der Ausgabe
		for (int i = 0; i < woerterArray.length; i++) {
			String wort = woerterArray[i].toLowerCase(); // Damit Groß- und Kleinschreibung missachtet wird
			maxWortLaenge = maxWortLaenge < wort.length() ? wort.length() : maxWortLaenge; // Ggf. Hochsetzen des
																							// Merkers für die Wortlänge
			ausgabeArray[i] = wort.equals(new StringBuffer(wort).reverse().toString()); // Belegung des
																						// Parallelliegenden
																						// Boolean-Arrays mit dem
																						// Ergebnis der Überprüfung auf
																						// ein Palindrom
		}

		// Ausgabe Header
		System.out.printf("|%" + (maxWortLaenge + 1) + "s | %-10s |%n", "Wort", "Palindrom?");

		// Ausgabe Werte
		for (int i = 0; i < woerterArray.length; i++)
			System.out.printf("|%" + (maxWortLaenge + 1) + "s | %-10s |%n", woerterArray[i], ausgabeArray[i]);
	}

}
