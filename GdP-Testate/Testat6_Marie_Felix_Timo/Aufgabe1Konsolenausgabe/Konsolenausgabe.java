package Aufgabe1Konsolenausgabe;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Ausgabe verschiedener Muster auf der Konsole.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 */
public class Konsolenausgabe {
	/**
	 * Main Methode.
	 * 
	 * @param args Übergabe des Musters in der ersten Stelle [a|b|c], sowie die
	 *             Hoehe an der zweiten Stelle und, wenn an Stelle eins a ist eine
	 *             Breite an Stelle drei.
	 */
	public static void main(String args[]) {
		if (args.length != 2 && args.length != 3) {
			args = userEingabe();
		}
		
		int[] auswahl = pruefeEingabe(args);
		
		while (auswahl == null) {
			System.out.println("Fehler in der Eingabe. \n\nErbitte Usereingabe");
			auswahl = pruefeEingabe(userEingabe());
		}
		
		switch (auswahl[0]) {
			case 0:
				musterA(auswahl[1], auswahl[2]);
				break;
			case 1:
				musterB(auswahl[1]);
				break;
			case 2:
				musterC(auswahl[1]);
				break;
			default:
				System.out.println("Fehler.");
		}
	}
	
	/**
	 * Lässt den User über die Konsole eine Eingabe tätigen.
	 * 
	 * @return String array mit den Inhalten der Eingabe
	 */
	private static String[] userEingabe() {
		String[] rueckgabe;
		rueckgabe = new String[2];
		System.out.println("Welches Muster möchtest du machen? [a|b|c]");
		rueckgabe[0] = new SimpleReader().liesText(1);
		System.out.println("Welche Höhe soll das Muster haben? ");
		rueckgabe[1] = "" + new SimpleReader().liesZahl(0);
		if (rueckgabe[0].equals("a")) {
			rueckgabe = new String[] { rueckgabe[0], rueckgabe[1], "" };
			System.out.println("Welche Breite soll das Muster haben? ");
			rueckgabe[2] = "" + new SimpleReader().liesZahl(0);
		}
		return rueckgabe;
	}
	
	/**
	 * Zeichnet das Muster A, ein Schachbrett
	 * 
	 * @param breite Breite des Schachbretts
	 * @param hoehe  Hoehe des Schachbretts (Zeilenanzahl)
	 */
	public static void musterA(int breite, int hoehe) {
		for (int i = 0; i < hoehe; i++) {
			for (int j = 0; j < breite; j++) {
				if (i % 2 == 0 ^ j % 2 == 0)
					zeichneLeer(1);
				else
					zeichnePlus(1);
			}
			System.out.println();
		}
	}
	
	/**
	 * Zeichnet das Muster B, ein Dreick, welches auf der Grundseite steht mit der
	 * Höhe hoehe
	 * 
	 * @param hoehe Höhe des Dreiecks
	 */
	private static void musterB(int hoehe) {
		if (hoehe > 0) {
			zeichneDreieck(hoehe - 1);
		} else
			System.out.println("Höhe kleiner 0, es wird kein Dreieck ausgegeben.");
		zeichneLeer(1);
		zeichnePlus(hoehe * 2 - 1);
	}
	
	/**
	 * Zeichnet das MusterC, eine Raute, mit der Hoehe hoehe
	 * 
	 * @param hoehe Höhe der Raute.
	 */
	private static void musterC(int hoehe) {
		zeichneDreieck(hoehe / 2);
		zeichneLeer(1);
		zeichnePlus(hoehe);
		System.out.println();
		zeichneDreieck(-1 * (hoehe / 2));
	}
	
	/**
	 * Zeichnet die übegene Anzahl an Plusen in eine Zeile. Macht keinen
	 * Zeilenumbruch.
	 * 
	 * @param anzahl Anzahl der Pluszeichen
	 */
	private static void zeichnePlus(int anzahl) {
		for (int i = 0; i < anzahl; i++) System.out.print("+");
	}
	
	/**
	 * Zeichnet ein Dreick auf der konsole. Bei positiven Werten, steht das Dreieck
	 * auf der Grundseite. Negative Werte lassen das Dreieck mit der Basis oben
	 * stehen.
	 * 
	 * @param hoehe Hoehe des Dreiecks
	 */
	private static void zeichneDreieck(int hoehe) {
		boolean umgekehrt = false;
		if (hoehe < 0) {
			hoehe = -1 * hoehe;
			umgekehrt = true;
		}
		
		for (int i = 0; i < hoehe; i++) {
			if (umgekehrt) {
				zeichneLeer(i + 2);
				zeichnePlus((hoehe - i) * 2 - 1);
			} else {
				zeichneLeer(hoehe - i + 1);
				zeichnePlus(i * 2 + 1);
			}
			System.out.println();
		}
	}
	
	/**
	 * Zeichnet die übegene Anzahl an Leerzeichen in eine Zeile. Macht keinen
	 * Zeilenumbruch.
	 * 
	 * @param anzahl Anzahl der Leerzeichen
	 */
	private static void zeichneLeer(int anzahl) {
		for (int i = 0; i < anzahl; i++) System.out.print(" ");
	}
	
	/**
	 * Überprueft ein übergebenes Stringarray, ob im ersten Feld eine gültige
	 * Eingabe für ein Muster steht, im 2. Feld die Hoehe und ggf. im dritten die
	 * Breite. Gibt die ausgelesenen Informationen in einem Integerarray zurück.
	 * 
	 * @param eingaben Eingabe als Stringarray
	 * @return intarray mit dem ersten Feld = 0 für MusterA, =1 für MusterB, =2 für
	 *         MusterC; zweites Feld = Höhr; drittes Feld = Breite, wenn MusterA
	 */
	public static int[] pruefeEingabe(String eingaben[]) {
		int[] rueckgabe = new int[eingaben.length];
		if (eingaben.length < 4 && eingaben.length > 1) {
			char zeichen = eingaben[0].charAt(0);
			if (zeichen == 'a' || zeichen == 'b' || zeichen == 'c') {
				rueckgabe[0] = zeichen - 97;
				
				try {
					rueckgabe[1] = Integer.parseInt(eingaben[1]);
					if (zeichen == 'a') {
						if (eingaben.length < 3) {
							System.out.println("Breite nicht übergeben. ");
							return null;
						}
						rueckgabe[2] = Integer.parseInt(eingaben[2]);
					}
					return rueckgabe;
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
			}
		}
		return null;
	}
}
