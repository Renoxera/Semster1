package Aufgabe2AufgabenVerwaltung;
//
import java.util.ArrayList;
import java.util.GregorianCalendar;
import de.hsw.gdp.helper.SimpleReader;

public class AufgabenSpeicher {
	protected ArrayList<Aufgabe>	alleAufgaben, erledigteAufgaben, unerledigteAufgaben;
	
	protected static int[]			spaltenbreite	= { 30, 8, 7 };
	
	/**
	 * legt die in der AufgabenVerwaltung gespeicherten Listen an.
	 */
	public AufgabenSpeicher() {
		alleAufgaben = new ArrayList<Aufgabe>();
		erledigteAufgaben = new ArrayList<Aufgabe>();
		unerledigteAufgaben = new ArrayList<Aufgabe>();
	}
	
	/**
	 * Methode, die dazu dient eine neue Aufgabe den Listen anzuhängen.
	 * 
	 * @param aufgabe  Name bzw. Beschreibung der Aufgabe
	 * @param erledigt true|false|ja|nein|1|0. Andernfalls Fehler
	 * @param datum    (tt.mm.jjjj,ss:mm) Andernfalls Fehler
	 * @return true, wenn erfolgreich. false, wenn es zu einem Fehler gekommen ist.
	 */
	public boolean fuegeAufgabeHinzu(String aufgabe, String erledigt, String datum) {
		return fuegeAufgabeDerListeHinzu(pruefeEingabeUndErzeugeAufgabe(aufgabe, erledigt, datum));
	}
	
	/**
	 * Interne Methode, die die eingegebenen Strings Überprüft und eine neue Aufgabe
	 * mit den übergebenen Werten erzeugt.
	 * 
	 * @param aufgabe  Name bzw. Beschreibung der Aufgabe
	 * @param erledigt Status der Aufgabe
	 * @param datum    Fälligkeitsdatum in der Form tt.mm.jjjj,ss:mm
	 * @return Aufgabe, wenn Eingaben zulässig. null, wenn Eingaben unzulässig.
	 */
	private Aufgabe pruefeEingabeUndErzeugeAufgabe(String aufgabe, String erledigt, String datum) {
		GregorianCalendar faelligkeitsdatum = stringZuDatum(datum);
		int pruefeEr = pruefeErledigt(erledigt);
		boolean erle;
		if (pruefeEr == 0) {
			erle = true;
		} else if (pruefeEr == 1) {
			erle = false;
		} else return null;
		if (faelligkeitsdatum != null) return new Aufgabe(aufgabe, erle, faelligkeitsdatum);
		else return null;
	}
	
	/**
	 * Interne Methode, die einen eingegebenen String überprüft, ob sie in ein
	 * boolean umsetzbar ist.
	 * 
	 * @param eingabe String zur überprüfung
	 * @return 0 - zulässige Eingabe von true. 1 - zulässige Eingabe von false. 2 -
	 *         unzulässige Eingabe
	 */
	private int pruefeErledigt(String eingabe) {
		if (eingabe.equals("true") || eingabe.equals("1") || eingabe.equals("ja")) {
			return 0;
		} else if (eingabe.equals("false") || eingabe.equals("0") || eingabe.equals("nein")) {
			return 1;
		} else {
			System.err.println("Falsche Eingabe. Bitte [true|false|0|1|ja|nein] eingeben.");
			return 2;
		}
	}
	
	/**
	 * Interne Methode, die eine Aufgabe an die Liste aller Aufgaben und an die
	 * passende Liste erleidgt oder unerledigt an.
	 * 
	 * @param aufgabe anzuhängende Aufgabe. Falls die Aufgabe = null ist, wird
	 *                nichts angehängt.
	 * @return true, wenn erfolgreich. false, falls nicht.
	 */
	private boolean fuegeAufgabeDerListeHinzu(Aufgabe aufgabe) {
		if (aufgabe == null) return false;
		anpassungLaengeTabelle(aufgabe);
		alleAufgaben.add(aufgabe);
		if (aufgabe.erledigt) {
			erledigteAufgaben.add(aufgabe);
		} else {
			unerledigteAufgaben.add(aufgabe);
		}
		return true;
	}
	
