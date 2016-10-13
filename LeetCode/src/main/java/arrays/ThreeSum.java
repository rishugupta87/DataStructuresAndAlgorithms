package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rg029761 on 8/30/16.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        Map<String, Integer> tripMap = new HashMap<String, Integer>();

        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> trip = new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[i], nums[j] , nums[k]}));
                    String tripKey = nums[i] + "" + nums[j] + "" + nums[k];
                    if(!tripMap.containsKey(tripKey)) {
                        result.add(trip);
                        tripMap.put(tripKey, 1);
                    }
                    j++;
                    k--;

                }else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(ThreeSum.threeSum(nums));
    }

}
