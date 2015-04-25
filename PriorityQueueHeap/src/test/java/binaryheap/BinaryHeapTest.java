package binaryheap;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rg029761 on 9/28/15.
 */
public class BinaryHeapTest {

    @Test
    public void testCreateHeap() {
        final int[] array = {2, 5, 3, 9, 4, 11, 7, 17, 10, 8, 2};
        System.out.println(Arrays.toString(BinaryHeap.createMinHeap((array))));
    }

    @Test
    public void testDeleteMin() {
        final int[] array = {-1, 2, 5, 3, 9, 6, 11, 4, 7, 10, 8};
        System.out.println(Arrays.toString(BinaryHeap.deleteMinimumFromBinaryHeap((array))));
    }
}
