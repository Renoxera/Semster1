package Aufgabe1Userverwaltung;

import de.hsw.gdp.helper.SimpleReader;

/**
 * 
 * @author Felix Franz, Timo Reitmann, Marie Salomon
 * 
 *         Hier kann man den User Verwalten, in dem man einen user anlegen,
 *         bearbeiten und l�schen kann, sowie alle User ausgeben kann. Hierzu
 *         wurden verschiedene Cases angelegt und diese mit der Klasse User
 *         verkn�pft. Es wurde ein Array userliste angelegt, welches indirekt
 *         die Funktion einer ArrayList �bernimmt. In diesem Array k�nnen User
 *         mit Namen, E-Mail Adresse und Passwort angelegt werden. Die
 *         Passw�rter werden bei der Ausgabe durch Sternchen ersetzt.
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
					"User anlegen (1), bearbeiten (2), l�schen (3), alle User ausgeben (4) oder Anwendung beenden (5)? ");
			int auswahl = reader.liesZahl();

			switch (auswahl) {
			/*
			 * Hier wird ein neuer User angelegt und �berpr�ft ob der Username bereits
			 * vorhanden ist. Ist dieses der Fall so wird der User nicht angelegt und nach
			 * einem neuen Username gefragt.
			 */
			case 1:
				boolean gefunden = false;

				while (!gefunden) { // l�uft solange wie kein neuer user angelegt wurde.
					System.out.println("Was ist der Name des Users?");
					String username = reader.liesText();
					/*
					 * es wird �berpr�ft ob es den Username bereits gibt
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
			 * Im case 2 gibt es die M�glichkeit einen speziellen User zu bearbeiten.
			 * Hierf�r wird der User gesucht und wenn dieser vorhanden ist wird gefragt ob
			 * das Passwort oder die Mail Adresse bearbeitet werden soll.
			 */
			case 2:
				System.out.println("Bitte geben Sie den Usernamen ein den sie bearbeiten m�chten");
				String username = reader.liesText();
				/*
				 * sucht ob es den User �berhaupt gibt
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
				 * Wenn der User vorhanden ist wird hier abgefragt was ver�ndert werden soll und
				 * dann kann man ein Neues
				 */

				if (vorhanden) { // user bearbeiten
					System.out.println("Was wollen Sie ver�ndern?");
					System.out.println("Passwort (1),  Mail (2) oder Username (3) ?");
					int entscheidung = reader.liesZahl(1, 3);
					if (entscheidung == 1) { // Passwort �ndern
						System.out.println("Geben sie ein neues Passwort ein");
						userliste[index].setPasswort(reader.liesText());
					}
					if (entscheidung == 2) { // email �ndern
						System.out.println("Geben sie eine neue Mail ein");
						userliste[index].setUsername(reader.liesText());
					}

					/*
					 * Hier kann der Benutzername ver�ndert werden. Es wird �berpr�ft ob der neue
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
							// l�uft solange wie kein neuer user angelegt wurde.
							String neuerUsername = reader.liesText();
							/**
							 * es wird �berpr�ft ob es den Username bereits gibt
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
			 * In diesem Case kann man alle Benutzernamen oder nur einen bestimmten l�schen
			 */
			case 3:
				System.out.println("Sollen alle Usernamen gel�scht werden (1) oder ein bestimmter (2) ?");
				int loeschen = reader.liesZahl();
				/**
				 * hier wird entweder ein neues Array angelegt, welches leer ist oder der
				 * bestimme User gesucht und dann gel�scht
				 */
				if (loeschen == 1) { // alle User l�schen
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
					 * pr�ft ob der User vorhanden ist wenn der Nutzername vorhanden ist wird die
					 * Stelle des Arrays auf null gesetzt
					 */
					if (vorhanden) { // user l�schen
						userliste[index] = null;
					} else {
						System.out.println("Der gesuchte Username ist nicht vorhanden.");
					}
				}
				break;
			/**
			 * Hier werden alle User ausgegeben. Daf�r werden alle Stellen im Arary
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
			 * Fehlermeldung f�r ung�ltige Eingaben
			 */
			default:
				System.out.println("Sie haben keine g�ltige Eingabe get�tigt");
				break;
			}
		}
	}
}
