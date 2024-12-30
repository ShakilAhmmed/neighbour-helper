package neighbourhelper.datastructure;

public class Stack {

	private Vector data;

	public Stack() {
		this.data = new Vector(10);
	}

	public void push(Object o) {
		this.data.addLast(o);
	}

	public Object pop() {
		if (this.data.isEmpty()) {
			return null;
		}

		Object topElement = this.data.getLast();
		this.data.removeLast();
		return topElement;
	}

	public Object top() {
		if (this.data.isEmpty()) {
			return null;
		}

		return this.data.getLast();
	}

	public int size() {
		return this.data.size();
	}

	public boolean empty() {
		return this.data.isEmpty();
	}
}
