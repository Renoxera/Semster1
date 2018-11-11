package Aufgabe3KontaktAnwendung;

/**
 * In der Klasse KontaktListe verwedete Klasse Kontakt. Speichert die
 * Informationen eines Kontakts. Weist jedem Kontakt zur Laufzeit eine
 * eindeutige Id zu.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 */
public class Kontakt {
	private String			name, adresse, mail, geburtsdatum, telefonnummer;
	private final Integer	id;
	private static int		idZaehler		= 0;
	private static int[]	spaltenbreite	= { 4, 6, 7, 4, 10 };
	
	/**
	 * Erzeugt ein Kontakt-Objekt. Dabei bekommt jeder Kontakt eine eindeutige ID.
	 * Eingaben werden nicht geprüft. Dies muss eine vorgeschaltete Instanz
	 * ausführen.
	 * </p>
	 * Im Zuge der Erstellung wird geprüft, ob Tabellenspalten breiter gezeichnet
	 * werden müssen, da ein Wert zu breit ist.
	 * 
	 * @param name          Name des Kontakts
	 * @param telefonnummer Telefonnummer der Kontaktes
	 * @param adresse       Adresse des Kontaktes
	 * @param mail          Mail-Adresse des Kontaktes
	 * @param geburtstag    Geburtstag des Kontaktes
	 */
	public Kontakt(String name, String telefonnummer, String adresse, String mail, String geburtstag) {
		this.id = ++idZaehler;
		this.name = name;
		this.adresse = adresse;
		this.mail = mail;
		this.geburtsdatum = geburtstag;
		this.telefonnummer = telefonnummer;
		
		String[] var = { name, telefonnummer, adresse, mail, geburtstag };
		Kontakt.pruefeLaenge(var);
	}
	
	/**
	 * gibt den Namen eines Kontaktes zurück.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Druckt den Kontakt in einer Zeile aus. Ausgabe ist an Tabellenkopf angepasst
	 * und ein vorheriges Aufrufen ist sinnvoll.
	 */
	public void printLine() {
		int i;
		for (i = 2; idZaehler / Math.pow(10, i) > 1; i++);
		System.out.printf(
				"| %0" + i + "d | %" + spaltenbreite[0] + "s | %" + spaltenbreite[1] + "s | %" + spaltenbreite[2]
						+ "s | %" + spaltenbreite[3] + "s | %" + spaltenbreite[4] + "s |%n",
				id, name, telefonnummer, adresse, mail, geburtsdatum);
	}
	
	/**
	 * Druckt den Tabellenkopf in der Konsole aus.
	 */
	public static void printHeader() {
		int i;
		for (i = 2; idZaehler / Math.pow(10, i) > 1; i++);
		System.out.printf(
				"| %" + i + "s | %" + spaltenbreite[0] + "s | %" + spaltenbreite[1] + "s | %" + spaltenbreite[2]
						+ "s | %" + spaltenbreite[3] + "s | %" + spaltenbreite[4] + "s |%n",
				"ID", "Name", "Nummer", "Adresse", "Mail", "Geburtstag");
	}
	
	/**
	 * Prüft ob die Spaltenbreite für die in <code>spaltenbreite</code>
	 * gespeicherten Breiten erhöht werden müssen, da ein breiterer String in den
	 * Kontakten aufgenommen wurde.
	 * 
	 * @param vars
	 */
	private static void pruefeLaenge(String[] vars) {
		for (int i = 0; i < vars.length && i < spaltenbreite.length; i++) {
			if (vars[i].length() > spaltenbreite[i]) {
				spaltenbreite[i] = vars[i].length();
			}
		}
	}
}
