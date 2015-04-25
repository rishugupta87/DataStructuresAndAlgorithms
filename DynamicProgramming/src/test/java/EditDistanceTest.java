import org.junit.Test;

/**
 * Created by rg029761 on 6/28/15.
 */
public class EditDistanceTest {

    @Test
    public void testEditDistance() {
        System.out.println(EditDistance.dynamicEditDistance("abcdef", "azced"));
    }

    @Test
    public void testArray() {
        final int[][] array= { {1,2,3,4,5},
                       {6,7,8,9,10}};
        System.out.println(array[0].length);
    }
}
