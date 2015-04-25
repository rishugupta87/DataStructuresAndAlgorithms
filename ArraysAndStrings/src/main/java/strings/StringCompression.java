package strings;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Created by rg029761 on 9/18/15.
 */
public class StringCompression {

    /**
     * Implement a method to perform basic string compression using the counts of repeated characters.
     * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than
     * the orig- inal string, your method should return the original string.
     */
    public static String compress(final String str) {
        if(str.length() == 0) {
            return null;
        }

        int i = 0 ; int j = i + 1;
        StringBuffer sb = new StringBuffer();

        while(i < str.length()) {
            char c1 = str.charAt(i);

            sb.append(c1);
            int count = 1;

            while(j < str.length() && str.charAt(j) == c1 ) {
                count++;
                j++;
            }
            sb.append(String.valueOf(count));
            i = j;
            j = i + 1;
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println(compress("aadddddddbcccccaaa"));
    }

}
