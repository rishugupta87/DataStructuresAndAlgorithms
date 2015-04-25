package array;

import java.util.Arrays;

/**
 * Created by rg029761 on 7/30/15.
 */
public class SortingArrayTechniques {

    /**
     *
     * Merge Sort
     * Worst case : T(n) = O(nlogn)
     * Best Case : T(n) = O(nlogn)
     * Space complexity: O(n)
     */
    public static int[] mergeSort(final int[] array) {
        int n = array.length;
        if (n == 1) {
            return array;
        }
        //find the mid point.
        int midpoint = n / 2;

        int[] left = new int[midpoint];
        int[] right = new int[n - midpoint];

        //populate left and right array.
        for (int i = 0; i < midpoint; i++) {
            left[i] = array[i];
        }
        int k = 0;
        for (int i = midpoint; i < n; i++) {
            right[k] = array[i];
            k++;
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);

        return array;
    }

    private static void merge(int[] left, int[] right, int[] array) {
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else if(left[i] > right[j]) {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * Worst case : T(n) = O(n^2)
     * Average Case : T(n) = O(nlogn)
     * Space complexity: O(1)
     *
     * With randomized choice of pivot we can make the time complexity almost O(nlogn) most of the time
     *
     * @param array
     * @return
     */


    public static void main(String args[]) {
        int[] array = {2,4,1,6,8,5,3,7};
        System.out.println(Arrays.toString(mergeSort(array)));
    }
}
