package Aufgabe1TicTacToe;

/**
 * Interne Klasse Spiel f�r das TicTacToe Spiel. Enth�lt ein Spielfeld, die
 * �berpr�fung, die Belegung und Ausgabe des Feldes
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
	 * �berpr�ft das Feld, ob einer der Spieler 3 Markierungen in einer Reihe /
	 * Spalte / Diagonalen hat. Ein Spieler kann erst gewonnen haben, sobald 5 oder
	 * mehr Spielz�ge ausgef�hrt wurden.
	 * 
	 * @return Ergebnis der �berpr�fung: True, wenn jemand gewonnen hat. false, wenn
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
		// Wenn keiner der F�lle eintrifft oder weniger als 5 Z�ge gespielt wurden.
		return false;
	}

	/**
	 * belegt das �bergebene Feld auf dem Spielfeld mit der Kennung des �bergebenen
	 * Spielers
	 * 
	 * @param spieler: Spieler, mit dessen Kennung das Spielfeld belegt werden soll
	 * @param y: Y-Koorinate / Zeile des Feldes (Von unten nach oben hochz�hlend)
	 * @param x: X-Koordinate / Spalte des Feldes (Von links nach rechts hochz�hlend
	 * @return true, wenn das Feld erfolgreich belegt werden konnte. false, wenn das
	 *         Feld bereits belegt wurde oder ein Fehler in der Eingabe gemacht
	 *         wurde.
	 */
	public boolean belegeFeld(Spieler spieler, int y, int x) {
		// Umrechnung der �bergegebenen Koordinaten in die entsprechenden Indizes des
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
	 * Gibt die Anzahl der durchgef�hrten Z�ge (erfolgreich belegten Felder)
	 * 
	 * @return Anzahl der Z�ge
	 */
	public int gibZuege() {
		return zug;
	}
}
