package aufgabe3.model;

import aufgabe3.interfaces.Queueable;

public class Queue<T> implements Queueable<T> {
	
	// Node welches auf das oberste Objekt eines Stack zeigt
	Node<T> head, tail;
	private int size;

	public Queue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
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
			currentNode = currentNode.getPrev();
		}

	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void offer(T data) {
		// neuen Knoten anlegen
		Node<T> newNode = new Node<T>(data);

		// Fall 1: Queue ist leer
		if(isEmpty()) {
			head = tail = newNode;
			newNode.setPrev(null);
		} else {
			tail.setPrev(newNode);
			newNode.setPrev(null);
			tail = newNode;
		}
				
		// Groesse um 1 erhoehen
		size++;

	}

	@Override
	public T poll() {

		// wenn die Queue leer ist soll null zurueckgegeben werden
		if (isEmpty())
			return null;

		// aktuelles oberstes Objekt zwischenspeichern
		T currentData = head.getData();

		// den head auf das nächste Element des aktuellen heads referenzieren
		head = head.getPrev();

		// Groesse des Stacks um 1 verringern
		size--;

		// das oberste Objekt zurueckgeben
		return currentData;
	}

	@Override
	public T peek() {

		// wenn die Queue leer ist soll null zurueckgegeben werden
		if (isEmpty())
			return null;

		// aktuelles oberstes Objekt zwischenspeichern
		T currentData = head.getData();

		return currentData;
	}

}
