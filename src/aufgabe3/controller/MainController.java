package aufgabe3.controller;

import static aufgabe3.helper.Tools.getHeader;
import static aufgabe3.helper.Tools.getRandomNumber;
import static aufgabe3.helper.Tools.showMsg;

import java.text.*;
import java.util.*;

import aufgabe3.algorithmen.RadixSort;
import aufgabe3.helper.Log;
import aufgabe3.model.DoublyLinkedList;

public class MainController {
	

	private static final String TAG = MainController.class.getSimpleName();
	
	private DoublyLinkedList<Integer> integerList;
	private Scanner scanner;

	public MainController() {

		scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		this.integerList = new DoublyLinkedList<>();	
	}

	
	/**
	 * Methode zum Erstelen von zufaelligen Zahlen 
	 * 
	 * @param n
	 *            Anzahl der Zahlen die generiert werden sollen
	 */

	private void generateSampleNumbers(int n) {

		integerList.clear();

		for (int i = 0; i < n; i++) {
			integerList.add(getRandomNumber(-9999, 9999));
		}
		
		
		Log.d(TAG, NumberFormat.getNumberInstance(Locale.GERMAN).format(n) + " Zufallszahlen erstellt erstellt!\n");
		
	}

	
	/**
	 * Zeigt das Hauptmenue an
	 */

	public void show_main_menu() {

		String eingabe = "";

		while (true) {

			getHeader("Hauptmenue");

			System.out.println("(1) Zufallszahlen generieren");
			System.out.println("(2) Zufallszahlen anzeigen");
			System.out.println("(3) mit RadixSort sortieren");

			System.out.println();
			System.out.println("(b) Programm beenden");
			System.out.println();
			System.out.print("Ihre Auswahl: ");

			try {
				eingabe = scanner.next();
			} catch (Exception e) {
				System.out.println("Ungültige Auswahl!");
			}

			System.out.println();

			switch (eingabe) {
			case "1":
				generateSampleNumbers(30);
				break;
			case "2":
				show_sub_menu_show_random_number_list();
				break;
			case "3":
				RadixSort.sort(getIntegerList()); 
				System.out.println();
				break;
			case "b":
				System.out.println("Programm beendet");
				return;
			default:
				showMsg("Ungültige Auswahl!");
			}

		}

	}

	/**
	 * Ausgabe des Untermenues um die zufaellig generierten Zahlen anzuzeigen
	 */

	private void show_sub_menu_show_random_number_list() {

		getHeader("Hauptmenue -> Zufallszahlen anzeigen");

		if (integerList.isEmpty()) {

			System.out.println("Bisher keine Zufallszahlen generiert!");
			System.out.println();

			return;
		}

		System.out.println("Anzahl Zufallszahlen: " + integerList.getSize());

		System.out.println("Elemente:");
		System.out.println(integerList.toString());

		System.out.println();
	}
	
	
	
	
	public DoublyLinkedList<Integer> getIntegerList() {
		return integerList;
	}



	
}
