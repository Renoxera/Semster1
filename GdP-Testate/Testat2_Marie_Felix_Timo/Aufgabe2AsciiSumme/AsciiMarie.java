package Aufgabe2AsciiSumme;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Wandelt den eingegebenen Namen in ASCII- Code um. im char ist der Unicode
 * gespeichert der unteranderem weiﬂ das ein Buchstabe die und die Zahl im ASCII
 * Code ist
 * 
 * @author Felix Franz, Timo Reitmann, Marie Salomon
 *
 */
public class AsciiMarie {

	public static void main(String[] args) {
		SimpleReader reader = new SimpleReader();
		System.out.println("Geben Sie ihren Namen ein: ");
		String name = reader.liesText();
		char[] buchstabe = name.toCharArray(); // Teilt den Namen in Buchstaben auf
		int summe = 0;
		System.out.println("Dein Name im ASCII-Code lautet: ");
		for (int i = 0; i < buchstabe.length; i++) {
			int ascii = 0;
			while (buchstabe[i] != (char) ascii) { // Vergleicht ob der Buchstabe schon die Ziffer im Ascii code
													// erreicht hat	
				ascii++;							// z‰hlt hoch, um zu schauen welche Ziffer der Buchstabe hat

			}
			summe = summe + ascii;
			System.out.println(buchstabe[i] + " -> " + ascii);

		}
		System.out.println("Die Summe ist: " + summe);
	}

}
