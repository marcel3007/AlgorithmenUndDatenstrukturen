package aufgabe1.controller;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import aufgabe1.algorithmen.BubbleSort;
import aufgabe1.algorithmen.MergeSort;
import aufgabe1.algorithmen.Search;
import aufgabe1.enums.RandomOption;
import aufgabe1.enums.SearchOptions;
import aufgabe1.enums.SortOptions;
import aufgabe1.model.RandomNames;
import aufgabe1.model.SingleLinkedList;
import aufgabe1.model.Student;

/**
 * Controller fuer das Konsolenmenue
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 */
public class MainController {

	private SingleLinkedList<Student> singleList;
	private Scanner scanner;

	public MainController() {

		scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		singleList = new SingleLinkedList<Student>();

		generate_sample_students(1000);

	}

	/**
	 * Methode zum Erstelen einiger Beispielstudenten
	 * 
	 * @param n
	 *            Anzahl der Studenten die generiert werden sollen
	 */

	private void generate_sample_students(int n) {

		singleList.removeAll();

		for (int i = 0; i < n; i++) {
			singleList.add(new Student(getRandomNumber(1000000, 9999999), RandomNames.getRandom(RandomOption.PRENAME),
					RandomNames.getRandom(RandomOption.LASTNAME), RandomNames.getRandom(RandomOption.COURSE)));
		}

		System.out.println(NumberFormat.getNumberInstance(Locale.GERMAN).format(n) + " Studenten erstellt!\n");
	}

	/**
	 * Zeigt das Hauptmenue an
	 */

