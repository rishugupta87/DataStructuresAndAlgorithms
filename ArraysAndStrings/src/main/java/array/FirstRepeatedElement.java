package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rg029761 on 7/18/15.
 */
public class FirstRepeatedElement {

    /**
     * Objective: Given an array of integers, find out the first repeated element.
     * First repeated element means the element occurs atleast twice and has smallest index.
     Input: An Array
     Output: The first repeated element

     Examples :

     Array {1,1,3,4,6,7,9} first repeated Number : 1

     Array {7,2,2,3,7} first repeated Number : 7

     Array {5,3,3,3,3,3,3,3,4,4,4,5,3} first repeated Number : 5

     * @param array
     * @return int
     */
    public static int findFirstRepeatedElement(int[] array) {
        int INDEX = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0 ; i < array.length; i++) {

            if(map.containsKey(array[i])) {
                int index = map.get(array[i]);
                if(index < INDEX) {
                    INDEX = index;
                }
            } else {
                map.put(array[i], i);
            }
        }
        return array[INDEX];
    }
}
