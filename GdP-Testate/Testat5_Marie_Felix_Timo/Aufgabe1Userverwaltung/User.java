package Aufgabe1Userverwaltung;

public class User {
	/**
	 * private man kann nur in der Klasse zugreifen nicht von außen, deswegen getter
	 * und setter benutzen
	 */
	private String username;
	private String passwort;
	private String mail;

	/**
	 * hier wird ein neuer User angelegt, mit username, Passwort und Mail-Adresse
	 * 
	 */
	public User(String username2, String passwort2, String mail2) {
		username = username2;
		passwort = passwort2;
		mail = mail2;
	}

	/**
	 * Hiermit kann man den Usernamen ändern
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/**
	 * hiermit kann man die Mail-adresse ändern
	 */
	public void setMail(String mail) { // set für mail
		this.mail = mail;
	}

	public String getPasswort() {
		return passwort;
	}

	public String getMail() {
		return mail;
	}

	public String getUsername() {
		return username;
	}
/**
 * Zeigt Passwort, Mail und Username an
 * Passwort wird durch Sternchen ersetzt und 
 */
	public void print() {
		String sternchenpw = "";
		/**
		 * for - Schleife die solange läuft wie das Passwort lang ist und dann einfach
		 * einen string mit sovielen sternchen erstellt
		 */
		for (int i = 0; i < passwort.length(); i++) {
			sternchenpw += "*";
		}

		System.out.println("Usernmame: " + this.getUsername() + " , Passwort: " + sternchenpw + " , E-mail Adresse: "
				+ this.getMail());
	}
}
