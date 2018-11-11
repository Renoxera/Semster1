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

		// Füllnullen für Kontonummer
		while (ktn.length() < 10)
			ktn = "0" + ktn;

		// Profsumme zusammenstellen
		String prüfS = blz + ktn + "131400";

		// Prüfziffer berechnen
		BigInteger bPrüfS = new BigInteger(prüfS);
		BigInteger cPrüfS = new BigInteger("97");
		int mod = bPrüfS.remainder(cPrüfS).intValue();
		int prüfZ = 98 - mod;
		if (prüfZ < 10)
			prüfZ = '0' + prüfZ;

		// Ausgabe
		System.out.println("Prüfziffer: " + prüfZ);
		System.out.println("Bankleitzahl: " + blz);
		System.out.println("Kontonummer: " + ktn);
		System.out.println("IBAN: " + "DE" + prüfZ + blz + ktn);
	}
}