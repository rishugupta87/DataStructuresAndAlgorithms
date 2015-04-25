package binaryheap;

/**
 * Created by rg029761 on 9/29/15.
 */
public class KthElement {

    static int heapsize = 14; //can do in a costructor.

    //to find the kth smallest element in the array.
    //construct a min heap bottom up and then perform k deletions and
    //return the kth element , similarly can find k smallest elements by returning a list instead of the kth element
    //Time: O(n) //to construct heap + O(klogn) = O(n + klogn)
    //Note: This problem can also be solved using partitioning step of quick sort.
    public static int findKthSmallestElement(int[] heap, int k) {
        int kthSmallest = -1;
        for(int i = 0 ; i < k ; i++) {
            kthSmallest = deleteMinimumFromBinaryHeap(heap);
        }
        return kthSmallest;
    }

    private static int deleteMinimumFromBinaryHeap(int minHeap[]) {

        //save this value to return at the end.
        int minElement = minHeap[1];

        //replace first element with the last in the miHeap
        minHeap[1] = minHeap[heapsize - 1];

        //this might violate the heap properties.
        bubbleDown(minHeap, 1);

        //make last element as - 1
        minHeap[heapsize - 1] = -1;

        heapsize --;

        return minElement; //should actually return the min element
    }

    private static void bubbleDown(int[] minHeap, int position) {
        int minIndex = -1;

        while(position * 2 < heapsize - 1 && (minHeap[position] > minHeap[2 * position] || minHeap[position] > minHeap[2 * position + 1])) {
            //swap root with minimum of left or right.
            int left = minHeap[2 * position];
            int right = minHeap[2 * position + 1];
            if(left < right) {
                minIndex = 2 * position;
            } else {
                minIndex = 2 * position + 1;
            }

            //swap
            int temp = minHeap[position];
            minHeap[position] = minHeap[minIndex];
            minHeap[minIndex] = temp;

            position = minIndex;
        }
    }
}
