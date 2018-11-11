package Aufgabe1TicTacToe;

public class Spieler {
	private String name;
	private char kennung;
	private int gewonnen = 0;

	public Spieler(String name, char kennung) {
		this.name = name;
		this.kennung = kennung;
	}

	/**
	 * Gibt die Kennung (für gewöhnlich X oder O) zurück.
	 * 
	 * @return Kennung des Spielers
	 */
	public char getKennung() {
		return kennung;
	}

	/**
	 * Gibt den vollständigen Namen des Spielers zurück.
	 * 
	 * @return Name des Spielers
	 */
	public String getName() {
		return name;
	}

	/**
	 * Erhöht den Zähler für die gewonnen Spiele um 1.
	 */
	public void gewinnt() {
		gewonnen++;
	}

	/**
	 * Gibt den Zähler für die gewonnen Spiele zurück.
	 * 
	 * @return Anzahl der gewonnen Spiele
	 */
	public int getGewonnen() {
		return gewonnen;
	}
}
