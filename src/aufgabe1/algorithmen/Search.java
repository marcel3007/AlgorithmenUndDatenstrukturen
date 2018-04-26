package aufgabe1.algorithmen;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import aufgabe1.enums.SearchOptions;
import aufgabe1.model.Node;
import aufgabe1.model.SingleLinkedList;
import aufgabe1.model.Student;

/**
 * Klasse die den Suchalgorithmus fuer eine lineare Suche implementiert
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 */
public class Search {

	// Diese Attribute sind nur für interne Statistikberechnungen
	protected static long compares = 0;
	protected static long loops = 0;
	protected static long timeStart = 0;
	protected static long timeEnd = 0;

	/**
	 * Diese Methode fuehrt eine lineare Suche auf einer SingleLinkedList durch
	 * 
	 * @param list
	 *            Liste die durchsucht werden soll
	 * @param option
	 *            nach welchem Attribut gesucht werden soll (Matrikelnr oder
	 *            Studiengang)
	 * @param query
	 *            Suchbegriff
	 * @return Liste mit gefundenen Studenten
	 */
	public static SingleLinkedList<Student> search(SingleLinkedList<Student> list, SearchOptions option, String query) {

		timeStart = System.nanoTime();

		compares = 0;
		loops = 0;

		SingleLinkedList<Student> ergebnis = new SingleLinkedList<>();

		Node<Student> tmp = list.getHead();

		while (tmp != null) {

			loops++;
			compares++;

			switch (option) {

			case Matrikelnr:

				if (String.valueOf(tmp.getData().getMatrikelnr()).equals(query))
					ergebnis.add(tmp.getData());

				break;

			case Vorname:

				if ((tmp.getData().getVorname()).equalsIgnoreCase(query))
					ergebnis.add(tmp.getData());

				break;

			case Nachname:

				if ((tmp.getData().getNachname()).equalsIgnoreCase(query))
					ergebnis.add(tmp.getData());

				break;

			case Studiengang:

				if ((tmp.getData().getStudiengang()).equalsIgnoreCase(query))
					ergebnis.add(tmp.getData());

				break;
			}

			tmp = tmp.getNext();
		}

		timeEnd = System.nanoTime();

		printStatisticSearch(list.getSize());

		return ergebnis;
	}

	/**
	 * Hilfsmethode zur Ausgabe einer Statistik ueber den Suchvorgang
	 * 
	 * @param size
	 *            Groesse der durchsuchten Liste
	 */

	private static void printStatisticSearch(int size) {
		System.out.println("###################################");
		System.out.println("Statistik zur Suche:");
		System.out.printf("Size n:\t\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(size));
		System.out.printf("Loops:\t\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(loops));
		System.out.printf("Compares:\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(compares));
		System.out.printf("Sum:\t\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(compares + loops));
		System.out.printf("Time:\t\t%s s\n", TimeUnit.NANOSECONDS.toSeconds(timeEnd - timeStart));
		System.out.println("###################################");
	}
}
