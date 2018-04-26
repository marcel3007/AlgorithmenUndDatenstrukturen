package aufgabe4.lists;


/**
 * 
 * Klasse zum Erstellen eines Listenknotens
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T> Klassen / Datentyp die der Knoten beinhaltet
 */

public class Node<T> {

	private Node<T> next;
	private Node<T> prev;
	private T data;
	
	
	
	
	public Node(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}


	public Node(Node<T> next, Node<T> prev, T data) {
		this.next = next;
		this.prev = prev;
		this.data = data;
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
	public Node<T> getPrev() {
		return prev;
	}
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
