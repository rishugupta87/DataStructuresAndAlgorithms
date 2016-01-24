import java.util.HashMap;

/**
 * Created by rg029761 on 6/26/15.
 */
public class LongestSubstring {
    static int findLengthOfLongestUniqueSubstring(final String str) {

        int curr = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        while(i < str.length()) {
            final char c = str.charAt(i);
            if(!map.containsKey(c)) {
                curr = curr + 1 ;
                max = Math.max(curr, max);
                map.put(c, i);
                i++;
            } else {
                i = map.get(c) + 1;
                map.clear();
                curr = 0;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        System.out.println(findLengthOfLongestUniqueSubstring("abcabcdbcdebcdef"));
    }
}
