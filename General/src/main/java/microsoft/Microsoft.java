package microsoft;

/**
 * Created by rg029761 on 10/25/15.
 */
public class Microsoft {

    public static boolean digitSorted(int num, int min) {
        if(num == 0) {
            return true;
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

    public static void test() {

    }
}
