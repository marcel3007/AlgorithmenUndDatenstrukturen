package aufgabe3.tests;

import java.util.EmptyStackException;

import aufgabe3.helper.Log;
import aufgabe3.model.Stack;

public class StackTest {

	private static final String TAG = StackTest.class.getSimpleName();

	public static void main(String[] args) {

		Stack<Integer> s = new Stack<>();

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		Log.d(TAG, "printSatck: ");
		s.print();

		Log.d(TAG, "pop: " + s.pop());

		Log.d(TAG, "printSatck: ");
		s.print();

		Log.d(TAG, "pop: " + s.pop());

		Log.d(TAG, "printSatck: ");
		s.print();

		Log.d(TAG, "pop: " + s.pop());

		Log.d(TAG, "printSatck: ");
		s.print();

		Log.d(TAG, "pop: " + s.pop());

		Log.d(TAG, "printSatck: ");
		s.print();

		try {
			Log.d(TAG, "pop: " + s.pop());
		} catch (EmptyStackException e) {
			Log.d(TAG, e.toString());
		}

		Log.d(TAG, "printSatck: ");
		s.print();

	}

}
