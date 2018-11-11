package Aufgabe1Palindrom;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur �berpr�fung, ob die einzelnen W�rter einer Eingabe ein Palindrom
 * sind.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Palindrom {
	/**
	 * Hauptmethode
	 * 
	 * @param args �bergabe eines Strings zur �berpr�fung
	 */
	public static void main(String[] args) {
		String eingabe;

		// Eingabe
		if (args.length == 1) {
			// Aus Startparametern
			eingabe = args[0];
		} else {
			if (args.length > 0) // Abfangen, wenn mehr als 1 Startparameter an das Programm �bergeben wird.
				System.out.println("Es wurde mehr als 1 Startparamter �bergeben. Wechsel auf Konsoleneingabe.\n");
			
			// Durch Konsole
			System.out.println("Bitte geben Sie einen Satz oder ein Wort zur �berpr�fung ein.");
			SimpleReader reader = new SimpleReader();
			eingabe = reader.liesText();
		}

		// Teilen der Eingabe in ein Stringarray
		String formatierteEingabe = eingabe.replaceAll("[^a-zA-Z 0-9]", ""); // Damit Satzzeichen nicht im Array mit
																				// eingetragen werden
		String[] woerterArray = formatierteEingabe.split(" "); // Aufteilen und belegen des String-Arrays
		Boolean[] ausgabeArray = new Boolean[woerterArray.length]; // Parallel dazu liegendes Boolean Array

		// �berpr�fung
		int maxWortLaenge = 0; // Merker f�r sp�tere Formatierung der Ausgabe
		for (int i = 0; i < woerterArray.length; i++) {
			String wort = woerterArray[i].toLowerCase(); // Damit Gro�- und Kleinschreibung missachtet wird
			maxWortLaenge = maxWortLaenge < wort.length() ? wort.length() : maxWortLaenge; // Ggf. Hochsetzen des
																							// Merkers f�r die Wortl�nge
			ausgabeArray[i] = wort.equals(new StringBuffer(wort).reverse().toString()); // Belegung des
																						// Parallelliegenden
																						// Boolean-Arrays mit dem
																						// Ergebnis der �berpr�fung auf
																						// ein Palindrom
		}

		// Ausgabe Header
		System.out.printf("|%" + (maxWortLaenge + 1) + "s | %-10s |%n", "Wort", "Palindrom?");

		// Ausgabe Werte
		for (int i = 0; i < woerterArray.length; i++)
			System.out.printf("|%" + (maxWortLaenge + 1) + "s | %-10s |%n", woerterArray[i], ausgabeArray[i]);
	}

}
