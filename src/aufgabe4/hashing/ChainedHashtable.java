package aufgabe4.hashing;

import java.util.Iterator;

import aufgabe4.helper.*;
import aufgabe4.lists.DoublyLinkedList;

/**
 * Klasse zum Erstellen von ChainedHashtables fuer Integer
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @author Marcel
 *
 */

public class ChainedHashtable implements Hashable<Integer> {

	private static final String TAG = ChainedHashtable.class.getSimpleName();
	private DoublyLinkedList<Integer>[] listArray;
	private int m;

	public ChainedHashtable(int m) {
		this.m = m;
		listArray = (DoublyLinkedList<Integer>[]) new DoublyLinkedList[m];

		Log.i(TAG, "Konfiguration chainedHashtable");
		Log.i(TAG, "m = " + m);
		Log.i(TAG, "Hashfunktion = k%m\n");
	}

	/**
	 * Hashfunktion
	 * 
	 * @param k
	 *            Wert von dem der Hash ermittelt werden soll
	 * @return hash bzw. index
	 */
	private int hash(int k) {
		return Math.floorMod(k, m);
	}

	@Override
	public boolean insert(Integer k) {

		Log.i(TAG, "Einfuegen von Element:  " + k);

		// berechne den Hash (also den Index im Array)
		int i = hash(k);

		// wenn im Arrayindex noch keine Liste vorhanden, dann erstelle eine neue
		// LinkedList
		if (listArray[i] == null) {
			// Log.d(TAG, "Am Index " + i + " existiert noch keine Liste -> erstelle neue
			// Liste");
			// listArray[i] = new LinkedList<Integer>();
			listArray[i] = new DoublyLinkedList<Integer>();
		}

		// fuege den Wert a am Index i des Arrays der Liste hinzu
		listArray[i].add(k);

		Log.i(TAG, k + " zum Index " + i + " hinzugefuegt");

		return true;

	}

	@Override
	public Integer find(Integer k) {

		Log.i(TAG, "Finde Element:  " + k);

		// berechne den Hash (also den Index im Array)
		int index = hash(k);

		Log.i(TAG, "hash(" + k + ") = " + index);

		// wenn am Index i des Array eine Liste existiert, dann durchlaufe diese
		if (listArray[index] != null) {

			Log.i(TAG, "listArray[" + index + "] != null => suche in der Liste");

			Iterator<Integer> iterator = listArray[index].iterator();

			// durchlaufe die Liste bis das entsprechende Element gefunden wurde
			// wenn gefunden, gib index zurueck
			while (iterator.hasNext()) {
				int e = (Integer) iterator.next();

				if (e == k) {
					return index;
				}

			}

		} else {

			Log.i(TAG, "listArray[" + index + "] == null => Element nicht vorhanden");

		}

		// wenn kein Element gefunden, gib -1 zurueck
		return -1;

	}

	@Override
	public boolean delete(Integer k) {

		Log.i(TAG, "Loesche Element:  " + k);

		// berechne den Hash (also den Index im Array)
		int i = hash(k);

		// wenn am Index i des Array eine Liste existiert, dann durchlaufe diese
		if (listArray[i] != null) {

			Iterator<Integer> iterator = listArray[i].iterator();

			// durchlaufe die Liste bis das entsprechende Element gefunden wurde
			// wenn gefunden, gib true zurueck
			while (iterator.hasNext()) {
				int e = (Integer) iterator.next();

				if (e == k) {
					iterator.remove();

					// wenn die Liste leer ist, setze index auf null
					if (listArray[i].isEmpty())
						listArray[i] = null;

					return true;
				}

			}
		}

		return false;
	}

	@Override
	public void showAllElements() {

		Log.i(TAG, "Ausgabe aller Elemente: ");

		for (int i = 0; i < listArray.length; i++) {
			if (listArray[i] != null)
				Log.i(TAG, "array[" + i + "] = " + listArray[i].toString());
			else
				Log.i(TAG, "array[" + i + "] = null");
		}

	}
}
