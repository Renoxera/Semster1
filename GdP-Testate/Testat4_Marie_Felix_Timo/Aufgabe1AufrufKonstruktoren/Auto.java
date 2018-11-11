package Aufgabe1AufrufKonstruktoren;

/**
 * Die Klasse Auto erbt alle Eigenschaften und Attribute von der Klasse
 * Fahrzeug.
 * 
 * @author Felix Franz, Timo Reitmann, Marie Salomon
 */
public class Auto extends Fahrzeug {

	/**
	 * Parameterlose Konstruktor der Klasse Auto.
	 */
	public Auto() {
		anzahlReifen = 4;
		name = "Auto";
		System.out.println("Aufruf des Konstruktors der Klasse Auto");
	}

}
