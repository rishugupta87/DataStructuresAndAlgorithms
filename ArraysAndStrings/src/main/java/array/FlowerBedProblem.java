package array;

/**
 * Created by rg029761 on 11/8/15.
 */
public class FlowerBedProblem {

    /*Suppose you have a long flowerbed in which some of the plots are planted and some are not. However,
    flowers cannot be planted in adjacent plots - they would compete for water and both would die. Given a flowerbed
     (represented as an array containing booleans), return if a given number of new flowers can be planted in it without
     violating the no-adjacent-flowers rule
        Sample inputs

        Input: 1,0,0,0,0,0,1,0,0

        3 => true
        4 => false
        Input: 1,0,0,1,0,0,1,0,0

        1 => true
        2 => false
        input: 0

        1 => true
        2 => false */
    public static int simpleGetMaxFlowers(int[] array) {

        if(array == null) return 0;

        int maxFlowers = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                if((i > 0 && array[i-1] == 1) || (i < array.length - 1 && array[i+1] == 1))
                    continue;
                array[i] = 1;
                maxFlowers++;
            }
        }

        return maxFlowers;
    }

    public static void main(String args[]) {

        int[] array1 = {1,0,0,1,0,0,1,0,0};
        int[] array2 = {1,0,0,0,0,0,1,0,0};

        System.out.println(simpleGetMaxFlowers(array1));
        System.out.println(simpleGetMaxFlowers(array2));
    }
}
