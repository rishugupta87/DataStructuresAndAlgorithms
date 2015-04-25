package array;

/**
 * Created by rg029761 on 7/18/15.
 */
public class PeakElement {

    //find peak element in the array
    /**
     *
     * peak ele­ment is the ele­ment which is greater than or equal to both of its neighbors.
     * An array always has a peak element in this case
     *
     * Note: if we change this def to the peak ele­ment is the ele­ment which is greater than to both of its neighbors.
     * An array might not have a peak element in this case
     *
     * A sim­ple approach is to do a lin­ear scan to a array and using
     * few vari­ables we can find a peak ele­ment. But the Time Com­plex­ity will be O(n) but real ques­tion is, Can we do better?

     The Answer is yes, by using Binary Search tech­niques.

     If mid­dle ele­ment is the peak ele­ment, return it
     If mid­dle ele­ment is smaller than its left ele­ment , we will get our peak ele­ment on the left half
     If mid­dle ele­ment is the smaller than its right ele­ment, we will our peak ele­ment on the right.
     */
    public static int findPeakElement(final int low, final int high, final int[] array) {
        int mid = (low + high)/2;

        if((array[mid] >= array[mid-1]) && (array[mid] >= array[mid+1])) {
            return array[mid];
        }

        //peak element is to the left side in this case
        if( (array[mid]) < array[mid - 1]) {
              return findPeakElement(low, mid-1, array);
        } else {
            return findPeakElement(mid+1, high, array);
        }
    }
}
