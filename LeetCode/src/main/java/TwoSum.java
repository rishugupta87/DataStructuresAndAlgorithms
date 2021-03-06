import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rg029761 on 1/3/16.
 */
public class TwoSum {

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target,
     where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

     You may assume that each input would have exactly one solution.

     Input: numbers={2, 7, 11, 15}, target=9
     Output: index1=1, index2=2
     */
    public int[] twoSumIndexReturn(int[] nums, int target) {

        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if(nums.length == 1) {
            return new int[] {0, 0};
        }

        for(int i = 0 ; i < nums.length; i ++) {
            final int numToLook = target - nums[i];

            if(map.containsKey(numToLook)) {
                return new int[] {
                        map.get(numToLook), i + 1};
            } else {
                map.put(nums[i], i+1);
            }
        }

        return new int[] {0, 0};
    }

    public int[] twoSum2(int[] nums, int target) {

        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if(nums.length == 1) {
            return new int[] {0, 0};
        }

        for(int i = 0 ; i < nums.length; i ++) {
            final int numToLook = target - nums[i];

            if(map.containsKey(numToLook)) {
                return new int[] {
                        map.get(numToLook), i + 1};
            } else {
                map.put(nums[i], i+1);
            }
        }

        return new int[] {0, 0};
    }

    public static void main(String args[]) {
        int[] num = {1,3,4,7,3};
        int[] res = new TwoSum().twoSumIndexReturn(num, 6);
        System.out.println(Arrays.toString(res));
    }
}
