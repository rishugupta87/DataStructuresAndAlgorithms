package binaryheap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rg029761 on 10/11/15.
 */
public class MaxHeap {

    public static void createMaxHeap(int[] array) {
        for(int i = (array.length - 1)/2; i>=1; i--) {
            maxHeapify(array, i);
        }
    }

    public static int extractMax(int[] maxHeap) {
        //save this value to return at the end.
        int maxElement = maxHeap[1];

        //replace first element with the last in the miHeap
        maxHeap[1] = maxHeap[maxHeap.length - 1];

        //this might violate the heap properties.
        maxHeapify(maxHeap, 1);

        //make last element as - 1
        maxHeap[maxHeap.length - 1] = -1;

        return maxElement; //should actually return the min element
    }

    private static void maxHeapify(int[] array, int pos) {
        int leftPos = 2 * pos;
        int rightPos = 2 * pos + 1;
        int maximum = pos;

        if (leftPos < array.length && array[leftPos] > array[pos]) {
            maximum = leftPos;
        }

        if( rightPos < array.length && array[rightPos] > array[maximum]) {
            maximum = rightPos;
        }

        if(maximum != pos) {
            swap(array, pos, maximum);
            maxHeapify(array, maximum);
        }
    }

    private static void swap(int[] array, int parentPosition, int childPosition) {
        int temp = array[parentPosition];
        array[parentPosition] = array[childPosition];
        array[childPosition] = temp;
    }

    public static void main(String args[]) {
        int[] array = { -1, 5, 12, 64, 1, 37, 90, 91, 97 }; //-1 is just so array starts form index 1
        createMaxHeap(array);

        List<Integer> topK = new ArrayList<Integer>();
        for(int i = 0 ; i < 4; i++) {
            topK.add(extractMax(array));
        }
        System.out.println();
        PriorityQueue pq = new PriorityQueue();
    }
}
