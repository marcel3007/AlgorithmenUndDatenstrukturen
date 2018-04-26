package aufgabe3.tests;


import aufgabe3.helper.Log;
import aufgabe3.model.Queue;

public class QueueTest {

	private static final String TAG = QueueTest.class.getSimpleName();
	
	public static void main(String[] args) {
		
		Queue<Integer> q = new Queue<>();
		
		q.offer(1);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		q.print();
		
		Log.d(TAG, "Poll: " + q.poll());
		Log.d(TAG, "Poll: " + q.poll());
		Log.d(TAG, "Poll: " + q.poll());
		Log.d(TAG, "Poll: " + q.poll());

		q.print();
		
		q.offer(1);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		q.print();
		
	}

}
