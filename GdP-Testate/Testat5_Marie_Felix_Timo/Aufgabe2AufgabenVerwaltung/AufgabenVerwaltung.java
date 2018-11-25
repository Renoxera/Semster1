package Aufgabe2AufgabenVerwaltung;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Verwaltung von Aufgaben. Verwendet die Klasse AufgabenSpeicher
 * zum Speichern der Aufgaben.
 *
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 * 
 */
public class AufgabenVerwaltung {
	public static void main(String[] args) {
		AufgabenSpeicher a = new AufgabenSpeicher();
//		beispielBelegung(a);
		boolean schleife = true;
		int eingabe;
		do {
			System.out.print(
					"Was möchtest du machen? \n [1] - Aufgabe erfassen \n [2] - Ausgabe Aufgaben \n [3] - Aufgabenstatus ändern \n [4] - Aufgabe löschen \n [5] - Programm beenden\n Eingabe: ");
			SimpleReader reader = new SimpleReader();
			switch (reader.liesZahl(1, 5)) {
			case 1:
				eingabeUndErzeugung(reader, a);
				break;
			case 2:
				System.out.print(" [1] - alle \n [2] - erledigte \n [3] - unerledigte\n Eingabe: ");
				int auswahl1 = reader.liesZahl(1, 3);
				System.out.print("Sortiert nach:\n [1] - Nummer\n [2] - Datum\n Eingabe: ");
				int auswahl2 = reader.liesZahl(1, 2);
				a.ausgabeNach(auswahl2, auswahl1);
				break;
			case 3:
				System.out.print(
						"Möchtest du den Status einer Aufgabe auf\n [1] - von unerledigt auf erledigt\n [2] - von erledigt auf unerledigt\n setzen? Eingabe: ");
				eingabe = reader.liesZahl(1, 2);
				a.aenderStatus(eingabe);
				break;
			case 4:
				System.out.print(" [1] - Nach Name\n [2] - Nach ID\n");
				switch (reader.liesZahl(1, 2)) {
				case 1:
					System.out.print("Namen oder Teilnamen eingeben: ");
					String s = reader.liesText();
					if (a.loescheNachAufgabe(s)) {
						System.out.println("Löschen erfolgreich.");
					} else {
						System.out.println("Keine Löschung.");
					}
					break;
				case 2:
					System.out.print("ID der Aufgabe eingeben: ");
					int n = reader.liesZahl(0);
					if (a.loescheNachNummer(n)) {
						System.out.println("Löschen erfolgreich.");
					} else {
						System.out.println("Keine Löschung.");
					}
					break;
				default:
					break;
				}
				break;
			case 5:
				schleife = false;
				System.out.println("\n Das Programm wurde erfolgreich beendet.");
				break;
			default:
				System.out.println("Eingabe konnte nicht verarbeitet werden. Bitte wiederholen. ");
			}
			System.out.println();
		} while (schleife);

	}

	private static void eingabeUndErzeugung(SimpleReader reader, AufgabenSpeicher t) {
		String aufgabe, datum, erledigt;
		System.out.print("Aufgabe: ");
		aufgabe = reader.liesText();
		System.out.print("Datum [tt.mm.jjjj,ss:mm]: ");
		datum = reader.liesText();
		System.out.print("Erledigt [true|ja|j|false|nein|n]: ");
		erledigt = reader.liesText();

		if (t.fuegeAufgabeHinzu(aufgabe, erledigt, datum))
			System.out.println("\n Kontakt wurde erfolgreich angelegt.");
		else
			System.out.println("\n Kontakt konnte nicht angelegt werden.");
	}

	public static void beispielBelegung(AufgabenSpeicher a) {
		a.fuegeAufgabeHinzu("", "1", "");
		a.fuegeAufgabeHinzu("Test", "1", "");
		a.fuegeAufgabeHinzu("1223456789", "1", "1");
		a.fuegeAufgabeHinzu("äasdfj", "1", "1");
		a.fuegeAufgabeHinzu("Test1", "0", "0.0.0,0:0");
		a.fuegeAufgabeHinzu("Test1", "1", "1.0.0,0:0");
		a.fuegeAufgabeHinzu("Test1", "1", "1.1.0,0:0");
		a.fuegeAufgabeHinzu("Test1", "1", "1.1.1,0:0");
		a.fuegeAufgabeHinzu("Test1", "0", "1.1.-1,0:0");
		a.fuegeAufgabeHinzu("Test1", "1", "1.1.1,0:0");
		a.fuegeAufgabeHinzu("Test1", "0", "1.1.1,1:0");
		a.fuegeAufgabeHinzu("Test1", "1", "1.1.1,0:1");
		a.fuegeAufgabeHinzu("Test1", "1", "1.1.1,24:0");
		a.fuegeAufgabeHinzu("Test1", "1", "1.1.1,0:60");
		a.fuegeAufgabeHinzu("Test1", "true", "10.10.1000,01:00");
		a.fuegeAufgabeHinzu("Test1", "ja", "10.10.1000,01:00");
		a.fuegeAufgabeHinzu("Test1", "Ja", "10.10.1000,01:00");
		a.fuegeAufgabeHinzu("Test1", "false", "10.10.1000,01:00");
		a.fuegeAufgabeHinzu("Test1", "f", "10.10.1000,01:00");
		a.fuegeAufgabeHinzu("Test1", "nein", "10.10.1000,01:00");
		a.fuegeAufgabeHinzu("Test1", "0", "10.10.3000,01:00");
		a.fuegeAufgabeHinzu("Test1", "0", "10.10.2000,01:00");
		a.fuegeAufgabeHinzu("Test1", "0", "10.10.1000,01:00");
		a.fuegeAufgabeHinzu("Test1", "2", "10.10.1000,01:00");
	}
}
