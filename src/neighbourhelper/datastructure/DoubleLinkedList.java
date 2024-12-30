package neighbourhelper.datastructure;

public class DoubleLinkedList {

	private class DoubleLinkedListElement {

		private Comparable data;

		private DoubleLinkedListElement nextElement;

		private DoubleLinkedListElement previousElement;

		public DoubleLinkedListElement(Comparable data, DoubleLinkedListElement next, DoubleLinkedListElement previous) {

			this.data = data;
			this.nextElement = next;
			this.previousElement = previous;
			if (nextElement != null) {
				nextElement.previousElement = this;
			}
			if (previousElement != null) {
				previousElement.nextElement = this;
			}

		}

		public DoubleLinkedListElement(Comparable data) {

			this(data, null, null);

		}

		public DoubleLinkedListElement previous() {

			return previousElement;

		}

		public Comparable value() {

			return data;

		}

		public DoubleLinkedListElement next() {

			return nextElement;

		}

		public void setNext(DoubleLinkedListElement value) {

			this.nextElement = value;

		}

		public void setPrevious(DoubleLinkedListElement value) {

			this.previousElement = value;

		}
	}

	private int count;
	private DoubleLinkedListElement head;
	private DoubleLinkedListElement tail;

	public DoubleLinkedList() {

		head = null;
		tail = null;
		count = 0;

	}

	public Comparable getFirst() {

		return head.value();

	}

	public Comparable getLast() {

		return tail.value();

	}

	public int size() {

		return count;

	}

	public void addFirst(Comparable value) {

		head = new DoubleLinkedListElement(value, head, null);
		if (tail == null) {
			tail = head;
		}
		count++;

	}

	public void addLast(Comparable value) {

		tail = new DoubleLinkedListElement(value, null, tail);
		if (head == null) {
			head = tail;
		}
		count++;

	}

	public void printReverse() {

		StringBuilder s = new StringBuilder("(");
		DoubleLinkedListElement d = tail;
		while (d != null) {
			s.append(d.value().toString()).append(" ");
			d = d.previous();
		}
		s.append(")");
		System.out.println("Reversed List: " + s);

	}

	public void removeLast() {

		if (this.tail == null) {
			return;
		}

		tail = tail.previous();
		if (tail == null) {
			head = null;
		} else {
			tail.setNext(null);
		}

		count--;

	}

	@Override
	public String toString() {

		StringBuilder s = new StringBuilder("(");
		DoubleLinkedListElement d = head;
		while (d != null) {
			s.append(d.value().toString()).append(" ");
			d = d.next();
		}
		s.append(")");
		return s.toString();

	}
}
