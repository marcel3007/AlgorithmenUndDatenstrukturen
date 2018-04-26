package aufgabe2.controller;

import static aufgabe2.controller.Tools.getHeader;
import static aufgabe2.controller.Tools.showMsg;

import java.util.EmptyStackException;
import java.util.Locale;
import java.util.Scanner;

import aufgabe2.model.Stack;

/**
 * Controller fuer das Konsolenmenue
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 */
public class MainController {

	private Stack<Integer> stack;
	private Scanner scanner;

	public MainController() {

		scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		stack = new Stack<>();

	}

	/**
	 * Zeigt das Hauptmenue an
	 */

	public void show_main_menu() {

		String eingabe = "";

		while (true) {

			getHeader("Hauptmenue");

			System.out.println("(1) Stack anzeigen");
			System.out.println("(2) push Integer");
			System.out.println("(3) pop Integer");
			System.out.println();
			System.out.println("(4) Stack leeren");

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
				show_sub_menu_show_stack();
				break;
			case "2":
				show_sub_menu_push_stack();
				break;
			case "3":
				show_sub_menu_pop_stack();
				break;
			case "4":
				stack.clear();
				System.out.println("Alle Elemente im Stack wurden entfernt!\n");
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
	 * Ausgabe des Untermenues um den Stack auszugeben
	 */

	private void show_sub_menu_show_stack() {

		getHeader("Hauptmenue -> Stack anzeigen");

		if (stack.isEmpty()) {

			System.out.println("Der Stack ist leer");
			System.out.println();

			return;
		}

		System.out.println("Anzahl Elemente im Stack: " + stack.getSize());

		System.out.println("Elemente im Stack:");
		stack.print();

		System.out.println();
	}

	/**
	 * Ausgabe des Untermenues um ein Element in den Stack zu "pushen"
	 */

	private void show_sub_menu_push_stack() {
		String eingabe = "";
		while (true) {

			getHeader("Hauptmenue -> Element hinzufuegen");

			System.out.println("Bitte einen Integer eingeben");
			System.out.println();
			System.out.println("(z) Zurück");
			System.out.println();
			System.out.print("Integer: ");

			try {
				eingabe = scanner.next();
			} catch (Exception e) {
				showMsg("Ungültige Eingabe! ");
			}

			System.out.println();

			if (eingabe.equals("z")) {
				show_main_menu();
			} else {
				int i = 0;

				try {
					i = Integer.valueOf(eingabe);
				} catch (Exception e) {
					System.out.println("Ungueltige Eingabe!");
					System.out.println();
					return;
				}

				System.out.println();

				stack.push(i);

				System.out.println("Erfolgreich hinzugefuegt!");

			}

			System.out.println();
			return;

		}
	}

	/**
	 * Ausgabe des Untermenues um das oberste Element aus dem Stack zu holen (pop)
	 */

	private void show_sub_menu_pop_stack() {
		try {
			int i = stack.pop();

			System.out.println("pop Integer: " + i);

			System.out.println();

		} catch (EmptyStackException e) {
			System.out.println("Der Stack ist leer");
			System.out.println();
		}
	}

}
