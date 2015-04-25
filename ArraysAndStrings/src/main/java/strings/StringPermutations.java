package strings;

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
}
