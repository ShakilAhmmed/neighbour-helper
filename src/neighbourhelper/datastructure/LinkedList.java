package neighbourhelper.datastructure;

public class LinkedList {

	private class ListElement {

		private Comparable el1;
		private ListElement el2;

		public ListElement(Comparable el1, ListElement nextElement) {

			this.el1 = el1;
			this.el2 = nextElement;

		}

		public ListElement(Comparable el2) {

			this(el2, null);

		}

		public Comparable first() {

			return el1;

		}

		public ListElement rest() {

			return el2;

		}

		public void setFirst(Comparable value) {

			this.el1 = value;

		}

		public void setRest(ListElement value) {

			this.el2 = value;

		}
	}

	private ListElement head;

	public LinkedList() {

		this.head = null;

	}

	public void addFirst(Comparable o) {

		this.head = new ListElement(o, this.head);

	}

	public void addLast(Comparable o) {

		ListElement newElement = new ListElement(o, null);
		ListElement current = this.head;
		while (current.rest() != null) {
			current = current.rest();
		}
		current.setRest(newElement);

	}

	public Comparable getFirst() {

		return this.head.first();

	}

	public void set(int n, Comparable o) {

		ListElement newElement = new ListElement(o, null);
		ListElement current = this.head;
		while (n > 0) {
			current = current.rest();
			n--;
		}
		current.el1 = newElement.el1;
		newElement.el2 = current.el2;

	}

	public Comparable getLast() {

		ListElement current = this.head;
		while (current.rest() != null) {
			current = current.rest();
		}
		return current.el1;

	}

	public void reverse() {

		ListElement current = this.head;
		ListElement prev = null;
		ListElement next = null;
		while (current != null) {
			next = current.el2;

			current.el2 = prev;
			prev = current;
			current = next;
		}
		this.head = prev;

	}

	public void fropple() {

		if (this.head != null || this.head.rest() != null) {
			return;
		}

		ListElement prev = null;
		ListElement current = this.head;
		this.head = current.rest();

		while (current != null && current.rest() != null) {
			ListElement nextPair = current.rest().rest();
			ListElement second = current.rest();

			// Swap the nodes
			second.setRest(current);
			current.setRest(nextPair);

			if (prev != null) {
				prev.setRest(second);
			}

			// Move pointers forward
			prev = current;
			current = nextPair;
		}

	}

	public void append(LinkedList list2) {

		if (this.head == null) {
			this.head = list2.head;
			return;
		}

		ListElement current = this.head;
		while (current.rest() != null) {
			current = current.rest();
		}

		ListElement current2 = list2.head;
		while (current2 != null) {
			this.addLast(current2.first());
			current2 = current2.rest();
		}

	}

	public Comparable isExists(Comparable o) {

		ListElement current = this.head;
		while (current.rest() != null) {
			if (current.el1.equals(o)) {
				return current.el1;
			}
			current = current.rest();
		}
		return null;

	}

	public Comparable get(int n) {

		ListElement d = this.head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.el1;

	}

	public int size() {

		ListElement d = this.head;
		int count = 0;
		while (d.rest() != null) {
			d = d.rest();
			count++;
		}
		return count;

	}

	public void addSorted(Comparable o) {
		// an empty list , add element in front
		if (head == null)
			head = new ListElement(o, null);
		else if (head.first().compareTo(o) > 0) {
			// we have to add the element in front
			head = new ListElement(o, head);
		} else {
			// we have to find the first element which is bigger
			ListElement d = head;
			while ((d.rest() != null) && (d.rest().first().compareTo(o) < 0)) {
				d = d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(o, next));
		}
	}

	public String toString() {

		String s = "(";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		s += ")";
		return s;

	}
}
