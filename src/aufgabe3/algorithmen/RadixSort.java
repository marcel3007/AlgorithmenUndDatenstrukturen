package aufgabe3.algorithmen;

import java.text.DecimalFormat;
import java.util.Arrays;

import aufgabe3.helper.Log;
import aufgabe3.model.*;

public class RadixSort {

	private static final String TAG = RadixSort.class.getSimpleName();

	/**
	 * Hauptfunktion des RadixSort Algorithmus fuer die Sortierung einer Integer
	 * Liste
	 * 
	 * @param integerList
	 *            Liste mit Integer Werten, die sortiert werden soll
	 * @return sortierte Liste
	 */
	public static DoublyLinkedList<Integer> sort(DoublyLinkedList<Integer> integerList) {

		// Ermittlung Anzahl Stellen der groessten / laengsten Zahl
		int maxLength = getLengthOfBiggestNumber(integerList);

		// Laenge des Alphabets, da nur Zahlen und + sowie -
		// 0..9, + und -
		int alphabetLength = 12;

		// Konvertiere IntegerList zu einer StringList mit aufgefuellten Nullen und
		// Vorzeichen
		DoublyLinkedList<String> stringList = convertToStringList(integerList, maxLength);

		Log.d(TAG, "getLengthOfBiggestNumber() = " + maxLength);
		Log.d(TAG, "alphabetLength = " + alphabetLength);

		System.out.println();

		// Queues fuer 0..9 und das + Zeichen
		int anzahlQueues = alphabetLength - 1;
		Queue<String> queues[] = new Queue[anzahlQueues];

		// "-" nach LiFo Prinzip, also in Stack
		Stack<String> stack = new Stack<>();

		// QueueArray initialisieren
		for (int i = 0; i < anzahlQueues; i++) {
			queues[i] = new Queue<>();
		}

		// for Schleife von ganz rechts bis zur ersten Stelle
		for (int i = maxLength; i >= 0; i--) {

			Log.d(TAG, "forSchleife: i = " + i);

			// Verteilungsphase

			Log.d(TAG, "Verteilungsphase " + (maxLength - i));
			verteilen(i, stringList, queues, stack);

			System.out.println();

			// Sammelphase

			Log.d(TAG, "Sammelphase " + (maxLength - i));
			sammeln(i, stringList, queues, stack, alphabetLength);

			System.out.println();

		}

		Log.d(TAG, "Liste unsortiert (Integer): " + integerList.toString());

		Log.d(TAG, "Liste sortiert (String): " + stringList.toString());

		// StringListe in IntegerListe konvertieren

		DoublyLinkedList<Integer> resultList = convertToIntegerList(stringList);

		Log.d(TAG, "Liste sortiert (Integer): " + resultList.toString());

		return resultList;

	}

	/**
	 * Diese Methode verteilt die Zeichen an der Position i in das vorgesehene Fach
	 * 
	 * @param i
	 *            Position der Zahl
	 * @param stringList
	 *            Liste, in der die Werte gespeichert sind
	 * @param queues
	 *            Queue Arrays fuer die Zahlen 0..9 und 10 fuer das + Zeichen
	 * @param stack
	 *            Stack fuer negative Zeichen
	 */
	private static void verteilen(int i, DoublyLinkedList<String> stringList, Queue<String> queues[], Stack<String> stack) {

		Log.d(TAG, "AusgangsListe vor Verteilen: " + stringList.toString());
		for (String s : stringList) {

			// wenn erstes zeichen dann ...
			if (i == 0) {

				if (s.charAt(i) == '+') {
					// wenn + Zeichen

					Log.d(TAG, "Zahl = " + s + " | Zeichen = " + "+" + " to Queue");
					queues[10].offer(s);
				} else {
					// wenn - Zeichen
					Log.d(TAG, "Zahl = " + s + " | Zeichen = " + "-" + " to Stack[10]");
					stack.push(s);
				}

			} else {

				int ziffer = Character.getNumericValue(s.charAt(i));
				Log.d(TAG, "Zahl = " + s + " | Zeichen = " + ziffer + " to Queue[" + ziffer + "]");
				queues[ziffer].offer(s);
			}

		}

	}

