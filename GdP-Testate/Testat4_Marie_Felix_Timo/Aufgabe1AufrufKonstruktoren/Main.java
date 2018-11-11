package Aufgabe1AufrufKonstruktoren;

/**
 * Hauptmethode zur Demonstration der Reihnfolge von Konstruktoraufrufen bei
 * Vererbung.
 * 
 * @author Marie Salomon, Felix Franz, Timo Reitmann
 *
 */
public class Main {
	/**
	 * Hier wird ein Fahrzeug, Fahrrad und Auto erstellt und Methoden aufgerufen und
	 * ausgegeben.
	 * 
	 * @param args hier nicht verwendet.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Fahrzeug f1 = new Fahrzeug();
		System.out.println();

		Fahrrad f2 = new Fahrrad();
		System.out.println();

		Auto f3 = new Auto();
		System.out.println();

		Fahrzeug f4 = new Auto();
		System.out.println();

	}

}
