package aufgabe4.controller;

import static aufgabe4.helper.Tools.*;

import java.text.*;
import java.util.*;

import aufgabe4.hashing.*;
import aufgabe4.helper.*;

public class MainController {

	private static final String TAG = MainController.class.getSimpleName();


	// Array fuer zufaellige Datensaetze
	private int s[];

	private ChainedHashtable chainedHashtable;
	private DoubledHashtable doubledHashtable;

	private static int m = 7;
	private static int n = 5;

	private Scanner scanner;

	public MainController() {

		scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);


		chainedHashtable = new ChainedHashtable(m);
		doubledHashtable = new DoubledHashtable(m);
		
		//generateSampleNumbers(n);

	}

	/**
	 * Methode zum Erstelen von zufaelligen Zahlen
	 * 
	 * @param n
	 *            Anzahl der Zahlen die generiert werden sollen
	 */

	private void generateSampleNumbers(int n) {

		s = Tools.getRandomNumberArray(-99, 99, n);

		Log.d(TAG, NumberFormat.getNumberInstance(Locale.GERMAN).format(n) + " Zufallszahlen erstellt!\n");

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
			System.out.println("(3) Zufallszahlen in chained hashtable");
			System.out.println("(4) Zufallszahlen in doubled hashtable");

			System.out.println();

			getHeader("Chained hashtable");
			System.out.println("(5) insert");
			System.out.println("(6) delete");
			System.out.println("(7) find");
			System.out.println("(8) show all elements");

			System.out.println();

			getHeader("Doubled hashtable");
			System.out.println("(9) insert");
			System.out.println("(10) delete");
			System.out.println("(11) find");
			System.out.println("(12) show all elements");

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
				generateSampleNumbers(n);
				
				break;
			case "2":
				show_sub_menu_show_random_numbers();
				break;

			// chainning hashtable insert
			case "3":
				for (int i : s) {
					chainedHashtable.insert(i);
				}
				System.out.println();
				break;

			case "4":
				for (int i : s) {
					doubledHashtable.insert(i);
				}	
				System.out.println();
				break;
				
			case "5":
				show_sub_menu_insert_chained_hashtable();
				break;
			// chainning hashtable delete
			case "6":
				show_sub_menu_delete_chained_hashtable();
				break;

			// chainning hashtable find
			case "7":
				show_sub_menu_find_chained_hashtable();
				break;

			// chainning hashtable showAllElements
			case "8":
				chainedHashtable.showAllElements();
				System.out.println();
				break;

			// doubled hashtable
			case "9":
				show_sub_menu_insert_doubled_hashtable();
				break;

			case "10":
				show_sub_menu_delete_doubled_hashtable();
				break;

			case "11":
				show_sub_menu_find_doubled_hashtable();
				break;

			case "12":
				doubledHashtable.showAllElements();
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

	private void show_sub_menu_show_random_numbers() {

		getHeader("Hauptmenue -> Zufallszahlen anzeigen");

		System.out.println("Anzahl Zufallszahlen: " + s.length);

		System.out.println("Datensätze s: " + Arrays.toString(s));

		System.out.println();
	}
	
	/**
	 * Ausgabe des Untermenues zum Einfuegen eines Wertes in die chained hashtable
	 */
	
	private void show_sub_menu_insert_chained_hashtable() {
		getHeader("Hauptmenue -> Chained Hashtable -> Insert");

		System.out.print("Integer: ");
		
		int a;
		
		try {
			a = scanner.nextInt();
		} catch (Exception e) {
			Tools.showMsg("Ungültige Eingabe! ");
			return;
		}

		System.out.println();
		
		chainedHashtable.insert(a);

		System.out.println();
		
		
	}
	/**
	 * Ausgabe des Untermenues zum Einfuegen eines Wertes in die doubled hashtable
	 */
	
	private void show_sub_menu_insert_doubled_hashtable() {
		getHeader("Hauptmenue -> Doubled Hashtable -> Insert");

		System.out.print("Integer: ");
		
		int a;
		
		try {
			a = scanner.nextInt();
		} catch (Exception e) {
			Tools.showMsg("Ungültige Eingabe! ");
			return;
		}

		System.out.println();
		
		doubledHashtable.insert(a);

		System.out.println();
		
		
	}
	
	
	/**
	 * Ausgabe des Untermenues zum Suchen eines Wertes in der chained hashtable
	 */
	
	private void show_sub_menu_find_chained_hashtable() {
		getHeader("Hauptmenue -> Chained Hashtable -> Find");

		System.out.print("Integer: ");
		
		int a;
		
		try {
			a = scanner.nextInt();
		} catch (Exception e) {
			Tools.showMsg("Ungültige Eingabe! ");
			return;
		}

		System.out.println();
		
		int i = chainedHashtable.find(a);

		System.out.println();
		
		if(i>= 0)
			System.out.println("Die Zahl " + a + " ist in der hashtable am Index " + i);
		else
			System.out.println("Die Zahl " + a + " konnte nicht gefunden werden");

		System.out.println();
		
	}

	/**
	 * Ausgabe des Untermenues zum Suchen eines Wertes in der doubled hashtable
	 */
	
	private void show_sub_menu_find_doubled_hashtable() {
		
		getHeader("Hauptmenue -> Doubled Hashtable -> Find");

		System.out.print("Integer: ");
		
		int a;
		
		try {
			a = scanner.nextInt();
		} catch (Exception e) {
			Tools.showMsg("Ungültige Eingabe! ");
			return;
		}

		System.out.println();
		
		int i = doubledHashtable.find(a);

		System.out.println();
		
		if(i>= 0)
			System.out.println("Die Zahl " + a + " ist in der hashtable am Index " + i);
		else
			System.out.println("Die Zahl " + a + " konnte nicht gefunden werden");

		System.out.println();
	}

	/**
	 * Ausgabe des Untermenues zum Loeschen eines Wertes in der chained hashtable
	 */
	
	private void show_sub_menu_delete_chained_hashtable() {
		
		getHeader("Hauptmenue -> Chained Hashtable -> Delete");

		System.out.print("Integer: ");
		
		int a;
		
		try {
			a = scanner.nextInt();
		} catch (Exception e) {
			Tools.showMsg("Ungültige Eingabe! ");
			return;
		}

		System.out.println();
		
		boolean wasDeleted = chainedHashtable.delete(a);

		System.out.println();
		
		if(wasDeleted) {
			System.out.println("Die Zahl " + a + " wurde geloescht");
		} else {
			System.out.println("Die Zahl " + a + " konnte nicht geloescht werden");
		}

		System.out.println();
		
	}

	/**
	 * Ausgabe des Untermenues zum Loeschen eines Wertes in der doubled hashtable
	 */
	
	private void show_sub_menu_delete_doubled_hashtable() {

		getHeader("Hauptmenue -> Doubled Hashtable -> Delete");
		
		System.out.print("Integer: ");
		
		int a;
		
		try {
			a = scanner.nextInt();
		} catch (Exception e) {
			Tools.showMsg("Ungültige Eingabe! ");
			return;
		}

		System.out.println();
		
		boolean wasDeleted = doubledHashtable.delete(a);

		System.out.println();
		
		if(wasDeleted) {
			System.out.println("Die Zahl " + a + " wurde geloescht");
		} else {
			System.out.println("Die Zahl " + a + " konnte nicht geloescht werden");
		}

		System.out.println();
	}
	
}
