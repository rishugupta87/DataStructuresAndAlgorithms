import java.util.Arrays;

/**
 * Created by rg029761 on 7/4/15.
 */
public class Subsequence {
    /**
     * To find the length of the longest increasing subsequence.
     *
     * @param arr
     * @return
     */
    public static int findLongestIncreasingSubsequence(final int[] arr) {
        int[] L = new int[arr.length];
        int max = 0;
        L[0] = 1;
        for(int i = 1 ; i < arr.length; i++) {
            boolean flag = false;
            for(int j = 0 ; j < i ; j++) {
              if(arr[j] < arr[i]) {
                  flag = true; //if any such j exists this flag is true
                  if(L[j] > max) {
                      max = L[j];
                  }
              }
            }
            if(flag) {
                L[i] = 1 + max;
            } else {
                L[i] = 1;
            }
        }

        Arrays.sort(L);
        return L[L.length -1];
    }

    /**
     * Maximum Sum increasing subsequence
     * given an array, find the subsequence which is increasing in order and is also a max sum.
     */
    public static int findMaxSumIncreasingSubsequence(final int arr[]) {
        int[] S = Arrays.copyOf(arr, arr.length);

        //keep another array to track from which index value is coming.
        int[] S2 = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i ++) {
            S2[i] = i;
        }

        //first copy all elements of original array into the new array as the sum should atleast be this much.
        for(int i = 1 ; i < arr.length ; i++) {
            for(int j = 0 ; j < i ; j ++) {
                if(arr[j] < arr[i]) {
                    S[i] = Math.max(S[i], S[j] + arr[i]);
                }
            }
        }

        //Now find the max in the array.this will get the sum of increasing subsequence with max sum.
        Arrays.sort(S);

        return S[S.length - 1];
    }
}
