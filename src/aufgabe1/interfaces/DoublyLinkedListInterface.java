package aufgabe1.interfaces;

import aufgabe1.model.DoublyLinkedList;

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
	 * Fügt eine Liste zur Liste hinzu und löscht vorher die vorhandenen Elemente
	 * 
	 * @param list
	 *            Liste die hinzugefuegt werden soll
	 */

	public void addAll(DoublyLinkedList<T> list);

}
