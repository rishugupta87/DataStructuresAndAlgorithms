import java.util.PriorityQueue;

/**
 * Created by rg029761 on 6/25/15.
 */
public class BuildHeap {

    /**
     * Build a max heap from an array. If array is sorted we can easily construct heap.
     * If array is not sorted in descending order, we can sort the araay in descending order
     * using merge sort and create a heap
     * But time complexity for that is o(nlogn).
     *
     * We can actually create a heap in O(n) by building a heap bottom up
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {

        PriorityQueue pq = new PriorityQueue();


    }
}
