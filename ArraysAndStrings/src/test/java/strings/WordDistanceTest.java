package strings;

import org.junit.Test;

/**
 * Created by rg029761 on 11/4/15.
 */
public class WordDistanceTest {

    @Test
    public void test1() {
        String s = "hello how are you";
        System.out.println(WordDistance.distance(s, "hello", "you"));
    }

    @Test
    public void test2() {
        String s = "hello how are hello you";
        System.out.println(WordDistance.distance(s, "hello", "you"));
    }

    @Test
    public void test3() {
        String s = "you are hello";
        System.out.println(WordDistance.distance(s, "hello", "you"));
    }

    @Test
    public void test4() {
        String s = "hello how are hello";
        System.out.println(WordDistance.distance(s, "hello", "you"));
    }

    @Test
    public void test5() {
        String s = "hello how are hello dont know that you";
        System.out.println(WordDistance.distance(s, "hello", "you"));
    }
}
