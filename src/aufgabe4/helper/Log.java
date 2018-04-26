package aufgabe4.helper;

public class Log {

	private static boolean showDebug = true;
	private static boolean showInfo = true;
	private static boolean showError = true;

	public Log() {
	}

	/**
	 * Anzeigen einer Debug Nachricht
	 * 
	 * @param TAG
	 *            TAG um die Nachricht zu identifizieren
	 * @param msg
	 *            Text der ausgegeben werden soll
	 */

	public static void d(String TAG, String msg) {
		if (showDebug)
			System.out.println(TAG + " => " + msg);
	}

	/**
	 * Anzeigen einer normalen Info Nachricht
	 * 
	 * @param TAG
	 *            TAG um die Nachricht zu identifizieren
	 * @param msg
	 *            Text der ausgegeben werden soll
	 */

	public static void i(String TAG, String msg) {
		if (showInfo)
			System.out.println(TAG + " => " + msg);
	}

	/**
	 * Anzeigen einer Error Nachricht
	 * 
	 * @param TAG
	 *            TAG um die Nachricht zu identifizieren
	 * @param msg
	 *            Text der ausgegeben werden soll
	 */
	public static void e(String TAG, String msg) {
		if (showError)
			System.out.println(TAG + " => " + msg);
	}

}
