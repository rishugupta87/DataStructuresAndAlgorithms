import binaryheap.MinHeap;
import org.junit.Test;

/**
 * Created by rg029761 on 8/17/15.
 */
public class MinHeapTest {

    @Test
    public void testCreateHeap() {
        final int[] array = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        MinHeap minHeap = new MinHeap(array.length);
        minHeap.createHeap(array);
        minHeap.display();
    }

    @Test
    public void testCreateHeap2() {
        final int[] array = {2,5,3,9,6,11,4,17,10,8,2};
        MinHeap minHeap = new MinHeap(array.length);
        minHeap.createHeap(array);
        minHeap.display();
    }

    @Test
    public void testRemoveMin() {
        final int[] array = {2,5,3,11,4,9,6,17,18};
        MinHeap minHeap = new MinHeap(array.length);
        minHeap.createHeap(array);
        minHeap.display();
        System.out.println(minHeap.removeMin());
        minHeap.display();
    }

    @Test
    public void testRemoveMin2() {
        final int[] array = {1,5,3,9,6,11,4,17,10,8,2};
        MinHeap minHeap = new MinHeap(array.length);
        minHeap.createHeap(array);
        minHeap.display();
        System.out.println(minHeap.removeMin());
        minHeap.display();
    }

    @Test
    public void testRemoveMin3() {
        final int[] array = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        MinHeap minHeap = new MinHeap(array.length);
        minHeap.createHeap(array);
        minHeap.display();
        System.out.println(minHeap.removeMin());
        minHeap.display();
    }
}