	public void show_main_menu() {

		String eingabe = "";

		while (true) {

			getHeader("Hauptmenue");

			System.out.println("(1) Studenten anlegen");
			System.out.println("(2) Student löschen");
			System.out.println("(3) Studenten suchen");
			System.out.println();
			System.out.println("(4) Liste ausgeben");
			System.out.println("(5) Liste Element ausgeben");
			System.out.println("(6) Liste löschen");
			System.out.println("(7) Liste sortieren");
			// System.out.println("(0) Test BubbleSort3");

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
			case "0":

				break;

			case "1":
				show_sub_menu_add_student();
				break;
			case "2":
				show_sub_menu_delete();
				break;
			case "3":
				show_sub_menu_search();
				break;
			case "4":
				System.out.println(singleList.getAll());
				System.out.println();
				break;
			case "6":
				singleList.removeAll();
				System.out.println("Erledigt!\n");
				break;
			case "7":
				show_sub_menu_list_sort();
				break;
			case "b":
				System.out.println("Programm beendet");
				return;
			default:
				show_error_msg("Ungültige Auswahl!");
			}

		}

	}

	/**
	 * Ausgabe des Untermenues "Studenten anlegen"
	 */

	private void show_sub_menu_add_student() {
		String eingabe = "";

		while (true) {

			getHeader("Hauptmenue -> Student anlegen");

			System.out.println("(1) zufaellig 10");
			System.out.println("(2) zufaellig 100");
			System.out.println("(3) zufaellig 1.000");
			System.out.println("(4) zufaellig 10.000");

			show_error_msg(
					"Achtung: Das Anlegen groesserer Menngen an Objekten kann je nach System einige Zeit in Anspruch nehmen!");

			System.out.println("(5)  zufaellig 100.000");
			System.out.println("(6)  zufaellig 200.000");
			System.out.println();
			System.out.println("(7) zufaellig n");
			System.out.println();
			System.out.println("(8) manuell");
			System.out.println();
			System.out.println("(z) Zurück");
			System.out.println();
			System.out.print("Ihre Auswahl: ");

			try {
				eingabe = scanner.next();
			} catch (Exception e) {
				show_error_msg("Ungültige Eingabe! ");
			}

			System.out.println();

			switch (eingabe) {
			case "1":
				generate_sample_students(10);
				System.out.println();
				return;
			case "2":
				generate_sample_students(100);
				System.out.println();
				return;
			case "3":
				generate_sample_students(1000);
				System.out.println();
				return;
			case "4":
				generate_sample_students(10000);
				System.out.println();
				return;
			case "5":
				generate_sample_students(100000);
				System.out.println();
				return;
			case "6":
				generate_sample_students(200000);
				System.out.println();
				return;

			case "7":

				System.out.print("Anzahl n: ");

				try {
					eingabe = scanner.next();
				} catch (Exception e) {
					show_error_msg("Ungültige Eingabe!");
				}

				if (eingabe.equals("z")) {
					show_main_menu();
				} else {
					int n = -1;

					try {
						n = Integer.valueOf(eingabe);
					} catch (Exception e) {

					}

					if (n <= 0)
						return;

					generate_sample_students(n);

				}

				System.out.println();
				return;
			case "8":
				System.out.print("Matrikelnr: ");
				String preName, lastName, course;
				int matrikelnr = -1;
				try {
					eingabe = scanner.next();
				} catch (Exception e) {
					show_error_msg("Ungültige Eingabe!");
				}

				if (eingabe.equals("z")) {
					show_main_menu();
				} else {
					try {
						matrikelnr = Integer.valueOf(eingabe);
					} catch (Exception e) {

					}
					if (matrikelnr == -1)
						return;

				}

				System.out.print("Vorname: ");
				try {
					preName = scanner.next();
				} catch (Exception e) {
					show_error_msg("Ungültige Eingabe!");
					return;
				}

				System.out.print("Nachname: ");
				try {
					lastName = scanner.next();
				} catch (Exception e) {
					show_error_msg("Ungültige Eingabe!");
					return;
				}

				System.out.print("Studiengang: ");
				try {
					course = scanner.next();
				} catch (Exception e) {
					show_error_msg("Ungültige Eingabe!");
					return;
				}

				singleList.add(new Student(matrikelnr, preName, lastName, course));

				return;

			case "z":
				show_main_menu();
				return;
			default:
				show_error_msg("Ungültige Eingabe! ");
			}

		}
	}

	/**
	 * Ausgabe des Untermenues "Student loeschen"
	 */

	private void show_sub_menu_delete() {
		String eingabe = "";
		while (true) {

			getHeader("Hauptmenue -> Student loeschen");

			System.out.println("Bitte geben Sie den Index der Liste ein, der geloescht werden soll.");
			System.out.println();
			System.out.println("(z) Zurück");
			System.out.println();
			System.out.print("Index: ");

			try {
				eingabe = scanner.next();
			} catch (Exception e) {
				show_error_msg("Ungültige Eingabe! ");
			}

			System.out.println();

			if (eingabe.equals("z")) {
				show_main_menu();
			} else {
				int i = -1;

				try {
					i = Integer.valueOf(eingabe);
				} catch (Exception e) {

				}

				System.out.println();

				if (i < 0 || i > singleList.getSize() - 1) {
					show_error_msg("Index " + i + " wurde nicht gefunden!");
					return;
				}

				if (singleList.remove(0)) {
					System.out.println("Erfolgreich geloescht");
				}

			}

			System.out.println();
			return;

		}
	}

	/**
	 * Ausgabe des Untermenues "Studenten suchen"
	 */

	private void show_sub_menu_search() {
		String eingabe = "";
		while (true) {

			getHeader("Hauptmenue -> Student suchen");

			System.out.println("(1) nach Matrikelnummer");
			System.out.println("(2) nach Vorname");
			System.out.println("(3) nach Nachname");
			System.out.println("(4) nach Studiengang");
			System.out.println();
			System.out.println("(5) nach Listen Index");
			System.out.println();
			System.out.println("(z) Zurück");
			System.out.println();
			System.out.print("Ihre Auswahl: ");

			try {
				eingabe = scanner.next();
			} catch (Exception e) {
				show_error_msg("Ungültige Eingabe! ");
				return;
			}

			SearchOptions option = SearchOptions.Matrikelnr;

			switch (eingabe) {
			case "1":
				option = SearchOptions.Matrikelnr;
				break;
			case "2":
				option = SearchOptions.Vorname;
				break;
			case "3":
				option = SearchOptions.Nachname;
				break;
			case "4":
				option = SearchOptions.Studiengang;
				break;
			case "5":
				option = SearchOptions.ListenIndex;
				break;
			case "z":
				return;
			default:
				show_error_msg("Ungültige Eingabe! ");
				return;
			}

			System.out.println();
			System.out.print("Suchbegriff: ");

			try {
				eingabe = scanner.next();
			} catch (Exception e) {
				show_error_msg("Ungültige Eingabe! ");
				return;
			}

			if (option != SearchOptions.ListenIndex)
				System.out.println(Search.search(singleList, option, eingabe).getAll());
			else {
				int index = 0;
				try {
					index = Integer.valueOf(eingabe);
				} catch (Exception e) {
					show_error_msg("Dies war keine gueltige Zahl!");
					return;
				}
				Student s = singleList.get(index);
				if (s != null) {
					System.out.println(s);
				}
			}

			return;

		}
	}

	/**
	 * Ausgabe des Untermenues "Liste sortieren"
	 */

	private void show_sub_menu_list_sort() {
		String eingabe = "";
		if (singleList.getSize() > 20000)
			show_error_msg(
					"Achtung: Die Liste hat über 20.000 Eintraege. Das Sortieren mit dem BubbleSort Algorithmus kann sehr lange dauern bzw. zum Absturz fuehren!");

		while (true) {

			getHeader("Hauptmenue -> Liste Sortieren");

			System.out.println("(1) MergeSort - MatrikelNr");
			System.out.println("(2) MergeSort - Studiengang");
			System.out.println();
			System.out.println("(3) BubbleSort2 - Matrikelnr");
			System.out.println("(4) BubbleSort2 - Studiengang ");
			System.out.println();
			System.out.println("(z) Zurück");
			System.out.println();
			System.out.print("Ihre Auswahl: ");

			try {
				eingabe = scanner.next();
			} catch (Exception e) {
				show_error_msg("Ungültige Eingabe! ");
			}

			System.out.println();

			switch (eingabe) {
			case "1":
				MergeSort.sort(singleList, SortOptions.Matrikelnr);
				System.out.println();
				return;
			case "2":
				MergeSort.sort(singleList, SortOptions.Studiengang);
				System.out.println();
				return;
			case "3":
				BubbleSort.sort(singleList, SortOptions.Matrikelnr);
				System.out.println();
				return;
			case "4":
				BubbleSort.sort(singleList, SortOptions.Studiengang);
				System.out.println();
				return;
			case "z":
				show_main_menu();
				return;
			default:
				show_error_msg("Ungültige Eingabe! ");
			}

		}
	}

	/**
	 * Anzeigen eines Fehlertextes
	 * 
	 * @param msg
	 *            Text der ausgegeben werden soll
	 */

	private void show_error_msg(String msg) {
		System.out.println();
		System.out.println(msg);
		System.out.println();
	}

	/**
	 * Anzeigen einer Überschrift
	 * 
	 * @param title
	 *            Der Titel der Überschrift
	 */
	private void getHeader(String title) {
		System.out.println(title);
		System.out.println((getUnderline(title)));
		System.out.println();
	}

	/**
	 * Hilfsfunktion zur Berechnung der Anzahl der Unterstreichungszeichen
	 * 
	 * @param text
	 *            Text der unterstrichen werden soll
	 * @return Zeichenkette von - Zeichen (Anzahl entspricht Anzahl chars des
	 *         übergegebenen Textes)
	 */
	private String getUnderline(String text) {

		String underline = "";
		for (int i = 0; i < text.length(); i++) {
			underline += "-";
		}
		return underline;
	}

	/**
	 * Nethode zum Erstellen einer zufaelligen Zahl zwischen min und max
	 * 
	 * @param min
	 *            kleinste zufaellige Zahl
	 * @param max
	 *            groesste zufaellige Zahl
	 * @return eine zufaellige Zahl zwischen min und max
	 */

	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}
}
