package array;

/**
 * Created by rg029761 on 10/13/15.
 */
public class FirstRepeatingElement {


    public static String repeat(String s) {
        int[] array = new int[256];

        for(int i = 0 ; i < s.length() ; i++) {
            int s2 = s.charAt(i);
            array[s2]++;
        }

        int ascii = 0;

        for(int i = 0 ; i < s.length() ; i++) {
            int c = s.charAt(i);
            if(array[c] > 1) {
                ascii = c;
                break;
            }
        }

        char c = (char)ascii;

        return Character.toString(c);
    }

    public static void main(String args[]) {
        String s = "bcccdeeefgggb";
        System.out.println(repeat(s));
    }
}
