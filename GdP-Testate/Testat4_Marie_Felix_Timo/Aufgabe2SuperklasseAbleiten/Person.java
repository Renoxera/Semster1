package Aufgabe2SuperklasseAbleiten;

import java.util.ArrayList;

/**
 * 
 * @author Timo Reitmann, Marie Salomon, Felix Franz
 *
 */

public class Person {
	
	private String name;
	private ArrayList<String> Faecher;
	private int alter;
	
	/**
	 * Getter und Setter
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getFaecher() {
		return Faecher;
	}
	public void setFaecher(ArrayList<String> faecher) {
		Faecher = faecher;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	
}

