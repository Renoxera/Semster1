package Aufgabe1Userverwaltung;

import de.hsw.gdp.helper.SimpleReader;

/**
 * 
 * @author Felix Franz, Timo Reitmann, Marie Salomon
 * 
 *         Hier kann man den User Verwalten, in dem man einen user anlegen,
 *         bearbeiten und löschen kann, sowie alle User ausgeben kann. Hierzu
 *         wurden verschiedene Cases angelegt und diese mit der Klasse User
 *         verknüpft. Es wurde ein Array userliste angelegt, welches indirekt
 *         die Funktion einer ArrayList übernimmt. In diesem Array können User
 *         mit Namen, E-Mail Adresse und Passwort angelegt werden. Die
 *         Passwörter werden bei der Ausgabe durch Sternchen ersetzt.
 */
public class UserVerwalten {

	public static void main(String[] args) {
		SimpleReader reader = new SimpleReader();
		User[] userliste = new User[1000];
		boolean beenden = false;

		int o = 0;
		while (!beenden) {
			System.out.println("Was wollen Sie machen? ");
			System.out.println(
					"User anlegen (1), bearbeiten (2), löschen (3), alle User ausgeben (4) oder Anwendung beenden (5)? ");
			int auswahl = reader.liesZahl();

			switch (auswahl) {
			/*
			 * Hier wird ein neuer User angelegt und überprüft ob der Username bereits
			 * vorhanden ist. Ist dieses der Fall so wird der User nicht angelegt und nach
			 * einem neuen Username gefragt.
			 */
			case 1:
				boolean gefunden = false;

				while (!gefunden) { // läuft solange wie kein neuer user angelegt wurde.
					System.out.println("Was ist der Name des Users?");
					String username = reader.liesText();
					/*
					 * es wird überprüft ob es den Username bereits gibt
					 */
					boolean nameGleich = false;
					for (int j = 0; j < userliste.length; j++) {
						if (userliste[j] != null) {
							if (userliste[j].getUsername().equals(username)) {
								nameGleich = true;
							}
						}
					}
					/*
					 * Wenn der Username noch nicht vorhanden ist, wird hier ein neuer User
					 * angelegt.
					 */
					if (!nameGleich) { // erstellt einen neuen user wenn der name nicht vorhanden ist.
						System.out.println("Wie lautet die E-mail Adresse von " + username);
						String mail = reader.liesText();
						System.out.println("Wie soll das Passwort lauten?");
						String passwort = reader.liesText();

						userliste[o] = new User(username, passwort, mail);

						gefunden = true;
						o++;
					} else {
						System.out.println("Der Name ist bereits vorhanden");
					}
				}
				break;
			/*
			 * Im case 2 gibt es die Möglichkeit einen speziellen User zu bearbeiten.
			 * Hierfür wird der User gesucht und wenn dieser vorhanden ist wird gefragt ob
			 * das Passwort oder die Mail Adresse bearbeitet werden soll.
			 */
			case 2:
				System.out.println("Bitte geben Sie den Usernamen ein den sie bearbeiten möchten");
				String username = reader.liesText();
				/*
				 * sucht ob es den User überhaupt gibt
				 */
				boolean vorhanden = false;
				int index = 0;
				for (int i = 0; i < userliste.length; i++) {
					if (userliste[i] != null) {
						if (userliste[i].getUsername().equals(username)) {
							vorhanden = true;
							index = i;
						}

					}
				}
				System.out.println("Der Benutzername ist leider nicht vorhanden.");

				/*
				 * Wenn der User vorhanden ist wird hier abgefragt was verändert werden soll und
				 * dann kann man ein Neues
				 */

				if (vorhanden) { // user bearbeiten
					System.out.println("Was wollen Sie verändern?");
					System.out.println("Passwort (1),  Mail (2) oder Username (3) ?");
					int entscheidung = reader.liesZahl(1, 3);
					if (entscheidung == 1) { // Passwort ändern
						System.out.println("Geben sie ein neues Passwort ein");
						userliste[index].setPasswort(reader.liesText());
					}
					if (entscheidung == 2) { // email ändern
						System.out.println("Geben sie eine neue Mail ein");
						userliste[index].setUsername(reader.liesText());
					}

					/*
					 * Hier kann der Benutzername verändert werden. Es wird überprüft ob der neue
					 * Benutzername bereits exisitiert
					 *
					 * 
					 * 
					 * 
					 * Funktioniert nicht richtig!!!!!!!!!!!!
					 */
					else {

						boolean schonda = false;

						while (!schonda) {
							System.out.println("Geben sie einen neuen Benutzername ein:");
							// läuft solange wie kein neuer user angelegt wurde.
							String neuerUsername = reader.liesText();
							/**
							 * es wird überprüft ob es den Username bereits gibt
							 */
							boolean nameGleich = false;
							for (int j = 0; j < userliste.length; j++) {
								if (userliste[j] != null) {
									if (userliste[j].getUsername().equals(neuerUsername)) {
										nameGleich = true;
									}
								}
							}
							if (!nameGleich) {

								userliste[index].setUsername(reader.liesText());
								System.out.println(neuerUsername + " wurde als neuer Benutzername gespeichert");
							} else {
								System.out.println("Der Name ist bereits vorhanden");
							}
						}
					}
				}
				break;

			/**
			 * In diesem Case kann man alle Benutzernamen oder nur einen bestimmten löschen
			 */
			case 3:
				System.out.println("Sollen alle Usernamen gelöscht werden (1) oder ein bestimmter (2) ?");
				int loeschen = reader.liesZahl();
				/**
				 * hier wird entweder ein neues Array angelegt, welches leer ist oder der
				 * bestimme User gesucht und dann gelöscht
				 */
				if (loeschen == 1) { // alle User löschen
					userliste = new User[1000];
				} else {
					System.out.println("Geben Sie den Usernamen ein: ");
					username = reader.liesText();

					vorhanden = false;
					index = 0;
					for (int i = 0; i < userliste.length; i++) {
						if (userliste[i] != null) {
							if (userliste[i].getUsername().equals(username)) {
								vorhanden = true;
								index = i;
							}
						}
					}
					/**
					 * prüft ob der User vorhanden ist wenn der Nutzername vorhanden ist wird die
					 * Stelle des Arrays auf null gesetzt
					 */
					if (vorhanden) { // user löschen
						userliste[index] = null;
					} else {
						System.out.println("Der gesuchte Username ist nicht vorhanden.");
					}
				}
				break;
			/**
			 * Hier werden alle User ausgegeben. Dafür werden alle Stellen im Arary
			 * ausgegeben die nicht null sind
			 */
			case 4:
				for (int i = 0; i < userliste.length; i++) {
					if (userliste[i] != null) { // wenn die Stelle nicht leer ist wird die Position ausgegeben
						userliste[i].print();
					}
				}
				break;
			// Anwendung beenden
			case 5:
				beenden = true;
				break;
			/**
			 * Fehlermeldung für ungültige Eingaben
			 */
			default:
				System.out.println("Sie haben keine gültige Eingabe getätigt");
				break;
			}
		}
	}
}
