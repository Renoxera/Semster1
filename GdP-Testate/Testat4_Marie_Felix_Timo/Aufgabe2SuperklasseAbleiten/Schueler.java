package Aufgabe2SuperklasseAbleiten;

import java.util.ArrayList;

/**
 * 
 * @author Timo Reitmann, Felix Franz, Marie Salomon
 *
 */

public class Schueler extends lernendePerson {
	
	static Student sch1 = new Student();
	static ArrayList<String> faecher = new ArrayList<String>();

	/**
	 * In der Main-Methode werden die Parameter der Superklasse gefüllt
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		sch1.setAlter(7);
		sch1.setFaecher(faecher);
		sch1.setName("Hans-Martin Müller");
		sch1.setNotendurchschnitt(2.2);
	}
	/**
	 * In dieser Methode wird eine Hilfs-ArrayList befüllt, mit der dann die ArrayList der
	 * Superklasse gefüllt wird.
	 */
	
	public static  void befuelleFächer() {
		faecher.add("Mathe");
		faecher.add("Deutsch");
		faecher.add("Naturkunde");
		faecher.add("Englisch");
	}

}
