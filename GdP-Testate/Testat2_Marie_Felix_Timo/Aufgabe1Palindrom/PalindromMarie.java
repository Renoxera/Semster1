package Aufgabe1Palindrom;

import de.hsw.gdp.helper.SimpleReader;
/**
 *  Diese Methode untersucht ob die eingegeben Buchstaben zusammen ein Palindrom ergeben. 
 *  Sonderzeichen werden rausgenommen und nicht mit untersucht.
 * @author Felix Franz, Timo Reitmann, Marie Salomon
 *
 */

public class PalindromMarie {

	public static void main(String[] args) {
		SimpleReader reader = new SimpleReader(); 
		System.out.println("Bitte geben Sie ein, was auf Palindrom geprüft werden soll: ");
		String  input = reader.liesText();			// String mit dem eingegebenen Text wird erstellt
		String text1  = input.replaceAll("\\s+",""); // Entfernt alle Leerzeichen
		text1 = text1.toLowerCase();  	// Entfernt alle Großbuchstaben
		text1 = text1.replace(".", "");	// Entfernt Punkte
		text1 = text1.replace("?", ""); // Entfernt alle ?
		text1 = text1.replace("!", ""); // Entfernt alle !
		text1 = text1.replace(",", ""); // Entfernt alle ,
		String ruckwarts = "rückwärts";	// Ein neuer String wird erstellt
		ruckwarts = new StringBuffer(text1).reverse().toString(); // Neu erstellter String bekommt den input zugewiesen und dieser wird umgekehrt
		
		// es wird verglichen ob die beiden Strings identisch sind 
		if (text1.equals(ruckwarts)) {
		System.out.println("\""+input + "\" ist ein Palindrom."); 
		}
		else 
		System.out.println("\""+input + "\" ist kein Palindrom.");
		
	}

}
