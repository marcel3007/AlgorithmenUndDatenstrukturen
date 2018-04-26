package aufgabe4.hashing;

/**
 * Interface zum Erstellen von Hashtabellen
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T>
 *            Klassen / Datentyp der Hashtabelle
 */

public interface Hashable<T> {

	/**
	 * 
	 * Methode zum Einfuegen eines Objekts in die hashtable
	 * 
	 * @param k
	 *            Objekt das eingefuegt werden soll
	 * @return true, wenn erfolgreich
	 */
	public boolean insert(T k);

	/**
	 * Methode zum Suchen eines Objekts in der hashtable
	 * 
	 * @param k
	 *            Objekt das gesucht werden soll
	 * @return Index / Position in der hashtable, -1 wenn nicht gefunden
	 */
	public Integer find(T k);

	/**
	 * Methode zum Loeschen eines Objekts in der hashtable
	 * 
	 * @param k
	 *            Objekt welches geloescht werden soll
	 * @return true, wenn geloescht
	 */
	public boolean delete(T k);

	/**
	 * Methode zum Ausgeben aller Elemente in der hashtable
	 */
	public void showAllElements();

}
