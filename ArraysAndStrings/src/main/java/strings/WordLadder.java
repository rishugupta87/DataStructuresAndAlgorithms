package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * WordLadder Problem.
 */
public class WordLadder {

    class Word {
        String str;
        boolean visited;

        public Word(final String str, final boolean visited) {
            this.str = str;
            this.visited = visited;
        }
    }

    private static Queue<Word> inputQueue = new LinkedList<Word>();

    private List<String> findTransformLength(final String start, final String end, Set<String> dictionary) {
        if(inputQueue.isEmpty()) {
            inputQueue.add(new Word(start, true));
        }

        //add the last word to reach in the dictionary.
        dictionary.add(end);

        List<String> ladder = new ArrayList<String>();

        while(!inputQueue.isEmpty()) {
            for(final String currDictinaryWord : dictionary) {
                final String currentInputWord = inputQueue.remove().str;
                ladder.add(currentInputWord);

                if(findDiff(currentInputWord, currDictinaryWord) == 1) {
                    //inputQueue.add(currDictinaryWord);
                }
            }
        }

        return ladder;
    }

    /**
     * Find difference in no of characters in the two strings.
     *
     * @param str1
     * @param str2
     * @return
     */
    private static int findDiff(final String str1, final String str2) {
        int count = 0 ; int i = 0 ; int j = 0;
        while(i < str1.length()) {
            final char c1 = str1.charAt(i);
            while(j <  str2.length()) {
                final char c2 = str2.charAt(j);
                if(c1 == c2) {
                    i ++;
                    j ++;
                } else {
                    count ++;
                }
            }
        }
        return count;
    }
}
