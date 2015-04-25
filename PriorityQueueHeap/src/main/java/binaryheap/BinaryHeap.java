package binaryheap;

/**
 * Created by rg029761 on 9/28/15.
 */
public class BinaryHeap {

    //O(nlogn) . however can improve the complexity if constructed in bottom up way in O(n)
    //insert = bubbleup
    public static int[] createMinHeap(final int[] array) {
        if(array.length == 0) {
            return null;
        }
        if(array.length == 1) {
            return array;
        }

        int[] minHeap = new int[array.length + 1];
        int position = 1;
        minHeap[position++] =  array[0];

        for(int i = 1 ; i < array.length ; i++) {
            minHeap[position] = array[i];
            bubbleUp(minHeap, position);
            position++;
        }
        return minHeap;
    }

    public static int[] createMinHeapBottomUp(int[] array) {
        return null;
    }

    //O(logn) as we need to fix the heap property
    //delete = bubble down
    public static int[] deleteMinimumFromBinaryHeap(int minHeap[]) {

        //save this value to return at the end.
        int minElement = minHeap[1];

        //replace first element with the last in the miHeap
        minHeap[1] = minHeap[minHeap.length - 1];

        //this might violate the heap properties.
        bubbleDown(minHeap, 1);

        //make last element as - 1
        minHeap[minHeap.length - 1] = -1;

        return minHeap; //should actually return the min element
    }

    private static void bubbleDown(int[] minHeap, int position) {
        int minIndex = -1;

        while(position * 2 < minHeap.length && (minHeap[position] > minHeap[2 * position] || minHeap[position] > minHeap[2 * position + 1])) {
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

    public static void bubbleUp(int[] minHeap, int position) {
        while(minHeap[position] < minHeap[position/2]) {
            //swap
            int temp = minHeap[position];
            minHeap[position] = minHeap[position/2];
            minHeap[position/2] = temp;
            position = position/2;
        }
    }
}
