package shopkick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rg029761 on 5/11/15.
 */

//return a list which has more vowels than consonent
public class Problem1 {
    public static ArrayList<String> findVowelsThanConsonents(final List<String> list) {
        //Base case:
        if(list.isEmpty()) {
            return null;
        }

        final ArrayList<String> returnedList = new ArrayList<String>();

        for(final String str : list) {
            int[] array = new int[256];
            for(int i = 0 ; i < str.length(); i++) {
                final int val = Character.toLowerCase(str.charAt(i)); // 'a' = 97
                array[val]++;
            }

            int consonentSum = 0;
            int vowelSum = 0;
            for(int i = 'a' ; i <='z' ; i++) {
                if(i !='a' && i !='e' && i !='i' && i !='o' && i !='u') {
                    consonentSum += array[i];
                } else {
                    vowelSum += array[i];
                }
            }

            if(vowelSum > consonentSum){
                returnedList.add(str);
            }
        }
        return returnedList;
    }

}
