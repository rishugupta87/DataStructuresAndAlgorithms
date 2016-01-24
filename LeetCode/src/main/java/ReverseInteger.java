/**
 * Created by rg029761 on 1/5/16.
 */
public class ReverseInteger {

    StringBuilder sb = new StringBuilder();

    public int reverse(int x) {

        if(String.valueOf(x).length() == 1) {
            return x;
        }

       if(x < 0) {
           x = Math.abs(x);
           sb.append("-");
       }

       while(String.valueOf(x).length() != 1) {
           sb.append(x % 10);
           x = x/10;
       }

        sb.append(x);

        //handle overflow
        //for 32bit integer rangge is -2,147,483,648 to 2,147,483,647
        // The way java handles this is , If it overflows, it goes back to the minimum value and continues from there.
        // If it underflows, it goes back to the maximum value. catching exception is a smart way
        int reverse = 0;
        try {
            reverse = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {

        }
        String.valueOf(2);

        return reverse; //integer.parseint removes leading zeros
    }

    public int reverse2(int x) {

        if(String.valueOf(x).length() == 1) {
            return x;
        }

        if(x < 0) {
            x = Math.abs(x);
            sb.append("-");
        }

        while(String.valueOf(x).length() != 1) {
            sb.append(x % 10);
            x = x/10;
        }

        sb.append(x);

        //handle overflow
        //for 32bit integer rangge is -2,147,483,648 to 2,147,483,647
        // The way java handles this is , If it overflows, it goes back to the minimum value and continues from there.
        // If it underflows, it goes back to the maximum value. catching exception is a smart way
        long reverse = Long.parseLong(sb.toString()); //hold in long to check for overflow conditions
        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)reverse;
    }

    public int reverse3(int x) {
        long res = 0;

        while(Math.abs(x) > 0) {
            long digit = x % 10;
            res = res * 10 + digit;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            x= x/10;
        }

        return (int)res;
    }

    public static void main(String args[]) {
        System.out.println(new ReverseInteger().reverse3(-9000));
    }
}
