package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rg029761 on 11/5/15.
 */
public class IsStringNumber {

    public static boolean isStringNumber(String testString) {

        String pattern2 = "[-+$]?\\d+(\\.\\d+)?(,\\d+)?";

        if(testString.matches(pattern2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static boolean isNumeric2(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
