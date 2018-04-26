package aufgabe1.view;

import aufgabe1.algorithmen.BubbleSort;
import aufgabe1.enums.RandomOption;
import aufgabe1.enums.SortOptions;
import aufgabe1.model.DoublyLinkedList;
import aufgabe1.model.RandomNames;
import aufgabe1.model.Student;

public class DoublyLinkedListTest {

	/**
	 * Testprogramm fuer die doppelt verkettete Liste
	 * @param args Argumente
	 */
	public static void main(String[] args) {
		
		// neue doppelt verkettete Liste erstellen
		DoublyLinkedList<Student> list = new DoublyLinkedList<>();
		
		// Elemente jeweils am Anfangder Liste einfuegen, das heisst das zuletzt eingefuegte Element steht am Anfang der Liste
		list.addFirst(new Student(0, RandomNames.getRandom(RandomOption.PRENAME), RandomNames.getRandom(RandomOption.LASTNAME), RandomNames.getRandom(RandomOption.COURSE)));		
		list.addFirst(new Student(1, RandomNames.getRandom(RandomOption.PRENAME), RandomNames.getRandom(RandomOption.LASTNAME), RandomNames.getRandom(RandomOption.COURSE)));		
		list.addFirst(new Student(2, RandomNames.getRandom(RandomOption.PRENAME), RandomNames.getRandom(RandomOption.LASTNAME), RandomNames.getRandom(RandomOption.COURSE)));		
		list.addFirst(new Student(3, RandomNames.getRandom(RandomOption.PRENAME), RandomNames.getRandom(RandomOption.LASTNAME), RandomNames.getRandom(RandomOption.COURSE)));		
		list.addFirst(new Student(4, RandomNames.getRandom(RandomOption.PRENAME), RandomNames.getRandom(RandomOption.LASTNAME), RandomNames.getRandom(RandomOption.COURSE)));				
		list.addFirst(new Student(5, RandomNames.getRandom(RandomOption.PRENAME), RandomNames.getRandom(RandomOption.LASTNAME), RandomNames.getRandom(RandomOption.COURSE)));		
		list.addFirst(new Student(6, RandomNames.getRandom(RandomOption.PRENAME), RandomNames.getRandom(RandomOption.LASTNAME), RandomNames.getRandom(RandomOption.COURSE)));		

		// Ausgabe eines einzelnen Elements
		System.out.println("Ausgabe eines Elements");
		System.out.println(list.get(1).toString());

		System.out.println();

		// Ausgabe der gesammten Liste
		System.out.println("Ausgabe der gesammten Liste");
		System.out.println(list.getAll());

		// Sortierung nach Matrikelnr mittels BubbleSort
		System.out.println("BubbleSort - Matrikelnr");
		BubbleSort.sort(list, SortOptions.Matrikelnr);

		// erneute ausgabe der gesammten Liste, nach der Sortierung
		System.out.println("Ausgabe der gesammten Liste nach dem Sortiervorgang");
		System.out.println(list.getAll());
		


	}

}
