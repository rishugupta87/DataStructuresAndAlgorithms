import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake."
 */
public class WordCloud {

    public static String myFunction(String arg) {
        // write the body of your function here
        Map<String, Integer> map = new HashMap<String, Integer>();
        //split the words
        List<String> stringList = splitWords(arg.toLowerCase().trim());

        for(String str : stringList) {
            if(!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println();
            System.out.printf("Key -> %s, Value = %s", entry.getKey(), entry.getValue());
        }
        System.out.println();

        return "running with " + arg;
    }
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        String testInput = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.";
        System.out.println(myFunction(testInput));
    }

    public static List<String> splitWords(String inputString) {
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

}
