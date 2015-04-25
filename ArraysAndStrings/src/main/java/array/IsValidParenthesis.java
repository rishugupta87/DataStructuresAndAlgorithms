package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by rg029761 on 11/3/15.
 */
public class IsValidParenthesis {

    private static Map<Character, Character> map = new HashMap<Character, Character>();
    private static Stack<Character> stack = new Stack<Character>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static boolean isValidParenthesis(final String str) {
        //can use string utils for null or blank

        if(str.length() == 0) {
            return false;
        }

        for(int i = 0 ; i < str.length(); i++) {
            char c = str.charAt(i);

            if(map.values().contains(c)) {//if open parenthesis push on stack
                stack.push(c);
            } else if(map.keySet().contains(c)){ // if closed
                char topCharacter = stack.peek();
                if(map.get(c) == topCharacter && !stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        }

        return false;
    }

}
