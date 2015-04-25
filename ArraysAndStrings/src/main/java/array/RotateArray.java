package array;

import java.util.Arrays;

/**
 * Created by rg029761 on 7/26/15.
 */
public class RotateArray {

    /**
     * Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3,
     * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     * How many different ways do you know to solve this problem?
     * bubbling
     */
    public static void rotate(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }


    /**
     * Taking reverse approach.
     *
     * @param arr
     * @param order
     */
    public static void rotate2(int[] arr, int order) {
        order = order % arr.length;

        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        //length of first part
        int a = arr.length - order;

        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int findElement(final int[] array, int low, int high, int element) {
        int mid = (low + high)/2;

        if(array[mid] == element) {
            return mid;
        }
        if(array[mid] < array[high]) { //the right half is sorted
            if(element > array[mid] && element < array[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(array[mid] > array[low]) { // the left half is sorted
            if(element >= array[low] && element < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return findElement(array, low, high, element);
    }
}