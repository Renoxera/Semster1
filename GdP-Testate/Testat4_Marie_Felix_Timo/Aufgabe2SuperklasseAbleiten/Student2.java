package Aufgabe2SuperklasseAbleiten;

import java.util.ArrayList;

/**
 * 
 * @author Timo Reitmann, Felix Franz, Marie Salomon
 *
 */

public class Student2 extends lernendePerson {
	
	static Student2 st1 = new Student2();
	static ArrayList<String> faecher = new ArrayList<String>();

	/**
	 * In der Main-Methode werden die Parameter der Superklasse gefüllt
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		st1.setAlter(20);
		st1.setFaecher(faecher);
		st1.setName("Max Mustermann");
		st1.setNotendurchschnitt(2.2);
	}
	
	/**
	 * In dieser Methode wird eine Hilfs-ArrayList befüllt, mit der dann die ArrayList der
	 * Superklasse gefüllt wird.
	 */
	
	public static  void befuelleFächer() {
		faecher.add("Mathe");
		faecher.add("Deutsch");
		faecher.add("Informatik");
		faecher.add("Englisch");
	}

}
