/**
 * Created by rg029761 on 1/10/16.
 */
public class DivideTwoIntegers {

    /**
     *
     * Algorithm:
     * https://leetcode.com/discuss/38997/detailed-explained-8ms-c-solution
     *
     -1010369383
     -2147483648
     -2147483648
     -13232322

     Does not handle max and underflow
     *
     */
    public int divide(int dividend, int divisor) {

        if (divisor <= Integer.MIN_VALUE || divisor >= Integer.MAX_VALUE) {
            return 0;
        }

        long divid = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);

        if (divs == 0) {
            return Integer.MAX_VALUE;
        }

        if (divs > divid) {
            return 0;
        }

        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;

        if(divs == 1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        if(divs == 1 && dividend == Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }

        if(divs == 1) {
            return (int)divid * sign;
        }

        int res = 0;

        while (true) {
            int x = 0;

            if (divs > divid) {
                return res * sign;
            }

            while (divid - (divs << x) >= 0) {
                if (divid - (divs << x) == 0) {
                    res++;
                    return res * sign;
                }
                x++;
            }

            //dividentRemain < 0
            --x;
            if (x == 0) {
                res++;
                return res * sign;
            }
            res += Math.pow(2, x);
            divid = divid - (divs << x);
        }
    }

    public static void main(String args[]) {
        System.out.println(new DivideTwoIntegers().divide(-1, 1));
    }
}
