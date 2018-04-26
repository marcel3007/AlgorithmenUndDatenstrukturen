package aufgabe4.hashing;

import aufgabe4.helper.*;

/**
 * Klasse zum Erstellen von DoubledHashtables fuer Integer
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @author Marcel
 *
 */

public class DoubledHashtable implements Hashable<Integer> {

	private static final String TAG = DoubledHashtable.class.getSimpleName();

	private int m;
	private int mStrich;

	private Integer hashtable[];

	private int size;

	public DoubledHashtable(int m) {
		this.m = m;

		// m' muss kleiner als m, jedoch ziemlich groß und am besten eine Primzahl sein
		this.mStrich = Tools.getNextSmallerPrimzahl(m);

		hashtable = new Integer[m];

		size = 0;

		Log.i(TAG, "Konfiguration DoubledHashtable");
		Log.i(TAG, "m = " + m + " | m' = " + mStrich);
		Log.i(TAG, "Hashfunktion = ho(j,k)=(h(k) - j * h'(k) ) mod m für j=0,1,..,m-1\n");

	}

	/**
	 * Konstruktur um m und mStrich vorzugegeben
	 * 
	 * @param m
	 *            m
	 * @param mStrich
	 *            mStrich
	 */
	public DoubledHashtable(int m, int mStrich) {
		this.m = m;
		this.mStrich = mStrich;

		hashtable = new Integer[m];

		size = 0;

		Log.i(TAG, "Konfiguration DoubledHashtable");
		Log.i(TAG, "m = " + m);
		Log.i(TAG, "m' = " + mStrich);
		Log.i(TAG, "Hashfunktion = ho(j,k)=(h(k) - j * h'(k) ) mod m für j=0,1,..,m-1\n");

	}

	/**
	 * Hashfunktion
	 * 
	 * @param k
	 *            Wert von dem der hash berechnet werden soll
	 * @return hash / Index des Wertes
	 */
	private int h(int k) {
		return Math.floorMod(k, m);
		// return k % m;
	}

	/**
	 * Zweite Hashfunktion
	 * 
	 * @param k
	 *            Wert von dem der hash berechnet werden soll
	 * @return hash / Index des Wertes der zweiten Hashfunktion
	 */

	private int h2(int k) {
		return 1 + Math.floorMod(k, mStrich);
	}

	/**
	 * Sondierfunktion
	 * 
	 * @param j
	 *            aktuelles j
	 * @param k
	 *            Wert von dem der hash berechnet werden soll
	 * @return Index
	 */
	private int s(int j, int k) {
		return j * h2(k);
	}

	/**
	 * doubleHash Funktion
	 * 
	 * @param j
	 *            aktuelles j
	 * @param k
	 *            Wert von dem der hash berechnet werden soll
	 * @return hash / Index des Wertes
	 */
	private int doubleHash(int j, int k) {

		return Math.floorMod(h(k) - s(j, k), m);
	}

	@Override
	public boolean insert(Integer k) {

		Log.i(TAG, "Einfuegen von Element:  " + k);
		Log.i(TAG, "size = " + size);

		// kleine Performanceverbesserung
		if (size >= m) {
			Log.i(TAG, k + " konnte nicht eingefuegt werden, da kein freier Platz gefunden wurde");
			return false;
		}

		boolean hasFoundFreeIndex = false;

		int j = 0;
		int index = 0;

		while (j != m && !(hasFoundFreeIndex)) {

			index = doubleHash(j, k);

			Log.i(TAG, "j = " + j + " | index = " + index);

			if (hashtable[index] == null) {

				Log.i(TAG, "index = " + index + " ist frei");
				hasFoundFreeIndex = true;
			} else {
				Log.i(TAG, "index = " + index + " ist belegt, erhoehe j um 1");
				j++;
			}

		}

		if (hasFoundFreeIndex) {
			hashtable[index] = k;
			Log.i(TAG, k + " erfolgreich am Index " + index + " eingefuegt");
			System.out.println();
			size++;
			return true;
		} else {
			Log.i(TAG, k + " konnte nicht eingefuegt werden, da kein freier Platz gefunden wurde");
			System.out.println();
			return false;
		}

	}

	@Override
	public Integer find(Integer k) {

		Log.i(TAG, "Finde Element:  " + k);

		// kleine Performanceverbesserung
		if (size == 0) {
			return -1;
		}

		boolean hasFoundIndex = false;

		int j = 0;
		int index = 0;

		while (j != m && !(hasFoundIndex)) {

			index = doubleHash(j, k);

			Log.i(TAG, "j = " + j + " | hash(" + k + ", " + j + ") = " + index);

			if (hashtable[index] == k) {
				hasFoundIndex = true;
				Log.i(TAG, "hashtable[" + index + "] = " + hashtable[index] + " == " + k + " => gefunden");
				// Log.i(TAG, k + " erfolgreich am index = " + index + " gefunden");
			} else {

				Log.i(TAG, "hashtable[" + index + "] = " + hashtable[index] + "  != " + k + " => erhoehe j um 1");
				// Log.i(TAG, k + " nicht am index = " + index + " gefunden, erhoehe j um 1");
				j++;
			}

		}

		if (!hasFoundIndex) {
			Log.i(TAG, k + " konnte nicht gefunden werden");
			index = -1;
		}

		System.out.println();

		return index;
	}

	@Override
	public boolean delete(Integer k) {

		int index = find(k);

		if (index == -1) {
			return false;
		}

		hashtable[index] = null;

		size--;

		return true;
	}

	/**
	 * Methode zum Ausgeben aller Elemente in der doubled hashtable
	 */

	@Override
	public void showAllElements() {
		Log.i(TAG, "Ausgabe aller Elemente: ");

		// Arrays.toString(hashtable);

		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] != null)
				Log.i(TAG, "array[" + i + "] = " + hashtable[i]);
			else
				Log.i(TAG, "array[" + i + "] = null");
		}

		System.out.println();

	}

	/**
	 * Gibt die aktuelle Hashtable als Integer Array zurueck
	 * 
	 * @return Hashtable als Integerarray
	 */
	public Integer[] getHashtable() {
		return this.hashtable;
	}

}
