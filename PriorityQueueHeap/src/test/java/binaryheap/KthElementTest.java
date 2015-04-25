package binaryheap;

import org.junit.Test;

/**
 * Created by rg029761 on 9/29/15.
 */
public class KthElementTest {

    @Test
    public void testCreateHeap() {
        final int[] heap = {-1, 2, 5, 7, 11, 20, 8, 20, 12, 15, 22, 25, 10, 13};
        System.out.println(KthElement.findKthSmallestElement(heap, 12));
    }
}
