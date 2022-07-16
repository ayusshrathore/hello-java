public class HashMaps {
    private class Entry {
        private int key;
        private String value;

        private Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int count = 0;
    private Entry[] entries;

    public HashMaps(int size) {
        this.size = size;
        this.entries = new Entry[size];
    }

    public void put(int key, String value) {
        int index = Hash(key);

        for (int i = 0; i < entries.length; i++) {
            if (entries[index] != null)
                index += 1;
            else {
                entries[index] = new Entry(key, value);
                count++;
                break;
            }
        }

    }

    public String get(int key) {
        var index = Hash(key);

        if (entries[index] == null)
            throw new IllegalStateException("INVALID KEY");

        while (entries[index].key != key)
            index++;
        return entries[index].value;
    }

    public void remove(int key) {
        var index = Hash(key);

        if (entries[index] == null)
            throw new IllegalStateException("INVALID KEY");

        entries[index] = null;
        count--;
    }

    public int size() {
        return count;
    }

    private int Hash(int key) {
        return key % size;
    }

}
