package array;

import java.util.HashMap;

/**
 * Created by rg029761 on 11/15/16.
 */
public class CowsAndBulls {

    public static String getHint(String secret, String guess) {
        int countBull=0;
        int countCow =0;
        int[] secretArr = new int[10];
        int[] guessArray = new int[10];

        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1==c2)
                countBull++;
            else{
                secretArr[c1-'0']++;
                guessArray[c2-'0']++;
            }
        }

        for(int i=0; i<10; i++){
            countCow += Math.min(secretArr[i], guessArray[i]);
        }

        return countBull+"A"+countCow+"B";
    }

    public String getHint2(String secret, String guess) {
        int countBull=0;
        int countCow=0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        //check bull
        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1==c2){
                countBull++;
            }else{
                if(map.containsKey(c1)){
                    int freq = map.get(c1);
                    freq++;
                    map.put(c1, freq);
                }else{
                    map.put(c1, 1);
                }
            }
        }

        //check cow
        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1!=c2){
                if(map.containsKey(c2)){
                    countCow++;
                    if(map.get(c2)==1){
                        map.remove(c2);
                    }else{
                        int freq = map.get(c2);
                        freq--;
                        map.put(c2, freq);
                    }
                }
            }
        }

        return countBull+"A"+countCow+"B";
    }

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        System.out.println(CowsAndBulls.getHint(secret, guess));
    }
}
