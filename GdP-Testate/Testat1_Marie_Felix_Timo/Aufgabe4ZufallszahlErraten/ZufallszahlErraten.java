package Aufgabe4ZufallszahlErraten;

import de.hsw.gdp.helper.SimpleReader;

/**
 * Programm zum Erraten von durch den Computer erzeugten Ganzzahlen
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann / WI5618
 * 
 */
public class ZufallszahlErraten {
	public static void main(String[] args) {
		// Eingabe der Grenze für die Zufallszahl
		 SimpleReader reader = new SimpleReader();
		 System.out.println(
				"Bitte geben Sie eine ganzzahlige Grenze ein.\n Die Zufallszahl wird zwischen 0 und der Grenze bestimmt. (Auch negetive Eingabe sind valide)");
		int eingabe = reader.liesZahl();
		int zufallszahl = erzeugeZufallszahlGrenze(eingabe);

		// Abfrage der Eingabe und Vergleich mit der Zufallszahl
		System.out.print("Erster Versuch: ");
		eingabe = reader.liesZahl();
		int zaehler = 1;
		while (eingabe != zufallszahl) {
			zaehler++;
			if (eingabe < zufallszahl) {
				System.out.println("Die Zufallszahl ist größer als " + eingabe + ".");
			} else {
				System.out.println("Die Zufallszahl ist kleiner als " + eingabe + ".");
			}
			System.out.print("Versuche es erneut: ");
			eingabe = reader.liesZahl();
		}
		System.out.println("Glückwunsch, du hast die Zufallszahl erraten.\n Du hast "+ zaehler + " Versuche gebraucht.");
	}

	/**
	 * Berechnung einer Zufallszahl zwischen 0 und einer angegebenen Grenze
	 * 
	 * @param grenze: ganzzahlige Grenze, auch negative Zahlen sind möglich.
	 * @return Eine Zufallszahl zwischen 0 und der gegebenen Grenze
	 */
	public static int erzeugeZufallszahlGrenze(int grenze) {
		// Damit beim Runterbrechen der Double-Zufallszahl richtig gerundent wird.
		double rundungsvariable = 0.5;

		// Für die spätere Ausgabe
		int untereGrenze = 0;
		int obereGrenze = 0;

		if (grenze < 0) {
			rundungsvariable -= 1; // Für den Fall, dass die Zufallszahl im negativen Bereich gesucht wird, muss
									// die Rundungsvariable angepasst werden.
			untereGrenze = grenze;
		} else
			obereGrenze = grenze;

		// Errechnung der Zufallszahl und addieren der Rundungsvariable
		Double zahl = Math.random() * grenze + rundungsvariable;

		// Runterbrechen der Dezimalzufallszahl auf eine Ganzzahl
		int intZahl = zahl.intValue();

		System.out.println("Zufällige Ganzzahl zwischen " + untereGrenze + " und " + obereGrenze + " generiert.\n");

		return intZahl;
	}
}
