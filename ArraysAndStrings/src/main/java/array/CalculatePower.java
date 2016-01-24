package array;

/**
 * Created by rg029761 on 11/3/15.
 */
public class CalculatePower {

    //handles both positive and negative powers.
    public static double pow(double a, int b) {

        if ( b == 0 ) {
            return 1;
        }

        if(b == 1) {
            return a;
        }

        if(b > 1) {
            return ( a * pow(a, b-1));
        }

        return 1/(pow(a, -1 * b));
    }

    public static double pow2(double a, int b) {

        double x = 1;
        for(int i = 0 ; i < b ; i++) {
            x *= a;
        }

        return x;
    }

    /* Function to calculate x raised to the power y, does not work for negative powers */
    //Time Complexity: O(y)
    //Space Complexity: O(1)
    public static double power3(double x, int y) {
        if( y == 1)
            return x;
        else if (y%2 == 0)
            return power3(x, y/2) * power3(x, y/2);
        else
            return x * power3(x, y/2) * power3(x, y/2);
    }

    // this will take o(logn) since we dont have to recurse again
    //for both positive and negative powers
    public static double power4(double x, int y)
    {
        if( y == 0)
            return 1;

        double temp = power4(x, y / 2);

        if (y%2 == 0) {
            return temp * temp;
        } else {
            if(y > 0) {
                return x * temp * temp;
            } else {
                return (temp*temp)/x;
            }
        }
    }
}
