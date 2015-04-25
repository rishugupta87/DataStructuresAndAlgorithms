package array;

import org.junit.Test;

/**
 * Created by rg029761 on 7/18/15.
 */
public class PeakElementTest {

    @Test
    public void testPeak1() {
        final int[] array = {1,2,3,4,0,1,5,4,3,2,1};
        System.out.println(PeakElement.findPeakElement(0, array.length-1, array));
    }
}
