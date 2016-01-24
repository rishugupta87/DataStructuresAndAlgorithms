/**
 * Created by rg029761 on 1/5/16.
 */
public class StringToInteger {

    /**
     Test cases:
         "345"
         "-345"
         "34xpr"
         "4000000001"
         "-4000000001"
         "?"
         "56.767"
         "  567  "
         "5 6 3 7 "

     Expected Outputs:
         345
         -345
         34
         2147483647
         -2147483648
         0
         56
         567
         5
     */
    public int myAtoi(String str) {

        if(str == null) {
            return 0;
        }

        String s1 = str.trim();

        if(s1.isEmpty()) {
            return 0;
        }

        int sign = s1.charAt(0) == '-'  ? -1 : 1;
        int i = sign == -1 ||  s1.charAt(0) == '+' ? 1 : 0;

        long result = 0 ;

        while (i < s1.length()) {
            char c = s1.charAt(i);
            if(Character.isDigit(c)) {
                result = result * 10 + Character.getNumericValue(c);
            } else {
                break;
            }
            i++;
        }
        result = result* sign;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)result;
    }

    public static void main(String args[]) {
        String s = "9223372036854775809";
        System.out.println(new StringToInteger().myAtoi(s));
    }

}
