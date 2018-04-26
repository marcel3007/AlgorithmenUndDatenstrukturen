package aufgabe1.model;

import aufgabe1.interfaces.SingleLinkedListInterface;

/**
 * 
 * Klasse zum Erstellen einfach verketteter Listen
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T>
 *            Klassen / Datentyp die die Liste verwaltet
 */
public class SingleLinkedList<T> extends List<T> implements SingleLinkedListInterface<T> {

	@Override
	public void add(T data) {

		Node<T> node = new Node<T>(data);
		insertLast(node);

	}

	@Override
	public void addFirst(T data) {

		Node<T> node = new Node<T>(data);
		insertFirst(node);

	}

	@Override
	public void addLast(T data) {
		Node<T> node = new Node<T>(data);
		insertLast(node);
	}

	@Override
	public void addAll(SingleLinkedList<T> list) {

		removeAll();

		head = list.getHead();
		size = list.getSize();

	}

	@Override
	public boolean remove(int index) {
		// überprüfe die Ränder bzw falsche elementIds
		if (index >= size || index < 0)
			return false;

		// wenn i = 0 dann setze das nächste Element als Kopf
		if (index == 0) {
			head = head.getNext();
			size--;
			return true;
		}

		// finde das zu löschende Element
		// speicher bei jedem Schleifendurchlauf das vorherige Element
		Node<T> predecessor = head;

		for (int i = 0; i < index - 1; i++) {
			predecessor = predecessor.getNext();
		}

		// wenn gefunden dann setze das vorherige Element auf das zu löschende.next()
		// falls das zu löschende Element nicht das letzte ist
		if (index < size - 1)
			predecessor.setNext(predecessor.getNext().getNext());
		else
			predecessor.setNext(null);

		size--;
		return true;
	}

	@Override
	public void removeFirst() {
		remove(0);

	}

	@Override
	public void removeLast() {
		remove(size - 1);

	}

	@Override
	public void removeAll() {

		// setze Kopf auf null, das Freigeben der Objekte übernimmt der Garbage
		// Collector
		head = null;
		size = 0;

	}

	/**
	 * Einfuegen eines Knoten am Anfang der Liste
	 * 
	 * @param node
	 *            Knoten der eingefuegt werden soll
	 */

	private void insertFirst(Node<T> node) {

		// wenn Liste leer

		if (head == null) {
			node.setNext(null);
			head = node;
		}

		// wenn Liste nicht leer
		else {

			// setze neues Element als head und
			// setze den next Pointer des Heads auf den current
			node.setNext(head);
			head = node;
		}

		// erhöhe size um 1
		size++;

	}

	/**
	 * Einfuegen eines Knoten am Ende der Liste
	 * 
	 * @param node
	 *            Knoten der eingefuegt werden soll
	 */

	private void insertLast(Node<T> node) {

		// Vorgänger = aktueller
		Node<T> prev;

		// der letzte Node zeigt immer auf null
		node.setNext(null);

		// wenn Liste noch leer ist
		if (head == null) {
			head = node;
		}

		else {

			// ansonsten gehe bis zum Ende der Liste aber speicher vorher immer den
			// Vorgänger

			Node<T> tmp = prev = head;

			while (tmp != null) {
				prev = tmp;
				tmp = tmp.getNext();
			}

			// setze den nextPointer des letzten Elementes auf das neue Element
			// das neue Element ist nun das Ende und zeigt nach null
			prev.setNext(node);

		}

		// erhöhe size um 1
		size++;

	}

	@Override
	public T get(int index) {

		// überprüfe die Ränder bzw falsche elementIds
		if (index >= size || index < 0)
			return null;

		// wenn Index 0 dann gib den Kopf zurück
		if (index == 0)
			return head.getData();

		// durchlaufe die Liste bis i < elementId und hole das nächste Element als
		// current
		Node<T> current = head;

		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}

		return current.getData();
	}

}
