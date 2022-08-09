public class Main {
    public static void main(String[] args) throws Exception {

        /**
         * Insertion in Heap
         */
        Heap heap = new Heap(6);
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        System.out.println(heap.toString());

        /**
         * Sorting (Heap application)
         */
        Heap heap1 = new Heap(7);
        System.out.println(heap1.sort(new int[] { 12, 98, 67, 55, 40, 1, 29 }, true));

        /**
         * Heapify
         */
        System.out.println(MaxHeap.iterativeHeapify(new int[] { 5, 3, 8, 4, 1, 2 }));

        /**
         * Get kth largest element
         */
        System.out.println(MaxHeap.getKthLargestItem(new int[] { 5, 3, 8, 4, 1, 2 }, 0));
    }
}
