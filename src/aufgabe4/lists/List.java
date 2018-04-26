package aufgabe4.lists;

import aufgabe4.lists.ListInterface;

/**
 * Klasse zum Erstellen einer Listen
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 * @param <T> Klassen / Datentyp die die Liste verwaltet
 */

public class List<T> implements ListInterface<T>{
	
	protected Node<T> head;
	protected int size;
	
	public List() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}


	

	@Override
	public String getAll() {
		if (head == null)
			return "Keine Elemente in der Liste vorhanden!";

		// erstelle einen neuen StringBuffer
		StringBuffer sb = new StringBuffer();

		Node<T> tmp = head;

		// durchlaufe solange tmp != null, also bis das Ende der Liste erreicht ist
		while (tmp != null) {

			// hänge bei jedem Durchgang das aktuelle Element als String an den buffer an
			sb.append(tmp.getData());
			sb.append("\n");

			// hole das nächste Element
			tmp = tmp.getNext();
		}

		return sb.toString();
	}

	@Override
	public Node<T> getHead() {
		return head;
	}



}
