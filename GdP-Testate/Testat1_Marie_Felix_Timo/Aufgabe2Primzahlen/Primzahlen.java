package Aufgabe2Primzahlen;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Dieses Programm überprüft, ob eine eingegebene Zahl eine Primzahl ist. Falls
 * die Zahl keine Primzahl ist, so werden die Teiler der Zahl ausgegeben.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann / WI5618
 */
public class Primzahlen {
	public static void main(String args[]) {
		SimpleReader reader = new SimpleReader();
		System.out.println("Gib eine Zahl ein, von welcher du alle Teiler sehen möchtest:");
		int eingabeZahl = reader.liesZahl();
		int positiveEingabeZahl = 0;

		if (eingabeZahl < 0) // Bei negativer Eingabe wird mit dem Betrag der Eingabe weitergerechnet.
			positiveEingabeZahl = eingabeZahl * -1;
		else
			positiveEingabeZahl = eingabeZahl;

		// Zerlegung bestimmen
		String teiler = new String();
		int zaehlerTeiler = 0;
		for (int i = positiveEingabeZahl; i > 0; i--) {
			if (positiveEingabeZahl % i == 0) {
				teiler = teiler + i + ", " + (-1 * i) + ", "; // Hier werden alle Teiler hintereinander geschrieben
				zaehlerTeiler++;
			}
		}

		// Ausgabe
		teiler = teiler.substring(0, teiler.length() - 2); // Entfernung des letzten Kommas und Leerzeichen

		if (zaehlerTeiler == 2) {
			if (eingabeZahl >= 0)
				System.out.println(eingabeZahl + " ist eine Primzahl!");
			else // Fall, dass der Betrag einer negativen Eingabe eine Primzahl ist.
				System.out.println("Die Teiler von " + eingabeZahl + " sind 1, -1, " + positiveEingabeZahl + ", -"
						+ positiveEingabeZahl);
		} else
			System.out.println("Die Teiler von " + eingabeZahl + " sind: " + teiler);
	}
}
