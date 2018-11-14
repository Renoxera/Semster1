package Aufgabe3KontaktAnwendung;

import java.util.ArrayList;

/**
 * Klasse KontaktListe zum Speichern von Kontakten. Verwendet intern die Klasse
 * Kontakt.
 * </p>
 * Zum hinzuf�egen eines Kontaktes muss die Methode
 * <code>fuegeKontaktHinzu()</code> verwendet werden.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 */

public class KontaktListe {
	private ArrayList<Kontakt> kontaktListe;
	
	/**
	 * Erzeugt eine Kontaktliste, in der Kontakte gespeichert werden k�nnen.
	 */
	public KontaktListe() {
		kontaktListe = new ArrayList<Kontakt>();
	}
	
	/**
	 * F�gt ein neuen Kontakt in das Telefonbuch ein. Sollte ein Fehler bei der
	 * Verarbeitung eines Parameters auftreten, so wird kein Kontakt hinzugef�gt.
	 * Die Eingaben Telefonnummer, Mail und Geburtstag werden auf korrekte
	 * Schreibweise �berpr�ft und formatiert.
	 * 
	 * @param name          Name des Kontakts
	 * @param telefonNummer Telefonnummer des Kontakts
	 * @param adresse       Adresse des Kontakts
	 * @param mail          Mail-Adresse des Kontakts
	 * @param geburtstag    Geburtstag des Kontakts
	 * @return <code>true</code>, wenn der Kontakt erfolgreich angelegt werden
	 *         konnte
	 *         </p>
	 *         <code>false</code>, wenn der Kontakt <u>nicht</u> angelegt werden
	 *         konnte.
	 */
	public boolean fuegeKontaktHinzu(String name, String telefonNummer, String adresse, String mail,
			String geburtstag) {
		name = ueberpruefeName(name);
		telefonNummer = formatiereTelefonNummer(telefonNummer);
		adresse = ueberpruefeAdresse(adresse);
		mail = ueberpruefeMail(mail);
		geburtstag = ueberpruefeUndFormatiereGeburtstag(geburtstag);
		
		if (telefonNummer != null && geburtstag != null && mail != null && name != null && adresse != null) {
			kontaktListe.add(new Kontakt(name, telefonNummer, adresse, mail, geburtstag));
			return true;
		}
		return false;
	}
	
	/**
	 * �berpr�ft, ob der �bgergebene Name nicht leer ist und mit einem Buchstaben
	 * beginnt.
	 * 
	 * @param name Name zur �berpr�fung.
	 * @return name, wenn nicht leer
	 *         </p>
	 *         null, wenn der name leer ist.
	 */
	private String ueberpruefeName(String name) {
		if (name.matches("[a-zA-Z].*")) return name;
		System.out.println("Fehler in der Eingabe des Namens: " + name);
		return null;
	}
	
	/**
	 * L�scht auch alle Zeichen ungleich + oder Ziffern aus der �bergebenen
	 * Telefonnummer. Formatiert eine Telefonnummer anschlie�end so, dass bei der
	 * Eingabe mit L�nderkennung ("+") an der 7. Stelle ein Leerzeichen ist. Sollte
	 * keine L�nderkennung eingeben worden sein, wird das Leerzeichen nach der 5.
	 * Ziffer gedruckt.
	 * </p>
	 * 
	 * @param telefonNummer Telefonnummer, die formaitert werden soll.
	 * @return formatierte Telefonnumer
	 */
	private String formatiereTelefonNummer(String telefonNummer) {
		telefonNummer = telefonNummer.replaceAll("[^0-9+]", "");
		
		if (telefonNummer.startsWith("+") && telefonNummer.length() > 7)
			telefonNummer = telefonNummer.substring(0, 7) + " " + telefonNummer.substring(7);
		else if (telefonNummer.length() > 5)
			telefonNummer = telefonNummer.substring(0, 5) + " " + telefonNummer.substring(5);
		return telefonNummer;
	}
	
	/**
	 * �berpr�ft die Adresse, ob sie mit einem Buchstaben anf�ngt.
	 * 
	 * @param adresse Adresse zur �berpr�fung.
	 * @return adresse, wenn valide oder keine Eingabe.
	 *         </p>
	 *         null, wenn Adresse nicht nicht mit Buchstabe beginnt.
	 */
	private String ueberpruefeAdresse(String adresse) {
		if (adresse.equals("") || adresse.matches("[a-zA-Z].*")) return adresse;
		else return null;
	}
	
