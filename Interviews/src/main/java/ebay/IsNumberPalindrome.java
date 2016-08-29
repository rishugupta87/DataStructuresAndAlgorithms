package ebay;

/**
 * Created by rg029761 on 8/22/16.
 */
public class IsNumberPalindrome {

    /**
     * 2. Palindrome Number : 1234321

     Conditions are

     a. Should NOT reverse the number, and check if they are equal
     b. Do NOT Convert into string

     54345

     243435 % 10 = 5

     54345 =
     434 =

     log10000
     */
    static boolean isNumberPalindrome(int num) {

        if(num < 0) {
            return false;
        }

        if(num >= Integer.MAX_VALUE) {
            return false;
        }
        int number = num;
        int noOfZeros = -1;

        while(num > 0) {
            num /= 10;
            noOfZeros++;
        }
        while(number > 0 && noOfZeros != 0 ) {
            int first = number/(int)(Math.pow(10, noOfZeros));
            int last = number%10;
            if(first != last) {
                return false;
            }
            noOfZeros = noOfZeros -1;
            number = (number / 10) % ((int)Math.pow(10, noOfZeros));
            noOfZeros = noOfZeros - 1;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(IsNumberPalindrome.isNumberPalindrome(-232));
    }
}
