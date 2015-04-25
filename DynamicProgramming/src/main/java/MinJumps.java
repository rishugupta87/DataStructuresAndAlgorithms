/**
 * Created by rg029761 on 7/6/15.
 */
public class MinJumps {

    /**
     * Given an array, find minimum number to jumps to reach end of array,
     * given you can jump at max as much as value at position in array.
     */
    public static int findMinJumps(final int[] arr) {
        final int minJumps[] = new int[arr.length];
        //final int trackJumps[] = new int[arr.length];

        minJumps[0] = 0;

        for(int i = 1; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < i ; j++) {
                //check if i can be reached from j
                if(j + arr[j] >= i) {
                    //keep track of min jumps required to reach i from j
                    if(minJumps[j] + 1 < min) {
                        min = minJumps[j] + 1;
                    }
                }
            }
            minJumps[i] = min;
        }
        return minJumps[minJumps.length - 1];
    }
}
