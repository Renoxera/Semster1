package Aufgabe2AsciiSumme;

public class AsciiTimo {
	public static void main(String args[]) {
		String name = "Timo Reitmann, Marie Salomon, Felix Franz";

		if (args.length == 1) {
			name = args[0];
		}

		for (int i = 0; i < name.length(); i++)
			System.out.printf("%-4s", name.charAt(i));
		System.out.println();

		int summe = 0;

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);

			System.out.printf("%-4s", (int) name.charAt(i));
			if ((c >= 56 && c <= 90) || c >= 97 && c <= 122)
				summe += c;
		}

		System.out.println("\n\nSumme der Ascii Buchstaben: " + summe);
	}
}
