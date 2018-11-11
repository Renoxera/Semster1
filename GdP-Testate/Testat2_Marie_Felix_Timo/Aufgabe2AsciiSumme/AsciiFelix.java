package Aufgabe2AsciiSumme;
import java.util.Scanner;

public class AsciiFelix {
	
	private static Scanner reader;
	
	public static void main(String[] args) {
		reader = new Scanner(System.in);
		int a = 0;
		System.out.println("Gib ein Wort ein:");
		String word = reader.nextLine();
		for (int i = 0; i < word.length(); i++) {
			int tmp = (int) word.charAt(i);
			a = a + tmp;
			System.out.print(word.charAt(i));
			System.out.println(" | " + (int) word.charAt(i));
			System.out.println("---------");
		}
		System.out.println("Die Summe der ASCII-Codes beträgt " + a);
	}

}
