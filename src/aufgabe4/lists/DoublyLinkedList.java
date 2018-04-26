package aufgabe4.lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import aufgabe4.lists.DoublyLinkedListInterface;

/**
 * Klasse zum Erstellen doppelt verketteter Listen
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T>
 *            Klassen / Datentyp die die Liste verwaltet
 */
public class DoublyLinkedList<T> extends List<T> implements DoublyLinkedListInterface<T>, Iterable<T> {

	private Node<T> tail;

	/**
	 * Rueckgabe des letztens Knotens
	 * 
	 * @return letzen Knoten
	 */

	public Node<T> getTail() {
		return tail;
	}

	/**
	 * Setzen des letzten Knotens
	 * 
	 * @param tail
	 *            Knoten der an das Ende der Liste gesetzt werden soll
	 */

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

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
	public void addAll(DoublyLinkedList<T> list) {

		removeAll();

		head = list.getHead();
		tail = list.getTail();
		size = list.getSize();

	}

	@Override
	public boolean remove(int index) {

		// überprüfe die Ränder bzw falsche elementIds
		if (index >= size || index < 0)
			return false;

		// wenn i = 0 dann setze das nächste Element als Kopf
		if (index == 0) {
			head.getNext().setPrev(null);
			head = head.getNext();
			size--;
			return true;
		}

		// letzte Element
		if (index == size - 1) {
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
			size--;
			return true;
		}

		// ueberpruefe von welcher Sete es schneller ist
		// Bsp: n = 1000, index = 999, dann gehe von hinten zum Element

		Node<T> prev;

		// von vorne
		// Bsp n = 101, index = 40 -> 101-40=61 -> 61 >101/2=50
		if (size - index > size / 2) {

			// finde das zu löschende Element
			prev = head;

			// traversiere bis zum Node davor
			for (int i = 0; i < index - 1; i++) {
				prev = prev.getNext();
			}

			// wenn gefunden dann setze das vorherige Element auf das zu löschende.next()
			// falls das zu löschende Element nicht das letzte ist

			delete(prev);

		} else {
			// von hinten
			prev = tail;
			int steps = size - index;
			for (int i = 0; i < steps; i++) {
				prev = prev.getPrev();
			}

			delete(prev);

		}
		size--;

		return true;

	}

	/**
	 * Loeschen eines Knotens
	 * 
	 * @param prev
	 *            Knoten der vor dem zu loeschenden Knoten ist
	 */

	private void delete(Node<T> prev) {
		Node<T> tmp = prev.getNext().getNext();
		tmp.setPrev(prev);
		prev.setNext(tmp);
	}

	public void removeNode(Node<T> node) {
		Node<T> prev = node.getPrev();
		Node<T> next = node.getNext();

		if (head == node)
			head = next;

		if (tail == node)
			tail = prev;

		if (prev != null) {
			prev.setNext(next);

		}

		if (next != null) {
			next.setPrev(prev);
		}

		size--;
	}

	/**
	 * Loeschen des ersten Knotens
	 */

	@Override
	public void removeFirst() {
		remove(0);

	}

	/**
	 * Loeschen des letzten Knotens
	 */

	@Override
	public void removeLast() {

		remove(size - 1);

	}

	/**
	 * Alle Knoten loeschen bzw Liste leeren
	 */
	@Override
	public void removeAll() {

		// setze Kopf und Tail auf null, das Freigeben der Objekte übernimmt der Garbage
		// Collector
		head = null;
		tail = null;
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
			node.setPrev(null);
			head = node;
			tail = node;
		}

		// wenn Liste nicht leer
		else {

			// setze den next Pointer des neuen Heads auf den ehemaligen Head
			node.setNext(head);

			// setze den prev Pointer vom ehemaligen Head auf den neuen Head
			head.setPrev(node);

			// setze den neuen Knoten als Head
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

		// wenn Head leer, dann befinden wir uns bereits am Ende
		if (head == null) {
			head = node;
			tail = node;
		} else {

			tail.setNext(node);

			node.setPrev(tail);
			node.setNext(null);

			tail = node;
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
		// wenn Index = letzter, dann gib den letzten Knoten zurueck
		if (index == size - 1)
			return tail.getData();

		// ueberpruefe von welcher Seite es schneller ist
		// Bsp: n = 1000, index = 999, dann gehe von hinten zum Element

		Node<T> current;

		// von vorne
		// Bsp n = 101, index = 40 -> 101-40=61 -> 61 >101/2=50
		if (size - index > size / 2) {

			current = head;

			// durchlaufe die Liste bis i < index und hole den naechsten Knoten als
			// current
			// traversiere bis zum Node davor
			for (int i = 0; i <= index - 1; i++) {
				current = current.getNext();
			}

			// wenn gefunden dann gebe es zurueck

			return current.getData();

		} else {
			// von hinten
			current = tail;
			int steps = size - index - 1;
			for (int i = 0; i < steps; i++) {
				current = current.getPrev();
			}

			// wenn gefunden dann gebe es zurueck
			return current.getData();

		}

	}

	@Override
	public void clear() {
		removeAll();
	}

	@Override
	public Iterator<T> iterator() {
		if (isEmpty()) {
			return Collections.<T>emptyList().iterator();
		}
		return new Iterator<T>() {
			private Node<T> currentNode = null;

			@Override
			public boolean hasNext() {
				return currentNode != getTail();
			}

			@Override
			public T next() {
				if (currentNode == null) {
					currentNode = getHead();
					return currentNode.getData();
				}
				if (currentNode.getNext() == null) {
					throw new NoSuchElementException();
				}
				currentNode = currentNode.getNext();
				return currentNode.getData();
			}

			@Override
			public void remove() {

				if (currentNode == null) {
					throw new NoSuchElementException();
				}

				removeNode(currentNode);
			}

		};
	}

	@Override
	public String toString() {

		Iterator<T> it = iterator();
		if (!it.hasNext())
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (;;) {
			T t = it.next();
			sb.append(t);
			if (!it.hasNext())
				return sb.append(']').toString();
			sb.append(", ");
		}
	}

}
