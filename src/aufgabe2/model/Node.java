package aufgabe2.model;

/**
 * 
 * Klasse zum Erstellen eines Knotens
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 * @param <T>
 *            Klassen / Datentyp die der Knoten beinhaltet
 */

public class Node<T> {

	private Node<T> next;
	private T data;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	public Node(Node<T> next, T data) {
		this.next = next;
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