	/**
	 * Ausgabe einer Liste nach angegeben Sortierkriterium.
	 * 
	 * @param wonach      1 - Fälligkeitsdatum, 2 - Nummer des Einfügen/Bearbeiten
	 * @param welcheListe 1 - alle Aufgaben, 2 - erledigte Aufgaben, 3 - unerledigte
	 *                    Aufgaben
	 */
	public void ausgabeNach(int wonach, int welcheListe) {
		wonach--;
		welcheListe--;
		if (wonach == 0 || wonach == 1 && welcheListe >= 0 && welcheListe <= 2) {
			welcheListe += wonach * 3;
			switch (welcheListe) {
				case 0:
					ausgabeAufgabenNachId(this.alleAufgaben);
					break;
				case 1:
					ausgabeAufgabenNachId(this.erledigteAufgaben);
					break;
				case 2:
					ausgabeAufgabenNachId(this.unerledigteAufgaben);
					break;
				case 3:
					ausgabeAufgabenNachDatum(this.alleAufgaben);
					break;
				case 4:
					ausgabeAufgabenNachDatum(this.erledigteAufgaben);
					break;
				case 5:
					ausgabeAufgabenNachDatum(this.unerledigteAufgaben);
					break;
			}
		}
	}
	
	/**
	 * Löscht einen Eintrag anhand eines Index.
	 * 
	 * @param nummer Nummer anhand der Indizes in der Liste aller Aufgaben beginnend
	 *               bei 0;
	 * @return true, wenn ein Eintrag erfolgreich entfernt werden konnte, false,
	 *         wenn es zu einem Fehler gekommen ist.
	 */
	public boolean loescheNachNummer(int nummer) {
		if (nummer >= 0 && nummer < alleAufgaben.size()) {
			if (alleAufgaben.get(nummer).erledigt) erledigteAufgaben.remove(alleAufgaben.get(nummer));
			else unerledigteAufgaben.remove(alleAufgaben.get(nummer));
			alleAufgaben.remove(nummer);
			return true;
		}
		System.err.println("Eingabe außerhalb der Indizes. " + nummer);
		return false;
	}
	
	/**
	 * @param aufgabe
	 * @return
	 */
	public boolean loescheNachAufgabe(String aufgabe) {
		ArrayList<Aufgabe> auswahl = new ArrayList<Aufgabe>();
		alleAufgaben.stream().filter(a -> a.aufgabe.toLowerCase().contains(aufgabe.toLowerCase()))
				.forEach(k -> auswahl.add(k));
		if (auswahl.size() > 1) {
			ausgabeDerListeMitAngepasstenIndizes(auswahl);
			System.out.print("Welche Aufgabe genau (Nr): ");
			int nr = new SimpleReader().liesZahl(0, auswahl.size() - 1);
			loescheNachNummer(alleAufgaben.indexOf(auswahl.get(nr)));
		} else if (auswahl.size() == 1) {
			loescheNachNummer(alleAufgaben.indexOf(auswahl.get(0)));
		} else System.out.println("Keine Aufgabe mit dem Teilstring.");
		return false;
	}
	
	/**
	 * Methode zur Ändern eines Status einer Aufgabe.
	 * 
	 * @param eingabe 1 um einen unerledigten Eintrag zu ändern, 2 um einen
	 *                erledigte Eintrag zu ändern.
	 */
	public void aenderStatus(int eingabe) {
		if (eingabe == 1) {
			aendereStatusIntern(unerledigteAufgaben);
		} else if (eingabe == 2) {
			aendereStatusIntern(erledigteAufgaben);
		} else System.err.println("Falsche Eingabe. " + eingabe);
	}
	
