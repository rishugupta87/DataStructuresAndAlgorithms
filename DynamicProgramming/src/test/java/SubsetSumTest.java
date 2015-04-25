import org.junit.Test;

/**
 * Created by rg029761 on 7/5/15.
 */
public class SubsetSumTest {

    @Test
    public void test() {
        int arr[] = {2,3,7,8,10};
        System.out.println(SubsetSum.isSubsetSum(arr, 15, 14));
    }
}
