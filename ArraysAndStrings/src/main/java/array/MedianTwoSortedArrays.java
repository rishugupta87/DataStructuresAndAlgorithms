package array;

/**
 * Created by rg029761 on 1/27/16.
 */
public class MedianTwoSortedArrays {

    public static int median(int[] arr1, int[] arr2)
    {
        int N = arr1.length;
        return median(arr1, 0, N -1 , arr2, 0, N - 1);
    }
    public static int median(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2)
    {
        int mid1 = (h1 + l1 ) / 2;
        int mid2 = (h2 + l2 ) / 2;

        if (h1 - l1 == 1)
            return (Math.max(arr1[l1] , arr2[l2]) + Math.min(arr1[h1] , arr2[h2]))/2;
        else if (arr1[mid1] > arr2[mid2])
            return median(arr1, l1, mid1 , arr2, mid2 , h2);
        else
            return median(arr1, mid1 , h1, arr2, l2 , mid2 );
    }
}
