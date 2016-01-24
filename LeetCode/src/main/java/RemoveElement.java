/**
 * Created by rg029761 on 1/10/16.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int m = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[m] = nums[i];
                m++;
            }
        }
        return m;
    }
}
