package Aufgabe1AufrufKonstruktoren;

/**
 * Diese Klasse vererbt alle Eigenschaften und Attribute an ihre Unterklassen.
 * 
 * @author Felix Franz, Timo Reitmann, Marie Salomon
 * 
 */
public class Fahrzeug {

	int anzahlReifen;
	String name;
	int aktuellerGang;
	int geschwindigkeit;
	int anzahlGaenge;

	/**
	 * Parameterloser Konstruktor der Klasse Fahrzeug. Belegt den Namen des
	 * Fahrzeugs mit "Fahrzeug".
	 */
	public Fahrzeug() {
		name = "Fahrzeug";
		System.out.println("Aufruf des Konstruktors der Klasse Fahrzeug");
	}

	/**
	 * 
	 * @return Anzahl der Gänge des Fahrzeugs
	 */
	public int getanzahlGaenge() {
		return anzahlGaenge;
	}

	/**
	 * 
	 * @return Name des Fahrzeugs
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return Anzahl der Reifen
	 */
	public int getAnzahlReifen() {
		return anzahlReifen;
	}
}
