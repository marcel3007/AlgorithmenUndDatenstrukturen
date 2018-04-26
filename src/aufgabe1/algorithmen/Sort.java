package aufgabe1.algorithmen;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import aufgabe1.enums.SortOptions;
import aufgabe1.model.List;
import aufgabe1.model.Node;
import aufgabe1.model.Student;

/**
 * Klasse fuer die Sortierung von Listenelementen
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 */
public class Sort {

	// Diese Attribute sind nur für interne Statistikberechnungen
	private static long compares;
	private static long moves;
	private static long timeStart;
	private static long timeEnd;

	/**
	 * Diese Hilfsmethode prueft ob eine Liste sortiert ist oder nicht. Es wird
	 * durch jedes Element itteriert und sobald ein Element gefunden wurde, welches
	 * nicht sortiert ist, bricht die Schleife ab. Dadurch kann beim MergeSort bei
	 * einer vollständig sortierten Liste eine Effizienzsteigerung erreicht werden,
	 * die nur minimal Mehraufwand kostet (im schlimmsten Fall n-1 Loops und n-1
	 * Compares).
	 * 
	 * @param list
	 *            Liste die ueberprueft werden soll
	 * @param option
	 *            Sortierkriterium
	 * @return true wenn Liste bereits sortiert ist
	 */
	protected static boolean isSorted(List<Student> list, SortOptions option) {

		compares = 0;
		moves = 0;

		timeStart = System.nanoTime();

		boolean isSorted = true;

		Node<Student> current = list.getHead();

		while (current.getNext() != null && isSorted) {

			switch (option) {

			case Matrikelnr:

				if (current.getData().getMatrikelnr() > current.getNext().getData().getMatrikelnr())
					isSorted = false;

				break;

			case Studiengang:
				if (current.getData().getStudiengang().compareTo(current.getNext().getData().getStudiengang()) > 0)
					isSorted = false;
				break;
			}
			current = current.getNext();
			compares++;

		}

		timeEnd = System.nanoTime();

		printStatistic("isSorted", list.getSize(), compares, moves, timeStart, timeEnd);

		return isSorted;

	}

	/**
	 * Diese Methode zeigt eine kleine Statistik ueber die Sortierung an.
	 * Ausgewertet werden die Anzahl der Schleifendurchlaeufe, die Vergleiche (if,
	 * else ..), die Moves / Swaps und die benoetigte Zeit.
	 * 
	 * 
	 * @param algorithmus
	 *            Algorithmus der benutzt wurde
	 * @param size
	 *            die Groesse der Liste
	 * @param compares
	 *            die anzahl der Vergleiche
	 * @param moves
	 *            die Anzahl der Bewegungen
	 * @param timeStart
	 *            Startzeit
	 * @param timeEnd
	 *            Endzeit
	 */
	protected static void printStatistic(String algorithmus, int size, long compares, long moves, long timeStart,
			long timeEnd) {

		long sum = compares + moves;

		System.out.println("###################################");

		System.out.println("Statistik " + algorithmus + ":");

		System.out.printf("Size(list) n\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(size));

		System.out.printf("Compares\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(compares));
		System.out.printf("Swaps / Moves\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(moves));

		System.out.printf("Total:\t\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(sum));

		System.out.printf("Time:\t\t%s s\n", TimeUnit.NANOSECONDS.toSeconds(timeEnd - timeStart));

		System.out.println("###################################");
	}

}
