import org.junit.Test;

/**
 * Created by rg029761 on 7/4/15.
 */
public class SubsequenceTest {

    @Test
    public void test() {
        int[] arr = {3,4,-1,0,6,2,3};
        System.out.println(Subsequence.findLongestIncreasingSubsequence(arr));
    }

    @Test
    public void test2() {
        int[] arr = {1,12,7,0,23,11,52,31,61,69,70,2};
        System.out.println(Subsequence.findLongestIncreasingSubsequence(arr));
    }

    @Test
    public void test_maxSum() {
        int[] arr = {4, 6, 1, 3, 8, 4, 6};
        System.out.println(Subsequence.findMaxSumIncreasingSubsequence(arr));
    }
}
