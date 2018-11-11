package Aufgabe2Kalender;

/**
 * Interne Klasse der Kalendersmiulation
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Termin {
	int beginnStunde;
	int dauer;
	String betreff;

	/**
	 * Erzeugt einen Termin mit den �bergebenen Parametern
	 * 
	 * @param beginnStunde Beginn des Termins in Stunde
	 * @param dauer Dauer in Stunden
	 * @param betreff Name/Zweck des Termins
	 */
	public Termin(int beginnStunde, int dauer, String betreff) {
		this.beginnStunde = (beginnStunde);
		this.dauer = (dauer);
		this.betreff = (betreff);
	}

	// Getter und Setter
	/**
	 *
	 * @return Gibt die Stunde des Beginns eines Termin zur�ck
	 */
	public int getBeginn() {
		return beginnStunde;
	}

	/**
	 *
	 * @return Gibt die Dauer eines Termin zur�ck
	 */
	public int getDauer() {
		return dauer;
	}

	/**
	 *
	 * @return Gibt den Betreff eines Termines zur�ck
	 */
	public String getBetreff() {
		return betreff;
	}

}
