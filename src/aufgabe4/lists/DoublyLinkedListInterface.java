package aufgabe4.lists;

import aufgabe4.lists.DoublyLinkedList;

/**
 * Interface fuer doppelt verkettete Listen
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T>
 *            Klassen / Datentyp die die Liste verwaltet
 */
public interface DoublyLinkedListInterface<T> extends LinkedListInterface<T> {

	/**
	 * Fuegt eine Liste zur Liste hinzu und loescht vorher die vorhandenen Elemente
	 * 
	 * @param list
	 *            Liste die hinzugefuegt werden soll
	 */

	public void addAll(DoublyLinkedList<T> list);

}
