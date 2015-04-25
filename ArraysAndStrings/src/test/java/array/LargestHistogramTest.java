package array;

import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

/**
 * Created by rg029761 on 10/3/15.
 */
public class LargestHistogramTest {

    @Test
    public void testAreaHistogram() {
        int h[] = {2,1,5,6,2,3};
        System.out.println(LargestHistogramArea.largestRectangleArea(h));
    }
}
