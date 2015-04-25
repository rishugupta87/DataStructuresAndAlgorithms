/**
 * Created by rg029761 on 6/13/15.
 */
public class Fibonacci {
    static int memo[] = new int[20]; //assuming n is 10.
    static int f = 0;

    /**
     * Recursion with memoization.
     * Top Down approach
     *
     * @param n
     * @return
     */
    public static int fib(final int n) {
        if(memo[n] != 0) {
            return memo[n];
        }
        if(n <= 1) {
            f = n;
        } else {
            f = fib(n - 1) + fib(n - 2);
        }
        memo[n] = f;
        return f;
    }

    /**
     * Bottom Up Approach(do sequentially)
     *
     */
    public static int fib2(int n) {
        int[] table = new int[n+1];

        //this loop solves all the subproblems
        for(int i = 0 ; i <= n ; i++){
            if(i <= 1) {
                table[i] = i;
            } else {
                table[i] = table[i - 1] + table[i - 2];
            }
        }
        return table[n];
    }

    /**
     * Bottom Up Approach(do sequentially)
     * save space
     */
    public static int fib3(int n)
    {
        int a = 0, b = 1, c = 0, i;
        if( n == 0)
            return a;
        for (i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
