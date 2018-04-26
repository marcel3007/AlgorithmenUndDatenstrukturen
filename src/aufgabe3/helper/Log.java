package aufgabe3.helper;

public class Log {
	
	private static boolean showDebug = true;
	private static boolean showError = true;

	public Log() {
	}

	/**
	 * Anzeigen einer Debug Nachricht
	 * 
	 * @param tag
	 *            TAG um die Nachricht zu identifizieren
	 * @param msg
	 *            Text der ausgegeben werden soll
	 */

	public static void d(String tag, String msg) {
		if(showDebug)
			System.out.println(tag + " => " + msg);
	}

	/**
	 * Anzeigen einer Error Nachricht
	 * 
	 * @param tag
	 *            TAG um die Nachricht zu identifizieren
	 * @param msg
	 *            Text der ausgegeben werden soll
	 */
	public static void e(String tag, String msg) {
		if(showError)
			System.out.println(tag + " => " + msg);
	}

}
