package Aufgabe3Flaechenberechnung;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zur Berechnung von Fl�chen verschiedener geometrischer Fl�chen
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Flaechenberechnung {
	static SimpleReader reader = new SimpleReader();

	public static void main(String args[]) {
		System.out
				.println("Welche geometrische Form m�chtest du Brechenen?\n[0] - Kreis\n[1] - Dreieck\n[2] - Viereck");
		switch (reader.liesZahl()) {
		case 0:
			ausgabeFlaecheFigur(berechneKreis(eingabeZahl("den Raidus")));
			break;
		case 1:
			ausgabeFlaecheFigur(berechneDreieck(eingabeZahl("die L�nge"), eingabeZahl("die Breite")));
			break;
		case 2:
			ausgabeFlaecheFigur(berechneViereck());
			break;
		default:
			System.out.println("Fehlerhafte Eingabe. bitte versuche es erneut.\n\n");
			main(args);
		}
	}

	/**
	 * Methode zur Berechnug der Fl�che eines Kreises
	 * 
	 * @param radius: Radius des Kreises
	 * @return Fl�che als double. Bei Fehler wird -1 zur�ckgegeben.
	 */
	public static double berechneKreis(double radius) {
		if (radius >= 0) {
			return Math.pow(radius, 2) * Math.PI;
		}
		return -1;
	}

	/**
	 * Methode zur Berechnung der Fl�che eines Dreiecks
	 * 
	 * @param grundseite L�nge der Grundseite
	 * @param hoehe      H�he des Dreiecks
	 * @return Fl�che als double. Bei Fehler wird -1 zur�ckgegeben.
	 */
	public static double berechneDreieck(double grundseite, double hoehe) {
		double flaeche = berechneRechteck(grundseite, hoehe) / 2;
		return (flaeche >= 0) ? flaeche : -1;
	}

	/**
	 * Methode zur Berechnung von verschiedenen Viereckstypen. Ruft weitere Methoden
	 * zur konkreten Berechnung auf.
	 * 
	 * @return Fl�che als double. Bei Fehler wird -1 zur�ckgegeben
	 */
	private static double berechneViereck() {
		System.out.println(
				"Welche Art von Viereck m�chtest du Berechnen?\n [0] Quadrat\n [1] Rechteck\n [2] Parallelogramm\n [3] Trapez\n [4] allgemeinesViereck");
		switch (reader.liesZahl()) {
		case 0:
			return berechneQuadrat(eingabeZahl("der Breite"));
		case 1:
			return berechneRechteck(eingabeZahl("der L�nge"), eingabeZahl("der Breite"));
		case 2:
			return berechneParallelogramm(eingabeZahl("der Grundseite"), eingabeZahl("der H�he"));
		case 3:
			return berechneTrapez(eingabeZahl("der kurzen Seite"), eingabeZahl("der langen Seite"),
					eingabeZahl("der H�he"));
		case 4:
			return berechneBeliebigesViereck(eingabeZahl("der Diagonalen zwischen zwei Punkten"),
					eingabeZahl("des Abstands von der Diagonalen zu einem anderen Punkt"),
					eingabeZahl("des Abstands von der Diagonalen zu dem verbleibenden Punkt"));
		default:
			System.out.println("Falsche Eingabe, versuche es erneut.\n\n");
			return berechneViereck();
		}
	}

	/**
	 * Berechnung der Fl�che eines beliebigen Vierecks
	 * 
	 * @param diagonale Abstand zwischen zwei Punkten A und C des Vierecks
	 * @param abstand1  k�rzester Abstand von der Diagonalen "diagonale" zum Punkt B/D
	 * @param abstand2  k�rtester Abstand von der Diagonalen "diagonale" zum Punkt D/B
	 * @return Fl�che als double. Bei Fehler wird -1 zur�ckgegeben.
	 */
	public static double berechneBeliebigesViereck(double diagonale, double abstand1, double abstand2) {
		if (diagonale < 0) {
			return -1;
		}
		// Zerlegung des Vierecks in zwei Dreiecke und Berechnung deren Fl�chen
		// Hier kann nicht die Methode f�r die Dreiecksberechnung verwendet werden, dann
		// f�r die Abst�nde auch negative Werte m�glich sein sollen.
		double dreieck1 = (diagonale * abstand1) / 2;
		double dreieck2 = (diagonale * abstand2) / 2;
		return dreieck1 + dreieck2;
	}

	/**
	 * Methode zur Berechnung der Fl�che eines Trapez
	 * 
	 * @param laengeKurzeParallele L�nge der kurzen, parallelen Seite
	 * @param laengeLangeParallele L�nge der langen, parallelen Seite
	 * @param laengeHohe           Abstand zwischen den parallelen Seiten (H�he)
	 * @return Fl�che als double. Bei Fehler wird -1 zur�ckgegeben.
	 */
	public static double berechneTrapez(double laengeKurzeParallele, double laengeLangeParallele, double laengeHoehe) {
		double a = berechneParallelogramm(laengeKurzeParallele + laengeLangeParallele, laengeHoehe) / 2;
		return (a >= 0) ? a : -1; // Stellt klar, das sollte es zu einem Fehler kommen, so wird -1 zur�ckgegeben
									// und nicht -0.5
	}

	/**
	 * Methode zur Berechnung der Fl�che eines Parallelogramms
	 * 
	 * @param laengeGrundseite L�nge einer parallelen Seite (Grundseite)
	 * @param laengeHoehe      H�he des Trapez (Abstand zwischen der Grundseite und
	 *                         seiner gegen�berliegenden Seite)
	 * @return Fl�che als double. Bei Fehler wird -1 zur�ckgegeben.
	 */
	public static double berechneParallelogramm(double laengeGrundseite, double laengeHoehe) {
		return berechneAmalB(laengeGrundseite, laengeHoehe);
	}

	/**
	 * Methode zur Berechnung der Fl�che eines Rechtecks
	 * 
	 * @param laenge L�nge des Rechtecks
	 * @param breite Breite des Rechtecks
	 * @return Fl�che als double. Bei Fehler wird -1 zur�ckgegeben.
	 */
	public static double berechneRechteck(double laenge, double breite) {
		return berechneAmalB(laenge, breite);
	}

	/**
	 * Methode zur Berechnung der Fl�che eines Quadrats
	 * 
	 * @param laenge L�nge einer beliebigen Seite
	 * @return Flaeche als double. Bei Fehler wird -1 zur�ckgegeben.
	 */
	public static double berechneQuadrat(double laenge) {
		return berechneAmalB(laenge, laenge);
	}

	/**
	 * Hilfmethode, um die Eingabe der L�nge abzuk�rzen
	 * 
	 * @param baustein Dativform der einzugebenen L�nge mit Pronomen
	 * @return Flaeche als double. Bei Fehler wird -1 zur�ckgegeben.
	 */
	public static double eingabeZahl(String baustein) {
		SimpleReader reader = new SimpleReader();
		System.out.println("Bitte gibt die L�nge " + baustein + " ein:");
		return reader.liesDezimalzahl(Double.MIN_VALUE, Double.MAX_VALUE);
	}

	/**
	 * Gibt die in der Variablen flaeche �bergebene Fl�che einer geometrischen Figur
	 * aus.
	 * 
	 * @param flaecheFigur Fl�che einer geometrischen Figur Figur.
	 */
	public static void ausgabeFlaecheFigur(double flaecheFigur) {
		if (flaecheFigur == -1) {
			System.out.println("Fehler bei der Berechnung. Das Programm wird beendet.");
		} else if (flaecheFigur >= 0)
			System.out.println("Die Fl�che der geometrischen Figur ist: " + flaecheFigur);
		else
			System.out.println("Fehler in der �bergebenen Fl�che, da die Fl�che '" + flaecheFigur + "' negativ ist.");
	}

	/**
	 * Hilfsmethode, die die Paramter a und b mulitpliziert. Sollter oder beide
	 * Parameter negativ sein, so wird -1 ausgebgen (Fehler)
	 * 
	 * @param a
	 * @param b
	 * @return -1 || Fl�che
	 */
	public static double berechneAmalB(double a, double b) {
		if (a > 0 && b > 0)
			return a * b;
		return -1;
	}
}
