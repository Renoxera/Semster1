package Aufgabe2AsciiSumme;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Wandelt den eingegebenen Namen in ASCII-Code um. Im Character (char) wird die
 * ASCII-Nummer zu den dazugehörigen Zeichen gespeichert.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Ascii {
	/**
	 * Hauptmethode
	 * 
	 * @param args Übergabe eines Strings zur Ausgabe der ASCII-Nummern der Zeichen
	 *             und Berechnung der Summe dieser.
	 */
	public static void main(String[] args) {
		// Eingabe
		String name = "Marie Salomon, Felix Franz, Timo Reitmann";
		if (args.length == 1) {
			// Aus Startparameter
			name = args[0];
		} else {
			if (args.length != 0) // Abfangen, wenn mehr als 1 Startparameter an das Programm übergeben wird.
				System.out.println("Fehler bei Parameterübergabe. Wechsel auf Konsoleneingabe.\n");

			// Durch Konsole
			System.out.println("Geben Sie ihren Namen ein: ");
			SimpleReader reader = new SimpleReader();
			name = reader.liesText();
		}

		char[] buchstabe = name.toCharArray(); // Teilt den Namen in Buchstaben auf
		int summeAscii = 0; // Zum Speichern der Ascii-

		System.out.println("Dein Name im ASCII-Code: ");
		
		for (int i = 0; i < buchstabe.length; i++) { // Zeichenweiser Durchlauf der Eingabe.
			int ascii = (int) buchstabe[i]; // Umwandeln des Zeichens in den Ascii-Wert
			summeAscii = summeAscii + ascii; // Summenberechnung
			System.out.println(buchstabe[i] + " -> " + ascii); // Ausgabe Zeichen + Ascii-Wert

		}
		// Ausgabe der Summe.
		System.out.println("Die Summe ist: " + summeAscii);
	}

}
