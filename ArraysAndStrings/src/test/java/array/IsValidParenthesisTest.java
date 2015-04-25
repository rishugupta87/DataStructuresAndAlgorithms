package array;

import org.junit.Test;

/**
 * Created by rg029761 on 11/3/15.
 */
public class IsValidParenthesisTest {

    @Test
    public void test1() {
        String str = "()";
        System.out.println(IsValidParenthesis.isValidParenthesis(str));
    }

    @Test
    public void test2() {
        String str = "()[]{}";
        System.out.println(IsValidParenthesis.isValidParenthesis(str));
    }

    @Test
    public void test3() {
        String str = "[({()})]";
        System.out.println(IsValidParenthesis.isValidParenthesis(str));
    }

    @Test
    public void test4() {
        String str = "[(())]";
        System.out.println(IsValidParenthesis.isValidParenthesis(str));
    }

    @Test
    public void test5() {
        String str = "{(})";
        System.out.println(IsValidParenthesis.isValidParenthesis(str));
    }

    @Test
    public void test6() {
        String str = "{[]})";
        System.out.println(IsValidParenthesis.isValidParenthesis(str));
    }
}
