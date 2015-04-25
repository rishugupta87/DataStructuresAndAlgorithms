package array;

import org.junit.Test;

/**
 * Created by rg029761 on 7/18/15.
 */
public class FindNumberOfOccurenceTest {

    @Test
    public void testOccurence() {
        final int[] array = {2,4,10,10,10,10,18,20};
        System.out.println(FindNumberOfOccurence.findNumberOfOccurence(array, 10, 0, array.length-1));;
    }

    @Test
    public void testOccurence2() {
        final int[] array = {1,2,2,2,2,2,2,2,3,4,5,5,6};
        System.out.println(FindNumberOfOccurence.findNumberOfOccurence(array, 2, 0, array.length-1));;
    }

    @Test
    public void testOccurence3() {
        final int[] array = {2,4,10,10,10,10,18,20};
        System.out.println(FindNumberOfOccurence.findNumberOfOccurence(array, 10, 0, array.length-1));;
    }

    @Test
    public void testOccurence4() {
        final int[] array = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,10};
        System.out.println(FindNumberOfOccurence.findNumberOfOccurence(array, 5, 0, array.length-1));;
    }

    @Test
    public void testOccurence5() {
        final int[] array = {3,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        System.out.println(FindNumberOfOccurence.findNumberOfOccurence(array, 5, 0, array.length-1));;
    }
}
