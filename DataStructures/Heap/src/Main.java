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
        System.out.println(MaxHeap.getKthLargestItem(new int[] { 5, 3, 8, 4, 1, 2 }, 1));

        /**
         * 1- Given an array of integers, check to see if this array represents a max
         * heap.
         */
        System.out.println(MaxHeap.isMaxHeap(new int[] { 8, 4, 5, 3, 1, 2 }));
        System.out.println(MaxHeap.isMaxHeap(new int[] { 22, 17, 10, 4, 5 }));

        /**
         * 2- Implement a min heap. In this implementation, store the items in an
         * array of nodes. Each node should have two fields: key (integer) and
         */
        MinHeap heap2 = new MinHeap(5);
        heap2.insert("A", 6);
        heap2.insert("C", 9);
        heap2.insert("D", 1);
        heap2.insert("E", 2);
        heap2.insert("F", 5);
        heap2.remove();
        System.out.println(heap2.toString());

        // 3- Implement a min priority queue with the following operations:
        // • add(String value, int priority)
        // • remove()
        // • isEmpty()
        MinPriorityQueue queue = new MinPriorityQueue(5);
        queue.enqueue("D", 3);
        queue.enqueue("B", 1);
        queue.enqueue("C", 2);
        queue.enqueue("A", 0);
        System.out.println();
    }
}
