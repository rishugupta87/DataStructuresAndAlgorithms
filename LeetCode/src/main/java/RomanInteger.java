import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rg029761 on 1/7/16.
 */
public class RomanInteger {

    static Map<Integer, String> integerToRomanMap = new LinkedHashMap<Integer, String>();
    static Map<String, Integer> romanToIntegerMap = new LinkedHashMap<String, Integer>();
    static {
        integerToRomanMap.put(1000, "M");
        integerToRomanMap.put(900, "CM");
        integerToRomanMap.put(500, "D");
        integerToRomanMap.put(400, "CD");
        integerToRomanMap.put(100, "C");
        integerToRomanMap.put(90, "XC");
        integerToRomanMap.put(50, "L");
        integerToRomanMap.put(40, "XL");
        integerToRomanMap.put(10, "X");
        integerToRomanMap.put(9, "IX");
        integerToRomanMap.put(5, "V");
        integerToRomanMap.put(4, "IV");
        integerToRomanMap.put(1, "I");

        romanToIntegerMap.put("M", 1000);
        romanToIntegerMap.put("CM", 900);
        romanToIntegerMap.put("D", 500);
        romanToIntegerMap.put("CD", 400);
        romanToIntegerMap.put("C", 100);
        romanToIntegerMap.put("XC", 90);
        romanToIntegerMap.put("L", 50);
        romanToIntegerMap.put("XL", 40);
        romanToIntegerMap.put("X", 10);
        romanToIntegerMap.put("IX", 9);
        romanToIntegerMap.put("V", 5);
        romanToIntegerMap.put("IV", 4);
        romanToIntegerMap.put("I", 1);
    }

    //refer:http://javabypatel.blogspot.com/2015/07/converting-integers-to-roman-numerals.html
    public static String integerToRoman(int num) {
        if(num < 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for(int value : integerToRomanMap.keySet()) {
            if(num > 0) {
                int noOfTimes = num/value;
                while(noOfTimes > 0) {
                    sb.append(integerToRomanMap.get(value));
                    noOfTimes --;
                }
                num = num % value;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static int romanToInteger(String roman) {
        if(roman.isEmpty()) {
            return 0;
        }

        if(roman.length() == 1) {
            return romanToIntegerMap.get(roman);
        }

        //start from the end, if j<=i add to the sum else subtract from the sum
        int i = roman.length() - 1;
        int j = i - 1;
        int sum = romanToIntegerMap.get(String.valueOf(roman.charAt(i)));

        while(i > 0) {
            int intVal =  romanToIntegerMap.get(String.valueOf(roman.charAt(i)));
            int previousintVal =  romanToIntegerMap.get(String.valueOf(roman.charAt(j)));
            if (intVal <= previousintVal) {
                sum += previousintVal;
            } else {
                sum-=previousintVal;
            }
            i--;
            j--;
        }

        return sum;
    }

}
