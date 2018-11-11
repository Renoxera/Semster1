package Aufgabe1Fakultaet;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Berechnung der Fakult�t einer eingegebenen Zahl
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann / WI5618
 */

public class Fakultaet {
	private static SimpleReader reader;

	public static void main(String[] args) {
		reader = new SimpleReader();

		System.out.println("Gib eine Zahl ein, von welcher du die Fakult�t berechnen m�chtest:");

		// Eingabe der Zahl, von der die Fakult�t berechnet werden soll.
		int eingabeZahl = reader.liesZahl(1); // Eingabe

		// Initialisierung der Ergebnisvariablen
		// Vorbelegung mit a, da im weiteren Verlauf die Fakult�t durch eine r�ckw�rts
		// laufende Schleife berechnet wird.
		long ergebnis = eingabeZahl;

		// Abbruchbedingung i > 1 reicht, im letzten Schritt nur das Ergebnis mit 1
		// multipliziert werden w�rde.
		for (int i = eingabeZahl; i > 1; i--) {
			ergebnis = ergebnis * (i - 1);
		}

		// Ausgabe der Fakult�t
		System.out.println("Die Fakult�t von " + eingabeZahl + " ist " + ergebnis);
	}
}