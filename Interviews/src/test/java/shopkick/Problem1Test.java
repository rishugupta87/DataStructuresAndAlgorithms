package shopkick;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rg029761 on 5/11/15.
 */
public class Problem1Test {

    @Test
    public void test() {

        final List<String> list = new ArrayList<String>();
        list.add("bbbcooooe");
        list.add("ccce");
        list.add("aaa");
        System.out.println(Problem1.findVowelsThanConsonents(list));

    }
}
