package aufgabe1.interfaces;

import aufgabe1.model.SingleLinkedList;
/**
 * 
 * Interface fuer einfach verkettete Listen
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T> Klassen / Datentyp die die Liste verwaltet
 */
public interface SingleLinkedListInterface<T> extends LinkedListInterface<T> {
	
	/**
	 * Fügt eine Liste zur Liste hinzu und löscht vorher die vorhandenen Elemente
	 * 
	 * @param list
	 *            Liste die hinzugefügt werden soll
	 */
	
	public void addAll(SingleLinkedList<T> list);
	

	
}
