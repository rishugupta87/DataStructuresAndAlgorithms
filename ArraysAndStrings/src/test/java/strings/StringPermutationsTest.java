package strings;

import org.junit.Test;

/**
 * Created by rg029761 on 11/8/15.
 */
public class StringPermutationsTest {

    @Test
    public void test1() {
        long startTime = System.currentTimeMillis();

        String s = "abcdef";
        StringPermutations sp = new StringPermutations(s.length());
        sp.findStringPermutations(s, 0);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }

    @Test
    public void test2() {
        String s = "abcd";
        long startTime = System.currentTimeMillis();
        StringPermutations sp = new StringPermutations(s.length());
        sp.findStringPermutations2(s.toCharArray(), 0);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