	/**
	 * 
	 * Diese Methode sammelt die einzelnen Faecher auf
	 * 
	 * @param i
	 *            aktuelle Sammelphase
	 * @param stringList
	 *            Liste, in der die aufgesammelten Werte gespeichert werden
	 * @param queues
	 *            Queue Arrays fuer die Zahlen 0..9 und 10 fuer das + Zeichen
	 * @param stack
	 *            Stack fuer negative Zeichen
	 * @param alphabetLength
	 *            laenge des Alphabets {0..9, +, -} = 12
	 */
	private static void sammeln(int i, DoublyLinkedList<String> stringList, Queue<String> queues[], Stack<String> stack,
			int alphabetLength) {

		// Liste zuruecksetzen
		stringList.clear();

		if (i == 0) {

			// zu erst alle negativen aufsammeln und an das Ende der Liste hinzufuegen
			while (!stack.isEmpty()) {

				String s = stack.pop();
				stringList.add(s);
				Log.d(TAG, s + " popped from Stack and added to List");
			}

			// danach alle positiven Zahlen aufsammeln und an das Ende der Liste hinzufuegen
			while (!queues[10].isEmpty()) {
				String s = queues[10].poll();
				stringList.add(s);
				Log.d(TAG, s + " polled from Queue and added to List");
			}
		} else {

			for (int j = 0; j < alphabetLength - 2; j++) {

				Log.d(TAG, "forSchleife: j = " + j);

				while (!queues[j].isEmpty()) {
					String s = queues[j].poll();
					stringList.add(s);
					Log.d(TAG, s + " polled from Queue and added to List");
				}

			}

		}

		Log.d(TAG, "Liste nach sammeln: " + stringList.toString() + "\n");

	}


	/**
	 * Diese Hilfsmethode ermittelt die maximale Anzahl an Stellen in einer
	 * gegebenen Liste vom Typ Integer
	 * 
	 * @param integerList
	 *            Liste, in der die maximale Anzahl an Stellen ermittelt werden soll
	 * @return maximale anzahl an Stellen in der Liste
	 */
	private static int getLengthOfBiggestNumber(DoublyLinkedList<Integer> integerList) {
		int maxLength = 0;

		// Zaehle fuer jedes Element der Liste die Anzahl der Stellen und vergleiche es
		// mit maxLength, falls die Zahl mehr Stellen als maxLength hat, ueberschreibe
		// maxLength mit der neuen Anzahl an Stellen
		
		
		for (Integer i : integerList) {
			int digits = countDigits(i);
			if (digits > maxLength)
				maxLength = digits;
		}

		return maxLength;
	}

	/**
	 * Hilfsmethode zur Ermittlung der Anzahl an Stellen einer Zahl a
	 * 
	 * @param a
	 *            Zahl
	 * @return anzahl der Stellen von a
	 */
	private static int countDigits(int a) {

		if (a == 0)
			return 1;
		else
			return (int) (Math.log10(Math.abs(a)) + 1);
	}

	/**
	 * Diese Hilfsmethode formatiert eine Zahl als String wie es fuer RadixSort
	 * benoetigt wird
	 * 
	 * Es wird fuer jede Zahl, die weniger Stellen als die Zahl, mit den meissten
	 * Stellen hat voranstehende Nullen hinzugefuegt. Zusaetzlich wird auch ein
	 * positives Vorzeichen hinzugefuegt
	 * 
	 * Bsp: {3, 12, 123, -2} maxLength = 3 3 wird zu +003 12 wird zu +012 123 wird
	 * zu +123 -2 wird zu -002
	 * 
	 * @param a
	 *            Zahl die als String formatiert werden soll
	 * @param digits
	 *            Anzahl der Stellen
	 * @return Zahl als String formatiert
	 */
	private static String intToString(int a, int digits) {
		assert digits > 0 : "Ungueltige Anzahl an Stellen";

		// char Array der Groesse von digits erstellen und mit Nullen befuellen
		char[] zeros = new char[digits];
		Arrays.fill(zeros, '0');

		// ein DecimalFormat Objekt erstellen mit dem char Array als pattern
		DecimalFormat df = new DecimalFormat(String.valueOf(zeros));

		// die Zahl a mit dem DecimalFormat formatieren
		String formated = df.format(a);

		// sorgt dafuer das auch positive Zahlen ein + Zeichen erhalten
		if (a >= 0)
			formated = new StringBuilder(formated).insert(0, "+").toString();

		return formated;
	}


	/**
	 * Diese Hilfsmethode konvertiert eine Liste vom Typ Integer in eine Liste vom
	 * Typ String und formartiert eine Zahl wie es fuer RadixSort benoetigt wird.
	 * 
	 * @param integerList
	 *            Liste mit den Integers die umgewandelt werden soll
	 * @param maxLength
	 *            maximale Anzahl Stellen
	 * @return Liste vom Typ String
	 */
	private static DoublyLinkedList<String> convertToStringList(DoublyLinkedList<Integer> integerList, int maxLength) {

		DoublyLinkedList<String> stringList = new DoublyLinkedList<>();

		for (Integer i : integerList) {

			String zahlAsString = intToString(i, maxLength);
			stringList.add(zahlAsString);

		}

		return stringList;
	}
	
	/**
	 * Diese Hilfsmethode konvertiert eine Liste vom Typ String in eine Liste vom
	 * Typ Integer.
	 * 
	 * @param stringList Liste mit den Strings die umgewandelt werden soll
	 * @return Liste vom Typ Integer
	 */
	private static DoublyLinkedList<Integer> convertToIntegerList(DoublyLinkedList<String> stringList) {

		DoublyLinkedList<Integer> integerList = new DoublyLinkedList<>();

		for (String s : stringList) {
			int i = Integer.valueOf(s);
			integerList.add(i);

		}

		return integerList;
	}
}
