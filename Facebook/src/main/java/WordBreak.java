import java.util.HashSet;

/**
 * Created by rg029761 on 6/25/15.
 */
public class WordBreak {
    /**
     *
     * Objec­tive : Given an string and a dic­tio­nary of words, find out if the input string can be bro­ken into a space-separated sequence of one or more dic­tio­nary words.

     Exam­ple:

     dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]

     String = "IamSumit"

     Output: "I am Sumit"

     String ="thisisadog"

     Output : String can't be broken
     *
     */

    public void wordBreak(String s, HashSet<String> hs) {
        if (find(s, hs, "")) {
        } else {
            System.out.println("Cant Break");
        }
    }

    public boolean find(String s, HashSet<String> dict, String answer) {
        // System.out.println(s + "  " + answer);
        if (s.length() == 0) {
            System.out.println(answer);
            return true;
        } else {
            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);// add one char at a time
                // check if word exists in dictionary
                if (dict.contains(word)) {
                    //add word to the answer and make a recursive call
                    if (find(s.substring(index + 1), dict, answer + word + " ")) {
                        return true;
                    } else {
                        //System.out.println(word + "  backtrack");
                        index++;
                    }
                } else {
                    index++;
                }
            }
            return false;
        }
    }

    /**
     * With dynamic programming
     */
    public boolean findUsingDP(String s, HashSet<String> dict,
                               HashSet<String> memory, String answer) {
        if (s.length() == 0) {
            System.out.println(answer);
            return true;
        } else if (memory.contains(s)) {
            return false;
        } else {

            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);// add one char at a time
                // check if word already being solved
                if (dict.contains(word)) {
                    if (findUsingDP(s.substring(index + 1), dict, memory,
                            answer + word + " ")) {
                        return true;
                    } else {
                        System.out.println("backtrack");
                        index++;
                    }
                } else {
                    index++;
                }
            }
            memory.add(s);// memoization for future;
            return false;
        }
    }

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("this");
        hs.add("is");
        hs.add("sumit");
        hs.add("jain");
        hs.add("the");
        hs.add("problem");
        String s = "thisissumitjain";

        WordBreak ws = new WordBreak();

        // create another HashSet so store the sub problems result
        HashSet<String> memoization = new HashSet<String>();
        ws.findUsingDP(s, hs, memoization, "");
    }
}
