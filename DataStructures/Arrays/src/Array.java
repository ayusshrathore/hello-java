public class Array {
    public int[] array;
    public int count = 0;

    public Array(int size) {
        array = new int[size];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void insert(int value) {
        if (count == array.length) {
            int[] newArray = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[count] = value;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

}
