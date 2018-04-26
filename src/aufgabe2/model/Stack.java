package aufgabe2.model;

import java.util.EmptyStackException;

import aufgabe2.interfaces.Stackable;

public class Stack<T> implements Stackable<T> {

	// Node welches auf das oberste Objekt eines Stack zeigt
	Node<T> head;
	private int size;

	public Stack() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public void push(T data) {

		// neuen Knoten anlegen
		Node<T> newNode = new Node<T>(data);

		// den next Zeiger des neuen Knotens auf den aktuellen Head zeigen lassen
		newNode.setNext(head);

		// den head auf den neuen Knoten referenzieren
		head = newNode;

		// Groesse des Stacks um 1 erhoehen
		size++;
	}

	@Override
	public T pop() {

		// wenn der Stack leer ist soll eine Exeption geworfen werden
		if (isEmpty())
			throw new EmptyStackException();

		// aktuelles oberstes Objekt zwischenspeichern
		T currentData = head.getData();

		// den head auf das nächste Element des aktuellen heads referenzieren
		head = head.getNext();

		// Groesse des Stacks um 1 verringern
		size--;

		// das oberste Objekt zurueckgeben
		return currentData;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void print() {

		// aktueller Knoten ist der Knoten auf den der head zeigt
		Node<T> currentNode = head;

		// durchlaufe, solange der aktuelle Knoten nicht null ist
		while (currentNode != null) {

			// gebe aktuellen Knoten aus
			System.out.println(currentNode.getData());

			// setze aktuellen Knoten auf den Nachfolger
			currentNode = currentNode.getNext();
		}

	}

	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}

}
