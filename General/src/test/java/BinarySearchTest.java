import org.junit.Test;

/**
 * Created by rg029761 on 5/10/15.
 */
public class BinarySearchTest {

    @Test
    public void testRecursive() {
        int[] a = {1, 3, 5, 9, 10, 11, 13, 15};
        System.out.println(BinarySearch.binarySearchRecursive(a, 15, 0, 7));
    }

    @Test
    public void testIterative() {
        int[] a = {1, 3, 5, 9, 10, 11, 13, 15};
        System.out.println(BinarySearch.binarySearchIterative(a, 10));
    }

    @Test
    public void testrandom() {
        String str ="/storage/hadoop/00/mapred_local/taskTracker/rg029761/distcache/-1279031749409103907_1493410154_2080824565/samus/user/rg029761/test/gps.zip/gps";
        String str2 ="/storage/hadoop/00/mapred_local/taskTracker/rg029761/distcache/-1279031749409103907_1493410154_2080824565/samus/user/rg029761/test/gps.zip/gps.zip";

        System.out.println(str.endsWith("gps"));
        System.out.println(str2.endsWith("gps"));
    }

    @Test
    public void test() {

    }
}
