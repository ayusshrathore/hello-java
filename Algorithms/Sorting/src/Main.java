import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {

        /**
         * Bubble sort
         */
        System.out.println(Arrays.toString(bubbleSort(new int[] { 4, 1, 5, 8, 9, 3 })));

        /**
         * Selection sort
         */
        System.out.println(Arrays.toString(selectionSort(new int[] { 4, 1, 5, 8, 9, 3 })));

        /**
         * Insertion sort
         */
        System.out.println(Arrays.toString(insertionSort(new int[] {})));

        /**
         * Merge sort
         */
        sort(new int[] { 4, 1, 5, 8, 9, 3 });

        /**
         * Quick sort
         */
        System.out.println(Arrays.toString(quickSort(new int[] { 4, 1, 5, 8, 9, 3 }, 0, 5)));

        /**
         * Counting Sort
         */
        System.out.println(Arrays.toString(countingSort(new int[] { 4, 1, 5, 8, 3 }, 9)));

        /**
         * Bucket sort
         */
        System.out.println(Arrays.toString(bucketSort(new int[] { 4, 1, 5, 8, 9, 3 })));

    }

    static int[] bubbleSort(int[] array) {
        int size = array.length;
        boolean sorted = true;

        while (size != 1) {
            for (int i = 0; i < size - 1; i++)
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            if (sorted == !sorted)
                break;
            size--;
        }

        return array;
    }

    static int[] selectionSort(int[] array) {
        // 4, 1, 5, 8, 9, 3
        // 4 1 3 2
        // 1 4 3 2
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++)
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            int item = array[i];
            array[i] = array[minIndex];
            array[minIndex] = item;
        }

        return array;
    }

    static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            // 4, 1, 5, 8, 9, 3
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }

        return array;
    }

    static void sort(int[] array) {
        if (array.length < 2)
            return;
        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];

        for (int i = 0; i < left.length; i++)
            left[i] = array[i];

        for (int i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        sort(left);
        sort(right);

        merge(left, right, array);

    }

    static void merge(int[] left, int[] right, int[] array) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length)
            if (left[i] <= right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];

        while (i < left.length)
            array[k++] = left[i++];

        while (j < right.length)
            array[k++] = right[j++];

    }

    static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int boundary = start - 1;
        // 4, 1, 5, 8, 9, 3
        // 1, 4, 5, 8, 9, 3
        int i = start;
        while (i <= end) {
            if (array[i] <= pivot) {
                boundary++;
                int temp = array[i];
                array[i] = array[boundary];
                array[boundary] = temp;
            }
            i++;
        }
        return boundary;

    }

    static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            var pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }

        return array;
    }

    static int[] countingSort(int[] array, int max) {
        int[] list = new int[max + 1];

        for (int i = 0; i < array.length; i++)
            list[array[i]]++;

        int count = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i]; j++)
                array[count++] = i;
        }

        return array;
    }

    static int[] bucketSort(int[] array) {
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] buckets = new LinkedList[3];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (int i = 0; i < array.length; i++) {
            var index = array[i] / buckets.length;
            buckets[index == buckets.length ? index - 1 : index].addLast(array[i]);
        }

        var i = 0;
        for (var bucket : buckets) {
            Collections.sort(bucket);
            for (var item : bucket) {
                array[i++] = item;
            }
        }

        return array;
    }
}
