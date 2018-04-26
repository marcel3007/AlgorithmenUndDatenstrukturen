package aufgabe1.interfaces;

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
	 * Hinzufugen eines Elements zu einer Liste
	 * 
	 * @param data
	 *            Element, welches in der Liste eingefügt werden soll
	 */

	public void add(T data);

	/**
	 * Hinzufügen eines Elementes vor dem ersten Element
	 * 
	 * @param data
	 *            Element, welches am Anfang der Liste eingefügt werden soll
	 */

	public void addFirst(T data);

	/**
	 * Hinzufügen eines Elementes nach dem letzten Element
	 * 
	 * @param data
	 *            Element, welches am Ende der Liste eingefügt werden soll
	 */

	public void addLast(T data);

	/**
	 * Loeschen eines Elements
	 * 
	 * @param index
	 *            Index der gelöscht werden soll
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
	 * Löschen aller Elemente
	 */

	public void removeAll();

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
	 * @return Anzahl der Listeneinträge
	 */

	public int getSize();

	/**
	 * Information darueber, ob die Liste leer ist oder nicht
	 * 
	 * @return true wenn leer
	 */

	public boolean isEmpty();

}
