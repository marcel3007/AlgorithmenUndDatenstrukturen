package aufgabe1.algorithmen;

import aufgabe1.enums.SortOptions;
import aufgabe1.model.Node;
import aufgabe1.model.SingleLinkedList;
import aufgabe1.model.Student;

/**
 * Klasse, die den MergeSort Algorithmus (rekursiv) implementiert
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 */

public class MergeSort extends Sort {

	// Diese Attribute sind nur für interne Statistikberechnungen
	private static long compares;
	private static long moves;
	private static long timeStart;
	private static long timeEnd;

	/**
	 * Diese Methode sortiert eine Liste nach dem MergeSort Algorithmus (rekursiv).
	 * Diese Methode ist public und somit fuer andere Klassen sichtbar. Sie gibt im
	 * Anschluss auf der Konsole eine kleine Statistik zum Sortiervorgang aus.
	 * 
	 * @param list
	 *            Liste die sortiert werden soll
	 * @param attr
	 *            Sortierkriterium
	 */
	public static void sort(SingleLinkedList<Student> list, SortOptions attr) {

		SingleLinkedList<Student> result = new SingleLinkedList<>();

		compares = 0;
		moves = 0;

		timeStart = System.nanoTime();

		// Effizienzsteigerung durch vorheriges Prüfen, ob die Liste bereits sortiert
		// ist
		if (!isSorted(list, attr)) {
			result = merge_sort(list, attr);
			list.addAll(result);
		}

		timeEnd = System.nanoTime();

		printStatistic("MergeSort", list.getSize(), compares, moves, timeStart, timeEnd);

	}

	/**
	 * Diese Methode sortiert eine Liste nach dem MergeSort Algorithmus (rekursiv)
	 * 
	 * @param list
	 *            Liste die sortiert werden soll
	 * @param option
	 *            Sortierkriterium
	 * @return sortierte Liste
	 */

	private static SingleLinkedList<Student> merge_sort(SingleLinkedList<Student> list, SortOptions option) {

		// unsere Abbruchbedingung fuer den rekursiven Aufruf
		// wenn die Liste <= 1, also nur noch 1 Element enthaelt, gib die Liste zurueck
		if (list.getSize() <= 1)
			return list;

		// Statistik
		compares++;

		// erstelle eine linke Liste ...

		SingleLinkedList<Student> left = new SingleLinkedList<>();

		// ... und eine recte Liste
		SingleLinkedList<Student> right = new SingleLinkedList<>();

		// berechne die Mitte der Eingabeliste
		int half = list.getSize() / 2;

		// Erstelle einen temporären Knoten der mit dem Kopf initialisiert wird
		Node<Student> tmp = list.getHead();

		// Laufvariable auf 0 initialisieren
		int i = 0;

		// Teile Liste in 2 Listen
		// solange wir nicht am Ende der Liste sind, tue folgendes
		while (tmp != null) {

			// wenn i < als die Hälfte der Gesamtgröße ist, dann füge das aktuelle Element
			// in die linke Liste
			if (i < half) {
				left.add(tmp.getData());
			} else {
				// .. andernfalls kommt es in die rechte Liste
				right.add(tmp.getData());
			}

			// erhoehe die Laufvariable um 1 ...
			i++;

			// ... und gehe zum naechsten Knoten
			tmp = tmp.getNext();

			// Statistik
			compares++;
			moves++;
		}

		// nachdem wir die Liste in 2 Teile geteilt haben folgt nun der rekursive
		// Aufruf, d.h.
		// wie teilen die linke und rechte Liste wieder in 2 Hälften
		// solange die Listen größer 1 sind (also mehr als 1 Element enthalten)

		left = merge_sort(left, option);
		right = merge_sort(right, option);

		// nun werden die Teilisten zusammengefuegt
		return merge(left, right, option);

	}

	/**
	 * Zusammenfuegen zweier Teillisten zu einer Liste die aufsteigend sortiert ist
	 * 
	 * @param left
	 *            linke Liste
	 * @param right
	 *            rechte Liste
	 * @param option
	 *            Sortierkriterium
	 * @return sortierte Liste
	 */
	private static SingleLinkedList<Student> merge(SingleLinkedList<Student> left, SingleLinkedList<Student> right,
			SortOptions option) {

		// wir erstellen eine neue Liste
		SingleLinkedList<Student> result = new SingleLinkedList<>();

		// solange die linke UND rechte Liste nicht leer sind
		while ((!left.isEmpty() && !right.isEmpty())) {

			// diese switch Anweisung entscheidet darueber, nach was wir sortieren wollen
			switch (option) {

			case Matrikelnr:

				// wir vergleichen den linken Kopf mit dem rechten Kopf, ist dieser kleiner oder
				// gleich dem rechten
				if (left.getHead().getData().getMatrikelnr() <= right.getHead().getData().getMatrikelnr()) {

					// fuegen wir das linke Element in die Ergebnisliste
					result.add(left.get(0));

					// ... und entfernen es aus der linken Liste
					left.removeFirst();

				} else {
					// andernfalls war das rechte Element kleiner, d.h wir fuegen es in die
					// Ergebnisliste ein
					result.add(right.get(0));

					// und entfernen das rechte Kopfelement aus der Liste
					right.removeFirst();
				}
				break;

			case Studiengang:

				// analog zu Matrikelnr
				// wir vergleichen beide Listenkoepfe und fuegen das kleinere in die
				// Ergebnisliste ein,
				// anschliessend wird dieses aus der urspuenglichen Teilliste entfernt

				if (left.getHead().getData().getStudiengang()
						.compareTo(right.getHead().getData().getStudiengang()) <= 0) {
					result.add(left.get(0));
					left.removeFirst();
				} else {
					result.add(right.get(0));
					right.removeFirst();
				}

				break;
			default:
				break;

			}

			// Statistik
			compares++;
			moves++;
		}

		// Im folgenden wird nur EINE Schleife durchlaufen, entweder die linke oder die
		// rechte Liste,
		// jenachdem welche noch nicht leer ist

		// wenn die linke liste noch nicht leer ist
		// fuegen wir dessen Restelemente an das Ende der Ergebnisliste und loeschen
		// die Elemente aus der linken Liste

		while (!left.isEmpty()) {
			result.add(left.get(0));
			left.removeFirst();

			// Statistik
			moves++;
		}
		// wenn die rechte liste noch nicht leer ist
		// fuegen wir dessen Restelemente an das Ende der Ergebnisliste und loeschen
		// die Elemente aus der rechten Liste

		while (!right.isEmpty()) {
			result.add(right.get(0));
			right.removeFirst();

			// Statistik
			moves++;
		}

		// wir geben die Ergebnisliste zureuck
		return result;

	}

}
