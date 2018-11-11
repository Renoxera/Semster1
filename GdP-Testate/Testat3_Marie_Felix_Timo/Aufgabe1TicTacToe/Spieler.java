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
	 * Gibt die Kennung (f�r gew�hnlich X oder O) zur�ck.
	 * 
	 * @return Kennung des Spielers
	 */
	public char getKennung() {
		return kennung;
	}

	/**
	 * Gibt den vollst�ndigen Namen des Spielers zur�ck.
	 * 
	 * @return Name des Spielers
	 */
	public String getName() {
		return name;
	}

	/**
	 * Erh�ht den Z�hler f�r die gewonnen Spiele um 1.
	 */
	public void gewinnt() {
		gewonnen++;
	}

	/**
	 * Gibt den Z�hler f�r die gewonnen Spiele zur�ck.
	 * 
	 * @return Anzahl der gewonnen Spiele
	 */
	public int getGewonnen() {
		return gewonnen;
	}
}
