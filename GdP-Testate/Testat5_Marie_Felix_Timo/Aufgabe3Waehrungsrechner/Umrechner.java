package Aufgabe3Waehrungsrechner;

import de.hsw.gdp.helper.SimpleReader;

/**
 * 
 * @author Marie Salomon, Timo Reitmann, Felix Franz
 *
 */
public class Umrechner {

	public static SimpleReader r = new SimpleReader();
	static boolean run = true;

	static double[][] currencyRate = new double[4][4];

	/**
	 * In der Main-Methode werden die beiden Währungen inkl. ungültige Eingaben
	 * abgefragt
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		fillArray();
		do {
			System.out.println("Von 1 = Euro | 2 = US-Dollar | 3 = Pfund Sterling | 4 = Yen || 0 = Beenden");
			int first = r.liesZahl();
			if (first > 4) {
				System.err.println("!!Ungültige Eingabe, versuchs nochmal!!");
				System.out.println("");
				continue;
			} else if (first == 0) {
				run = false;
				System.out.println("Das Programm wurde beendet!");
				break;
			}
			System.out.println("nach 1 = Euro | 2 = US-Dollar | 3 = Pfund Sterling | 4 = Yen");
			int second = r.liesZahl();
			if (first == second)
				System.out.println("Gleiche Währungen, Umrechnung nicht erforderlich!");
			else
				calculate(first, second);
		} while (run);
	}

	/**
	 * 
	 * 
	 * In der calculate-Methode wird die WÃ¤hrung umgerechnet und auf 2 Stellen nach
	 * dem Komma gerundet
	 * 
	 * @param currency1 ist der Index der Augangswährung
	 * @param currency2 ist der Index der Währung, in die umgerechnet werden soll
	 */
	private static void calculate(int currency1, int currency2) {
		System.out.println("Geben sie einen gewünschten Betrag in " + giveCurrencySymbol(currency1) + " ein:");
		double number1 = r.liesDezimalzahl(Double.MIN_VALUE, Double.MAX_VALUE);
		double number2 = number1 * currencyRate[currency1 - 1][currency2 - 1];
		String number2AsString = String.format("%.2f", number2);

		System.out.println(number1 + giveCurrencySymbol(currency1) + " entsprechen " + number2AsString
				+ giveCurrencySymbol(currency2));
		System.out.println("");
	}

	/**
	 * Die giveCurrencySymbol gibt das WÃ¤hrungssymbol abhäning von dem
	 * eingebebenen Index aus
	 * 
	 * @param currency ist der Index der Währung, dessen Symbol ausgegeben werden
	 *                 soll
	 * @return Das entsprechende Währungsszeichen,
	 */
	private static String giveCurrencySymbol(int currency) {
		switch (currency) {
		case 1:
			return "€";
		case 2:
			return "$";
		case 3:
			return "£";
		case 4:
			return "¥";
		}
		return "";
	}

	/**
	 * In der Methode fillArray() wird das Array currencyRate mit den Wechselkursen
	 * belegt
	 */
	private static void fillArray() {

		// 1 Euro = ...

		currencyRate[0][1] = 1.13294; // USD
		currencyRate[0][2] = 0.87292; // GBP
		currencyRate[0][3] = 128.93; // JPY

		// 1 US-Dollar = ...

		currencyRate[1][0] = 0.88194; // EUR
		currencyRate[1][2] = 0.77052; // GBP
		currencyRate[1][3] = 113.77; // JPY

		// 1 Pfund Sterling = ...

		currencyRate[2][0] = 1.14314; // EUR
		currencyRate[2][1] = 1.29642; // USD
		currencyRate[2][3] = 147.49; // JPY

		// 1 Yen = ...

		currencyRate[3][0] = 0.00775; // USD
		currencyRate[3][1] = 0.00878; // GBP
		currencyRate[3][2] = 0.00677; // JPY

	}

}
