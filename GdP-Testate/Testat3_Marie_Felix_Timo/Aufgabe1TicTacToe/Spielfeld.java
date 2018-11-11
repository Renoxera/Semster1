package Aufgabe1TicTacToe;

/**
 * Interne Klasse Spiel für das TicTacToe Spiel. Enthält ein Spielfeld, die
 * Überprüfung, die Belegung und Ausgabe des Feldes
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Spielfeld {
	private char[][] spielfeld = new char[3][3];
	private int zug = 0;

	/**
	 * Erzeugt ein neues 3x3 Spielfeld.
	 */
	public Spielfeld() {
		for (int i = 0; i < 9; i++) {
			spielfeld[i / 3][i % 3] = (char) (32);
		}
	}

	/**
	 * Überprüft das Feld, ob einer der Spieler 3 Markierungen in einer Reihe /
	 * Spalte / Diagonalen hat. Ein Spieler kann erst gewonnen haben, sobald 5 oder
	 * mehr Spielzüge ausgeführt wurden.
	 * 
	 * @return Ergebnis der Überprüfung: True, wenn jemand gewonnen hat. false, wenn
	 *         noch keiner gewonnen hat.
	 */
	public boolean ueberpruefenGewonnen() {
		if (zug >= 5) { // Eigentlich 5

			// Zeilen
			for (int i = 0; i < 3; i++) {
				if (spielfeld[i][1] != ' ' && spielfeld[i][0] == spielfeld[i][1] && spielfeld[i][0] == spielfeld[i][2])
					return true;
			}

			// Spalten
			for (int i = 0; i < 3; i++) {
				if (spielfeld[1][i] != ' ' && spielfeld[0][i] == spielfeld[1][i] && spielfeld[0][i] == spielfeld[2][i])
					return true;
			}

			// Diagonalen
			if (spielfeld[1][1] != ' ' && spielfeld[0][0] == spielfeld[1][1] && spielfeld[0][0] == spielfeld[2][2])
				return true;

			if (spielfeld[1][1] != ' ' && spielfeld[2][0] == spielfeld[1][1] && spielfeld[0][2] == spielfeld[1][1])
				return true;
		}
		// Wenn keiner der Fälle eintrifft oder weniger als 5 Züge gespielt wurden.
		return false;
	}

	/**
	 * belegt das übergebene Feld auf dem Spielfeld mit der Kennung des übergebenen
	 * Spielers
	 * 
	 * @param spieler: Spieler, mit dessen Kennung das Spielfeld belegt werden soll
	 * @param y: Y-Koorinate / Zeile des Feldes (Von unten nach oben hochzählend)
	 * @param x: X-Koordinate / Spalte des Feldes (Von links nach rechts hochzählend
	 * @return true, wenn das Feld erfolgreich belegt werden konnte. false, wenn das
	 *         Feld bereits belegt wurde oder ein Fehler in der Eingabe gemacht
	 *         wurde.
	 */
	public boolean belegeFeld(Spieler spieler, int y, int x) {
		// Umrechnung der übergegebenen Koordinaten in die entsprechenden Indizes des
		// Arrays
		y = 3 - y;
		x = x - 1;
		if (x <= 2 && y <= 2 && -1 < x && y > -1) {
			if (spielfeld[y][x] == ' ') {
				spielfeld[y][x] = spieler.getKennung();
				zug++;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * Druckt Das Spielfeld auf der Konsole aus.
	 */
	public void ausgabeSpielfeld() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String tmp = " " + spielfeld[i][j];
				if (j < 2)
					tmp += " |";
				System.out.print(tmp);
			}
			if (i < 2)
				System.out.println("\n-----------");
		}
		System.out.println();
	}

	/**
	 * Gibt die Anzahl der durchgeführten Züge (erfolgreich belegten Felder)
	 * 
	 * @return Anzahl der Züge
	 */
	public int gibZuege() {
		return zug;
	}
}
