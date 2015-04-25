package array;

/**
 * Created by rg029761 on 11/8/15.
 */
public class ProductArray {

    //Given an array of n integers where n > 1, nums, return an array output such that output[i] is
    // equal to the product of all the elements of nums except nums[i].

    //Solve it without division and in O(n).
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0]=1;
        right[nums.length-1]=1;

        //scan from left to right
        for(int i=0; i < nums.length-1; i++){
            left[i+1] = nums[i] * left[i];
        }

        //scan from right to left
        for(int i=nums.length-1; i>0; i--){
            right[i-1] = right[i] * nums[i];
        }

        //multiply
        for(int i=0; i<nums.length; i++){
            result[i] = left[i] * right[i];
        }

        return result;
    }


    //Space is O(1).
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        result[result.length-1] = 1;

        for(int i=nums.length-2; i>=0; i--) {
            result[i] = result[i+1] * nums[i+1];
        }

        int left = 1;
        for(int i=0; i<nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }
}
