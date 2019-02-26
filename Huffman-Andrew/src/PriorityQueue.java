import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
	
	private ArrayList<T> queue;

	public PriorityQueue() {
		queue = new ArrayList<T>(8);
	}
	/**
	 * Peeks at the first element in the queue
	 * @return the first element in the queue
	 */
	public T peek() {
		return queue.get(0);
	}
	/**
	 * Checks if the queue is empty
	 * @return whether or not the queue is empty
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	/**
	 * adds data to the queue
	 * @param data the data to be added
	 */
	public void add(T data) {
		queue.add(data);
		heapifyUp((queue.size()-1));
	}

	private void heapifyUp(int loc) {
		if (loc > -1 && queue.get(loc).compareTo(queue.get((loc-1)/2)) == 1) {
			T a = queue.get(loc);
			queue.set(loc, queue.get((loc-1)/2));
			queue.set(((loc-1)/2), a);
			heapifyUp((loc-1)/2);
		}
	}
	
	/**
	 * Removes the first element in the Priority Queue and returns it
	 * @return the first element in the Priority Queue
	 */
	public T remove() {
		if (!isEmpty()) {
			T a = queue.get(0);
			queue.set(0, queue.get(queue.size()-1));
			queue.remove(queue.size()-1);
			heapifyDown(0);
			return a;
		}
		return null;
	}
	
	private void heapifyDown(int loc) {
		int dir;
		int l = 2*loc+1;
		int r = 2*loc+2;
		
		if (r < queue.size()) {
			
			if (queue.get(loc).compareTo(queue.get(l)) == -1) {
				dir = l;
			}
			else {
				dir = loc;
			} 
			if (queue.get(dir).compareTo(queue.get(r)) == -1) {
				dir = r;
			}
			
			if (dir != loc) {
				T a = queue.get(loc);
				queue.set(loc, queue.get(dir));
				queue.set(dir, a);
				heapifyDown(dir);
			}
		}
		else if (l < queue.size()) {
			if (queue.get(loc).compareTo(queue.get(l)) == -1) {
				dir = l;
			}
			else {
				dir = loc;
			}
			if (dir != loc) {
				T a = queue.get(loc);
				queue.set(loc, queue.get(dir));
				queue.set(dir, a);
				heapifyDown(dir);
			}
		}
	}

	/**
	 * Returns the size of the Priority Queue
	 * @return the size of the Priority Queue
	 */
	public int size() {
		return queue.size();
	}

	@Override
	public String toString() {
		return queue.toString();
	}
	
}
