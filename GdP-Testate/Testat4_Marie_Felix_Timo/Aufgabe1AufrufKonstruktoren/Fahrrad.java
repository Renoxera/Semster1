package Aufgabe1AufrufKonstruktoren;

/**
 * Die Klasse Fahrrad erbt alle Eigenschaften und Attribute von der Klasse
 * Fahrzeug.
 *
 * @author Felix Franz, Timo Reitmann, Marie Salomon
 */
public class Fahrrad extends Fahrzeug {

	/**
	 * Parameterloser Konstruktor der Klasse Fahrrad.
	 */
	public Fahrrad() {
		anzahlReifen = 2;
		name = "Fahrrad";
		System.out.println("Aufruf des Konstruktors der Klasse Fahrrad");
	}

}
