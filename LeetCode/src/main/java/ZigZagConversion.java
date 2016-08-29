import java.util.Arrays;

/**
 * The string " ALISHIRING" is written in a
 * zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

     P   A   H   N
     A P L S I I G
     Y   I   R

 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if(s.length() == 0) {
            return "";
        }

        char[] charArray = s.toCharArray();
        char [][] table = new char[numRows][1000];

        int k = 0, i = 0, j = 0;
        table[0][0] = charArray[0];

        while(k < s.length() - 1) {
            while(i < numRows - 1 && k < s.length()-1) {
                table[++i][j] = charArray[++k];
            }

            while (i > 0 && k < s.length()-1) {
                table[--i][++j] = charArray[++k];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p = 0 ; p < numRows; p ++) {
            for(int q = 0 ; q < 7; q++) {
                if(table[p][q] != (char)0) {
                    sb.append(table[p][q]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String s = "PAYPALISHIRING";
        System.out.println(new ZigZagConversion().convert(s, 4));
    }
}
