package aufgabe3.interfaces;

public interface Stackable<T> {

	/**
	 * Einfuegen eines neuen Objekts auf den Stack
	 * 
	 * @param data
	 *            Objekt welches auf den Stack gelegt werden soll
	 */
	public void push(T data);

	/**
	 * Zurueckgeben des obersten Objekts auf dem Stack
	 * 
	 * @return Objekt welches an erster Position auf dem Stack liegt
	 */
	public T pop();

	/**
	 * Den aktuellen Stack anzeigen lassen
	 */
	public void print();

	/**
	 * Information darueber, ob der Stack leer ist oder nicht
	 * 
	 * @return true wenn leer
	 */
	public boolean isEmpty();

	/**
	 * Ausgabe der Anzahl der Elemente die im Stack sind
	 * 
	 * @return Anzahl der Elemente im Stack
	 */
	public int getSize();

	/**
	 * Leeren des Stacks
	 */
	public void clear();
}
