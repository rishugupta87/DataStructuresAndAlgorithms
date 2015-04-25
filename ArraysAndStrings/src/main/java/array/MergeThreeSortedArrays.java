package array;

import java.util.Arrays;

/**
 * Created by rg029761 on 8/30/15.
 */
public class MergeThreeSortedArrays {

    public int[] merge(final int[] arr1, final int[] arr2, final int[] arr3) {
        int noOfelements = arr1.length + arr2.length + arr3.length;

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        int[] resultArray = new int[noOfelements];

        //create a min heap of size 3 and insert first elements of all arrays in the heap.
        HeapNode[] heap = new HeapNode[4];
        heap[0] = new HeapNode(-1, -1);

        int position = 0;

        //put the first elements of each array in the heap.
        heap[1] = new HeapNode(arr1[index1], 1);
        heap[2] = new HeapNode(arr2[index2], 2);
        heap[3] = new HeapNode(arr3[index3], 3);

        while(position < noOfelements) {
            if((heap[1].data > heap[2].data) || heap[1].data > heap[3].data) {
                if(heap[2].data > heap[3].data) {
                    swap(heap[1], heap[3]);
                } else {
                    swap(heap[1], heap[2]);
                }
            }

            //extract min and put in the result array
            resultArray[position] = heap[1].data;
            position++;

            //replace root with the next element in the list which had a minimum.
            //if no more elements in array replace by infinity.
            int listNo =  heap[1].listNo;
            if(listNo == 1) {
                if(index1 < arr1.length - 1) {
                    heap[1] = new HeapNode(arr1[++index1], 1);
                } else {
                    heap[1] = new HeapNode(Integer.MAX_VALUE, 1);
                }
            } else if(listNo == 2) {
                if(index2 < arr2.length - 1) {
                    heap[1] = new HeapNode(arr2[++index2], 2);
                } else {
                    heap[1] = new HeapNode(Integer.MAX_VALUE, 2);
                }
            } else {
                if(index3 < arr3.length - 1) {
                    heap[1] = new HeapNode(arr3[++index3], 3);
                } else {
                    heap[1] = new HeapNode(Integer.MAX_VALUE, 2);
                }
            }
        }
        return resultArray;
    }

    private void swap(HeapNode a, HeapNode b) {
        HeapNode temp = new HeapNode(a.data, a.listNo);
        a.data = b.data;
        a.listNo = b.listNo;
        b.data = temp.data;
        b.listNo = temp.listNo;
    }

    class HeapNode {
        int data;
        int listNo;

        public HeapNode(int data, int listNo) {
            this.data = data;
            this.listNo = listNo;
        }
    }

    public static void main(String args[]) {
        int A[]={1,3,5,7,35};
        int B[]={2,4,6,8, 67};
        int C[]={0,9,10,11, 12};

        int[] result = new MergeThreeSortedArrays().merge(A, B, C);
        System.out.println(Arrays.toString(result));
    }
}