	/**
	 * interne Methode, die �berpr�ft, ob eine Mail an irgendeiner Stelle ein "@"
	 * und danach einen "."hat.
	 * 
	 * @param mail Mail-Adresse, die �berpr�ft werden soll
	 * @return eingegebene Mail-Adresse, wenn sie der Formalie entspricht
	 *         </p>
	 *         null, wenn nicht.
	 */
	private String ueberpruefeMail(String mail) {
		if (mail.equals("")) return mail;
		if (mail.matches(".+[@].+[.].+")) return mail;
		System.out.println("Eingabe ist keine valide Mail-Adresse: " + mail);
		return null;
	}
	
	/**
	 * L�scht alle Eingaben ungleich Ziffern und Punkte aus der Eingabe. �berpr�ft
	 * anschlie�end, ob das eingegebene Datum ein m�glicher Tag im Kalenderjahr ist.
	 * 
	 * @param geburtstag
	 * @return Geburtstag im Format tt.mm.jjjj
	 */
	private String ueberpruefeUndFormatiereGeburtstag(String geburtstag) {
		if (geburtstag.equals("")) return geburtstag;
		
		// Entfernen aller unerw�nschter Zeichen
		geburtstag = geburtstag.replaceAll("[^0-9.]*", "");
		
		// Aufsplitten
		String[] gb = geburtstag.split("[.]");
		
		if (gb.length == 3) {
			// �bersetzen der einzelnen Bestandteile
			if (gb[0].length() > 0 && gb[1].length() > 0 && gb[2].length() > 0) {
				int tag = Integer.parseInt(gb[0]);
				int monat = Integer.parseInt(gb[1]);
				int jahr = Integer.parseInt(gb[2]);
				
				/**
				 * Jahreszahl wird nur als Korrekt angesehen, wenn:
				 * </p>
				 * jahr >= 0 ist und tag >= 1 ist und
				 * </p>
				 * tag <= 31 f�r die Monate Januar, M�rz, Mai, Juli, August, Oktober, Dezember
				 * </p>
				 * tag <= 30 f�r die Monate April, Juni, September, November
				 * </p>
				 * tag <= 29 f�r Februar im Schaltjahr
				 * </p>
				 * tag <= 28 f�r Februar, wenn kein Schaltjahr ist
				 * </p>
				 */
				boolean korrekt = (jahr >= 0) && (tag > 0)
						&& (((monat > 0 && monat <= 7) && (((monat == 2 && jahr % 4 == 0) && (tag <= 29))
								|| ((monat == 2 && jahr % 4 != 0) && (tag <= 28)) || ((monat % 2 == 1) && (tag <= 31))
								|| ((monat != 2 && monat % 2 == 0) && (tag <= 30))))
								|| ((monat > 7 && monat <= 12)
										&& (((monat % 2 == 0) && (tag <= 31)) || ((monat % 2 == 1) && (tag <= 30)))));
				if (korrekt) {
					String test1 = String.format("%02d.%02d.%04d", tag, monat, jahr);
					return test1;
				}
			}
		}
		System.out.println("Eingabe ist kein valides Datum: " + geburtstag);
		return null;
	}
	
	/**
	 * Gibt eine Tabelle mit allen Kontakten in der Reihnfolge ihrer Ids absteigend
	 * aus.
	 */
	public void gibAlleKontakteAus() {
		Kontakt.printHeader();
		for (Kontakt k : kontaktListe) {
			k.printLine();
		}
	}
	
	/**
	 * Durchsucht die Kontaktliste nach einem (Teil-)String eines Namen und gibt
	 * alle passenden Leute aus. Gro�- und Kleinschreibung wird dabei nicht
	 * beachtet.
	 * 
	 * @param name (Teil-)String des zusuchenden Namen
	 */
	public void sucheKontakt(String name) {
		Kontakt.printHeader();
		kontaktListe.stream().filter(k -> k.getName().toLowerCase().contains(name.toLowerCase()))
				.forEach(k -> k.printLine());
	}
}
