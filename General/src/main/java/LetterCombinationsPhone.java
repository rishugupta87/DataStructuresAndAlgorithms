import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rg029761 on 5/6/15.
 */
public class LetterCombinationsPhone {

    private static final Map<Character, String> PHONE_MAP = new HashMap<Character, String>();
    static {
        PHONE_MAP.put('1', "");
        PHONE_MAP.put('2', "abc");
        PHONE_MAP.put('3', "def");
        PHONE_MAP.put('4', "ghi");
        PHONE_MAP.put('5', "jkl");
        PHONE_MAP.put('6', "mno");
        PHONE_MAP.put('7', "pqrs");
        PHONE_MAP.put('8', "tuv");
        PHONE_MAP.put('9', "wxyz");
    }

    public static ArrayList<String> letterCombinations(String digits) {
        char[] cs = new char[digits.length()];
        ArrayList<String> res = new ArrayList<String>();
        appendDigits(digits, 0, cs, res);
        return res;
    }

    private static void appendDigits(String digits, int i, char[] cs, ArrayList<String> res){
        if(i == digits.length()){
            res.add(new String(cs));
            return;
        }
        String letters = PHONE_MAP.get(digits.charAt(i));
        for(int j = 0; j < letters.length(); j++){
            cs[i] = letters.charAt(j);
            appendDigits(digits, i + 1, cs, res);
        }
    }
}
