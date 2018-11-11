package Aufgabe1TicTacToe;

import de.hsw.gdp.helper.SimpleReader;
/**
 * Programm zum Spielen des TicTacToe-Spiels. Benötigt die Klassen Spielbrett und Spieler.
 * Enthält den Grobspielalgorithmus des Spiels.
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Main {
	/**
	 * TicTacToe Algorithmus.
	 * </p>
	 * Ablauf:
	 * </p>
	 * 1. Spieler-Eingabe
	 * </p>
	 * 2. Spieler-Objekte-Erzeugung
	 * </p>
	 * 3. Spiel.
	 * </p>
	 * 4. Ausgabe des Gewinners / Unentschieden
	 * </p>
	 * 5. Möglichkeit das Spiel zu wiederholen und die Zugreihnfolge zu wechseln.
	 * </p>
	 * 6. Ausgabe Statistik
	 * </p>
	 * 
	 * @param args nicht verwendet.
	 */
	public static void main(String[] args) {
		SimpleReader reader = new SimpleReader();

		// Eingabe Spieler 1
		System.out.println("Eingabe Name Spieler 1: ");
		String nameSpieler1 = reader.liesText();
		System.out.println("Möchten Sie [X] oder [O] verwenden, " + nameSpieler1 + "? ");
		char kennungSpieler1 = reader.liesText(1).toUpperCase().charAt(0);

		// Überprüfung, dass ein zulässiges Symbol gewählt wurde
		while (kennungSpieler1 != 'X' && kennungSpieler1 != 'O') {
			System.out.println("Ungültiges Symbol eingegeben. Bitte schreibe x, o, X oder O. ");
			kennungSpieler1 = reader.liesText(1).toUpperCase().charAt(0);
		}

		// Eingabe Spieler 2
		System.out.println("Eingabe Name Spieler 2: ");
		String nameSpieler2 = reader.liesText();
		char kennungSpieler2 = kennungSpieler1 == 'X' ? 'O' : 'X';

		Spieler spieler1 = new Spieler(nameSpieler1, kennungSpieler1);
		Spieler spieler2 = new Spieler(nameSpieler2, kennungSpieler2);

		Spieler beginnenderSpieler = spieler1;
		Spieler zweiterSpieler = spieler2;

		boolean aktivesSpiel = true;
		while (aktivesSpiel) {
			// 3. Spiel und 4. Ausgabe
			spiel(beginnenderSpieler, zweiterSpieler);

			// 5. Möglichkeit das Spiel zu wiederholen und die Zugreihnfolge zu wechseln.
			System.out.println("\n Möchten Sie noch eine Runde spielen? [j] / beliebige andere Eingabe zum Beenden.");
			aktivesSpiel = reader.liesText(1).equals("j") ? true : false;
			if (aktivesSpiel) {
				System.out.println("\n Möchten Sie Reihenfolge umkehren? [j] / beliebige andere Eingabe zum Beenden.");
				if (reader.liesText(1).equals("j")) {
					Spieler temp = beginnenderSpieler;
					beginnenderSpieler = null;
					beginnenderSpieler = zweiterSpieler;
					zweiterSpieler = null;
					zweiterSpieler = temp;
				}
			}
		}

		// 6. Ausgabe Statistik
		System.out.println(spieler1.getName() + " hat " + spieler1.getGewonnen() + " Mal gewonnen. ");
		System.out.println(spieler2.getName() + " hat " + spieler2.getGewonnen() + " Mal gewonnen. ");
	}

	/**
	 * TicTacToe Algorithmus. Verwendet zwei Spieler als Parameter und erzeugt
	 * intern das Spielfeld, auf dem gespielt wird.
	 * 
	 * @param beginnenderSpieler
	 * @param zweiterSpieler
	 */
	public static void spiel(Spieler beginnenderSpieler, Spieler zweiterSpieler) {
		Spielfeld spielfeld = new Spielfeld();
		boolean beginnenderSpielerDran = true;
		boolean gewonnen = false;
		while (!gewonnen ^ spielfeld.gibZuege() == 9) {
			if (beginnenderSpielerDran) {
				spielzug(spielfeld, beginnenderSpieler);
			} else {
				spielzug(spielfeld, zweiterSpieler);
			}
			spielfeld.ausgabeSpielfeld();
			beginnenderSpielerDran = !beginnenderSpielerDran;
			gewonnen = spielfeld.ueberpruefenGewonnen();
		}

		// 4. Ausgabe des Gewinners / Unentschieden
		if (gewonnen && !beginnenderSpielerDran) { // beginnender Spieler hat gewonnen
			System.out.println(beginnenderSpieler.getName() + " hat gewonnen!");
			beginnenderSpieler.gewinnt(); 
		} else if (gewonnen && beginnenderSpielerDran) { // zweiter Spieler hat gewonnen
			System.out.println(zweiterSpieler.getName() + " hat gewonnen!");
			zweiterSpieler.gewinnt();
		} else // vorherige Schleife wurde abgebrochen weil keiner gewonnen hat und somit muss es ein unentscheieden sein.
			System.out.println("Leider ein unentschieden.");
	}

	/**
	 * Hilfsmethode zur Verallgemeinerung eines Spielzuges. 
	 * @param spielfeld Das Spielfeld, auf dem der Zug ausgeührt werden soll
	 * @param spieler Spieler, der den Zug durchführen soll.
	 */
	private static void spielzug(Spielfeld spielfeld, Spieler spieler) {
		SimpleReader reader = new SimpleReader();
		System.out.print("\n" + spieler.getName() + ", bitte gib einen Punkt x/y an, den du Belegen möchtest. \n X: ");
		int x = reader.liesZahl(1, 3);
		System.out.print(" Y: ");
		int y = reader.liesZahl(1, 3);
		System.out.println();

		while (!spielfeld.belegeFeld(spieler, y, x)) {
			System.out.println("Dieses Feld ist bereits belegt, neue Eingabe benötigt.");
			System.out.print("");
			System.out.print(" X: ");
			x = reader.liesZahl(1, 3);
			System.out.print(" Y: ");
			y = reader.liesZahl(1, 3);
			System.out.println();
		}
	}
}
