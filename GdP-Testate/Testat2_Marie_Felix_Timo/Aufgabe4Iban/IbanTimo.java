package Aufgabe4Iban;

import java.math.BigInteger;

import de.hsw.gdp.helper.SimpleReader;

public class IbanTimo {

	public static void main(String[] args) {
		int blz = 0;
		BigInteger kntnr = new BigInteger("0");
		String kntnrString = "";
		if (args.length == 2) {
			blz = Integer.parseInt(args[0]);
			kntnr = new BigInteger(args[1]);
		} else {
			System.out.println("Bitte geben Sie eine BLZ und eine Kontonummer beim Start der Anwednung an.");
			SimpleReader reader = new SimpleReader();
			blz = reader.liesZahl(0,99999999);
			kntnrString = reader.liesText().replaceAll(" ", "");
			kntnr = new BigInteger(kntnrString);
			
		}	
		
		// Eingabe Bankleitzahl, Eingabe Kontonummer
		
		
		// Zusammensetzung Kontonummer aus String.
		
		// Berechnung Prüfziffer
		
		String zahl = ""+blz+kntnr+"131400";
		BigInteger zahlen = new BigInteger(zahl);
		System.out.println(zahlen);
		int pz = 98 - zahlen.mod(new BigInteger("97")).intValue();
		
		System.out.println("Prüfziffer: " + pz);
		System.out.println("Bankleitzahl: " + blz);
		System.out.println("Kontonummer: " + kntnr);
		
		System.out.printf("IBAN DE%2s%8s%10s",pz,blz,kntnr);
		// Voransetzen des DE - Zusatz
	}

}
