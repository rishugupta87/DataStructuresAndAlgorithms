package microsoft;

/**
 * Created by rg029761 on 10/25/15.
 * O(no of digits)
 */
public class DigitSorted {

    public static boolean digitSorted(int num, int min) {

        if(num == 0) {
            return true;
        }

        if(num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) {
            return false;
        }

        int unit = num % 10;
        if(unit > min) {
            return false;
        } else {
            min = unit;
        }

        if(digitSorted(num/10, min)) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(DigitSorted.digitSorted(2154, Integer.MAX_VALUE));
    }
}
