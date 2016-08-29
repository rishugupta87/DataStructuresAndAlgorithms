package array;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by rg029761 on 8/21/16.
 */
public class LongestValidParenthesis {


    static  int findMaxLen(String str)
    {
        int n = str.length();

        // Create a stack.
        Stack<Character> stk = new Stack<Character>();

       // Initialize result
        int result = 0;

        char[] chararray = str.toCharArray();

        // Traverse all characters of given string
        for (int i = 0; i < chararray.length; i++)
        {
            // If opening bracket, push char '(' of it
            if (chararray[i] == '(')
                stk.push(chararray[i]);

            else // If closing bracket, i.e.,str[i] = ')'
            {
                if (!stk.empty())
                {
                    stk.pop();
                    result += 2;
                }
            }
        }
        return result;
    }

    /**
     * The idea is simple, we only update the result (max) when we find a "pair".
     If we find a pair. We throw this pair away and see how big the gap is between current and previous invalid.
     EX: "( )( )"
     stack: -1, 0,
     when we get to index 1 ")", the peek is "(" so we pop it out and see what's before "(".
     In this example it's -1. So the gap is "current_index" - (-1) = 2.
     The idea only update the result (max) when we find a "pair" and push -1 to stack first covered all edge cases.
     */
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        String s = "()(()";
        System.out.println(LongestValidParenthesis.findMaxLen(s));
    }
}
