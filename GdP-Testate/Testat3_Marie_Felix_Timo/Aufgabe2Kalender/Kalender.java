package Aufgabe2Kalender;

import java.util.ArrayList;

/**
 * Klasse Kalender zur Simulation eines Kalendermonats mit 31 Tagen.
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */

public class Kalender {
	private Tag[] tage = new Tag[31];

	/**
	 * Erzeugt ein Objekt der Klasse Kalender mit einem Array für 31 Tagen.
	 */
	public Kalender() {
		for (int i = 0; i < 31; i++) {
			tage[i] = new Tag(i + 1);
		}
	}

	/**
	 * Legt einen Termin an den übergebenen Parametern an.
	 * 
	 * @param tag            Tag von 1 - 31
	 * @param stundeStart    Stunde für den Start des Termins von 0 - 23
	 * @param dauerInStunden Dauer des Termins in Stunden
	 * @param name
	 */
	public void erzeugeTermin(int tag, int stundeStart, int dauerInStunden, String name) {
		if (tag > 0 && tag < 32) {
			int tagIndex = tag - 1;
			tage[tagIndex].erzeugeTermin(stundeStart, dauerInStunden, name);
		}
	}

	/**
	 * Gibt aus, ob der in den Parametern übergebene Termin noch frei ist oder
	 * bereits ein Termin belegt ist.
	 * 
	 * @param tag    Tag von 1 - 31
	 * @param stunde Stunde zur Überprüfung von 0 - 23
	 * @return true, wenn der Termin noch frei ist. false, wenn ein oder mehrere
	 *         Termine an dem Tag liegen.
	 */
	public boolean terminNochFrei(int tag, int stunde) {
		if (tag > 0 && tag < 32) {
			return tage[tag - 1].frageStundefrei(stunde);
		}
		return false;
	}

	/**
	 * Gibt aus, ob an einem übergebenen Tag ein oder mehrere Termine liegen
	 * 
	 * @param tag Tag von 1 - 31
	 * @return true, wenn an dem Tag ein Termin liegt. false, wenn an dem Tag noch
	 *         kein Termin vorgemerkt ist.
	 */
	public boolean tagHatTermin(int tag) {
		if (tag > 0 && tag < 32) {
			return tage[tag - 1].hatTermine();
		}
		return false;
	}

	/**
	 * Gibt eine Liste aller Tage auf der Konsole aus. Ist an einem Tag ein Termin
	 * vorgemerkt, so wird dieser Tag mit einem angehängten "t" markiert.
	 */
	public void ausgabeTageUebersicht() {
		for (Tag tag : tage) {
			if (tag.hatTermine()) {
				System.out.printf("%2dt", tag.gibTagImMonat());
			} else
				System.out.printf("%3d", tag.gibTagImMonat());

		}
	}

	/**
	 * Gibt alle Termine an dem übergebenen Tag in der Konsole aus.
	 * @param t Tag von 1 - 31 
	 */
	public void tagAusgeben(int t) {
		int ausgabe = t;
		ArrayList<Termin> TermineAusgeben = tage[ausgabe - 1].gibTermine(); // alle Termine an dem Tag i
		if (TermineAusgeben.isEmpty())
			System.out.println("An diesem Tag befinden sich keine Termine.");
		else {
			System.out.println("An dem " + ausgabe + ". befinden sich folgende Termine:");

			for (int b = 0; b < TermineAusgeben.size(); b++) {
				Termin tmp = TermineAusgeben.get(b); // einzelne Termine an der Stelle b
				System.out.println(tmp.getBetreff() + " von " + tmp.getBeginn() + " Uhr bis "
						+ (tmp.getBeginn() + tmp.getDauer()) + " Uhr");
			}
		}
	}
}
