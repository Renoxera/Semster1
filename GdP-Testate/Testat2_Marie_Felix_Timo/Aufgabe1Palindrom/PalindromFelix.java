package Aufgabe1Palindrom;
import java.util.Scanner;

public class PalindromFelix {
	private static Scanner reader;

	public static void main(String[] args) {
		System.out.println("Wort oder Satz eingeben:");
		reader = new Scanner(System.in);
		String word = reader.nextLine();
		word = word.replace("\\s+","");
		word = word.toLowerCase();
		String reverseWord = new StringBuilder(word).reverse().toString();
	if (reverseWord.equals(word)) System.out.println("Das eingegebene Wort/Satz ist ein Palindrom.");
	else System.out.println("Das eingegebene Wort/Satz ist kein Palindrom.");
	}
}
