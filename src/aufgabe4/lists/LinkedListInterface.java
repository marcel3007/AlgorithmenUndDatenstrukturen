package aufgabe4.lists;

/**
 * 
 * Interface fuer verkettete Listen
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T>
 *            Klassen / Datentyp die die Liste verwaltet
 */
public interface LinkedListInterface<T> {

	/**
	 * Hinzufuegen eines Elements zu einer Liste
	 * 
	 * @param data
	 *            Element, welches in der Liste eingefuegt werden soll
	 */

	public void add(T data);

	/**
	 * Hinzufuegen eines Elementes vor dem ersten Element
	 * 
	 * @param data
	 *            Element, welches am Anfang der Liste eingefuegt werden soll
	 */

	public void addFirst(T data);

	/**
	 * Hinzufuegen eines Elementes nach dem letzten Element
	 * 
	 * @param data
	 *            Element, welches am Ende der Liste eingefuegt werden soll
	 */

	public void addLast(T data);

	/**
	 * Loeschen eines Elements
	 * 
	 * @param index
	 *            Index der geloescht werden soll
	 * @return true, wenn erfolgreich
	 */

	public boolean remove(int index);

	/**
	 * Loeschen des ersten Elements
	 */

	public void removeFirst();

	/**
	 * Loeschen des letzten Elements
	 */

	public void removeLast();

	/**
	 * Loeschen aller Elemente
	 */

	public void removeAll();

	/**
	 * Loeschen aller Elemente
	 */

	public void clear();

	/**
	 * Ausgabe eines Elements der Liste
	 * 
	 * @param index
	 *            Index des Elemetes
	 * @return Element
	 */
	

	public T get(int index);

	/**
	 * Ausgabe der Anzahl der Elemente
	 * 
	 * @return Anzahl der Listeneintraege
	 */

	public int getSize();

	/**
	 * Information darueber, ob die Liste leer ist oder nicht
	 * 
	 * @return true wenn leer
	 */

	public boolean isEmpty();


}
