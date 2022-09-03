import java.util.LinkedList;

public class HashTables {
	private int size;
	private int count = 0;
	private LinkedList<Entry>[] entries;

	@SuppressWarnings("unchecked")
	public HashTables(int size) {
		this.size = size;
		this.entries = new LinkedList[size];
	}

	private class Entry {
		private int key;
		private String value;

		private Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	public void put(int key, String value) {
		var index = hash(key);
		if (entries[index] == null)
			entries[index] = new LinkedList<>();

		var bucket = entries[index];
		for (var entry : bucket)
			if (entry.key == key) {
				entry.value = value;
				return;
			}
		bucket.add(new Entry(key, value));
		count++;
	}

	public String get(int key) {
		var index = hash(key);
		LinkedList<Entry> list = getListAtIndex(index);

		for (var ele : list)
			if (ele.key == key)
				return ele.value;

		throw new IllegalArgumentException("INVALID KEY");
	}

	private LinkedList<Entry> getListAtIndex(int index) {
		LinkedList<Entry> list = new LinkedList<>();

		for (int i = 0; i < entries.length; i++)
			if (index == i && entries[i] != null)
				list = entries[i];
		return list;
	}

	public int size() {
		return count = count > 0 ? count : 0;
	}

	public void remove(int key) {
		var index = hash(key);
		LinkedList<Entry> list = getListAtIndex(index);

		if (list.isEmpty())
			throw new IllegalArgumentException("INVALID KEY");

		for (var ele : list)
			if (ele.key == key) {
				list.remove(ele);
				count--;
				return;
			}
		throw new IllegalArgumentException("INVALID KEY");
	}

	private int hash(int number) {
		return number % size;
	}
}