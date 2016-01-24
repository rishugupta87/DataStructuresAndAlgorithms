package array;

/**
 * Created by rg029761 on 7/18/15.
 */
public class FindNumberOfOccurence {

    public static int findNumberOfOccurence(int[] a,int x, int low, int high) {
        final int firstOccurence = findFirstOccurence(a, x, low, high);
        final int lastOccurence = findLastOccurence(a, x, low, high);

        if(firstOccurence == -1 && lastOccurence == -1) {
            return -1;
        }
        return  lastOccurence - firstOccurence + 1;
    }

    // need extra low and high parameters
    private static int findFirstOccurence(int[] a, int x, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high)/2;

        //first occurence can be the first element in the array handle the edge case.
        if ( (a[mid] == x && mid == 0) || (a[mid] == x && a[mid-1] < a[mid])) {
            return mid;
        }
        else if ( x > a[mid])
            return findFirstOccurence(a, x, mid + 1, high);
        else // last possibility:  x <= a[mid]
            return findFirstOccurence(a, x, low, mid - 1);
    }

    // need extra low and high parameters
    private static int findLastOccurence(int[] a, int x, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high)/2;

        //to handle the last index edge case.
        if( (a[mid] == x && mid == a.length - 1) || (a[mid] == x && a[mid] < a[mid+1])) {
            return mid;
        }

        else if (x >= a[mid])
            return findLastOccurence(a, x, mid + 1, high);
        else // last possibility:  x < a[mid]
            return findLastOccurence(a, x, low, mid - 1);
    }
}
