package Aufgabe1Fakultaet;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Berechnung der Fakultät einer eingegebenen Zahl
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann / WI5618
 */

public class Fakultaet {
	private static SimpleReader reader;

	public static void main(String[] args) {
		reader = new SimpleReader();

		System.out.println("Gib eine Zahl ein, von welcher du die Fakultät berechnen möchtest:");

		// Eingabe der Zahl, von der die Fakultät berechnet werden soll.
		int eingabeZahl = reader.liesZahl(1); // Eingabe

		// Initialisierung der Ergebnisvariablen
		// Vorbelegung mit a, da im weiteren Verlauf die Fakultät durch eine rückwärts
		// laufende Schleife berechnet wird.
		long ergebnis = eingabeZahl;

		// Abbruchbedingung i > 1 reicht, im letzten Schritt nur das Ergebnis mit 1
		// multipliziert werden würde.
		for (int i = eingabeZahl; i > 1; i--) {
			ergebnis = ergebnis * (i - 1);
		}

		// Ausgabe der Fakultät
		System.out.println("Die Fakultät von " + eingabeZahl + " ist " + ergebnis);
	}
}