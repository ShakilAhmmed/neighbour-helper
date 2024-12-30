package neighbourhelper.datastructure;

import java.util.Comparator;

public class PriorityQueue {

	private class PriorityPair implements Comparable {
		private Object element;
		private Object priority;

		public PriorityPair(Object element, Object priority) {
			this.element = element;
			this.priority = priority;
		}

		public Object getElement() {
			return element;
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}
	}

	private LinkedList data;

	public PriorityQueue() {
		this.data = new LinkedList();
	}

	public void push(Object o, int priority) {
		PriorityPair pair = new PriorityPair(o, priority);
		this.data.addSorted(pair);
	}

	public Object pop() {
		if (data.size() == 0) {
			return null;
		}
		Object element = ((PriorityPair) data.getFirst()).getElement();
		data.addFirst(null); // Effectively removing the first element
		return element;
	}

	public Object top() {
		if (data.size() == 0) {
			return null;
		}
		return ((PriorityPair) data.getFirst()).getElement();

	}
}
