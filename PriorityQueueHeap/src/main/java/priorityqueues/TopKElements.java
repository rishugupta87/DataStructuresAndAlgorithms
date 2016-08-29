package priorityqueues;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rg029761 on 10/12/15.
 */
public class TopKElements {

    //http://java67.blogspot.com/2015/07/how-to-use-priorityqueue-in-java-example.html
    public static void findTop4Marks(int[] array) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(4); //uses min heap

        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>(4, Collections.reverseOrder()); //uses max heap

        //add first k elements in the pq or min heap
        for(int i = 0 ; i < 4; i++) {
            pq.add(array[i]);
        }

        //now iterate over k+1 elements in the pq
        for(int i = 4 ; i < array.length; i ++) {
            if(array[i] > pq.peek()) {
                //remove top element from pq and replace with array element
                pq.poll();
                pq.offer(array[i]);
            }
        }

        System.out.println();

    }

    public static int findKthLargestElement(int[] array, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k); //uses min heap

        //add first k elements in the pq or min heap
        for(int i = 0 ; i < k; i++) {
            pq.add(array[i]);
        }

        //now iterate over k+1 elements in the pq
        for(int i = k ; i < array.length; i ++) {
            if(array[i] > pq.peek()) {
                //remove top element from pq and replace with array element
                pq.poll();
                pq.offer(array[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String args[]) {
        int[] array = {3,2,1,5,6,4};
        findTop4Marks(array);
        System.out.println(findKthLargestElement(array, 3));
    }
}
