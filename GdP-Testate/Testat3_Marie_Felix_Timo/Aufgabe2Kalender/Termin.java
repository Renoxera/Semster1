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
	 * Erzeugt einen Termin mit den übergebenen Parametern
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
	 * @return Gibt die Stunde des Beginns eines Termin zurück
	 */
	public int getBeginn() {
		return beginnStunde;
	}

	/**
	 *
	 * @return Gibt die Dauer eines Termin zurück
	 */
	public int getDauer() {
		return dauer;
	}

	/**
	 *
	 * @return Gibt den Betreff eines Termines zurück
	 */
	public String getBetreff() {
		return betreff;
	}

}
