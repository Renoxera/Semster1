package Aufgabe2SuperklasseAbleiten;

/**
 * @author Timo Reitmann, Marie Salomon, Felix Franz
 */

public class LehrendePerson extends Person {
	
	private boolean	prof;
	private boolean	dr;
	private double	notendurchschnitt;
	
	Person			p1	= new Person();
	
	/**
	 * Getter und Setter
	 */
	
	public boolean isProf() {
		return prof;
	}
	
	public void setProf(boolean prof) {
		this.prof = prof;
	}
	
	public boolean isDr() {
		return dr;
	}
	
	public void setDr(boolean dr) {
		this.dr = dr;
	}
	
	public double getNotendurchschnitt() {
		return notendurchschnitt;
	}
	
	public void setNotendurchschnitt(double notendurchschnitt) {
		this.notendurchschnitt = notendurchschnitt;
	}
	
	public Person getP1() {
		return p1;
	}
	
	public void setP1(Person p1) {
		this.p1 = p1;
	}
	
}
