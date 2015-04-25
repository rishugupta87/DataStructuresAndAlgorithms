package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rg029761 on 7/31/15.
 */
public class RotateArrayTest {

    @Test
    public void test1() {
        int[] array = {1,2,3,4,5,6,7};
        RotateArray.rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testFind1() {
        int[] array = {10, 11, 12, 1, 2, 3, 4, 5, 6};
        final int isExists = RotateArray.findElement(array, 0, 8, 4);
        System.out.println(isExists);
    }
}
