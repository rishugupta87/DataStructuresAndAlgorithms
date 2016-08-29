package ebay;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rg029761 on 8/22/16.
 */
public class NumberToExcel {

    /**
     *
     *  I/P o/P

     1     A
     2     B
     3     C
     ..
     26     Z

     27     AA
     28     AB
     29     AC
     30     AD
     ..
     52     AZ = (52/26-1).52%26(z)
     53     BA =
     54     BB

     ...78  BZ = (78/26-1)*z
     702     ZZ
     703 AAA
     */
    static String numberToExcel(int num) {

        //map
        Map<Integer, String> map = new HashMap<Integer, String>();
        StringBuilder sb = new StringBuilder();

        if(map.containsKey(num)) {
            return map.get(num);
        }

        while(num  > 0) {
            int remainder = num % 26; //13
            int divisor = num/26; //25

            if(remainder != 0 ) {
                sb.append(String.valueOf(map.get(remainder))).append('A');
                num = divisor;
            } else {
                sb.append(String.valueOf(map.get(divisor -1))).append('Z');
                num = divisor - 1;
            }
        }

        return sb.toString();
    }

    static String numberToExcel2(int num) {
        if(num <= 0){
            throw new IllegalArgumentException("Input is not valid!");
        }

        StringBuilder sb = new StringBuilder();

        while(num > 0){
            num--;
            char ch = (char) (num % 26 + 'A');
            num /= 26;
            sb.append(ch);
        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println(NumberToExcel.numberToExcel2(702));
    }

}
