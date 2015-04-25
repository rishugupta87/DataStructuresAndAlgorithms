package array;

import java.util.Arrays;

/**
 * Created by rg029761 on 7/26/15.
 */
public class RemoveDuplicates {

    // Create an array with all unique elements
    public static int[] removeDuplicates(int[] A) {
        if (A.length < 2)
            return A;

        int j = 0;
        int i = 1;

        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }

        int[] B = Arrays.copyOf(A, j + 1);

        return B;
    }

    public static void main(String[] args) {
        int[] arr = { 2,3,3,3,4,4,5,6,7,7  };
        arr = removeDuplicates(arr);
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
