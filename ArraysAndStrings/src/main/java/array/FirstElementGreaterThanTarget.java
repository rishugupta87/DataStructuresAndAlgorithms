package array;

/**
 * Created by rg029761 on 11/8/15.
 */
public class FirstElementGreaterThanTarget {

    //find first element in the sorted array greater than the target

    public static int firstElement(int[] array, int x) {
        if(x > array[array.length - 1] || x < array[0]) { //no such x exists in the array.
            return -1;
        }

        if(x ==  array[array.length - 1]) { //there is no element greater than x
            return -1;
        }

        int k = binarySearch(array, x, 0 , array.length -1);

        if(k == -1) {
            return -1;
        }

        return array[k + 1];
    }

    public static int binarySearch(int[] a, int x, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high)/2;
        if (a[mid] == x) return mid;
        else if ( x > a[mid])
            return binarySearch(a, x, mid + 1, high);
        else // last possibility:  x < a[mid]
            return binarySearch(a, x, low, mid - 1);
    }
}