	private void aendereStatusIntern(ArrayList<Aufgabe> liste) {
		int nr = 0;
		if (liste.size() == 0) {
			System.err.println("Kein Eintrag zum ändern vorhanden.");
			return;
		} else if (liste.size() > 1) {
			ausgabeDerListeMitAngepasstenIndizes(liste);
			System.out.print("Welche Aufgabe genau (Nr): ");
			nr = new SimpleReader().liesZahl(0, liste.size() - 1);
			
		} else nr = 0;
		liste.get(nr).erledigt = !liste.get(nr).erledigt;
		if (liste == unerledigteAufgaben) {
			erledigteAufgaben.add(liste.get(nr));
			unerledigteAufgaben.remove(liste.get(nr));
		} else {
			unerledigteAufgaben.add(liste.get(nr));
			erledigteAufgaben.remove(liste.get(nr));
			
		}
	}
	
	/**
	 * Druckt den Tabellenkopf in der Konsole aus.
	 */
	private void printHeader() {
		int i;
		for (i = 2; alleAufgaben.size() / Math.pow(10, i) > 1; i++);
		System.out.printf("| %" + i + "s | %-" + spaltenbreite[0] + "s | %-" + spaltenbreite[1] + "s | %-"
				+ spaltenbreite[2] + "s |%n", "Nr", "Datum", "Erledigt", "Aufgabe");
	}
	
	/**
	 * gibt die übergebene Liste mit den Indizes dieser Liste an
	 * @param liste Liste, die ausgegeben werden soll.
	 */
	private void ausgabeDerListeMitAngepasstenIndizes(ArrayList<Aufgabe> liste) {
		printHeader();
		liste.stream().forEach(a -> a.printLine(liste));
	}
	
	/**
	 * gibt die übergene Liste mit den Indizes aller Aufgaben aus. Die Ausgabe ist nach der Reihnfolge aller Aufgaben sortiert.
	 * @param liste Liste, die ausgegeben werden soll.
	 */
	private void ausgabeAufgabenNachId(ArrayList<Aufgabe> liste) {
		printHeader();
		liste.stream().forEach(a -> a.printLine());
	}
	
	/**
	 * gibt die übergene Liste mit den Indizes aller Aufgaben aus. Die Ausgabe ist nach der Reihnfolge ihres Fälligkeitsdatum sortiert.
	 * @param liste Liste, die ausgegeben werden soll.
	 */
	private void ausgabeAufgabenNachDatum(ArrayList<Aufgabe> liste) {
		printHeader();
		liste.stream().sorted().forEach(a -> a.printLine());
	}
	
	/**
	 * Wandelt ein in der Form (tt.mm.jjjj,ss:mm) eingegebenes Datum in ein Datum
	 * Objekt der Klasse GregorianCalendar aus.
	 * 
	 * @param datum Datum in der obengenannten Form
	 * @return Objekt der Klasse Gregorian, sofern ein valieds
	 */
	private static GregorianCalendar stringZuDatum(String datum) {
		datum = datum.replaceAll("[^0-9,.:]", "");
		if (datum.matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{1,4}[,][0-9]{1,2}[:][0-9]{1,2}")) {
			String date = datum.split(",")[0];
			String time = datum.split(",")[1];
			
			String[] dateA = date.split("[.]");
			String[] timeA = time.split("[:]");
			
			int tag = Integer.parseInt(dateA[0]);
			int monat = Integer.parseInt(dateA[1]);
			int jahr = Integer.parseInt(dateA[2]);
			int stunde = Integer.parseInt(timeA[0]);
			int minute = Integer.parseInt(timeA[1]);
			if (pruefeValiedenTag(tag, monat, jahr) && (stunde >= 0 && stunde < 24) && (minute >= 0 && minute < 60)) {
				return new GregorianCalendar(jahr, monat - 1, tag, stunde, minute);
			}
		}
		System.err.println("Fehler in der Eingabe des Datums " + datum);
		return null;
	}
	
