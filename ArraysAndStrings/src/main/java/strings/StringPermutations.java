package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rg029761 on 11/8/15.
 */
public class StringPermutations {

    boolean[] used;
    StringBuffer sb;

    StringPermutations(int length) {
        used = new boolean[length]; //keeps track of characters visited.
        sb = new StringBuffer(length);
    }

    // permutation n! = n* (n-1)!
    public void findStringPermutations(final String str, int position) {
        if(position == str.length()) { //all characters visited
            System.out.println(sb.toString());
            return;
        } else {

            for(int i = 0 ; i < str.length(); i ++) {
                if(used[i]) { //if character already used skip
                    continue;
                }

                sb.append(str.charAt(i));
                used[i] = true; //pick the character at position

                //permute over remaining characters starting at position = 1
                //position just keeps track if we reached end of string buffer
                findStringPermutations(str, position + 1);

                sb.deleteCharAt(sb.length() -1);
                used[i] = false;
            }
        }
    }

    /**
     * https://www.youtube.com/watch?v=iFafKAUGqrY
     *
     * Also Do
     * https://www.youtube.com/watch?v=wIPcruaQ3Sg
     *
     * @param characters
     * @param position
     */
    public void findStringPermutations2(char[] characters, int position) {

        if(position == characters.length) { //all characters visited
            System.out.println(characters);
        } else {

            for(int i = position ; i < characters.length; i ++) {
                char temp = characters[i];
                characters[i] = characters[position];
                characters[position] = temp;


                //permute over remaining characters starting at position = 1
                //position just keeps track if we reached end of string buffer
                findStringPermutations2(characters, position + 1);

                temp = characters[i];
                characters[i] = characters[position];
                characters[position] = temp;
            }
        }
    }

    public static Set<String> getPermutations(String inputString) {
        // base case
        if (inputString.length() <= 1) {
            return new HashSet<String>(Arrays.asList(inputString));
        }

        String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
        char lastChar = inputString.charAt(inputString.length() - 1);

        // recursive call: get all possible permutations for all chars except last
        Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

        // put the last char in all possible positions for each of the above permutations
        Set<String> permutations = new HashSet<String>();
        for (String permutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
            for (int i = 0; i <= allCharsExceptLast.length(); i++) {
                String permutation = permutationOfAllCharsExceptLast.substring(0, i) + lastChar + permutationOfAllCharsExceptLast.substring(i);
                permutations.add(permutation);
            }
        }

        return permutations;
    }


    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void main(String args[]) {
        StringPermutations.getPermutations("abcd");
    }
}
