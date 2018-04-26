package aufgabe4.helper;

import java.math.BigDecimal;

import java.math.RoundingMode;

/**
 * Einige nuetzliche Funktionen die oefters gebraucht werden
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 */

public class Tools {

	/**
	 * Gibt eine ganzzahlige Zufallszahl zwischen min und max
	 * 
	 * @param min
	 *            minimaler Wert
	 * @param max
	 *            maximaler Wert
	 * @return zufaellige Zahl zwischen min und max
	 */
	public static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	/**
	 * Gibt ein Array von zufaelligen Integerzahlen zurueck
	 * 
	 * @param min
	 *            minimaler Wert
	 * @param max
	 *            maximaler Wert
	 * @param n
	 *            Anzahl der Werte
	 * @return Integerarray von Zufallszahlen
	 */
	public static int[] getRandomNumberArray(int min, int max, int n) {

		int array[] = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = getRandomNumber(min, max);
		}

		return array;
	}

	/**
	 * Rundet einen double Wert auf x Stellen
	 * 
	 * @param value
	 *            Wert der gerundet werden soll
	 * @param places
	 *            Anzahl der Stellen hinter dem Komma
	 * @return gerundeter double Wert
	 */

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * Prueft ob eine Zahl eine Primzahl ist
	 * 
	 * @param value Wert der geprueft werden soll, ob er eine Primzahl ist
	 * @return true wenn Zahl eine Primzahl ist
	 */

	public static boolean isPrimzahl(int value) {

		if (value <= 16) {
			return (value == 2 || value == 3 || value == 5 || value == 7 || value == 11 || value == 13);
		}
		if (value % 2 == 0 || value % 3 == 0 || value % 5 == 0 || value % 7 == 0) {
			return false;
		}
		for (long i = 10; i * i <= value; i += 10) {
			if (value % (i + 1) == 0) { // 11, 21, 31, 41, 51, ...
				return false;
			}
			if (value % (i + 3) == 0) { // 13, 23, 33, 43, 53, ...
				return false;
			}
			if (value % (i + 7) == 0) { // 17, 27, 37, 47, 57, ...
				return false;
			}
			if (value % (i + 9) == 0) { // 19, 29, 39, 49, 59, ...
				return false;
			}
		}
		return true;
	}

	/**
	 * Diese Funktion berechnet die naechst kleinere Primzahl zu einer Zahl a
	 * 
	 * @param a
	 *            Zahl, zu der die naechst kleinere Primzahl gesucht werden soll
	 * @return Primzahl
	 */

	public static int getNextSmallerPrimzahl(int a) {

		if (a <= 2)
			return 2;

		int i = a - 1;

		while (i >= 1) {

			if (Tools.isPrimzahl(i))
				return i;

			i--;
		}

		return i;

	}

	/**
	 * Berechnet den Modulowert von a % b Diese Extrafunktion ist nötig da Java bei
	 * negativen Werten keinen positiven Modulo Wert zurueckgibt Stichwort Remainder
	 * Math.floorMod(a.b) erfuellt den selben Zweck
	 * 
	 * @param a
	 *            Zahl
	 * @param b
	 *            Zahl
	 * @return Rest
	 */

	public static int mod(int a, int b) {
		return (a % b + b) % b;
	}

	/**
	 * Anzeigen einer (Info/Error) Nachricht
	 * 
	 * @param msg
	 *            Text der ausgegeben werden soll
	 */

	public static void showMsg(String msg) {
		System.out.println();
		System.out.println(msg);
		System.out.println();
	}

	/**
	 * Anzeigen einer Ueberschrift
	 * 
	 * @param title
	 *            Der Titel der Ueberschrift
	 */
	public static void getHeader(String title) {
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
	 *         uebergegebenen Textes)
	 */
	public static String getUnderline(String text) {

		String underline = "";
		for (int i = 0; i < text.length(); i++) {
			underline += "-";
		}
		return underline;
	}
}
