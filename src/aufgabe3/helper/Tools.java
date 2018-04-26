package aufgabe3.helper;

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
