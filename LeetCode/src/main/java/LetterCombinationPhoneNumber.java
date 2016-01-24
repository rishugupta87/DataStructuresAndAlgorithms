import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rg029761 on 1/9/16.
 */
public class LetterCombinationPhoneNumber {


    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i = 0; i < digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        System.out.println(new LetterCombinationPhoneNumber().letterCombinations("23"));
    }
}
