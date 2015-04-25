import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rg029761 on 5/5/15.
 */
public class SortingTechniquesTest {

    @Test
    public void testMergeSort() {
        int[] array = {10,2,1,30,40,50,4,7};
        int[] sortedArray = SortingTechniques.mergeSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
