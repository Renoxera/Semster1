package Aufgabe2AufgabenVerwaltung;

import de.hsw.gdp.helper.SimpleReader;

public class AufgabenVerwaltung {
	public static void main(String[] args) {
		AufgabenSpeicher a = new AufgabenSpeicher();
//		beispielBelegung(a);
		boolean schleife = true;
		int eingabe;
		do {
			System.out.println(
					"Was möchtest du machen? \n [1] - Aufgabe erfassen \n [2] - Ausgabe Aufgaben \n [3] - Aufgabenstatus ändern \n [4] - Aufgabe löschen \n [5] - Programm beenden");
			SimpleReader reader = new SimpleReader();
			switch (reader.liesZahl(1, 5)) {
				case 1:
					eingabeUndErzeugung(reader, a);			
					break;
				case 2:
					System.out.print(" [0] - alle \n [1] - erledigte \n [2] - unerledigte\n Eingabe: ");
					int auswahl1 = reader.liesZahl(1,3);
					System.out.print("Sortiert nach:\n [0] - Datum\n [1] - ID\n Eingabe: ");
					int auswahl2 = reader.liesZahl(1,2);
					a.ausgabeNach(auswahl2, auswahl1);
					break;
				case 3:
					System.out.println("Möchtest du den Status einer Aufgabe auf\n [0] - von unerledigt auf erledigt oder\n [1] - von erledigt auf unerledigt setzen? ");
					eingabe = reader.liesZahl(0,1);
  					a.aenderStatus(eingabe);
					break;
				case 4:
					System.out.print(" [0] - Nach Name\n [1] - Nach ID\n");
					String e = "";
					switch (reader.liesZahl(0, 1)) {
						case 0:
							System.out.print("Namen oder Teilnamen eingeben: ");
							e=reader.liesText();
							a.loescheNachAufgabe(e);
							break;
						case 1:
							System.out.print("ID der Aufgabe eingeben: ");
							int i=reader.liesZahl(0);
							a.loescheNachNummer(i);
							
							break;
						default:
							break;
					}
					break;
				case 5:
					schleife = false;
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
		System.out.print("Erledigt [true|false|0|1]: ");
		erledigt = reader.liesText();
		
		
		if (t.fuegeAufgabeHinzu(aufgabe, erledigt, datum))
			System.out.println("\n Kontakt wurde erfolgreich angelegt.");
		else System.out.println("\n Kontakt konnte nicht angelegt werden.");
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
		a.fuegeAufgabeHinzu("Test1", "0", "10.10.1000,01:00");
		a.fuegeAufgabeHinzu("Test1", "2", "10.10.1000,01:00");
		}
}
