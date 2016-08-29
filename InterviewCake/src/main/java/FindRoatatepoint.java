/**
 * Created by rg029761 on 8/18/16.
 */
public class FindRoatatepoint {

    static int findRotatingPoint(final String[] words, int low, int high) {
        int mid = (low + high) / 2;
        if(words[mid].compareTo(words[0]) < 0) { // rotation in the left half
            if(words[mid].compareTo(words[mid-1]) < 0) {
                return mid;
            }
            return findRotatingPoint(words, low, mid-1);

        }  else {
            return findRotatingPoint(words, mid+1, high);
        }
    }

    public static void main(String args[]) {
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "apdsdnsd",
                "asymptote", // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };
        System.out.println(FindRoatatepoint.findRotatingPoint(words, 0, words.length-1));
    }
}
