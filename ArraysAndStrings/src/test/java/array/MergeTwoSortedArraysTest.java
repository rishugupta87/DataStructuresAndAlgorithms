package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rg029761 on 11/6/15.
 */
public class MergeTwoSortedArraysTest {

    @Test
    public void test1() {
        int[] a = {3,7,9,11,15,90,100,120,180};
        int[] b = {2,8,10,16,18,22,34,45};

        System.out.println(Arrays.toString(MergeTwoSortedArrays.merge(a,b)));
    }
}