	/**
	 * Interne Methode, die Überprüft, ob die übergebenen parameter ein valider Tag
	 * im Jahr sind.
	 * 
	 * @param tag   Tag im Monat beginnend bei 1
	 * @param monat Monat im Jahr beginnend bei 1
	 * @param jahr  Jahr beginnend bei 0 für 0 n. Chr.
	 * @return true, wenn es ein valider Tag ist
	 */
	private static boolean pruefeValiedenTag(int tag, int monat, int jahr) {
		return (jahr >= 0) && (tag > 0)
				&& (((monat > 0 && monat <= 7) && (((monat == 2 && jahr % 4 == 0) && (tag <= 29))
						|| ((monat == 2 && jahr % 4 != 0) && (tag <= 28)) || ((monat % 2 == 1) && (tag <= 31))
						|| ((monat != 2 && monat % 2 == 0) && (tag <= 30))))
						|| ((monat > 7 && monat <= 12)
								&& (((monat % 2 == 0) && (tag <= 31)) || ((monat % 2 == 1) && (tag <= 30)))));
		
	}
	
	/**
	 * Prüft ob die Spaltenbreite für die in <code>spaltenbreite</code>
	 * gespeicherten Breiten erhöht werden müssen, da ein breiterer String in den
	 * Kontakten aufgenommen wurde.
	 * 
	 * @param aufgabeA
	 */
	private static void anpassungLaengeTabelle(Aufgabe aufgabe) {
		String[] aufgabeA = { "" + aufgabe.faelligkeitsdatum.getTime(), "" + aufgabe.erledigt, aufgabe.aufgabe };
		for (int i = 0; i < aufgabeA.length && i < spaltenbreite.length; i++) {
			if (aufgabeA[i].length() > spaltenbreite[i]) {
				spaltenbreite[i] = aufgabeA[i].length();
			}
		}
	}
	
	/**
	 * Interne Klasse, in der die benötigten Daten für eine Aufgabe gespeichert
	 * werden. Integration des Interface Comparable, damit Aufgaben nach ihrem
	 * Fälligkeitsdatum sortiert weden können.
	 * 
	 * @author Marie Salomon, Felix Franz, Timo Reitmann
	 */
	class Aufgabe implements Comparable<Aufgabe> {
		private boolean				erledigt	= false;
		private String				aufgabe;
		private GregorianCalendar	faelligkeitsdatum;
		private int					id;
		
		public Aufgabe(String aufgabe, boolean erledigt, GregorianCalendar faelligkeitsdatum) {
			this.aufgabe = aufgabe;
			this.erledigt = erledigt;
			this.faelligkeitsdatum = faelligkeitsdatum;
		}
		
		/**
		 * Druckt den Kontakt in einer Zeile aus. Ausgabe ist an Tabellenkopf angepasst
		 * und ein vorheriges Aufrufen ist sinnvoll.
		 */
		public void printLine() {
			printLine(alleAufgaben);
		}
		/**
		 * Gibt diese Aufgabe mit den Indizes 
		 * @param liste
		 */
		public void printLine(ArrayList<Aufgabe> liste) {
			int i;
			id = liste.indexOf(this);
			for (i = 2; alleAufgaben.size() / Math.pow(10, i) > 1; i++);
			System.out.printf("| %0" + i + "d | %-" + spaltenbreite[0] + "s | %-" + spaltenbreite[1] + "s | %-"
					+ spaltenbreite[2] + "s |%n", id, faelligkeitsdatum.getTime(), erledigt, aufgabe);
		}
		
		@Override
		public int compareTo(Aufgabe o) {
			return this.faelligkeitsdatum.compareTo(o.faelligkeitsdatum);
		}
	}
	
}
