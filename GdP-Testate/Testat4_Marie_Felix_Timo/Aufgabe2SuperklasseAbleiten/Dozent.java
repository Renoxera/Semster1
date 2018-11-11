package Aufgabe2SuperklasseAbleiten;

import java.util.ArrayList;

/**
 * 
 * @author Timo Reitmann, Felix Franz, Marie Salomon
 *
 */

public class Dozent extends LehrendePerson {
	
	static Dozent d1 = new Dozent();
	static ArrayList<String> Faecher = new ArrayList<String>();
	
	/**
	 * In der Main-Methode werden die Parameter der Superklasse gefüllt
	 * 
	 * @param args
	 */ 
	
	public static void main(String[] args) {
		d1.setDr(true);
		d1.setProf(true);
		d1.setName("Theodor Meier");
		d1.setFaecher(Faecher);
	}
	
	/**
	 * In dieser Methode wird eine Hilfs-ArrayList befüllt, mit der dann die ArrayList der
	 * Superklasse gefüllt wird.
	 */
	
	public static void befuelleFächer() {
		Faecher.add("Mathe");
		Faecher.add("BWL");
	}
}
