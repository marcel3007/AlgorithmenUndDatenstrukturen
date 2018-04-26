package aufgabe3.interfaces;

public interface Queueable<T> {

	/**
	 * Aus der Java Dokumentation (zur Information):
	 * 
	 * Queues typically, but do not necessarily, order elements in a FIFO
	 * (first-in-first-out) manner. Among the exceptions are priority queues, which
	 * order elements according to a supplied comparator, or the elements' natural
	 * ordering, and LIFO queues (or stacks) which order the elements LIFO
	 * (last-in-first-out). Whatever the ordering used, the head of the queue is
	 * that element which would be removed by a call to remove() or poll(). In a
	 * FIFO queue, all new elements are inserted at the tail of the queue. Other
	 * kinds of queues may use different placement rules. Every Queue implementation
	 * must specify its ordering properties.
	 */

	/**
	 * Fuegt ein Objekt zum Ende Queue hinzu (muss sich hinten anstellen)
	 * 
	 * @param data
	 *            Objekt welches in die Queue hinzugefuegt werden soll
	 */
	public void offer(T data);

	/**
	 * Zurueckgeben und Loeschen des Objekts, welches am laengsten in der Queue ist
	 * 
	 * @return Objekt, welches am laengsten in der Queue ist
	 */
	public T poll();

	/**
	 * Gibt das Element an vorderster Stelle der Queue zurueck aber laesst es in der Queue
	 * @return Objekt am Kopf der Warteschlange
	 */
	public T peek();

	/**
	 * Die aktuelle Queue anzeigen
	 */
	public void print();

	/**
	 * Information darueber, ob die Queue leer ist oder nicht
	 * 
	 * @return true wenn leer
	 */
	public boolean isEmpty();

	/**
	 * Ausgabe der Anzahl der Elemente die in der Queue sind
	 * 
	 * @return Anzahl der Elemente in der Queue
	 */
	public int getSize();

	/**
	 * Leeren der Queue
	 */
	public void clear();
}
