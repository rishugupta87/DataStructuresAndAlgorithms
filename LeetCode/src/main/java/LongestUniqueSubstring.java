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

    public static String findLongestUniqueSubstring(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int i = 0;
        int j = 1;

        map.put(s.charAt(i), i);
        String longestString = null;
        int max = Integer.MIN_VALUE;

        while(i < s.length() && j < s.length()) {
            if(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                j++;
            } else {
                if(s.substring(i, j).length() > max) {
                    max = s.substring(i, j).length();
                    longestString = s.substring(i, j);
                }
                int prev = map.get(s.charAt(j));
                if(prev > i) {
                    map.clear();
                } else {
                    map.remove(s.charAt(j));
                }
                i = prev+1;
            }
        }
        if(s.substring(i, j).length() > max) {
            max = s.substring(i, j).length();
            longestString = s.substring(i, j);
        }
        return longestString;
    }

    public static void main(String args[]) {
        String s = "poppoppop";
        String s1 = "abcbbcadefgh";

        System.out.println(new LongestUniqueSubstring().lengthOfLongestSubstring(s));
        System.out.println(new LongestUniqueSubstring().findLongestUniqueSubstring(s1));

    }
}
