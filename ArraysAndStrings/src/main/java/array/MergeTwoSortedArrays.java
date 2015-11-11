package array;

/**
 * Created by rg029761 on 11/5/15.
 */
public class MergeTwoSortedArrays {

    public static int[] merge(int[] a , int[] b) {

        if(a.length == 0) {
            return b;
        }

        if(b.length == 0) {
            return a;
        }

        int[] result = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while(i <  a.length && j < b.length) {

            if(a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while(j < b.length) {
            result[k++] = b[j++];
        }

        while(i < a.length) {
            result[k++] = a[i++];
        }

        return result;
    }
}
