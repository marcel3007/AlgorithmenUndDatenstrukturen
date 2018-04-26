package aufgabe1.algorithmen;


import aufgabe1.enums.SortOptions;
import aufgabe1.model.List;
import aufgabe1.model.Node;
import aufgabe1.model.Student;

/**
 * Klasse, die den BubbleSort Algorithmus implementiert
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 */
public class BubbleSort extends Sort {

	// Diese Attribute sind nur für interne Statistikberechnungen
	private static long compares;
	private static long moves;
	private static long timeStart;
	private static long timeEnd;

	/**
	 * Sortieren der Datensätze der Studenten, Matrikelnummer, Studiengang nach dem
	 * BubbleSort Verfahren Best Case O(n) Average Case O(n^2) Worst Case O(n^2)
	 * 
	 * @param list
	 *            Liste die sortiert werden soll
	 * @param attr
	 *            Attribut nach dem sortiert werden soll
	 */

	public static void sort(List<Student> list, SortOptions attr) {

		// Statistik
		timeStart = System.nanoTime();
		moves = 0;
		compares = 0;

		// Information ob ein Tausch stattgefunden hat
		boolean hasSwapped = true;

		// leere Listen oder Listen mit nur einem Element sind per Definition sortiert
		if (list.getSize() <= 1)
			return;

		// setze Laufvariable auf 0
		int i = 0;

		// wiederhole solange i kleiner als die Größe der Liste ist und mindestens ein
		// Tausch stattgefunden hat
		while (i < list.getSize() && hasSwapped) {

			Node<Student> current = list.getHead();
			Node<Student> next = list.getHead().getNext();

			// bisher nichts geswapped
			hasSwapped = false;

			// setze Laufvariable j auf 0 und wiederholange solange j kleiner als die
			// Listengröße weniger 1
			// weniger der schon sortierte hintere Teil i ist

			for (int j = 0; j < list.getSize() - 1 - i; j++) {

				// Statistik
				compares++;

				switch (attr) {
				case Matrikelnr:

					// wenn die Matrikelnr des aktuellen Elements größer als die des nächsten
					// Elements ist,
					// dann tausche die beiden Elemente und setze hasSwapped auf true
					if (current.getData().getMatrikelnr() > next.getData().getMatrikelnr()) {

						swapData(current, next);
						hasSwapped = true;
					}
					break;
				case Studiengang:

					// analog zu Matrikelnr
					// wenn der Studiengang des aktuellen Elements "größer" als der des nächsten
					// Elements ist,
					// dann tausche die beiden Elemente und setze hasSwapped auf true

					// verwendet wird die Hilfsfunktion compareTo() die eine 1 zurück gibt wenn das
					// Objekt "größer" (lexikographisch) als das des zu vergleichenden Objektes ist

					if (current.getData().getStudiengang()
							.compareTo(current.getNext().getData().getStudiengang()) > 0) {

						swapData(current, next);
						hasSwapped = true;

					}
				}

				// gehe zum nächsten Element
				current = next;
				next = next.getNext();

			}

			// erhöhe die Laufvariable i um eins
			i++;
		}

		// Statistik
		timeEnd = System.nanoTime();

		printStatistic("BubbleSort", list.getSize(), compares, moves, timeStart, timeEnd);

	}

	/**
	 * Diese Hilfsfunktion tauscht den Inhalt zweier Knoten
	 * 
	 * @param current
	 *            der aktuelle Knoten
	 * @param next
	 *            der naechste knoten
	 */
	private static void swapData(Node<Student> current, Node<Student> next) {

		Student tmp = current.getData();
		current.setData(next.getData());
		next.setData(tmp);

		// Statistik
		moves++;
	}

}
