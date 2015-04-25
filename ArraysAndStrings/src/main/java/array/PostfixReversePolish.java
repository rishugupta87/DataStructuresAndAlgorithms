package array;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by rg029761 on 11/8/15.
 */
public class PostfixReversePolish {

    /**
     * Compute the value of an expression in Reverse Polish Notation. Supported operators are "+", "-", "*" and "/".
     * Reverse Polish is a postfix mathematical notation in which each operator immediately follows its operands.
     * Each operand may be a number or another expression.
     * For example, 3 + 4 in Reverse Polish is 3 4 + and 2 * (4 + 1) would be written as 4 1 + 2 * or 2 4 1 + *
     *
     * @param ops a sequence of numbers and operators, in Reverse Polish Notation
     * @return the result of the computation
     * @throws IllegalArgumentException ops don't represent a well-formed RPN expression
     * @throws ArithmeticException the computation generates an arithmetic error, such as dividing by zero
     *
     * <p>Some sample ops and their results:
     * ["4", "1", "+", "2.5", "*"] -> ((4 + 1) * 2.5) -> 12.5
     * ["5", "80", "40", "/", "+"] -> (5 + (80 / 40)) -> 7
     */

    public static void main(String[] args) throws IOException {
        String[] tokens1 = new String[] { "2", "1", "+", "3", "*" };
        String[] tokens2 = new String[] { "4", "13", "5", "/", "+" };
        System.out.println(evalRPN(tokens1));
        System.out.println(evalRPN(tokens2));
    }

    public static int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) { //push to stack if it is a number
                stack.push(t);
            } else {  //pop numbers from stack if it is an operator
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t.charAt(0)) {
                    case '+':
                        stack.push(String.valueOf(a + b));
                        break;
                    case '-':
                        stack.push(String.valueOf(b - a));
                        break;
                    case '*':
                        stack.push(String.valueOf(a * b));
                        break;
                    case '/':
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;
    }
}
