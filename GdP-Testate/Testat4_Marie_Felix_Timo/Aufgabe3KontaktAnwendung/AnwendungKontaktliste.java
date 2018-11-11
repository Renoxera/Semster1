package Aufgabe3KontaktAnwendung;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Hauptklasse mit der Mechanik. Ist für die Eingaben und das kommunizieren mit
 * einer Kontaktliste ausgelegt.
 * 
 * @author Service
 */
public class AnwendungKontaktliste {
	public static void main(String args[]) {
		KontaktListe k = new KontaktListe();
		ausfuehren(k);
	}
	
	/**
	 * Mechanik:
	 * </p>
	 * 1. Abfrage, was gemacht werden möchte.
	 * </p>
	 * 2. ggf. Eingabe.
	 * </p>
	 * 3. Ausgabe des Ergebnis.
	 * </p>
	 * 4. Wiederholtung ab 1.
	 * </p>
	 * 
	 * @param k Kontaktliste, die verwendet werden soll.
	 */
	private static void ausfuehren(KontaktListe k) {
		boolean schleife = true;
//		beispielKontakte(k);
		
		do {
			System.out.println(
					"Was möchtest du machen? \n [1] - Kontakt hinzufügen \n [2] - Alle Kontakte ausgeben \n [3] - Kontakte nach Namen durchsuchen \n [4] - Programm beenden");
			SimpleReader reader = new SimpleReader();
			String name, telefonnummer, adresse, mail, geburtstag;
			switch (reader.liesZahl(1, 4)) {
				case 1:
					System.out.println(" Optionale Eingaben können durch [Enter] übersprungen werden.");
					System.out.print("Name: ");
					name = reader.liesText();
					System.out.print("Nummer: ");
					telefonnummer = reader.liesText();
					System.out.print("Adresse (optional): ");
					adresse = reader.liesText();
					System.out.print("Mail (optional): ");
					mail = reader.liesText();
					System.out.print("Geburtstag (optional): ");
					geburtstag = reader.liesText();
					if (k.fuegeKontaktHinzu(name, telefonnummer, adresse, mail, geburtstag))
						System.out.println("\n Kontakt wurde erfolgreich angelegt.");
					else System.out.println("\n Kontakt konnte nicht angelegt werden.");
					break;
				case 2:
					k.gibAlleKontakteAus();
					break;
				case 3:
					System.out.print("Eingabe (Teil-)Namen zur Suche: ");
					name = reader.liesText();
					k.sucheKontakt(name);
					break;
				case 4:
					schleife = false;
					break;
				default:
					System.out.println("Eingabe konnte nicht verarbeitet werden. Bitte wiederholen. ");
			}
			System.out.println();
		} while (schleife);
	}
	/**
	 * Hilfsmethode, die "nur" einige Kontakte versucht anzulegen. 
	 * Hilft bei Demo und Bugfixing als Testmethode.
	 * @param k
	 */
	@SuppressWarnings("unused")
	private static void beispielKontakte(KontaktListe k) {
		System.out.println(" Anlegung Beispielkontakte gestartet. \n\n");
		System.out.println("Kontakt 1: (Keinen Name und keine Nummer eingegeben)");
		k.fuegeKontaktHinzu("", "", "", "", "");
		System.out.println("Kontakt 2: (Nur Name und Nummer)");
		k.fuegeKontaktHinzu("Nur Nummer Tester", "0123456789", "", "", "");
		System.out.println("Kontakt 3: (Nur Name und Nummer2)");
		k.fuegeKontaktHinzu("Nur Nummer Tester", "+123456789", "", "", "");
		System.out.println("Kontakt 4: (Adresstester valide)");
		k.fuegeKontaktHinzu("Walter Adresstester", "+49 4562 5822", "Straße 1", "", "");
		System.out.println("Kontakt 5: (Adresstester invalide)");
		k.fuegeKontaktHinzu("Walter Adresstester", "+49 4562 5822", "1", "", "");
		System.out.println("Kontakt 6: (Mailtester valide)");
		k.fuegeKontaktHinzu("Maier Mailtester", "+49 4562 5824", "", "mailtester@mail.de", "");
		System.out.println("Kontakt 7: (Mailtester invalide)");
		k.fuegeKontaktHinzu("Maier Mailtester", "+49 4562 5825", "", "mailtester.mail@de", "");
		System.out.println("Kontakt 8: (Mailtester invalide2)");
		k.fuegeKontaktHinzu("Maier Mailtester", "+49 4562 5826", "", "mailtestermail@de", "");
		System.out.println("Kontakt 9: (Mailtester invalide3)");
		k.fuegeKontaktHinzu("Maier Mailtester", "+49 4562 5827", "", "mailtestermail.de", "");
		System.out.println("Kontakt 10: (Mailtester invalide4)");
		k.fuegeKontaktHinzu("Maier Mailtester", "+49 4562 5828", "", "@.", "");
		System.out.println("Kontakt 11: (Geburtstagstester valide)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5830", "", "", "1.1.1999");
		System.out.println("Kontakt 12: (Geburtstagstester valide Schaltjahr)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5831", "", "", "29.2.2000");
		System.out.println("Kontakt 13: (Geburtstagstester invalide nicht Schaltjahr)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5832", "", "", "29.2.2001");
		System.out.println("Kontakt 14: (Geburtstagstester invalide Tag = 0)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5833", "", "", "0.1.1999");
		System.out.println("Kontakt 15: (Geburtstagstester invalide Monat = 0)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5833", "", "", "1.0.1999");
		System.out.println("Kontakt 16: (Geburtstagstester valide kurzer Monat, tag = 30)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5834", "", "", "30.4.1999");
		System.out.println("Kontakt 17: (Geburtstagstester valide kurzer Monat, tag = 30 2)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5835", "", "", "30.11.1999");
		System.out.println("Kontakt 18: (Geburtstagstester invalide kurzer Monat, tag = 31)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5836", "", "", "31.4.1999");
		System.out.println("Kontakt 19: (Geburtstagstester invalide kurzer Monat, tag = 31 2)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5837", "", "", "31.9.1999");
		System.out.println("Kontakt 20: (Geburtstagstester valide langer Monat, tag = 31)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5838", "", "", "31.1.1999");
		System.out.println("Kontakt 21: (Geburtstagstester valide langer Monat, tag = 31 2)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5839", "", "", "31.10.1999");
		System.out.println("Kontakt 22: (Geburtstagstester invalide langer Monat, tag = 32)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5840", "", "", "31.4.1999");
		System.out.println("Kontakt 23: (Geburtstagstester invalide langer Monat, tag = 32 2)");
		k.fuegeKontaktHinzu("Gerog Geburtstagstester", "+49 4562 5841", "", "", "31.9.1999");
		System.out.println("Kontakt 24: (Gesammttester)");
		k.fuegeKontaktHinzu("Albert Alles", "+49 4562 5835", "testweg 1", "tester@m.com", "1.1.1999");
		System.out.println("\n Anlegung Beispielkontakte beendet. \n\n");	
	}
}
