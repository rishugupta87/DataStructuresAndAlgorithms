import java.util.HashMap;
import java.util.Map;

/**
 * Created by rg029761 on 1/3/16.
 */
public class LongestUniqueSubstring {

    /**
     *
     * Given a string, find the length of the longest substring without repeating characters. For example,
     * the longest substring without repeating letters for "abcabcbb" is "abc",
     * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     *
     * Test cases:
         "bbbbb"
         "abcabcbb"
         "abcadcd"
         "abcabcdbcdebcdef"
         "abcdefgg"
         "bcdefghij"
         "cd"
         "p"
         ""
         " "
         "poppoppop"

     Expected Answers:
         1
         3
         4
         5
         7
         9
         2
         1
         0
         1
         2
     */
    public int lengthOfLongestSubstring(String s) {
        final char[] c = s.toCharArray();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int length = 0 , max = 0;
        for(int i = 0 ; i < c.length ; i ++) {

            if(!map.containsKey(c[i])) {
                length ++;
            } else {
                if(length > max) {
                    max = length;
                }
                int start = map.get(c[i]) + 1;
                length = i - start + 1;
                map.clear();
            }
            map.put(c[i], i);
        }

        if(length > max) {
            max = length;
        }

        return max;
    }

    public static void main(String args[]) {
        String s = "poppoppop";
        System.out.println(new LongestUniqueSubstring().lengthOfLongestSubstring(s));
    }
}
