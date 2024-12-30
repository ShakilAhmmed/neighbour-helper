package neighbourhelper.datastructure;

public class Queue {

	private Vector data;

	public Queue() {

		this.data = new Vector(10);
		
	}

	public void push(Object o) {
		
		this.data.addLast(o);
		
	}

	public Object pop() {

		if (this.empty()) {
			return null;
		}
		Object frontElement = this.data.getFirst();
		this.data.removeFirst();
		return frontElement;

	}

	public Object top() {
		
		if (this.empty()) {
			return null;
		}
		
		return this.data.getFirst();
		
	}

	public int size() {
		
		return this.data.size();
		
	}

	public boolean empty() {
		
		return this.data.isEmpty();
		
	}
}
