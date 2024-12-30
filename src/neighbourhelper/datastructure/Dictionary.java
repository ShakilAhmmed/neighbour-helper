package neighbourhelper.datastructure;

public class Dictionary {

	private class DictionaryPair implements Comparable {
		private Object key;
		private Object value;

		public DictionaryPair(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getKey() {
			return this.key;
		}

		public void setKey(Object key) {
			this.key = key;
		}

		public Object getValue() {
			return this.value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		@Override
		public int compareTo(Object o) {
			DictionaryPair dictionaryPair = (DictionaryPair) o;
			return ((Comparable) dictionaryPair.getKey()).compareTo(((DictionaryPair) o).getKey());
		}
	}

	private Vector data;

	public Dictionary() {

		this.data = new Vector(10);
	}

	public void add(Object key, Object value) {

		int position = this.findPosition(key);

		if (position != -1) {
			DictionaryPair existingPair = (DictionaryPair) this.data.get(position);
			existingPair.setValue(value);
		} else {
			this.data.addLast(new DictionaryPair(key, value));
		}

	}

	public int findPosition(Object key) {

		for (int count = 0; count < data.size(); count++) {
			DictionaryPair pair = (DictionaryPair) data.get(count);
			if (pair.getKey().equals(key)) {
				return count;
			}
		}
		return -1; // Key not found
	}

	public Object find(Object key) {

		int position = this.findPosition(key);
		if (position != -1) {
			return ((DictionaryPair) this.data.get(position)).getValue();
		}
		return null;

	}

	public void removeKey(Object key) {

		int position = this.findPosition(key);
		if (position != -1) {
			this.data.removeAt(position); // Remove the key-value pair at the found index
		}

	}

	public int size() {

		return this.data.size();

	}
}
