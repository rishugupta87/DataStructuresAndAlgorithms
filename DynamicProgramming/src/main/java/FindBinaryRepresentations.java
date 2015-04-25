/**
 * Created by rg029761 on 7/1/15.
 * Find number of binary representations so that there are no onsecutive 1's
 */
public class FindBinaryRepresentations {

    public static int findNoOfBinaryRepresenations(final int n) {
        if(n == 0)
            return 0;
        if(n == 1) {
            return 2;
        }
        if(n == 2) {
            return 3;
        }
        int a = 2, b = 3 , c = 0; //just need to remember last two variables , no need of an array.
        for(int i = 3 ; i <= n ; i++) {
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
