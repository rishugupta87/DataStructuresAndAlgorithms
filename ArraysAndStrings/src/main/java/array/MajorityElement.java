package array;

/**
 * Created by rg029761 on 7/27/15.
 */
public class MajorityElement {

    /**
     * To find element which appears more than n/2 times.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int majorityElement(int[] nums, int k) {
        int result = 0, count = 0;

        for(int i = 0; i<nums.length; i++ ) {
            if(count == 0){
                result = nums[i];
                count = 1;
            }else if(result == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        // Now maj stores the majority element. But we need to check whether it occurs > n/2 times
        for( int i = 0;i < nums.length;i++ ) {
            if( nums[ i ] == result )
                count++;
        }
        if( count > nums.length / k )
            return result;
        else
            return -1;
    }



    public static void main(String args[]) {
        int[] arr = {2,3,4,5,3,6,6,7,8,8,8,8,8,8};
        System.out.println(MajorityElement.majorityElement(arr,2));
    }
}
