package Aufgabe4Iban;

import java.math.BigInteger;
import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Berechnung und Ausgabe eine Iban aus einer eingegebenen
 * Bankleitzahl und Kontonummer
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Iban {

	/**
	 * Hauptmethode
	 */
	public static void main(String[] args) {
		SimpleReader reader = new SimpleReader();

		// Kontonummer und Bankleitzahl eingeben
		System.out.println("Bitte Geben sie ihre Bankleitzahl ein:");
		String blz = reader.liesText(8);
		System.out.println("Bitte Geben sie ihre Kontonummer ein:");
		String ktn = reader.liesText(10);

		// F�llnullen f�r Kontonummer
		while (ktn.length() < 10)
			ktn = "0" + ktn;

		// Profsumme zusammenstellen
		String pr�fS = blz + ktn + "131400";

		// Pr�fziffer berechnen
		BigInteger bPr�fS = new BigInteger(pr�fS);
		BigInteger cPr�fS = new BigInteger("97");
		int mod = bPr�fS.remainder(cPr�fS).intValue();
		int pr�fZ = 98 - mod;
		if (pr�fZ < 10)
			pr�fZ = '0' + pr�fZ;

		// Ausgabe
		System.out.println("Pr�fziffer: " + pr�fZ);
		System.out.println("Bankleitzahl: " + blz);
		System.out.println("Kontonummer: " + ktn);
		System.out.println("IBAN: " + "DE" + pr�fZ + blz + ktn);
	}
}