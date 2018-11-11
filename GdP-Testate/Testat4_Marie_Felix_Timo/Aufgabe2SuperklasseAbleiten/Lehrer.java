package Aufgabe2SuperklasseAbleiten;

import java.util.ArrayList;

/**
 * 
 * @author Timo Reitmann, Felix Franz, Marie Salomon
 *
 */

public class Lehrer extends LehrendePerson {

	static Lehrer l1 = new Lehrer();
	static ArrayList<String> Faecher = new ArrayList<String>();
	
	/**
	 * In der Main-Methode werden die Parameter der Superklasse gefüllt
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		l1.setDr(false);
		l1.setProf(false);
		l1.setName("Sabine Hermann");
		l1.setFaecher(Faecher);
	}
	
	/**
	 * In dieser Methode wird eine Hilfs-ArrayList befüllt, mit der dann die
	 * ArrayList der Superklasse gefüllt wird.
	 */
	
	public static void befuelleFächer() {
		Faecher.add("Mathe");
		Faecher.add("Musik");
	}

}
