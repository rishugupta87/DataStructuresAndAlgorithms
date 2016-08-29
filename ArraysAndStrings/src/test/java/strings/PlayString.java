package strings;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rg029761 on 7/24/16.
 */
public class PlayString {

    @Test
    public void testReverseString() {
        String s  = "Rishu Gupta is a goo45 boy";
        char[] charArray = s.toCharArray();

        int first = 0;
        int last = charArray.length - 1;

        while(first < last) {
            char tmp = charArray[first];
            charArray[first] = charArray[last];
            charArray[last] = tmp;
            first ++;
            last--;
        }

        //reversed
        System.out.println("Reversed:" + String.valueOf(charArray));

        System.out.println(s.toCharArray());
    }

    @Test
    public void testReverseWordsInAString() {
        String s  = "the eagle has landed";
        String[] sarray = s.split(" ");

        int first = 0;
        int last = sarray.length - 1;

        while(first < last) {
            String tmp = sarray[first];
            sarray[first] = sarray[last];
            sarray[last] = tmp;
            first ++;
            last--;
        }

        System.out.println(Arrays.asList(sarray));

    }
}
