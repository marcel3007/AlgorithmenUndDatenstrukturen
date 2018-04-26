package aufgabe1.interfaces;

import aufgabe1.model.Node;

/**
 *
 * Interface fuer Listen
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T>
 *            Klassen / Datentyp die die Liste verwaltet
 */
public interface ListInterface<T> {

	/**
	 * Ausgabe der Anzahl der Elemente
	 * 
	 * @return Anzahl der Listeneinträge
	 */
	
	public int getSize();

	/**
	 * Gibt an ob die Liste leer ist
	 * 
	 * @return true wenn leer
	 */
	
	public boolean isEmpty();

	/**
	 * Ausgabe der gesammten Liste
	 * 
	 * @return Die gesammte Liste als String
	 */
	public String getAll();

	/**
	 * Gibt den Kopf einer Liste zurück
	 * 
	 * @return Lopf der Liste
	 */
	public Node<T> getHead();

}
