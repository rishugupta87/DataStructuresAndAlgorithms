package array;

import org.junit.Test;

/**
 * Created by rg029761 on 7/18/15.
 */
public class FirstRepeatedElementTest {

    @Test
    public void testFindRepeatedElement() {
        int[] array = {5,3,3,3,3,3,3,3,4,4,4,5,3};
        System.out.println(FirstRepeatedElement.findFirstRepeatedElement(array));
    }

    @Test
    public void testFindRepeatedElement2() {
        int[] array = {7,2,2,3,7};
        System.out.println(FirstRepeatedElement.findFirstRepeatedElement(array));
    }

    @Test
    public void testFindRepeatedElement3() {
        int[] array = {1,1,3,4,6,7,9};
        System.out.println(FirstRepeatedElement.findFirstRepeatedElement(array));
    }

    @Test
    public void testFindRepeatedElement4() {
        int[] array = {1,2,3,4,5,6,5,7,8,8,8,9,5,6,10};
        System.out.println(FirstRepeatedElement.findFirstRepeatedElement(array));
    }
}
