/**
 * Created by rg029761 on 5/10/15.
 */
public class BinarySearch {

    // need extra low and high parameters
    public static int binarySearchRecursive(int[ ] a, int x, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high)/2;
        if (a[mid] == x) return mid;
        else if ( x > a[mid])
            return binarySearchRecursive(a, x, mid + 1, high);
        else // last possibility:  x < a[mid]
            return binarySearchRecursive(a, x, low, mid - 1);
    }

    // binarySeach: non-recursive
    public static int binarySearchIterative(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (a[mid] == x) return mid;
            else if (a[mid] < x) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }


}
