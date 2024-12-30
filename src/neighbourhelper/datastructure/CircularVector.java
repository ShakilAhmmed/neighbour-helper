package neighbourhelper.datastructure;

public class CircularVector {

	private Vector data;
	private int first;
	private int count;

	public CircularVector() {

		this.count = 0;
		this.first = 0;
		this.data = new Vector(5);

	}

	public int size() {
		return count;
	}

	public void AddFirst(Object element) {

		if (count == data.size()) {
			this.extendCapacity();
		}
		first = (first - 1 + this.data.size()) % this.data.size();
		this.data.set(first, element);
		this.count++;

	}

	public void AddLast(Object element) {

		if (this.count == this.data.size()) {
			this.extendCapacity();
		}
		int lastIndex = (this.first + this.count) % this.data.size();
		this.data.set(lastIndex, element);
		this.count++;

	}

	public Object GetFirst() {

		if (this.count == 0) {
			return null;
		}

		return this.data.get(this.first);

	}

	public Object GetLast() {

		if (this.count == 0) {
			return null;
		}

		int lastIndex = (this.first + this.count - 1) % this.data.size();
		return this.data.get(lastIndex);

	}

	public void RemoveFirst() {

		if (this.count > 0) {
			first = (this.first + 1) % this.data.size();
			this.count--;
		}
	}

	public void extendCapacity() {

		Vector newData = new Vector(this.data.size() * 2);
		for (int cnt = 0; cnt < this.count; cnt++) {
			newData.set(cnt, this.data.get((this.first + cnt) % this.data.size()));
		}
		this.data = newData;
		this.first = 0;

	}

	public void RemoveLast() {

		if (this.count > 0) {
			this.count--;
		}

	}

	public String toString() {
		String s = " [ ";
		for (int i = 0; i < count; i++) {
			int index = (first + i) % data.size();
			s += data.get(index).toString();
			s += " ";
		}
		s += " ] ";
		return s;
	}

}
