package uber;

/**
 * Created by rg029761 on 8/1/16.
 */
import java.util.*;

class GroupAnagrams {
    static List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> keyToWord = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();

        for(String s : input) {
            String originalString = s;
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String s1 = String.valueOf(charArray);
            if(!keyToWord.containsKey(s1)) {
                List<String> list = new ArrayList<String>();
                list.add(originalString);
                keyToWord.put(String.valueOf(charArray), list);
            } else {
                keyToWord.get(String.valueOf(charArray)).add(originalString);
            }
        }

        for(Map.Entry<String, List<String>> entry: keyToWord.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public static void main(String args[]) {
        String[] s = {"dog", "elvis", "forest", "fortes", "foster", "goat", "god", "heros", "horse", "lives", "shore", "softer"};
        List<List<String>> result =  GroupAnagrams.groupAnagrams(s);
        for(List<String> list :result) {
            System.out.println(list);
        }
    }
}