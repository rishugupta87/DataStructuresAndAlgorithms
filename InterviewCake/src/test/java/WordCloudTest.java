import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class WordCloudTest {

    public List<String> splitWords(String inputString) {
        List<String> words = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (c == ' ' || c == '.') {
                if(!words.contains('.') && sb.toString().length() != 0) {
                    words.add(sb.toString());
                }
                sb = new StringBuilder();
            } else if (Character.isLetter(c) || c == '-') {
                sb.append(c);
            }
        }
        return words;
    }

    @Test
    public void test() {
        String str = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.";
        List<String> setStr = new WordCloudTest().splitWords(str.toLowerCase());
        System.out.println(setStr);
    }
}
