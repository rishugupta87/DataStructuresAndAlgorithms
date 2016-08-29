package array;

/**
 * Created by rg029761 on 8/22/16.
 */
public class ReverseInteger {

    static int reverseInteger(int num) {

        if(String.valueOf(num).length() == 0) {
            return -1;
        }

        if(String.valueOf(num).length() == 1) {
            return num;
        }

        int sign = num < 0 ? -1 : 1;

        num = Math.abs(num);

        long rev = 0;
        int remainder = 0;
        while (num > 0) {
            remainder = num % 10;
            rev = rev*10 + remainder;
            num = num / 10;
        }

        if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)(rev * sign);
    }

    public static void main(String args[]) {
        System.out.println(reverseInteger(323235));
    }
}
