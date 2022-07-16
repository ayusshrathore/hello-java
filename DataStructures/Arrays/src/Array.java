import java.util.Arrays;

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
        resizeIfRequired();

        array[count++] = value;
    }

    private void resizeIfRequired() {
        if (count == array.length) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public int indexOf(int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num)
                return i;
        }
        return -1;

    }

    // Extend the Array class and add a new method to return the largest
    // number. What is the runtime complexity of this method?

    // Runtime complexity is O(n) since we need to iterate the entire array in order
    // to compare each one of the array element
    public int getLargest() {
        var largest = 0;
        for (var number : array)
            largest = largest < number ? number : largest;

        return largest;
    }

    // Extend the Array class and add a method to return the common items
    // in this array and another array.
    public Array intersect(int[] numbers) {
        Array intersection = new Array(count);

        for (int i = 0; i < count; i++)
            for (int j = 0; j < numbers.length; j++)
                if (array[i] == numbers[j])
                    intersection.insert(array[i]);

        return intersection;
    }

    // alternative way to get intersection
    public Array getIntersection(Array otherArray) {
        var intersection = new Array(count);

        for (int number : array)
            if (otherArray.indexOf(number) >= 0)
                intersection.insert(number);

        return intersection;
    }

    // Extend the Array class and add a method to reverse the array. For
    // example, if the array includes [1, 2, 3, 4], after reversing and printing it,
    // we should see [4, 3, 2, 1].
    public String reverseArray() {
        var first = array[0];
        var last = array[count - 1];
        while (first != array[count - 1] && last != array[0]) {
            for (int i = 0; i < count - 1; i++) {
                var temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
            count--;
        }

        return Arrays.toString(array);
    }

    // alternate reverse method complexity O(n) worst case
    public void reverse() {
        int[] newArray = new int[count];

        for (int i = 0; i < count; i++)
            newArray[i] = array[count - i - 1];

        array = newArray;
    }

    // Extend the Array class and add a new method to insert an item at a given
    // index
    public void insertAt(int number, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        resizeIfRequired();

        for (int i = count; i > index; i--)
            array[i] = array[i - 1];

        array[index] = number;
        count++;
    }

}
