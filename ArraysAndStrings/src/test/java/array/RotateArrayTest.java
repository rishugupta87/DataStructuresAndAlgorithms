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
}
