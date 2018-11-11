package Aufgabe2Kalender;

import de.hsw.gdp.helper.SimpleReader;
/**
 * Hauptprogramm zur Simulation eines Kalenders mit 31 Tagen.
 * Verwendet die Klassen Kalender, Tag und Termin.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Main {
	/**
	 * Hauptmethode
	 * @param args hier nicht verwendet.
	 */
	public static void main(String[] args) {
		Kalender dezember = new Kalender();

		int t, h, d;
		String n;

		SimpleReader reader = new SimpleReader();

		while (true) {
			System.out.println(
					"\nWas möchtest du tun? \n[1] - Termin stündlichgenau eintragen\n[2] - Abfrage Zeitraum frei\n[3] - Ausgabe aller Termine an einem Tag\n[4] - Übersicht Kalendertage");
			switch (reader.liesZahl(1, 4)) {
			case 1:
				System.out.print("Eingabe Tag (1-31): ");
				t = reader.liesZahl(1, 31);
				System.out.print("Eingabe Stunde (0-23): ");
				h = reader.liesZahl(1, 23);
				System.out.print("Eingabe Dauer (>0): ");
				d = reader.liesZahl(1);
				System.out.print("Eingabe Name: ");
				n = reader.liesText();
				dezember.erzeugeTermin(t, h, d, n);
				break;
			case 2:
				System.out.print("Welchen Tag möchtest du abfragen? ");
				t = reader.liesZahl(1, 31);
				System.out.print("Welche Stunde möchtest du abfragen? ");
				h = reader.liesZahl(1, 24);
				System.out.println("Termin noch frei? " + dezember.terminNochFrei(t, h));
				break;
			case 3:
				System.out.print("Welchen Tag möchtest du abfragen? ");
				t = reader.liesZahl(1, 31);
				dezember.tagAusgeben(t);
				break;
			case 4:
				dezember.ausgabeTageUebersicht();
				break;
			default:
			}
		}
	}
}
