/**
 * Created by rg029761 on 1/6/16.
 */
public class IntegerPalindrome {
    /**
     *
     Test Cases:
         -2147483648
         35453
         123321
         128821
         5345
         -128821
         1000000001
         -1
         0

     */
    public boolean isPalindrome_withExtraSpace(int x) {

        if(x < 0 || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return false;
        }

        String str = String.valueOf(x);

        if(str.length() == 1) {
            return true;
        }

        int i = 0 , j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_withoutExtraSpace(int x) {

        if(x < 0 || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return false;
        }

        //can reverse the integer and match with x

        // initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }

}
