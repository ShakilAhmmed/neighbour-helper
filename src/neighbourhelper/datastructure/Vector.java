package neighbourhelper.datastructure;

public class Vector {

	private Object data[];
	private int count;
	private int capacity;

	public Vector(int capacity) {

		this.data = new Object[capacity];
		this.count = 0;
		this.capacity = capacity;

	}

	public Object get(int index) {

		return this.data[index];

	}

	public void addFirst(Object o) {

		if (this.count == this.capacity) {
			this.extendCapacity();
		}
		this.count++;
		for (int i = this.count; i >= 0; i--) {
			this.set(i + 1, this.data[i]);
		}
		this.set(0, o);

	}

	public void addLast(Object o) {

		if (this.count == this.capacity) {
			this.extendCapacity();
		}
		this.data[this.count++] = o;

	}

	public void set(int index, Object o) {

		this.data[index] = o;

	}

	public int size() {

		return this.count;

	}

	public boolean isEmpty() {

		return this.count == 0;

	}

	public boolean contains(Object obj) {

		for (int i = 0; i < count; i++) {
			if (this.data[i].equals(obj))
				return true;
		}
		return false;
	}

//	public boolean binarySearch(Object key) {
//
//		int start = 0;
//		int end = count - 1;
//		while (start <= end) {
//			int middle = (start + end + 1) / 2;
//			if (key < this.data[middle])
//				end = middle - 1;
//			else if (key > this.data[middle])
//				start = middle + 1;
//			else
//				return true;
//		}
//		return false;
//	}

	public Object getFirst() {

		return this.data[0];

	}

	public Object getLast() {

		return this.data[this.count - 1];

	}

	public void removeFirst() {

		for (int i = 1; i <= this.count; i++) {
			this.set(i - 1, this.data[i]);
		}
		this.count--;

	}

	public void removeAt(int index) {

		if (index < 0 || index >= this.count) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		for (int i = index; i < this.count - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
		this.data[this.count - 1] = null; // Clear the last element
		this.count--;

	}

	public void removeLast() {

		this.count--;

	}

	public void reverse() {

		int firstPointer = 0;
		int lastPointer = this.count - 1;
		while (firstPointer <= lastPointer) {
			Object temp = this.data[firstPointer];
			this.data[firstPointer] = this.data[lastPointer];
			this.data[lastPointer] = temp;
			firstPointer++;
			lastPointer--;
		}

	}

	public Vector repeat() {

		Vector vector = new Vector(this.count * 2);
		for (int i = 0; i < this.count; i++) {
			vector.addLast(this.data[i]);
			vector.addLast(this.data[i]);
		}
		return vector;

	}

	public Vector interleave(Vector vector) {

		Vector interLeaveVector = new Vector(this.count + vector.size());
		int i = 0;
		int j = 0;
		while (i < this.size() && j < vector.size()) {
			interLeaveVector.addLast(this.get(i++));
			interLeaveVector.addLast(vector.get(j++));
		}

		while (i < this.size()) {
			interLeaveVector.addLast(this.get(i++));
		}
		while (j < vector.size()) {
			interLeaveVector.addLast(vector.get(j++));
		}

		return interLeaveVector;

	}

	private void extendCapacity() {

		Object[] data2 = new Object[this.capacity * 2];
		for (int i = 0; i < this.count; i++) {
			data2[i] = this.data[i];
		}
		this.data = data2;

	}

	public String toString() {

		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < this.count; i++) {
			s.append(" " + this.data[i] + "\n");
		}
		s.append("]");
		return s.toString();

	}

}
