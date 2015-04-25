package strings;

import org.junit.Test;

/**
 * Created by rg029761 on 11/7/15.
 */
public class IsIsomorphicStringsTest {

    @Test
    public void test1() {
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
    }

    @Test
    public void test2() {
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "baa"));
    }


    @Test
    public void test3() {
        System.out.println(new IsomorphicStrings().check("foo", "bar"));
    }

    @Test
    public void test4() {
        System.out.println(new IsomorphicStrings().check("foo", "baa"));
    }

    @Test
    public void test5() {
        System.out.println(new IsomorphicStrings().check("fooddeegg", "baarrllmm"));
    }
}
