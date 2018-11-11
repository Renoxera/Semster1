package Aufgabe3CaeserChiffre;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Ver- und Entschlüsselung von Texten nach der Ceaser-Chiffre.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class CaeserChiffre {
	public static void main(String args[]) {
		String eingabe;
		int verschiebung;
		SimpleReader reader = new SimpleReader();

		// Eingabe
		switch (args.length) {
		case 2:
			eingabe = args[0];
			try {
				verschiebung = Integer.parseInt(args[1]);
			} catch (Exception e) {
				System.out.println(
						"Fehler in der Parameterübergabe an das Programm.\n Manuelle Eingabe der Verschiebung nötig.");
				verschiebung = reader.liesZahl();
			}
			break;
		case 1:
			eingabe = args[0];
			System.out.println("Eingabe Verschiebung:");
			verschiebung = reader.liesZahl();
			break;

		default:
			System.out.println("Eingabe Text:");
			eingabe = reader.liesText();
			System.out.println("Eingabe Verschiebung:");
			verschiebung = reader.liesZahl();
		}

		eingabe = caeserVerschluesseln(eingabe, verschiebung);

		System.out.println("Der verschlüsselte Text lautet: \n" + eingabe);

		eingabe = caeserEntschluesseln(eingabe, verschiebung);

		System.out.println("Der entschlüsselte Text lautet: \n" + eingabe);

	}

	/**
	 * Methode zur Verschlüsselung nach der Caeser-Chiffre
	 * 
	 * @param text         Eingabetext
	 * @param verschiebung Anzahl der Dreh-Klicks (Bsp. 1: a -> b)
	 * @return verschluesselten Text
	 */
	public static String caeserVerschluesseln(String text, int verschiebung) {
		return caeserVerschiebung(text, verschiebung);
	}

	/**
	 * Methode zur Entschlüsselung nach der Caeser-Chiffre
	 * 
	 * @param text         Eingabetext
	 * @param verschiebung Anzahl der Dreh-Klicks (Bsp. 1: b -> a)
	 * @return entschluesselten Text
	 */
	public static String caeserEntschluesseln(String text, int verschiebung) {
		return caeserVerschiebung(text, (-1) * verschiebung);
	}

	/**
	 * Verschiebt die eingegebene Buchstabenkette um verschiebung Stellen nach
	 * rechts im Aplhabet.
	 * 
	 * @param text Eingabetext
	 * @param Verschiebung Verschiebung nach rechts (Bsp. 1: a->b; -1: b->a)
	 * @return verschobener Text
	 */
	private static String caeserVerschiebung(String text, int verschiebung) {
		char[] buchstabenArray = text.toCharArray();
		String ausgabe = "";
		int tatsaechlicheVerschiebung = verschiebung % 26;
		for (char c : buchstabenArray) {
			int temp = c + tatsaechlicheVerschiebung;
			// Großbuchstaben
			if ((c >= 65 && c <= 90)) {
				temp += temp < 65 ? 26 : 0;
				temp -= temp > 90 ? 26 : 0;
				ausgabe += (char) temp;
			// Kleinbuchstaben
			} else if (c >= 97 && c <= 122) {
				temp += temp < 97 ? 26 : 0;
				temp -= temp > 122 ? 26 : 0;
				ausgabe += (char) temp;
			// Andere Zeichen
			} else
				ausgabe += (char) c;
		}
		return ausgabe;
	}
}
