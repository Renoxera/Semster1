package Aufgabe2Kalender;

import java.util.ArrayList;

/**
 * Intern verwendete Klasse Tag in der Kalendersimulation
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Tag {
	private int tagImMonat = 0;
	private ArrayList<Termin> terminListe;

	/**
	 * 
	 * @param nummerTagImMonat
	 */
	public Tag(int nummerTagImMonat) {
		tagImMonat = nummerTagImMonat;
		terminListe = new ArrayList<Termin>();
	}

	/**
	 * Erzeugt einen Termin mit dem Parametern:
	 * 
	 * @param stundeStart
	 * @param dauerInStunden
	 * @param name           und fügt diesen in die ArrayListe hinzu.
	 */
	public void erzeugeTermin(int stundeStart, int dauerInStunden, String name) {
		this.terminListe.add(new Termin(stundeStart, dauerInStunden, name));
	}

	/**
	 * 
	 * @return gibt eine Arraylist mit allen Terminen eines Tages zurück
	 */
	public ArrayList<Termin> gibTermine() {
		return this.terminListe;
	}

	/**
	 * 
	 * Fragt ab ob die der ausgewählte Zeitraum in der Terminliste noch frei
	 *
	 * @param stunde
	 * @return false, wenn der Termin belegt ist. true, wenn frei.
	 */
	public boolean frageStundefrei(int stunde) {
		for (Termin t : terminListe) {
			if (t.getBeginn() <= stunde && t.getBeginn() + t.getDauer() >= stunde) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @return true, wenn der Tag einen oder mehrere Termine hat, sonst false.
	 */
	public boolean hatTermine() {
		return !(terminListe.size() == 0);
	}

	/**
	 * 
	 * @return Tag im Monat
	 */
	public int gibTagImMonat() {
		return tagImMonat;
	}
}
